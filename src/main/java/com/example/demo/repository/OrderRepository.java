package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Order;


public interface OrderRepository extends JpaRepository<Order, Integer>{
	
		@Query(value = "select * from tbl_order where ship_address like concat(:p1, '%') ", nativeQuery = true)
		List<Order> select(@Param ("p1") String address);
		
		@Query(value = "select * from tbl_order where order_date like concat ('%',:p1, '%')" , nativeQuery = true)
		List<Order> select2(@Param("p1") String date);
	
}
