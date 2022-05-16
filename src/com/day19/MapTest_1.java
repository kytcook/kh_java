package com.day19;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest_1 {
	// 앞에 꺾새 <제네릭 다이아몬드 연산자
	Map<String, Object> map = new HashMap<>();// Object: value의 타입이다
	public MapTest_1() {
//		printMap(); // 위치의 문제 : 선언이 먼저인가 초기화가 먼저인가.
		// Map계열은 값을 담을 때 put 메소드를 사용한다.
		// 파라미터가 두 개 필요한데 첫번째는 키값이고 두번째(스캇,타이거,나신입)는 값이다.
		map.put("mem_id", "scott");// 아이디// 첫번째 파라미터 : key, 두번째 파라미터
		map.put("mem_pw", "tiger");// 비번// put : 있는거에 붙인다.
		map.put("mem_name", "나신입");//이름 
		printMap();// 출력을 담당하는 메소드 호출하기
	}
	public void printMap() {
		// 키값만을 추출할 때 사용한다.
		Set<String> set = map.keySet();
		// 키값이 세가지(mem_id, mem_pw, mem_name) 이니까 배열에 담을 수 있다.
		// 프론트앤드개발자 - 배열 집중 -- 3차배열은 제외, 다차원배열 제외
			Object obj[] = set.toArray();// 변수의 타입한계를 뛰어넘는 Object. obj배열에는 키값이 들어있다.
//		String obj[] = set.toArray(); // 
		for(int i = 0; i < obj.length; i++) {
			// 형전환 연산자 사용할 때는 받아주는 타입을 적은 것이다.
			String key = (String)obj[i];// 타입을 맞추자.
			// 리스트는 오브젝트로 접근. 맵계열은 키로 접근한다.
			System.out.println(key + ", " + map.get(key)); // 맵이 제공하는 겟이라는 메소드
		}
	}
	public static void main(String[] args) {
		new MapTest_1(); // 재사용할게 아니라면 클래스타입 안쓴다.
		
		
	}

}
