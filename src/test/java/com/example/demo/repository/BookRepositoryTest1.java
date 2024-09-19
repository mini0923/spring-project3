package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;

@SpringBootTest
public class BookRepositoryTest1 {

	@Autowired
	BookRepository bookRepository;
	
	@Test
	public void Quiz5_1() {
		List<Book> list = bookRepository.select("자바프로그래밍입문");
		
		for (Book book : list) {
			System.out.println(book);
		}
	}
	
	@Test
	public void Quiz5_2() {
		List<Book> list = bookRepository.select2(30000, "남가람북스");
		
		for (Book book : list ) {
			System.out.println(book);
		}
	}
	
	@Test
	public void Quiz5_3() {
		List<Book> list = bookRepository.select3("한빛출판사", "이지스퍼블리싱");
		
		for (Book book : list ) {
			System.out.println(book);
		}
	}
	
	
}
