package com.example.demo;

import com.example.demo.dto.FindMate.FindMateRoomDto;
import com.example.demo.repository.FindMateRoomRepository;
import com.example.demo.repository.RoomUserRepository;
import com.example.demo.service.FindMateRoomService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class RoomTest {

    @Autowired
    FindMateRoomRepository findMateRoomRepository;

    @Autowired
    RoomUserRepository roomUserRepository;

    @Autowired
    FindMateRoomService findMateRoomService;

    @Autowired
    EntityManager em;


    @Test
    void 방생성(){

        FindMateRoomDto findMateRoomDto = FindMateRoomDto.builder()
                .roomTitle("테스트")
                .roomWriter("백명규")
                .roomPassword("1234")
                .headCount(8)
                .planTime(LocalDateTime.now())
                .isPrivate(true)
                .shopName("우리집")
                .roomMessage("테스트입니다.")
                .build();

        findMateRoomService.createFindMateRoom(findMateRoomDto);

        em.flush();
        em.clear();
    }

    @Test
    void 유저주입(){

        String roomId = "b76cd42a-bd9d-4393-b041-dd9e2387ca2c";
        String userName = "이재홍";

        findMateRoomService.joinFindMateRoom(userName, roomId);

        em.flush();
        em.clear();
    }

    @Test
    void 유저내역전체조회(){
        String roomId = "b76cd42a-bd9d-4393-b041-dd9e2387ca2c";

        Assertions.assertThat(findMateRoomService.showFindMateRoom(roomId).getUsers().size()).isEqualTo(2);

    }

    @Test
    void 방전체조회(){
        String userName = "백명규";
        String password = "1234";

        System.out.println(findMateRoomService.showRoomList(userName, password));
    }
}
