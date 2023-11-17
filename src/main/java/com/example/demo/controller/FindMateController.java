package com.example.demo.controller;

import com.example.demo.dto.FindMate.FindMateRoomDto;
import com.example.demo.dto.FindMate.FindMateRoomForm;
import com.example.demo.dto.FindMate.FindMateRoomPageDto;
import com.example.demo.dto.FindMate.FindMateRoomPageForm;
import com.example.demo.service.FindMateRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Controller
@RequiredArgsConstructor
@Slf4j
public class FindMateController {

    private final FindMateRoomService findMateRoomService;
    private String roomId;
    private boolean isPrivate = true;

    @GetMapping("/mate")
    public String writeFindMateRoom(@ModelAttribute("findMateRoom") FindMateRoomForm findMateRoomForm) {
        return "find-mate-";
    }

    @PostMapping("/mate")
    public String postFindMateRoom(@ModelAttribute("findMateRoom") FindMateRoomForm findMateRoomForm, Model model) {

        //로그 찍기
        logPostFindMateRoom(findMateRoomForm);

        if (findMateRoomForm.getIsPrivate().equals("false")) {
            isPrivate = false;
        } else {
            isPrivate = true;
        }

        FindMateRoomDto findMateRoomDto = new FindMateRoomDto(
                findMateRoomForm.getRoomTitle(),
                findMateRoomForm.getShopName(),
                LocalDateTime.parse(findMateRoomForm.getPlanTime()),
                findMateRoomForm.getHeadCount(),
                findMateRoomForm.getRoomWriter(),
                findMateRoomForm.getRoomMessage(),
                isPrivate,
                findMateRoomForm.getRoomPassword()
        );

        roomId = findMateRoomService.createFindMateRoom(findMateRoomDto);
        model.addAttribute("roomId", roomId);

        //테스트용 유저 추가
        findMateRoomService.joinFindMateRoom("유저2", roomId);
        findMateRoomService.joinFindMateRoom("유저3", roomId);
        findMateRoomService.joinFindMateRoom("유저4", roomId);
        findMateRoomService.joinFindMateRoom("유저5", roomId);

        log.info("Before roomId = " + roomId);
        log.info("Before isPrivacy = " + isPrivate);

        return "find-mate-check";
    }

    @GetMapping("/mate/check/{roomId}")
    public String checkFindMateRoom(@PathVariable String roomId, Model model) {
        model.addAttribute("roomId", roomId);
        return "find-mate-check";
    }



    @GetMapping("/mate/room/{roomId}")
    public String showFindMateRoom(@PathVariable String roomId, @ModelAttribute("findMateRoomPage") FindMateRoomPageForm findMateRoomPageForm, Model model) {

        log.info("=== @GetMapping showFindMateRoom 접근 ===");
        log.info("roomId = " + roomId);
        log.info("isPrivacy = " + isPrivate);

        FindMateRoomPageDto findMateRoomPageDto;
        if (isPrivate) {
            findMateRoomPageDto = findMateRoomService.showFindMateRoomWithBlindMode(roomId);
        } else {
            findMateRoomPageDto = findMateRoomService.showFindMateRoom(roomId);
        }

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

        log.info("year = " + year);
        log.info("month = " + month);
        log.info("date = " + date);
        log.info("day = " + day);
        log.info("time = " + time);

        findMateRoomPageForm.setYear(year);
        findMateRoomPageForm.setMonth(month);
        findMateRoomPageForm.setDate(date);
        findMateRoomPageForm.setDay(day);
        findMateRoomPageForm.setTime(time);
        findMateRoomPageForm.setHeadCount(findMateRoomPageDto.getHeadCount());
        findMateRoomPageForm.setRoomWriter(findMateRoomPageDto.getRoomWriter());
        findMateRoomPageForm.setRoomMessage(findMateRoomPageDto.getRoomMessage());
        findMateRoomPageForm.setUsers(findMateRoomPageDto.getUsers());

        return "find-mate-ver1";
    }

    @GetMapping("/mate/instagram/{roomId}")
    public String shareInstagram(@PathVariable String roomId, @ModelAttribute("findMateRoomPage") FindMateRoomPageForm findMateRoomPageForm, Model model) {

        FindMateRoomPageDto findMateRoomPageDto;
        if (isPrivate) {
            findMateRoomPageDto = findMateRoomService.showFindMateRoomWithBlindMode(roomId);
        } else {
            findMateRoomPageDto = findMateRoomService.showFindMateRoom(roomId);
        }

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

        findMateRoomPageForm.setYear(year);
        findMateRoomPageForm.setMonth(month);
        findMateRoomPageForm.setDate(date);
        findMateRoomPageForm.setDay(day);
        findMateRoomPageForm.setTime(time);
        findMateRoomPageForm.setHeadCount(findMateRoomPageDto.getHeadCount());
        findMateRoomPageForm.setRoomWriter(findMateRoomPageDto.getRoomWriter());
        findMateRoomPageForm.setRoomMessage(findMateRoomPageDto.getRoomMessage());
        findMateRoomPageForm.setUsers(findMateRoomPageDto.getUsers());

        model.addAttribute("roomId", roomId);

        return "ver1-instagram-story";
    }

    private static void logPostFindMateRoom(FindMateRoomForm findMateRoomForm) {
        log.info("=== Post 완료! ===");
        log.info("게시글 제목 = " + findMateRoomForm.getRoomTitle());
        log.info("음식점 이름 = " + findMateRoomForm.getShopName());
        log.info("날짜 및 시간 = " + findMateRoomForm.getPlanTime());
        log.info("인원수 = " + findMateRoomForm.getHeadCount());
        log.info("게시글 작성자 = " + findMateRoomForm.getRoomWriter());
        log.info("작성자의 메시지 = " + findMateRoomForm.getRoomMessage());
        log.info("친구이름 공개/비공개 = " + findMateRoomForm.getIsPrivate());
        log.info("게시글 수정 비밀번호(4자리) = " + findMateRoomForm.getRoomPassword());
    }


}
