package com.example.demo.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_member")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Member {

	@Id
	@Column(name="user_id")
	String userId;
	
	@Column(length = 255 ,nullable = false)
	String grade;
	
	@Column(length = 255 ,nullable = false)
	String password;
	
	@CreatedDate
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(nullable = false)
	LocalDate  registerDate;

}
