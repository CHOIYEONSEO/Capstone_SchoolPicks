package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {

    @GetMapping("/main")
    public String indexMain() {
        return "main";
    }

    /*@GetMapping("/sign_in")
    public String indexSignIn() {
        return "sign_in";
    }

    @GetMapping("/menu_recommendation_HSSC")
    public String indexHSSC() {
        return "menu_recommendation_HSSC";
    }

    @GetMapping("/menu_recommendation_NSC")
    public String indexNSC() {
        return "menu_recommendation_NSC";
    }*/
}
