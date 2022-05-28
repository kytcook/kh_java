package com.day3;

public class Parameter {

	public static void main(String[] args) {
		String[] names = new String[3];
		names[0] = "홍길동";
		names[1] = "이순신";
		names[2] = "강감찬";
		System.out.println(names[0]);
		System.out.println(names[1]);
		System.out.println(names[2]);
		
		// 배열을 선언하기 - 한 번에 방이 3개가 생긴다.
		// 위와 같이 일일이 코드를 짜기 귀찮으니 매개변수(args)를 통해 인자(변수값)를 전달한다.
		// arguments : 매개변수 args | 인자(변수값) = "홍길동" "이순신" "강감찬"
	}

}
/*
컴파일을 하는 명령어
javac Parameter.java -> JVM경유 -> 컴파일 경유 -> Parameter.class

java Parameter 이순신 강감찬 이성계
*/