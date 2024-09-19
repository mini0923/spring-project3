package com.example.demo.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;

@SpringBootTest
public class OrderRepositoryTest {

	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void 데이터추가() {
		
		List<Order> list = new ArrayList<>();
		LocalDate localDate1 = LocalDate.of(2024,7,1);
		LocalDate localDate2 = LocalDate.of(2024,7,2);
		LocalDate localDate3 = LocalDate.of(2024,7,3);
		Order order1 = Order.builder()
																		.customerName("둘리")
																		.orderDate(localDate1)
																		.shipAddress("인천 구월동")
																		.build();
		Order order2 = Order.builder()
																	.customerName("또치")
																	.orderDate(localDate2)
																	.shipAddress("인천 연수동")
																	.build();
		Order order3 = Order.builder()
																	.customerName("도우너")
																	.orderDate(localDate3)
																	.shipAddress("부산 동래동")
																	.build();
		Order order4 = Order.builder()
																	.customerName("마이콜")
																	.orderDate(localDate1)
																	.build();
		Order order5 = Order.builder()
																	.customerName("고길동")
																	.orderDate(localDate2)
																	.build();
		
		list.add(order1);
		list.add(order2);
		list.add(order3);
		list.add(order4);
		list.add(order5);
		
		orderRepository.saveAll(list);
	}
	
	@Test 
	public void 단건조회() {
		Optional<Order> result = orderRepository.findById(1);
		
		if(result.isPresent()) {
			System.out.println(result);
		}
		
	}
	
	@Test 
	public void 전체조회() {
		List<Order> list = orderRepository.findAll();
		
		for (Order order : list ) {
			System.out.println(order);
		}
		
	}
	
	@Test
	public void 데이터수정() {
		Optional<Order> result = orderRepository.findById(3);
		
		Order order = result.get();
		order.setShipAddress("수정된주소");
		
		orderRepository.save(order);
		
	}
	
	@Test
	public void 데이터삭제() {
		orderRepository.deleteById(2);
	}
	
}


















