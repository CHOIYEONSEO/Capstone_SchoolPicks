package com.example.demo;

import com.example.demo.service.FindMateRoomService;
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

    @Test
    void 전체방조회테스트(){
        System.out.println(findMateRoomService.findAllFindMateRoom());
    }
}
