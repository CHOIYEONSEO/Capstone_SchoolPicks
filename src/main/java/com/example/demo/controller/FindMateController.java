package com.example.demo.controller;

import com.example.demo.dto.FindMate.FindMateRoomDto;
import com.example.demo.dto.FindMate.FindMateRoomForm;
import com.example.demo.dto.FindMate.FindMateRoomPageDto;
import com.example.demo.dto.FindMate.FindMateRoomPageForm;
import com.example.demo.dto.ResponseDto;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


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
    public String postFindMateRoom(@ModelAttribute("findMateRoom") FindMateRoomForm findMateRoomForm, Model model
            , RedirectAttributes redirectAttributes) {
        //로그 찍기
        logPostFindMateRoom(findMateRoomForm);

        if (findMateRoomForm.getIsPrivate().equals("false")) {
            isPrivate = false;
        } else {
            isPrivate = true;
        }

        FindMateRoomDto findMateRoomDto = null;

        try{
            findMateRoomDto = new FindMateRoomDto(
                    findMateRoomForm.getRoomTitle(),
                    findMateRoomForm.getShopName(),
                    LocalDateTime.parse(findMateRoomForm.getPlanTime()),
                    LocalDateTime.parse(findMateRoomForm.getExpiredTime()),
                    findMateRoomForm.getHeadCount(),
                    findMateRoomForm.getRoomWriter(),
                    findMateRoomForm.getRoomMessage(),
                    isPrivate,
                    findMateRoomForm.getRoomPassword(),
                    findMateRoomForm.getVersion()
            );
        } catch(DateTimeParseException e){ // 시간값 제대로 입력 안한 경우 처리
            return "find-mate-";
        }

        ResponseDto<String> response = findMateRoomService.createFindMateRoom(findMateRoomDto);

        if(!response.getResult()){ // 시간값이 앞이거나 다른 값을 제대로 안 넣은 경우 처리
            return "find-mate-";
        }


        // 이거 나중에 출력하실 때 사용하세요.
        model.addAttribute("message", response.getMessage());

        String roomId = response.getData();
        model.addAttribute("roomId", roomId);


        log.info("Before roomId = " + roomId);
        log.info("Before isPrivacy = " + isPrivate);

        int version = findMateRoomForm.getVersion();
        if (version == 4) {
            version = (int) ((Math.random() * 10000) % 3) + 1;
        }
        log.info("version = " + version);

        if (version == 1) {
            return "redirect:/mate/room/ver1/" + roomId;
        } else if (version == 2) {
            return "redirect:/mate/room/ver2/" + roomId;
        } else if (version == 3) {
            return "redirect:/mate/room/ver3/" + roomId;
        } else {
            return "find-mate";
        }
    }

    @GetMapping("/mate/room/ver1/{roomId}")
    public String showFindMateRoomVer1(@PathVariable String roomId, @ModelAttribute("findMateRoomPage") FindMateRoomPageForm findMateRoomPageForm, Model model) {

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


        return "find-mate-ver1";
    }

    /**
     * 수정하기
     * 기존에 있던 게시글을 리포지토리에서 삭제하고, 게시글을 만드는 페이지로 이동한다
     */
    @PostMapping("/mate/room/ver1/{roomId}")
    public String editFindMateRoomVer1(@PathVariable String roomId) {
        findMateRoomService.deleteFindMateRoom(roomId);
        return "find-mate-";
    }

    @GetMapping("/mate/room/ver2/{roomId}")
    public String showFindMateRoomVer2(@PathVariable String roomId, @ModelAttribute("findMateRoomPage") FindMateRoomPageForm findMateRoomPageForm, Model model) {

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

        return "find-mate-ver2";
    }


    @GetMapping("/mate/room/ver3/{roomId}")
    public String showFindMateRoomVer3(@PathVariable String roomId, @ModelAttribute("findMateRoomPage") FindMateRoomPageForm findMateRoomPageForm, Model model) {

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

        return "find-mate-ver3";
    }


    @GetMapping("/mate/instagram/ver1/{roomId}")
    public String shareInstagramVer1(@PathVariable String roomId, @ModelAttribute("findMateRoomPage") FindMateRoomPageForm findMateRoomPageForm, Model model) {

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

        model.addAttribute("roomId", roomId);

        return "ver1-instagram-story";
    }

    @GetMapping("/mate/instagram/ver2/{roomId}")
    public String shareInstagramVer2(@PathVariable String roomId, @ModelAttribute("findMateRoomPage") FindMateRoomPageForm findMateRoomPageForm, Model model) {

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

        model.addAttribute("roomId", roomId);

        return "ver2-instagram-story";
    }

    @GetMapping("/mate/instagram/ver3/{roomId}")
    public String shareInstagramVer3(@PathVariable String roomId, @ModelAttribute("findMateRoomPage") FindMateRoomPageForm findMateRoomPageForm, Model model) {

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

        model.addAttribute("roomId", roomId);

        return "ver3-instagram-story";
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
