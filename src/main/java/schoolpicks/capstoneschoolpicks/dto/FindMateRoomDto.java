package schoolpicks.capstoneschoolpicks.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindMateRoomDto {

    String roomTitle;
    String shopName;

    LocalDateTime planTime;

    int headCount;

    String roomWriter;

    String roomMessage;

    boolean isPrivate;

    String roomPassword;
}
