package com.example.demo.repository;

import com.example.demo.domain.Member;

import javax.swing.*;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);//없을면 null을 반환 하는데 거기에 대한 최근 방법중 하나  optional
    Optional<Member> findByName(String name);
    List<Member> findAll();




}
