package com.example.demo.dto.FindMate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindMateRoomPageForm {

    String shopName;
    String year;
    String month;
    String date; //29일
    String day; //요일
    String time;

    int headCount;
    String roomWriter;
    String roomMessage;

    List<String> users = new ArrayList<>();
}
