package com.day20;

import java.util.ArrayList;
import java.util.List;
/*
 * int - Integer
 * double - Double
 * float - Float
 * boolean - Boolean, new Boolean(true);, new Boolean("true");
 * 어떤 값에 더블쿼테이션을 붙이면 String타입이다.
 */

public class ListTest_3 {

	public static void main(String[] args) {
		// 제네릭을 추가한 인스턴스화의 경우 타입체크 필요없음
//		List<Int> nameList2 = new ArrayList<>(); // Int는 오브젝트가 아니다 
		List<Integer> numberList = new ArrayList<>();
		numberList.add(5);
		// 제네릭에서 String 타입을 명시 하였으므로 캐스팅연산자가 필요없다.
//		String name2 = nameList2.get(0);
		Integer num = numberList.get(0);
		// 받을 때는 원시형 타입으로 받을 수 있다 왜냐하면 오토박싱이 적용되어서..
		int num2 = numberList.get(0);
		// insert here
		System.out.println(num);// 5
		
	}

}
