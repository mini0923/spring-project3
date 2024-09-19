package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity	// 엔티티 클래스 표시(필수)
@Table(name = "tbl_memo") // 테이블 명
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Memo {
	
	// primary key
	@Id
	// auto increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	int no;
	
	// 일반 컬럼
	@Column(length = 200, nullable = true)
	String text;

}
