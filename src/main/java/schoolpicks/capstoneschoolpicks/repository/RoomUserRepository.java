package schoolpicks.capstoneschoolpicks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import schoolpicks.capstoneschoolpicks.entity.FindMate.RoomUser;

@Repository
public interface RoomUserRepository extends JpaRepository<RoomUser, Long> {
}
