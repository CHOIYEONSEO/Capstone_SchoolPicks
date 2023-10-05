package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.domain.form.SignUpForm;
import com.example.demo.service.SignUpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class SignUpController {

    private final SignUpService signUpService;

    @GetMapping("/sign_up")
    public String signupForm(@ModelAttribute("form") SignUpForm signUpForm) {
        return "sign_up";
    }

    @PostMapping("/sign_up")
    public String signUp(SignUpForm form) {

        Member member = new Member();
        member.setLoginId(form.getLoginId());
        member.setNickname(form.getNickname());
        member.setEmail(form.getEmail());
        member.setPassword(form.getPassword());
        member.setStudentId(form.getStudentId());
        member.setDepartment(form.getDepartment());
        member.setSex(form.getSex());
        member.setAge(form.getAge());

        log.info("Member Nickname = " + member.getNickname());
        log.info("Member studentId = " + member.getStudentId());

        signUpService.save(member);

        return "redirect:/";
    }
}
