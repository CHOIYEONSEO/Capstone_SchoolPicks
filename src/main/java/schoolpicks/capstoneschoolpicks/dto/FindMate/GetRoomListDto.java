package schoolpicks.capstoneschoolpicks.dto.FindMate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetRoomListDto {

    String roomTitle;
    String roomWriter;

}
