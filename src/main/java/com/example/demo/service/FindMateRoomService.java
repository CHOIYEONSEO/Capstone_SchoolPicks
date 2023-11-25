package com.example.demo.service;

import com.example.demo.dto.FindMate.FindMateRoomDto;
import com.example.demo.dto.FindMate.FindMateRoomPageDto;
import com.example.demo.dto.FindMate.GetRoomListDto;
import com.example.demo.entity.FindMate.FindMateRoom;
import com.example.demo.entity.FindMate.RoomUser;
import com.example.demo.repository.FindMateRoomRepository;
import com.example.demo.repository.RoomUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindMateRoomService {
    private final FindMateRoomRepository findMateRoomRepository;
    private final RoomUserRepository roomUserRepository;

    public String createFindMateRoom(FindMateRoomDto dto){

        String roomId = UUID.randomUUID().toString();

        FindMateRoom findMateRoom = FindMateRoom.builder()
                .roomId(roomId)
                .roomTitle(dto.getRoomTitle())
                .shopName(dto.getShopName())
                .planTime(dto.getPlanTime())
                .headCount(dto.getHeadCount())
                .roomWriter(dto.getRoomWriter())
                .roomMessage(dto.getRoomMessage())
                .isPrivate(dto.isPrivate())
                .roomPassword(dto.getRoomPassword())
                .version(dto.getVersion())
                .build();

        RoomUser roomUser = RoomUser.builder()
                .findMateRoom(findMateRoom)
                .userName(dto.getRoomWriter())
                .build();

        try{
            findMateRoomRepository.save(findMateRoom);
            roomUserRepository.save(roomUser);
        } catch(Exception e){
            System.out.println("데이터 베이스 오류입니다.");
        }


        return roomId;
    }

    // 임시 주석
    public void joinFindMateRoom(String userName, String roomId){

        FindMateRoom findMateRoom = findMateRoomRepository.findByRoomId(roomId);

        RoomUser roomUser = RoomUser.builder()
                .userName(userName)
                .findMateRoom(findMateRoom)
                .build();

        // 적정 인원보다 많은 경우 reject, 나중에 이거 신호로 변경
        if(findMateRoom.getRoomUsers().size() == findMateRoom.getHeadCount()){
            return;
        }

        try{
            roomUserRepository.save(roomUser);
            System.out.println("유저 데이터 저장이 완료되었습니다.");
        } catch(Exception e){
            System.out.println("데이터 베이스 오류입니다.");
        }

    }

    public FindMateRoomPageDto showFindMateRoom(String roomId){

        FindMateRoom findMateRoom = findMateRoomRepository.findFindMateRoomWithRoomUsers(roomId);

        List<String> users = new ArrayList<>();
        for(RoomUser roomUser : findMateRoom.getRoomUsers()){
            users.add(roomUser.getUserName());
        }

        // password, shopName추가
        FindMateRoomPageDto findMateRoomPageDto = FindMateRoomPageDto.builder()
                .localDateTime(findMateRoom.getPlanTime())
                .headCount(findMateRoom.getHeadCount())
                .roomWriter(findMateRoom.getRoomWriter())
                .roomMessage(findMateRoom.getRoomMessage())
                .users(users)
                .roomId(roomId)
                .roomPassword(findMateRoom.getRoomPassword())
                .shopName(findMateRoom.getShopName())
                .version(findMateRoom.getVersion())
                .build();

        return findMateRoomPageDto;
    }

    // 이름 출력하고 싶지 않을 때 작성자 이름만 가져옴.
    public FindMateRoomPageDto showFindMateRoomWithBlindMode(String roomId){

//        FindMateRoom findMateRoom = findMateRoomRepository.findByRoomId(roomId);
        FindMateRoom findMateRoom = findMateRoomRepository.findFindMateRoomWithRoomUsers(roomId);

        List<String> users = new ArrayList<>();
        users.add(findMateRoom.getRoomUsers().get(0).getUserName());

        // password, shopName, roomId추가
        FindMateRoomPageDto findMateRoomPageDto = FindMateRoomPageDto.builder()
                .localDateTime(findMateRoom.getPlanTime())
                .headCount(findMateRoom.getHeadCount())
                .roomWriter(findMateRoom.getRoomWriter())
                .roomMessage(findMateRoom.getRoomMessage())
                .users(users)
                .roomPassword(findMateRoom.getRoomPassword())
                .shopName(findMateRoom.getShopName())
                .roomId(findMateRoom.getRoomId())
                .version(findMateRoom.getVersion())
                .build();

        return findMateRoomPageDto;
    }

    // 비공개 모드에서 이름 전체 조회, 비밀번호 틀렸으면 null로 보냅니다.
    public List<String> getUserNameInBlindMode(String roomId, String password){

        FindMateRoom findMateRoom = findMateRoomRepository.findByRoomId(roomId);

        if(findMateRoom.getRoomPassword().equals(password)){
            List<String> users = new ArrayList<>();
            for(RoomUser roomUser : findMateRoom.getRoomUsers()){
                users.add(roomUser.getUserName());
            }

            return users;
        }

        return null;
    }

    // 방 조회
    public List<GetRoomListDto> showRoomList(String roomWriter, String roomPassword){

        List<FindMateRoom> findMateRooms = findMateRoomRepository.findByRoomWriterAndRoomPassword(roomWriter, roomPassword);

        List<GetRoomListDto> getRoomListDtos = new ArrayList<>();

        for(FindMateRoom findMateRoom: findMateRooms){
            getRoomListDtos.add(GetRoomListDto.builder()
                    .roomTitle(findMateRoom.getRoomTitle())
                    .roomWriter(findMateRoom.getRoomWriter())
                    .roomId(findMateRoom.getRoomId())
                    .planTime(findMateRoom.getPlanTime())
                    .build());
        }

        return getRoomListDtos;

    }

    // 전체 방 조회
    public List<FindMateRoom> findAllFindMateRoom(){
        return findMateRoomRepository.findAll();
    }

    // roomId로 내역지우기
    public void deleteFindMateRoom(String roomId){
        FindMateRoom findMateRoom = findMateRoomRepository.findFindMateRoomWithRoomUsers(roomId);
        System.out.println(findMateRoom.getRoomId());
        List<RoomUser> roomUsers = findMateRoom.getRoomUsers();
        for(RoomUser roomUser: roomUsers){
            roomUserRepository.delete(roomUser);
        }

        findMateRoomRepository.delete(findMateRoom);
    }

    public List<FindMateRoom> findMateRoomSearch(String keyword){
        List<FindMateRoom> findMateRooms = findMateRoomRepository.findByRoomWriterContainingOrRoomTitleContaining(keyword,keyword);
        return findMateRooms;
    }


}
