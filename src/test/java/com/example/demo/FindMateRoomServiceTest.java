package com.example.demo;

import com.example.demo.dto.FindMate.FindMateRoomDto;
import com.example.demo.dto.FindMate.FindMateRoomPageDto;
import com.example.demo.service.FindMateRoomService;
import com.example.demo.service.ShopRecommendService;
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
public class FindMateRoomServiceTest {
    @Autowired
    FindMateRoomService findMateRoomService;

    @Autowired
    EntityManager em;

//    @Test
//    void 글작성테스트(){
//
//        FindMateRoomDto findMateRoomDto = FindMateRoomDto.builder()
//                .roomTitle("오늘 밥 먹을사람")
//                .shopName("성대밥상")
//                .planTime(LocalDateTime.now())
//                .headCount(5)
//                .roomWriter("테스터")
//                .roomPassword("1234")
//                .roomMessage("밥먹자고오오")
//                .isPrivate(true)
//                .version(1)
//                .build();
//
//        String roomId = findMateRoomService.createFindMateRoom(findMateRoomDto);
//
//        em.flush();
//        em.clear();
//
//    }

    @Test
    void 유저추가테스트(){
        findMateRoomService.joinFindMateRoom("테스터2", "773610fe-f1fd-4f88-a75c-b125d3c43f0c");
        em.flush();
        em.clear();
    }

    // version 반영된 것 확인
    @Test
    void 방조회_공개(){
        FindMateRoomPageDto findMateRoomPageDto = findMateRoomService.showFindMateRoom("773610fe-f1fd-4f88-a75c-b125d3c43f0c");

        Assertions.assertThat(findMateRoomPageDto.getVersion()).isEqualTo(1);
    }

    @Test
    void 방조회_비공개(){
        FindMateRoomPageDto findMateRoomPageDto = findMateRoomService.showFindMateRoomWithBlindMode("773610fe-f1fd-4f88-a75c-b125d3c43f0c");

        Assertions.assertThat(findMateRoomPageDto.getVersion()).isEqualTo(1);
    }


    @Test
    void 제목및작성자검색테스트(){
        findMateRoomService.findMateRoomSearch("스트");
    }

    @Test
    void 전체방조회테스트(){
        System.out.println(findMateRoomService.findAllFindMateRoom());
    }
}
