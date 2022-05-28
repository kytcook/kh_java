package com.day13;

public class WhileTest_1 {

	public static void main(String[] args) {
		int i = 1;
//		int XXX = 0;
		int hap = 0;
		// for문 안에서 1번 초기화(6번)와 3번 증감 연산자를 생략(대신 16번에)할 수 있다.
//		for(;i<6;) {
//		while(X < 6) {
		while(i < 6) {
			hap = hap + i;
			System.out.println("i : " + i);
			System.out.println("hap : " + hap);
			i++; // 무한루프 방지@!@!@!@!@!@!
		}
		System.out.println("1부터 5까지의 합은 " + hap);
	}

}
