package com.example.demo.repository;

import com.example.demo.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements  MemberRepository{

    private static Map<Long, Member> store=new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member->member.getName().equals(name))
                .findAny(); //람다? 를 이용하여 멤버 리스트를 돌면서 파라미터name과 같은 name 을 찾기 위해서 getNmae()사용


    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }



    public  void clearStore(){
        store.clear();
    }
}
