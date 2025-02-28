package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Memo;

import jakarta.transaction.Transactional;

@Transactional
public interface MemoRepository2 extends JpaRepository<Memo, Integer>{

	// jpql 사용하기
	// 테이블 대신 엔티티 사용
	// 컬럼 대신 엔티티의 필드 사용
	@Query("select m from Memo m where m.no <  :mno")
	List<Memo> get1(@Param("mno") int mno);

	// 메모의 내용이 없는 데이터 검색
	// select * from tbl_memo where text is null
	@Query("select m from Memo m where m.text is null")
	List<Memo> get2();
	
	// 메모의 번호가 10에서 20 사이인 데이터 검색
	// select * from tbl_memo where no between ? and ?
	@Query("select m from Memo m where m.no between :p1 and :p2")
	List<Memo> get3(@Param("p1") int from , @Param("p2") int to);
	
	// 순수한 SQL 사용하기!
	@Query(value = "SELECT  * FROM TBL_MEMO ORDER BY NO DESC", nativeQuery = true)
	List<Memo> get4();
	
	@Modifying
	@Query(value = "DELETE FROM TBL_MEMO WHERE NO = :param", nativeQuery = true)
	void delete1(@Param("param") int mno);	
	
	// 객체 파라미터
	@Modifying
	@Query(value="UPDATE TBL_MEMO SET text = :#{#param.text} WHERE NO = :#{#param.no}", nativeQuery = true)
	int update1(); // update는 결과값을 숫자로 반환받음. (데이터가 없어 실패 시 : 0, 데이터가 있어서 성공 시 : 1)
}
