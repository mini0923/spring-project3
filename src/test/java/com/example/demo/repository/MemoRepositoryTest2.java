package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;

@SpringBootTest
public class MemoRepositoryTest2 {

	@Autowired
	MemoRepository memoRepository ;
	
	@Test
	public void 번호가_10와20사이인_데이터검색() {
		
			List<Memo> list = memoRepository.findByNoBetween(10, 20);
			
			for (Memo memo : list) {
				System.out.println(memo);
			}
		
	}
	
	@Test
	public void 번호가10보다작은_데이터검색() {
		List<Memo> list = memoRepository.findByNoLessThan(10);
		
		for (Memo memo : list ) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 텍스트가null이아닌_데이터검색() {
		List<Memo> list = memoRepository.findByTextIsNotNull();
		
		for (Memo memo : list ) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 번호를기준으로역정렬한_데이터검색() {
		List<Memo> list = memoRepository.findAllByOrderByNoDesc();
		
		for (Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 번호가5보다작은_데이터삭제() {
		memoRepository.deleteMemoByNoLessThan(5);
		
		// select는 원본 데이터에 영향이 없지만
		// delete update 는 데이터에 영향이 있다.
		// delete는 롤백처리가 되어 테이블에 반영이 안된다!
	}
	
}
