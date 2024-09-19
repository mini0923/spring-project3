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
@Table(name = "tbl_gift")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Gift {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int no;
	
	@Column(length = 20, nullable = false)
	String name;
	
	@Column(nullable = false)
	int price;
	
	@Column(length = 20, nullable = false)
	String type;
	
	
}
