package com.example.demo.dto.FindMate;

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

    String roomId;
    LocalDateTime localDateTime;
    int headCount;
    String roomWriter;
    String roomMessage;
    String roomPassword;
    String shopName;

    List<String> users = new ArrayList<>();
}
