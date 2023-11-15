package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/detail")
    public String detail() {
        return "detail";
    }

    /*@GetMapping("/find-mate-")
    public String findMate() {
        return "find-mate-";
    }*/

    /*@GetMapping("/find-mate-ver1")
    public String findMateVer1() {
        return "find-mate-ver1";
    }*/

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    /*@GetMapping("/reviewver2")
    public String reviewVer2() {
        return "reviewver2";
    }*/

    @GetMapping("/ver1-instagram-story")
    public String instagramStory() {
        return "ver1-instagram-story";
    }


    @GetMapping("/test/tempt1")
    public String test1() {
        return "tempt1";
    }

    @PostMapping("/test/tempt1")
    public String test1Post() {
        return "tempt2";
    }

    @GetMapping("/test/tempt2")
    public String test2() {
        return "tempt2";
    }
}
