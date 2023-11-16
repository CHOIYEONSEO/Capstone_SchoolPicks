package com.example.demo.repository;

import com.example.demo.entity.FindMate.FindMateRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FindMateRoomRepository extends JpaRepository<FindMateRoom, Long> {

    @Query("SELECT f FROM FindMateRoom f JOIN FETCH f.roomUsers WHERE f.roomId = :roomId")
    FindMateRoom findFindMateRoomWithRoomUsers(@Param("roomId") String roomId);

    FindMateRoom findByRoomId(String roomId);

    List<FindMateRoom> findByRoomWriterAndRoomPassword(String roomWriter, String roomPassword);
}
