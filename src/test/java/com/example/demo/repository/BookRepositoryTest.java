package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;

// 조회 : 단건, 목록
// 추가, 수정, 단건삭제

@SpringBootTest
public class BookRepositoryTest {

	@Autowired
	BookRepository bookRepository;
	
	@Test
	public void 데이터추가() {
		List<Book>  list = new ArrayList<>();
		
		
		Book book1 = Book 
												.builder()
												.price(20000)
												.publisher("한빛출판사")
												.title("자바프로그래밍입문")
												.build();
		Book book2 = Book 
												.builder()
												.price(25000)
												.publisher("남가람북스")
												.title("스프링부트프로젝트")
												.build();
		
		Book book3 = Book 
												.builder()
												.price(40000)
												.publisher("남가람북스")
												.title("실무로 끝내는 PHP")
												.build();
		
		Book book4 = Book 
												.builder()
												.price(35000)
												.publisher("이지스퍼블리싱")
												.title("알고리즘코딩테스트")
												.build();
		
		list.add(book1);
		list.add(book2);
		list.add(book3);
		list.add(book4);
		
		bookRepository.saveAll(list);
		
	}
	
	// 단건 조회
	@Test
	public void 단건조회 () {
		Optional<Book> result = bookRepository.findById(1);
		
		if (result.isPresent()) {
			Book book = result.get();
			System.out.println(book);
		}
	}
	
	// 전체 조회
	@Test
	public void 데이터전체조회() {
		List<Book> list = bookRepository.findAll();
		
		for (Book book : list) {
			System.out.println(book);
		}
	}
	
	// 수정
	@Test
	public void 데이터수정() {
		Optional<Book> result = bookRepository.findById(1);
		Book book = result.get();
		book.setTitle("수정된책");
		
		bookRepository.save(book);
	}
	
	// 단건삭제
	@Test
	public void 단건삭제() {
		bookRepository.deleteById(4);
	}
}
