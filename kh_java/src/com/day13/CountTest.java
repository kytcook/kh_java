package com.day13;

public class CountTest {
	// 1부터 100까지 센다 - 반복문
	public void Count() {
		int i = 1;
		while(i <= 100) {
//		for(int i=1; i <=100; i++) {
			if ((i%5==0) && (i%7==0)) {
				System.out.println("fizzbuzz");
			}else if (i%5 == 0) {
				System.out.println("fizz");
			}else if (i%7 == 0) {
				System.out.println("buzz");
			}else {
				System.out.println(i);
			}
			// 블록 맨 앞으로 보내고 i를 0으로 초기화, while을 <100으로 해도 되지만
			// 직관성이 떨어진다.
			i++;  // while과 짝궁 
		}
	}

	public static void main(String[] args) {
	CountTest ct = new CountTest();
	ct.Count();
	}
	
}
