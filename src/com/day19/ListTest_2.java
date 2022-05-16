package com.day19;

import java.util.ArrayList;
import java.util.List;
public class ListTest_2 {
	List <String> list = new ArrayList<>();
	
	public void setList () { 
		// 생성자를 거치지 않으면 0
		list.add("수박");
		list.add("토마토");
		list.add("사과");
	}
	public void printList () {
		setList();
		// 배열처럼 첫번째 인덱스가 0이므로 두번째를 삭제할 경우 1을 준다
		String 	ele		 = list.remove(0); 
		boolean isFail	 = list.remove("사과"); 
//		list.remove(1); //  
		list.add("바나나");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		// 코드작성시 고민해볼 사항 :
		// 스트링 타입으로 삭제요소를 찾는다. 
		// 조건문이 역할이 있다.
		System.out.println("삭제된 요소는 : " + ele);
		System.out.println("응답에 대한 결과 값 : " + isFail);
		System.out.println("바나나 있니? : " + list.contains("바나나") +", " + list.contains("키위"));
		if(list.contains("바나나")) {
			System.out.println("바나나 있습니다. 드릴까요?");
		}
	}
	
	public static void main(String[] args) {
		ListTest_2 lt = new ListTest_2(); // 디폴트 생성자 호출
		lt.printList();
	}

}

/*
 * 파라미터와 리턴타입의 기준이 애매.
 * 자바에서 제공되는 리턴값들이 반환값이 있다. 
 * API 기준으로, API활용능력을 기른다. 리턴타입 어떻게 내가 구현할 것인가?
 * API가 제공하는 리턴타입을 어떻게 사용할 것인가?
 * 사용자에게 확인시켜준다.
 * 처음에는 모방한다. 흉내내보기 
 * 직접 API보고 메소드들 확인하면서 접근해본다.
 * 
 * 
 * 
 */
