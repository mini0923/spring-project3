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

@Entity
@Table(name="tbl_book")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int book_no;
	
	@Column(nullable = false)
	int price;
	
	@Column(nullable = false, length = 100)
	String publisher;
	
	@Column(nullable = false, length = 30)
	String title;

}
