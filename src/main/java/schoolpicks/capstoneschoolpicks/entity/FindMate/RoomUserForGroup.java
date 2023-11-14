package schoolpicks.capstoneschoolpicks.entity.FindMate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor // constructor 생성
@NoArgsConstructor // getter, setter 생성


public class RoomUserForGroup {
    @Id @GeneratedValue
    @Column(name = "ROOM_USER_FOR_GROUP_ID")
    private Long Id;

    private String userName;
    private String SKKUId;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "FIND_MATE_ROOM_ID")
    private FindMateRoom findMateRoom;
}
