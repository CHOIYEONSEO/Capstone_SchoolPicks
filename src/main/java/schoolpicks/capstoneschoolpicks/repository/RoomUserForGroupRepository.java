package schoolpicks.capstoneschoolpicks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import schoolpicks.capstoneschoolpicks.entity.FindMate.RoomUserForGroup;

@Repository
public interface RoomUserForGroupRepository extends JpaRepository<RoomUserForGroup, Long> {
}
