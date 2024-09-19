package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Member;

@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	MemberRepository memberRepository;
	
	@Test
	public void 데이터추가() {
		List<Member> list = new ArrayList<>();
		
		Member member1 = Member.builder()
																						.userId("admin")
																						.grade("관리자")
																						.password("1234")
																						.build();
		
		Member member2 = Member.builder()
																						.userId("user1")
																						.grade("사용자")
																						.password("1234")
																						.build();
		
		Member member3 = Member.builder()
																						.userId("user2")
																						.grade("사용자")
																						.password("1234")
																						.build();
		
		Member member4 = Member.builder()
																						.userId("yoyt22")
																						.grade("관리자")
																						.password("1234")
																						.build();

		list.add(member1);
		list.add(member2);
		list.add(member3);
		list.add(member4);
		
		memberRepository.saveAll(list);
		
	}
	
	// 단건 조회
	@Test
	public void 단건조회() {
		Optional<Member> result = memberRepository.findById("admin");
		
		if(result.isPresent()) {
			System.out.println(result);
		}
		
	}
	
	// 전체 조회
	@Test
	public void 전체조회() {
		List<Member> list = memberRepository.findAll();
		
		for(Member member : list) {
			System.out.println(member);
		}
		
	}
	
	// 수정
	
	@Test
	public void 수정() {
		Optional<Member> result = memberRepository.findById("admin");
		
		Member member = result.get();
		member.setGrade("수정됨");
		
		memberRepository.save(member);
	}
	
	// 단건 삭제
	@Test
	public void 단건삭제() {
		memberRepository.deleteById("user1");
	}
	
}
