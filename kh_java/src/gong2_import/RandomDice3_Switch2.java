package gong2_import;

import java.util.Scanner;
import java.util.Random;
/////////////////////////////////////////////////// Random Dice 2 ///////////////////////////////////////////////////
//////////////////////// 게임 시작 묻기 - 기회 부여 - 숫자 입력 후 성공 여부 묻기 - 정답 공개하기 - 게임 종료 ////////////////////////
////////////////////////////////////////////////////// 코드 줄이기 ////////////////////////////////////////////////////

public class RandomDice3_Switch2 {
	int count; // 기회
	int max;
	int ran; // 랜덤 숫자 
	
	public RandomDice3_Switch2(int max){ // 생성자를 통한 기회 부여
		this.max = max;
		this.ran = (int)(Math.random() * max);
	}
	
	public int gameStart(int i) {
		Scanner scan = new Scanner(System.in); // 스캐너 함수 생성
		
		System.out.println("========== Random Dice ==========");
		System.out.print("게임을 시작하시겠습니까? 1.Yes 2.No \n> ");
		
		while(true) {
			count = i; // 게임이 다시 시작할 떄 카운트가 메소드의 파라미터 값으로 초기화 된다. 생성자의 파라미터 값으로 설정했다가, 게임이 진행되는 메소드의 파라미터 값으로 count을 설정하였더니 성공 ! 
			int yOrN = scan.nextInt();
			
			switch(yOrN) {
				case 2: // 게임 종료 
					System.out.println("\n게임을 종료합니다.");
					break;
				case 1: // 게임 시작 
					System.out.println("\n게임을 시작합니다.");
					System.out.println("0부터 " + max + "까지의 숫자를 입력하세요. 기회는 " + count + "번 입니다. \n> ");
					//System.out.println("##컴퓨터가 채번한 답 : " + ran);
					
					while(true) {
						int user = scan.nextInt();
						
						if(user != ran && count == 1) {
							System.out.println("아쉽게도 실패했습니다.");
							System.out.println("정답은 " + ran + "(이)였습니다. \n");
							break;
						} else if(user < ran) {
							count--;
							System.out.print("더 높은 숫자입니다.");
							System.out.println(" 기회는 " + count + "번 남았습니다. \n> ");
						} else if(user > ran) {
							count--;
							System.out.print("더 낮은 숫자입니다.");
							System.out.println(" 기회는 " + count + "번 남았습니다. \n> ");
						} else if(user == ran) {
							System.out.println("축하합니다. 정답입니다. \n");
							break;
						}
					}
			}
			System.out.print("다시 시작하시겠습니까? 1.Yes 2.No \n> "); // 다시 시작하면 기회 초기화가 안된다. 
		}
		
	}

}