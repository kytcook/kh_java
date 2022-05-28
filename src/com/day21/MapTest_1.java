package com.day21;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * 자바자료구조 - 랜덤하게 쓰기가 된다.
 * List보다 읽기와 쓰기가 빠르다
 * List구조는 index로 접근한다.
 * 그리고 순차적이다. (정렬 - 2차 가공이 필요하다 : 속도가 느리다(0.0001(?))
	ex - 1조가 넘는 메시지를 서버가 매초마다 밀어낸다.(카톡의 1)
 * Map은 빈자리가 있으면 넣는다.
 * Map은 중복값도 담을 수 있다.
 * 
 * 프론트앤드 진로 - 배열을 깊이있게, key는  - React수업
 * 자바에서는 배열이 비효율적이다 : 끼워넣기가 안된다
 * List, Map을 친하게 지낸다.
 * 
 * */

// 기본적으로 오브젝트라는 클래스를 상속받고 있지만 생략되어있다.
// Object : 로그인할때, 회원가입할 때 사용할 수 있는 
public class MapTest_1 extends Object{

	public static void main(String[] args) {
		// <Object : 모든타입을 담을 수 있따. > 
		Map<String, Object> pmap = new HashMap<>();
		pmap.put("one", 1);
		pmap.put("two", 2);
		pmap.put("three", 2); // 키는 덮어쓰기 된다. 하나만 사용해야 한다. 
		pmap.put("three", 3); 
		Set<String> set  = pmap.keySet();
		// insert here
//		Object pmap.put[] = new Object[null, null]; 내가 혼자 한것
		Object keys[] = set.toArray();// 메소드의 리턴타입이 참조형이다.
		for(Object key:keys) {
			System.out.println(key+ ", " + pmap.get(key));
		}
		
	}

}
