package com.day12;

import java.util.Random;
import java.util.Scanner;

public class RandomGame_2A {
// 게임 횟수를 5회로 제한
	// 컴퓨터가 채번하는 일을 전담하는 메소드 구현
	public static void randomNumber() {
		Random r = new Random();
		int dap = r.nextInt(10);// 10 미만의 정수를 리턴해 준다.
	}
	//사용자가 입력하는 값을 받아서 판정하는 메소드에 전달하기 구현
	public void userInput() {
		Scanner scn = new Scanner(System.in);
		System.out.println("0부터 9까지의 숫자를 입력하시오.");
		String str = null;
		str = scn.next();
	}
	
	public void gameStart() {
		int cnt = 5;
		// 만일 i가 6이라면 for문 안에 실행문이 진행될 수 있을까?
		for (int i = 1; i < 6; i++) {
			// 만약에 i값이 5이면 진행되어야 하는가?
			// 만약에 i값이 6이면 어디로 가야하지?
			// if if는 매번 조건을 따지지만 else if문을 사용하면 첫번째 조건이
			// 만족되었을 경우 아래 조건은 따지지 않고 if문 블록을 탈출한다.
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
		// 그렇다면 과연 언제 for문을 탈출할 수 있는가?
		// 5번 기회 중에서 3번째 정답을 맞추면 나간다.
		// 5번을 초과해서 사용자가 입력을 할 수 있나요?
		System.out.println("while문을 탈출하면 여기가 출력된다");
	}

	// <<<<<<end of gameStart>>>>>>

	public static void main(String[] args) {
		RandomGame_2A.randomNumber();
		
	}// <<<<<<end of main>>>>>>
	
}