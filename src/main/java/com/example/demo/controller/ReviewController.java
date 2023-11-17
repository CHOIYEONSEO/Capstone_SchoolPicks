package com.example.demo.controller;

import com.example.demo.entity.FindMate.FindMateRoom;
import com.example.demo.service.FindMateRoomService;
import com.example.demo.service.ShopRecommendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;


@Controller
@RequiredArgsConstructor
@Slf4j
public class ReviewController {

    private final FindMateRoomService findMateRoomService;

    @GetMapping("/review")
    public String reviewVer2(Model model) {


        List<FindMateRoom> findMateRooms = findMateRoomService.findAllFindMateRoom();

        log.info("rooms(0) id = " + findMateRooms.get(0).getId());
        log.info("rooms(0) title = " + findMateRooms.get(0).getRoomTitle());
        log.info("rooms(0) writer = " + findMateRooms.get(0).getRoomWriter());

        model.addAttribute("rooms", findMateRooms);

        return "reviewver2";
    }

}
