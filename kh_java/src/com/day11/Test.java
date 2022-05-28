package com.day11;

import java.util.Scanner;

public class Test {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int a = 0;
		while(true) {
			System.out.print("문자열을 입력해주세요 :");
			String str = sc.nextLine();
			if(str.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println(str.length() + "글자 입니다.");
			}
		}
	}
}

