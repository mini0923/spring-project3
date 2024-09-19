package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Book;

import jakarta.transaction.Transactional;

// 1. SQL을 그대로 작성한다.
// 2. 변경될 수 있는 값(파라미터)을 매개변수로 선언한다.
// 예를 들어 제목은 '자바~' 또는 '스프링~' 또는 '빈문자열' 가 될 수 있다.
// 이런 값들은 외부에서 입력받아 SQL에 동적으로 적용될 수 있도록 처리한다.
// 3. 파라미터로 전달된 값을 SQL에 바인딩한다.


@Transactional
public interface BookRepository extends JpaRepository<Book, Integer>{

	@Query(value = "select  * from tbl_book  where title = :param", nativeQuery = true )
	List<Book> select(@Param("param") String title);
	
	@Query(value = "select * from tbl_book where price >= :p1 and publisher = :p2", nativeQuery = true)
	List<Book> select2(@Param("p1") int mno, @Param("p2")String name);
	
	@Query(value = "select * from tbl_book where publisher = :p1 or publisher = :p2", nativeQuery = true)
	List<Book> select3(@Param("p1")String publisher1, @Param("p2")String publisher2);
	
}
