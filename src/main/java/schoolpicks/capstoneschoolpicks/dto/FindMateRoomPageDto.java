package schoolpicks.capstoneschoolpicks.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindMateRoomPageDto {

    LocalDateTime localDateTime;
    int headCount;
    String roomWriter;
    String roomMessage;

    List<String> users = new ArrayList<>();
}
