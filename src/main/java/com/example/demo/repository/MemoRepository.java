package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Memo;

import jakarta.transaction.Transactional;

// Repository : 엔티티를 사용하여 데이터 작업을 처리 (CRUD, 페이징, 정렬)

@Transactional
public interface  MemoRepository extends JpaRepository<Memo, Integer>{
	
	// 메모의 번호가 10에서 20 사이인 데이터 검색
	// 검색에 필요한 파라미터는 매개변수로 선언
	List<Memo> findByNoBetween(int from, int no); 
	
	// 메모의 번호가 10보다 작은 데이터 검색
	// .. where no < ?
	List<Memo> findByNoLessThan(int mno);
	
	// 메모의 내용이 없는 데이터 검색
	// .. where text is not null
	List<Memo> findByTextIsNotNull();
	
	// 메모의 번호를 기준으로 역정렬
	// .. order by no desc
	List<Memo> findAllByOrderByNoDesc();
	
	// 메모의 번호가 3보다 작은 데이터 삭제
	// delete from tbl_memo where no < ?
	void deleteMemoByNoLessThan(int mno);
	
}

// JpaRepository를 생성할 때는 엔티티와 해당 엔티티의 PK 타입을 지정해야 한다.