package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Gift;

@SpringBootTest
public class GiftRepositoryTest1 {

	@Autowired
	GiftRepository giftRepository;
	
	@Test
	public void Quiz6_1() {
		List<Gift> list = giftRepository.select(50000);
		
		for (Gift gift : list) {
			System.out.println(gift);
		}
	}
	
	@Test
	public void Quiz6_2() {
		List<Gift> list = giftRepository.select2("세트");
		
		for (Gift gift : list) {
			System.out.println(gift);
		}
	}
	
	@Test
	public void Quiz6_3() {
		List<Gift> list = giftRepository.select3(40000, "생활용품");
		
		for (Gift gift : list) {
			System.out.println(gift);
		}
	}
	
}
