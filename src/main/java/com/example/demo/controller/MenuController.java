package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MenuController {

    @GetMapping("/menu_recommendation_NSC")
    public String findRestaurantNSC() {
        return "menu_recommendation_NSC";
    }

    @GetMapping("/menu_recommendation_HSSC")
    public String findRestaurantHSSC() {
        return "menu_recommendation_HSSC";
    }
}
