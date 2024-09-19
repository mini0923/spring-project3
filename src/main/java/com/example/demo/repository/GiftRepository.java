package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Gift;

import jakarta.transaction.Transactional;

@Transactional
public interface GiftRepository extends JpaRepository<Gift, Integer>{
	
	@Query(value = "select * from tbl_gift where price >= :param", nativeQuery = true)
	List<Gift> select(@Param("param")int price);
	
	@Query(value = "select * from tbl_gift where name like concat('%',:param)", nativeQuery = true)
	List<Gift> select2(@Param("param") String name);
	
	@Query(value = "select * from tbl_gift where price <= :p1 and type = :p2", nativeQuery = true)
	List<Gift> select3(@Param("p1") int price, @Param("p2") String type);
	
}
