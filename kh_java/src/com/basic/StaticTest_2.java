package com.basic;

public class StaticTest_2 {
	int age = 30;
	public static void main(String[] args) {
		// 아래 코드를 어떻게 바꾸면 11번 라인에서 4번 라인에 선언된 변수의 값 30을 출력할까?
		// 인스턴스 진행시 클래스명을 동일화한다.
		StaticTest st = new StaticTest();
		System.out.println(st.age);
		
		StaticTest_2 st1 = new StaticTest_2 ();
		System.out.println(st1.age);
		
		

	}

}
