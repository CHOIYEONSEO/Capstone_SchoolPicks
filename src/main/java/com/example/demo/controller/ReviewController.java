package com.example.demo.controller;

import com.example.demo.service.ShopRecommendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
@Slf4j
public class ReviewController {

    private final ShopRecommendService shopRecommendService;

    @GetMapping("/reviewver2")
    public String reviewVer2() {
        return "reviewver2";
    }








}
