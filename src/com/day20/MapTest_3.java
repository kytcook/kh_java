package com.day20;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * 회원가입
 * 아이디 : 입력하세요.
 * <input type="text" name="mem_id">
 * 비번 : 입력하세요.
 * <input type="text" name="mem_pw">
 * 이름 : 입력하세요.
 * <input type="text" name="mem_name">
 * 이메일 : 입력하세요. 
 * <input type="text" name="mem_email">
 * 
 * Map은 키로 관리한다. keyset
 */
public class MapTest_3 {
	// 제네릭
//	Map<String, Object> map = new HashMap<>();
	Map<String, String> map = new HashMap<>();
	public MapTest_3() {
		map.put("mem_id", "scott");// 아이디// 첫번째 파라미터 : key, 두번째 파라미터
		map.put("mem_pw", "tiger");// 비번// put : 있는거에 붙인다.
		map.put("mem_name", "나신입");// 이름
		// 선언이 먼저 호출이 나중
		printMap();// 출력을 담당하는 메소드 호출하기
	}////// end of 디폴트 생성자

	public void printMap() {
		System.out.println(map.size());//키 값에 대한 원소의 수이다. - 3이 출력될 것이다.
		// 22번에서 정의된 클래스를 사용하므로 제네릭 타입이 변하면 아래에서도 동일하게 바꿔야 한다.
//		for(Map.Entry<String,Object> et:map.entrySet()) { // 22번의 밸류타입이 스트링이므로 맞춘다
		for(Map.Entry<String,String> et:map.entrySet()) { // 22번의 밸류타입이 스트링이므로 맞춘다
			// getValue에 마우스 갖다대면 타입이 바뀐다. 위에 String - Object 교체시
			System.out.println("[key]:" + et.getKey() + ", [value] : " + et.getValue());
			
		}
	}

	public static void main(String[] args) {
		new MapTest_2();
	}

}
