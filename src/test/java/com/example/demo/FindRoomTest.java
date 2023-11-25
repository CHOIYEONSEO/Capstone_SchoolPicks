package com.example.demo;

import com.example.demo.dto.Recommend.SpecificDto;
import com.example.demo.entity.Shop.Shop;
import com.example.demo.service.FindMateRoomService;
import com.example.demo.service.ShopRecommendService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class FindRoomTest {
    @Autowired
    FindMateRoomService findMateRoomService;

    @Autowired
    ShopRecommendService shopRecommendService;

    @Test
    void 제목및작성자검색테스트(){
        findMateRoomService.findMateRoomSearch("스트");
    }

    @Test
    void 전체방조회테스트(){
        System.out.println(findMateRoomService.findAllFindMateRoom());
    }
}
