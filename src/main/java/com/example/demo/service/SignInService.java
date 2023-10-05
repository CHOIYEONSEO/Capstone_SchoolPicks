package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignInService {

    private final MemberRepository memberRepository;

    public Member signIn(String loginId, String password) {

        /**
         * loginId와 password 검증
         * 맞으면 member 반환, 틀리면 null 반환
         */
        /*return memberRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);*/

        return new Member();
    }
}
