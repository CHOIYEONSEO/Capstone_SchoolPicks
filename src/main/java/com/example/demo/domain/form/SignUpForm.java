package com.example.demo.domain.form;

import com.example.demo.domain.Department;
import com.example.demo.domain.Sex;
import lombok.Data;

@Data
public class SignUpForm {

    private String loginId;
    private String nickname;
    private String email;
    private String password;
    private int studentId;
    private Department department;
    private Sex sex;
    private int age;

}
