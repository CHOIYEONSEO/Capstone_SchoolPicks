package com.example.demo.repository;

import com.example.demo.entity.FindMate.RoomUserForGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomUserForGroupRepository extends JpaRepository<RoomUserForGroup, Long> {
}
