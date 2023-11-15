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


        // 여기 사용하실 때 나중에 공유할 수 있는 url 띄우는 바 부분을 만들어서
        // 조회와 관련된 url에 roomId 붙여서 get Method로 가져오면 될 것 같습니다.
        return roomId;
    }

    // 그냥 오류가 난다는 가정없이 코드를 짜겠습니다. 제대로 넘겨주면 오류가 나지 않는 부분이니까요.
    public void joinFindMateRoom(String userName, String roomId){

        FindMateRoom findMateRoom = findMateRoomRepository.findByRoomId(roomId);

        RoomUser roomUser = RoomUser.builder()
                .userName(userName)
                .findMateRoom(findMateRoom)
                .build();

        try{
            roomUserRepository.save(roomUser);
        } catch(Exception e){
            System.out.println("데이터 베이스 오류입니다.");
        }

    }

    // 이름 출력하고 싶을 때 사용
    public FindMateRoomPageDto showFindMateRoom(String roomId){

        FindMateRoom findMateRoom = findMateRoomRepository.findFindMateRoomWithRoomUsers(roomId);

        List<String> users = new ArrayList<>();
        for(RoomUser roomUser : findMateRoom.getRoomUsers()){
            users.add(roomUser.getUserName());
        }

        FindMateRoomPageDto findMateRoomPageDto = FindMateRoomPageDto.builder()
                .localDateTime(findMateRoom.getPlanTime())
                .headCount(findMateRoom.getHeadCount())
                .roomWriter(findMateRoom.getRoomWriter())
                .roomMessage(findMateRoom.getRoomMessage())
                .users(users)
                .build();

        return findMateRoomPageDto;
    }

    // 이름 출력하고 싶지 않을 때 작성자 이름만 가져옴.
    public FindMateRoomPageDto showFindMateRoomWithBlindMode(String roomId){

        FindMateRoom findMateRoom = findMateRoomRepository.findByRoomId(roomId);

        List<String> users = new ArrayList<>();
        users.add(findMateRoom.getRoomUsers().get(0).getUserName());

        FindMateRoomPageDto findMateRoomPageDto = FindMateRoomPageDto.builder()
                .localDateTime(findMateRoom.getPlanTime())
                .headCount(findMateRoom.getHeadCount())
                .roomWriter(findMateRoom.getRoomWriter())
                .roomMessage(findMateRoom.getRoomMessage())
                .users(users)
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
                    .build());
        }

        return getRoomListDtos;
    }
}
