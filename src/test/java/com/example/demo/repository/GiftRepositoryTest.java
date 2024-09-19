package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Gift;

@SpringBootTest
public class GiftRepositoryTest {

	@Autowired
	GiftRepository giftRepository ;
	
	@Test
	public void 기프트테스트() {
		
		List<Gift> list = new ArrayList<>();
		
		Gift gift1 = Gift .builder().name("참치세트").price(10000).type("식품").build();
		Gift gift2 = Gift .builder().name("햄세트").price(20000).type("식품").build();
		Gift gift3 = Gift .builder().name("삼푸세트").price(30000).type("생활용품").build();
		Gift gift4 = Gift .builder().name("세차용품").price(40000).type("생활용품").build();
		Gift gift5 = Gift .builder().name("주방용품").price(50000).type("생활용품").build();
		Gift gift6 = Gift .builder().name("노트북").price(60000).type("가전제품").build();
		
		Gift gift7 = Gift .builder().name("벽걸이TV").price(70000).type("가전제품").build();
		
		list.add(gift1);
		list.add(gift2);
		list.add(gift3);
		list.add(gift4);
		list.add(gift5);
		list.add(gift6);
		list.add(gift7);
		
		giftRepository.saveAll(list);
		
	}
	
	@Test
	public void 단건조회() {
		Optional<Gift> result = giftRepository.findById(1);
		
		if(result.isPresent()) {
			Gift gift = result.get();
			System.out.println(gift);
		}
	}
	
	@Test
	public void 전체조회() {
		List<Gift> list = giftRepository.findAll();
		
		for(Gift gift : list ) {
			System.out.println(gift);
		}
	}
	
	@Test
	public void 데이터수정() {
		Optional<Gift> result = giftRepository.findById(1);
		Gift gift = result.get();
		gift.setName("수정된것");
	}
	
	@Test
	public void 단건삭제() {
		giftRepository.deleteById(4);
	}
	
}
