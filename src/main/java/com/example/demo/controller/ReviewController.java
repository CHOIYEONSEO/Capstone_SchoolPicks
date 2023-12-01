package com.example.demo.controller;

import com.example.demo.dto.FindMate.FindMateRoomPageDto;
import com.example.demo.dto.FindMate.FindMateRoomPageForm;
import com.example.demo.dto.FindMate.KeywordForm;
import com.example.demo.entity.FindMate.FindMateRoom;
import com.example.demo.entity.FindMate.RoomUser;
import com.example.demo.service.FindMateRoomService;
import com.example.demo.service.ShopRecommendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.time.format.DateTimeFormatter;
import java.util.List;



@Controller
@RequiredArgsConstructor
@Slf4j
public class ReviewController {

    private final FindMateRoomService findMateRoomService;

    @GetMapping("/review")
    public String reviewVer2(@ModelAttribute("keyword") KeywordForm keyword, Model model) {
        List<FindMateRoom> findMateRooms = findMateRoomService.findAllFindMateRoom();
        model.addAttribute("rooms", findMateRooms);
        return "reviewver2";
    }

    @PostMapping("/review")
    public String reviewSearch(@ModelAttribute("keyword") KeywordForm keywordForm, Model model) {
        List<FindMateRoom> findMateRooms = findMateRoomService.findMateRoomSearch(keywordForm.getKeyword());
        log.info("keyword = " + keywordForm.getKeyword());
        model.addAttribute("rooms", findMateRooms);
        return "reviewver2";
    }

    @GetMapping("/mate/room/ver1/review/{roomId}")
    public String showFindMateRoomVer1(@PathVariable String roomId, @ModelAttribute("findMateRoomPage") FindMateRoomPageForm findMateRoomPageForm, Model model) {

        FindMateRoomPageDto findMateRoomPageDto;
        findMateRoomPageDto = findMateRoomService.showFindMateRoom(roomId);

        String localDateTime = findMateRoomPageDto.getLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-E-HH-mm-ss"));
        String[] localDateTimeSplit = localDateTime.split("-");
        String year = localDateTimeSplit[0];
        String month = localDateTimeSplit[1];
        String date = localDateTimeSplit[2];
        String day = "(" + localDateTimeSplit[3] + ")";
        int hour = Integer.parseInt(localDateTimeSplit[4]);
        String minute = localDateTimeSplit[5];
        String time;
        if (hour >= 12) {
            time = "오후 " + (hour - 12) + ":" + minute;
        } else {
            time = "오전 " + hour + ":" + minute;
        }

        findMateRoomPageForm.setShopName(findMateRoomPageDto.getShopName());
        findMateRoomPageForm.setYear(year);
        findMateRoomPageForm.setMonth(month);
        findMateRoomPageForm.setDate(date);
        findMateRoomPageForm.setDay(day);
        findMateRoomPageForm.setTime(time);
        findMateRoomPageForm.setHeadCount(findMateRoomPageDto.getHeadCount());
        findMateRoomPageForm.setRoomWriter(findMateRoomPageDto.getRoomWriter());
        findMateRoomPageForm.setRoomMessage(findMateRoomPageDto.getRoomMessage());
        findMateRoomPageForm.setUsers(findMateRoomPageDto.getUsers());

        model.addAttribute("password", findMateRoomPageDto.getRoomPassword());
        model.addAttribute("addUser", new RoomUser());

        return "find-mate-ver1";
    }
}
