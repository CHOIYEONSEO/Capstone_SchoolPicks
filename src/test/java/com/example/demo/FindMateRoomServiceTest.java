package com.example.demo;

import com.example.demo.dto.FindMate.FindMateRoomDto;
import com.example.demo.dto.FindMate.FindMateRoomPageDto;
import com.example.demo.dto.FindMate.GetRoomListDto;
import com.example.demo.repository.FindMateRoomRepository;
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
import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class FindMateRoomServiceTest {
    @Autowired
    FindMateRoomService findMateRoomService;

    @Autowired
    FindMateRoomRepository findMateRoomRepository;

    @Autowired
    EntityManager em;

    @Test
    void 글작성테스트(){

        FindMateRoomDto findMateRoomDto = FindMateRoomDto.builder()
                .roomTitle("오늘 밥 먹을사람")
                .shopName("성대밥상")
                .planTime(LocalDateTime.now().plusMinutes(60))
                .expiredTime(LocalDateTime.now().plusMinutes(30))
                .headCount(5)
                .roomWriter("테스터")
                .roomPassword("1234")
                .roomMessage("밥먹자고오오")
                .isPrivate(true)
                .version(1)
                .build();

        findMateRoomService.createFindMateRoom(findMateRoomDto);

        em.flush();
        em.clear();

    }

    @Test
    void 글작성테스트2(){

        FindMateRoomDto findMateRoomDto = FindMateRoomDto.builder()
                .roomTitle("오늘 밥 먹을사람")
                .shopName("성대밥상")
                .planTime(LocalDateTime.now().plusMinutes(60))
                .expiredTime(LocalDateTime.now().plusMinutes(30))
                .headCount(5)
                .roomWriter("테스터")
                .roomPassword("1234")
                .roomMessage("밥먹자고오오")
                .isPrivate(false)
                .version(1)
                .build();

        findMateRoomService.createFindMateRoom(findMateRoomDto);


    }

    @Test
    void 유저추가테스트(){
        findMateRoomService.joinFindMateRoom("테스터2", "90ab052a-09f9-4176-83b2-b36ae0bdab7b");
        em.flush();
        em.clear();
    }

    // version 반영된 것 확인
    @Test
    void 방조회_공개(){
        FindMateRoomPageDto findMateRoomPageDto = findMateRoomService.showFindMateRoom("90ab052a-09f9-4176-83b2-b36ae0bdab7b");

        Assertions.assertThat(findMateRoomPageDto.getVersion()).isEqualTo(1);
    }

    @Test
    void 방조회_비공개(){
        FindMateRoomPageDto findMateRoomPageDto = findMateRoomService.showFindMateRoomWithBlindMode("90ab052a-09f9-4176-83b2-b36ae0bdab7b");

        Assertions.assertThat(findMateRoomPageDto.getVersion()).isEqualTo(1);
    }

    @Test
    void 방모드조회(){

        Assertions.assertThat(findMateRoomService.getIsPrivate("90ab052a-09f9-4176-83b2-b36ae0bdab7b"))
                .isEqualTo(true);
    }
    @Test
    void 제목및작성자검색테스트(){
        findMateRoomService.findMateRoomSearch("스트");
    }

    @Test
    void 전체방조회테스트(){
        System.out.println(findMateRoomService.findAllFindMateRoom());
    }

    @Test
    void 방내부유저조회테스트(){
        List<String> users = findMateRoomService.getUserNameInBlindMode("90ab052a-09f9-4176-83b2-b36ae0bdab7b", "1234");

        Assertions.assertThat(users.size()).isEqualTo(5);
    }

    @Test
    void 방유저이름_검색테스트(){
        List<GetRoomListDto> getRoomListDtos = findMateRoomService.showRoomList("백명규", "1234");

        Assertions.assertThat(getRoomListDtos.size()).isEqualTo(6);
    }
    @Test
    void 방삭제테스트(){
        findMateRoomService.deleteFindMateRoom("8fef8395-91aa-4f65-b184-d8c2ba8a9432");

        Assertions.assertThat(findMateRoomRepository.findByRoomId("8fef8395-91aa-4f65-b184-d8c2ba8a9432"))
                .isEqualTo(null);
    }
}
