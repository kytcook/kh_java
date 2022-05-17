package com.day9;

public class P38 {
	// Casting 연산자
	// 자동형전환, 강제 형전환
	public static void main(String[] args) {
		int i = 10;
		double d = 3.14;
		String s = null;
		boolean isOK = false;
		// 캐스팅 연산자는 받아주는 쪽의 타입으로 쓴다.
		// 대신 받아주는 쪽의 데이터 범위만 담을 수 있다.
		i = (int)d;
		d = i;
		//s = (String)d; // 타입이 달라서 불가능하다
		//isOk = (boolean)i; // 논리연산자라서 불가능하다
		System.out.println(i); // 3.14 → 3
		System.out.println(s); 
		System.out.println(isOK);
	}

}
 /*
  * 어떤 이름에 ()가 있으면 3가지 중 하나 
    → method, 생성자(Constructor), Casting 연산자(형변환 연산자)
    
    생성자와 method의 차이
    method는 반환타입이 있다./ 없으면 void라도 써야한다.
    생성자 리턴타입이 없다.
*/
