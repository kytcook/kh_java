package com.day4;

public class Variable_3 {
	int age = 20;
	// 메소드의 파라미터 자리도 지역변수 자리 이다.
	// 값은 호출할 때 결정된다.
	void methodA(int age) {
		System.out.println("지역변수 ===> " +age); // 50 - automatic 자동소멸
		age = 30;
		// mthodA를 벗어나면 자동 소멸된다.
		System.out.println("methodA 전역변수 : "+ this.age); // 20 - 전역변수(this)
		
	}
	public static void main(String[] args) { 
		Variable_3 v3 = new Variable_3();
		
		System.out.println("before : "+v3.age);
		v3.methodA(50); 
		System.out.println("after : "+v3.age);		
	} 
}
/*
 method( ) 괄호안에 void가 아닌 매개변수가 있으면, 그 변수는 지역변수이다.
 	   ( ) 가 void(공란)이면 타입없는 선언문은 전역변수이다.
 */