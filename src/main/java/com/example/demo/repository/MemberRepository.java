package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MemberRepository {

    public Optional<Member> findByLoginId(String loginId) {
        return Optional.of(new Member());
    }

    public Member save(Member member) {
        return member;
    }

}
