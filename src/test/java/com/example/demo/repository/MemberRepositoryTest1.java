package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Member;

@SpringBootTest
public class MemberRepositoryTest1 {

	@Autowired
	MemberRepository memberRepository;
	
	@Test
	public void Quiz8_1() {
		List<Member> list = memberRepository.select("user");
		
		for (Member member : list ) {
			System.out.println(member);
		}
	}
	
	@Test
	public void Quiz8_2() {
		List<Member> list = memberRepository.select2("관리자");
		
		for(Member member : list) {
			System.out.println(member);
		}
		
	}
	
}
