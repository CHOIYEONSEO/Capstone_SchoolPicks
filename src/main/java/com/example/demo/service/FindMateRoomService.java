package com.example.demo.service;

import com.example.demo.dto.FindMate.FindMateRoomDto;
import com.example.demo.dto.FindMate.FindMateRoomPageDto;
import com.example.demo.dto.FindMate.GetRoomListDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.FindMate.FindMateRoom;
import com.example.demo.entity.FindMate.RoomUser;
import com.example.demo.repository.FindMateRoomRepository;
import com.example.demo.repository.RoomUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindMateRoomService {
    private final FindMateRoomRepository findMateRoomRepository;
    private final RoomUserRepository roomUserRepository;

    public ResponseDto<String> createFindMateRoom(FindMateRoomDto dto){

        String roomId = UUID.randomUUID().toString();

        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime targetTime = currentTime.plus(30, ChronoUnit.MINUTES);

        if(dto.getPlanTime().isBefore(targetTime)){ // 30분보다 일찍 잡힌 경우
            return ResponseDto.setFailed("일찍 시간을 최소 30분 이상으로 설정해주세요.");
        }

        // 마감시간이 만료시간보다 뒤에 있거나, 현재 시간보다 앞에 있는 경우 에러 발생
//        if(dto.getExpiredTime().isAfter(dto.getPlanTime()) || dto.getExpiredTime().isBefore(currentTime)){
//            return ResponseDto.setFailed("마감 시간은 현재시간부터 약속시간까지만 가능합니다.");
//        }

        FindMateRoom findMateRoom = FindMateRoom.builder()
                .roomId(roomId)
                .roomTitle(dto.getRoomTitle())
                .shopName(dto.getShopName())
                .planTime(dto.getPlanTime())
                .expiredTime(dto.getExpiredTime())
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
            return ResponseDto.setFailed("데이터베이스 상의 에러가 있습니다.");
        }


        return ResponseDto.setSuccess("방을 개설하는데 성공하였습니다.", roomId);
    }

    // 임시 주석
    public void joinFindMateRoom(String userName, String roomId){

        FindMateRoom findMateRoom = findMateRoomRepository.findByRoomId(roomId);

        RoomUser roomUser = RoomUser.builder()
                .userName(userName)
                .findMateRoom(findMateRoom)
                .build();

        log.info("findMateRoom.getHeadCount() = " + findMateRoom.getHeadCount());
        log.info("findMateRoom.getRoomUsers().size() = " + findMateRoom.getRoomUsers().size());

        // 적정 인원보다 많은 경우 reject, 나중에 이거 신호로 변경
        if(findMateRoom.getRoomUsers().size() == findMateRoom.getHeadCount()){
            return;
        }

        // 시간을 초과한 경우도 reject
        LocalDateTime currentTime = LocalDateTime.now();
        if(currentTime.isAfter(findMateRoom.getExpiredTime())){
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
        FindMateRoom findMateRoom = findMateRoomRepository.findByRoomId(roomId);
        findMateRoomRepository.delete(findMateRoom);
    }

    public List<FindMateRoom> findMateRoomSearch(String keyword){
        List<FindMateRoom> findMateRooms = findMateRoomRepository.findByRoomWriterContainingOrRoomTitleContaining(keyword,keyword);
        return findMateRooms;
    }


}
