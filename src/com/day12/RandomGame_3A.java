package com.day12;

import java.util.Random;
import java.util.Scanner;

public class RandomGame_3A {
	public void randomNumber() {
		Random r = new Random();
		int dap = r.nextInt(10);// 10 미만의 정수를 리턴해 준다.
	}
	
	public String userInput(String str) {
		Scanner scn = new Scanner(System.in);
		String str = null;
		str = scn.next();
		System.out.println("0부터 9까지의 숫자를 입력하시오.");
		return str;
	}
	
	public void gameStart(String str) {
		int cnt = 5;
		for (int i = 1; i < 6; i++) {
			if (cnt == 0) {
				System.out.println("더 이상 기회는 없습니다.");
				break;
			}

			if (Integer.parseInt(str) == dap) { // parseInt
				System.out.println("마따~");
				break;
			} 
			else if (Integer.parseInt(str) > dap) { // 너무 큰 숫자를 적었으니 낮춰라. 요구사항이다 - 요구사항 정의서 작성
				cnt--;
				System.out.println("나차라~");
			} 
			else if (Integer.parseInt(str) < dap) {
				cnt--;
				System.out.println("노피라~");
			}
		}
		System.out.println("while문을 탈출하면 여기가 출력된다");
	}

	// <<<<<<end of gameStart>>>>>>
	
}