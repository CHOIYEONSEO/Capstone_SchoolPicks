package schoolpicks.capstoneschoolpicks.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import schoolpicks.capstoneschoolpicks.dto.FindMate.FindMateRoomDto;
import schoolpicks.capstoneschoolpicks.dto.FindMate.FindMateRoomPageDto;
import schoolpicks.capstoneschoolpicks.entity.FindMate.FindMateRoom;
import schoolpicks.capstoneschoolpicks.entity.FindMate.RoomUserForGroup;
import schoolpicks.capstoneschoolpicks.repository.FindMateRoomRepository;
import schoolpicks.capstoneschoolpicks.repository.RoomUserForGroupRepository;
import schoolpicks.capstoneschoolpicks.repository.RoomUserRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExtraService {

    private final FindMateRoomRepository findMateRoomRepository;
    private final RoomUserRepository roomUserRepository;
    private final RoomUserForGroupRepository roomUserForGroupRepository;


    // 추가기능 방 생성
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

        try{
            findMateRoomRepository.save(findMateRoom);
        } catch(Exception e){
            System.out.println("데이터 베이스 오류입니다.");
        }


        // 여기 사용하실 때 나중에 공유할 수 있는 url 띄우는 바 부분을 만들어서
        // 조회와 관련된 url에 roomId 붙여서 get Method로 가져오면 될 것 같습니다.
        return roomId;
    }

    // 그냥 오류가 난다는 가정없이 코드를 짜겠습니다. 제대로 넘겨주면 오류가 나지 않는 부분이니까요.
    public void joinFindMateRoom(String userName, String phoneNumber, String SKKUId, String roomId){

        FindMateRoom findMateRoom = findMateRoomRepository.findByRoomId(roomId);

        RoomUserForGroup roomUserForGroup = RoomUserForGroup.builder()
                .userName(userName)
                .phoneNumber(phoneNumber)
                .SKKUId(SKKUId)
                .findMateRoom(findMateRoom)
                .build();

        try{
            roomUserForGroupRepository.save(roomUserForGroup);
        } catch(Exception e){
            System.out.println("데이터 베이스 오류입니다.");
        }

        // 내역 모두 조회
        public FindMateRoomPageDto showFindMateRoomWithBlindMode(String roomId){

            FindMateRoom findMateRoom = findMateRoomRepository.findByRoomId(roomId);

            FindMateRoomPageDto findMateRoomPageDto = FindMateRoomPageDto.builder()
                    .localDateTime(findMateRoom.getPlanTime())
                    .headCount(findMateRoom.getHeadCount())
                    .roomWriter(findMateRoom.getRoomWriter())
                    .roomMessage(findMateRoom.getRoomMessage())
                    .users(null)
                    .build();

            return findMateRoomPageDto;
        }
    }
}
