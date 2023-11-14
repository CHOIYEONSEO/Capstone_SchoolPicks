package schoolpicks.capstoneschoolpicks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import schoolpicks.capstoneschoolpicks.repository.FindMateRoomRepository;
import schoolpicks.capstoneschoolpicks.repository.RoomUserForGroupRepository;
import schoolpicks.capstoneschoolpicks.repository.RoomUserRepository;
import schoolpicks.capstoneschoolpicks.service.FindMateRoomService;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class ExtraServiceTest {

    @Autowired
    FindMateRoomRepository findMateRoomRepository;

    @Autowired
    RoomUserForGroupRepository roomUserForGroupRepository;

    @Autowired
    RoomUserRepository roomUserRepository;

    @Autowired
    FindMateRoomService findMateRoomService;

    @Autowired
    EntityManager em;

    @Test

}
