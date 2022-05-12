package com.day4;

public class Variable_2 {
	// 전역변수 age선언 및 초기화(초기값은 20임)
	int age = 20;
	void methodA(int age) { //50 복사됨 - 메소드 파라미터 자리에 선언된 변수도 지역변수
	// 만일 아래에서  age를 출력하면 30을 출력함
	// 5번 전역변수에 30이 저장되는 것이 아니라 6번 메소드의 파라미터 변수에 30이 저장됨	
		age = 30; 
		
	}
	public static void main(String[] args) {
		Variable_2 v1 = new Variable_2();
		// 전역변수 age즉 5번 라인의 20이 출력됨
		System.out.println("before : "+v1.age);
		// 6번 라인 메소드 호출시 파라미터에 있는 50이 6번 파라미터 age지역변수에 저장됨
		// 그러나 7번 라인에서 새로운 30으로 변경됨 - 덮어쓰기 됨
		// 결론 전역변수에 전혀 영향을 주지 않음
		v1.methodA(50);
		// age는 전역변수를 출력하므로 20이 출력됨
		System.out.println("after : "+v1.age);		
	}
}
