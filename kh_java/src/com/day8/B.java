package com.day8;

public class B {
	
	public static void main(String[] args) {
		//insert here - A클래스의 변수 i 호출하기
		A a = new A();
		// 변수 호출은 선언이 먼저이다.
		// B클래스 안에서 i가 선언되지 않았다.
		//System.out.println(i);
		// 아래와 같이 호출할 수 있는건 변수 i가 전역변수이기 때문이다.
		System.out.println(a.i);
		a.i = 10; // 변수값을 재정의 할 수 있다.
		//insert here -10이 출력되었을 것이다.
		System.out.println("B클래스에서 a주소번지" + a);
	}

}
