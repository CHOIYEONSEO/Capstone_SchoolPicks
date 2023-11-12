package schoolpicks.capstoneschoolpicks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import schoolpicks.capstoneschoolpicks.entity.FindMate.FindMateRoom;

import java.util.List;

@Repository
public interface FindMateRoomRepository extends JpaRepository<FindMateRoom, Long> {

    @Query("SELECT f FROM FindMateRoom f JOIN FETCH f.roomUsers WHERE f.roomId = :roomId")
    FindMateRoom findFindMateRoomWithRoomUsers(String roomId);

    FindMateRoom findByRoomId(String roomId);

    List<FindMateRoom> findByRoomWriterAndRoomPassword(String roomWriter, String roomPassword);
}
