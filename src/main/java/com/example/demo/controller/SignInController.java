package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.domain.form.SignInForm;
import com.example.demo.service.SignInService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.example.demo.SessionConst.*;


@Controller
@RequiredArgsConstructor
@Slf4j
public class SignInController {

    private final SignInService signInService;

    /*@GetMapping("/")
    public String signInForm(@ModelAttribute("form") SignInForm signInForm,
                             @SessionAttribute(name = SIGN_IN_MEMBER, required = false) Member signInMember,
                             Model model) {

        *//**
         * 세션에 회원 데이터가 없으면 로그인 페이지
         *//*
        if (signInMember == null) {
            return "sign_in";
        }

        *//**
         * 세션이 유지된다면 로그인이 되어있는 상태이므로 메인화면으로 이동
         *//*
        model.addAttribute("member", signInMember);
        return "main";
    }

    @PostMapping("/")
    public String signIn(@Valid @ModelAttribute("form") SignInForm signInForm, BindingResult bindingResult,
                         HttpServletRequest request) {

        *//**
         * loginService 에서 로그인 하는 로직. 틀리면 다시 이 주소로
         *//*
        if (bindingResult.hasErrors()) {
            return "/sign_in";
        }

        Member signInMember = signInService.signIn(signInForm.getLoginId(), signInForm.getPassword());

        if (signInMember == null) {
            log.info("signInMember == null 진입");
            bindingResult.reject(SIGN_IN_FAIL, "아이디 또는 비밀번호가 맞지 않습니다.");
            return "/sign_in";
        }


        *//**
         * 로그인 성공처리
         * 세션 있으면 세션 반환, 없으면 신규 세션 생성
         * 세션에 로그인 회원 정보 보관
         *//*
        HttpSession session = request.getSession();
        session.setAttribute(SIGN_IN_MEMBER, signInMember);

        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {

        *//**
         * 로그아웃: 세션을 해제합니다
         *//*
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }*/
}
