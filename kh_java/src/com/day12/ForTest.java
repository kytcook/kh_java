package com.day12;

public class ForTest {

	public static void main(String[] args) {
		int hap = 0;
//		for(초기화;조건식;증감연산자) {		}
		for (int i = 0; i < 6; i += 1) {
			if (i % 2 == 0) {
				hap = hap + i;
			}
			System.out.println(i);
		}
		// System.out.println(i); 좌중괄호 우중괄호도 필드이다.
		System.out.println("0부터 5까지의 합은" + hap);
	}

}
