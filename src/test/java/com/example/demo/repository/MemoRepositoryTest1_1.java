package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;

@SpringBootTest
public class MemoRepositoryTest1_1 {

	@Autowired
	MemoRepository memoRepository ;
	
	@Test
	public void 리파지토리객체를_가져왔는지확인() {
			System.out.println("memoRepository = " + memoRepository);
	}
	
	@Test
	public void 데이터등록() {
		// 새로운 데이터 생성
		// no는 0(null 값)을 입력하면 auto increment 
		
//		Memo memo = new Memo(0, "새글입니다");
		
		Memo memo = Memo
														.builder()
														.text("새글입니다")
														.build();
		
		// save : 테이블에 데이터를 추가 또는 수정 하는 함수
		// insert 또는 update sql이 생성된다.
		memoRepository.save(memo);
	}
	
	@Test 
	public void 데이터일괄등록() {
		List <Memo>  list = new ArrayList<>();
		
		Memo memo1 = Memo 
														.builder()
														.text("새글입니다.")
														.build();
		Memo memo2 = Memo 
														.builder()
														.build();
		
		list.add(memo1);
		list.add(memo2);
		
		memoRepository.saveAll(list);
	}

		@Test
		public void 데이터단건조회() {
			
			// 결과값을 반환받을 때는 함수의 선언부를 확인 할 것
			// 그리고 그 타입을 대입연산자 앞부분에 변수로 선언
			// findById : 단건 데이터를 조회하는 함수
			// find 함수 호출
			// 1. jpa가 sql을 자동으로 생성
			// 2. jdbc가 mariaDB로 SQL을 전달
			// 3. DB에서 데이터 조회
			// 4. 결과를 다시 받아옴
			Optional<Memo> optional =  memoRepository.findById(1);
			
			if (optional.isPresent()) {
				System.out.println(optional.get());
			} else {
				System.out.println("값이 없습니다.");
			}
			
		}
		
		@Test
		public void 데이터수정() {
			Memo memo = Memo 
															.builder()
															.no(1)
															.text("새글입니다.")
															.build();
			
			// save : 데이터를 추가 또는 수정하는 함수
			memoRepository.save(memo);
			
			// select > update sql이 생성된다.
			// 조회결과에따라 insert 또는 update 가 수행된다.
		}
		
		@Test
		public void 데이터삭제() {
			// deleteById: 특정 데이터를 삭제하는 함수
			memoRepository.deleteById(1);
			
			// select 한 후, 데이터 개수 만큼 delete sql이 생성된다.
		}
	
}
