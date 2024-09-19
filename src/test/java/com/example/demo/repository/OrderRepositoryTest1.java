package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;

@SpringBootTest
public class OrderRepositoryTest1 {

	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void Quiz7_1() {
		List<Order> list = orderRepository.select("인천");
		
		for(Order order : list) {
			System.out.println(order);
		}
	}
	
	@Test
	public void Quiz7_2() {
		List<Order> list = orderRepository.select2("07-03");
		
		for(Order order : list) {
			System.out.println(order);
		}
	}
	
}
