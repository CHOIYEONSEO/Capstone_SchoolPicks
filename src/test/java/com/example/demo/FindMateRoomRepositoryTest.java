package com.example.demo;

import com.example.demo.entity.FindMate.FindMateRoom;
import com.example.demo.repository.FindMateRoomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class FindMateRoomRepositoryTest {
    @Autowired
    FindMateRoomRepository findMateRoomRepository;

    @Test
    void 페치조인테스트(){
        FindMateRoom findMateRoom = findMateRoomRepository.findFindMateRoomWithRoomUsers("50f7a288-edd7-4ab7-8e73-bf77e0eb4a0b");

        System.out.println(findMateRoom.getRoomWriter());
    }
}
