package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{

	// Repository 만드는 방법
	// 1. JpaRepository를 상속받는다.
	// 2. 제네릭 타입에 엔티티와 PK를 설정한다.
	
}
