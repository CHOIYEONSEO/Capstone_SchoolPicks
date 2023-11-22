package com.example.demo.dto.FindMate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetRoomListDto {
    String roomId;
    String roomTitle;
    String roomWriter;
    LocalDateTime planTime;
}
