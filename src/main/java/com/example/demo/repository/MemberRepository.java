package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String>{

	@Query(value = "select * from tbl_member where user_id like concat(:p1,'%') ", nativeQuery = true)
	List<Member> select(@Param("p1") String id);
	
	@Query(value = "select * from tbl_member where grade = :p1 ", nativeQuery = true)
	List<Member> select2(@Param("p1") String grade);
	
}
