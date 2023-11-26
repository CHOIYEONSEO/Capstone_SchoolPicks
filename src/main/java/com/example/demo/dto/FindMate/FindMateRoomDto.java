package com.example.demo.dto.FindMate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindMateRoomDto {

    String roomTitle;
    String shopName;

    LocalDateTime planTime;

    LocalDateTime expiredTime;

    int headCount;

    String roomWriter;

    String roomMessage;

    boolean isPrivate;

    String roomPassword;

    int version;
}
