package com.day12;

import java.util.Random;
import java.util.Scanner;

public class RandomGame {
	public static void gameStart() {
		// Random 클래스의 인스턴스화
		// 임의의 숫자를 채번하는 메소드를 제공하는 클래스임 - 0.0~1.0
        Random r = new Random();
        // 정수형 변수 dap에 Random클래스에서 채번된 값을 저장한다
        // 게임이 시작되기 전에 0부터 9사이의 임의의 수를 채번하기
        // 사용자가 값을 입력하는 것보다 먼저 채번해야 된다.
        int dap = r.nextInt(10);//0이상10 미만사이의 정수를 리턴해 준다.
        // Scanner 클래스의 인스턴스화
        // system : 내 컴퓨터, in : 입력 장치 - 듣기, 사용자(User)의 말
        // 사용자가 입력한 (콘솔화면에) 값을 읽어올 때 - 듣기 
        Scanner scan = new Scanner(System.in);
        // 안내 메시지 - 유효범위는 0~9 사이이다.
        System.out.println("0부터 9까지의 숫자를 입력하시오.");
        // 문자열 변수 str은 값이 정해지지 않았다.
        // 사용자가 담을 변수 str의 선언
        String str = null;
        // while 반복문. 은 조건을 먼저 따진다.
        // 조건을 만족하지 않으면 단 한번도 실행하지 않는다. <-> do while : 무적권 한번은 실행
        // 무한루프 방지코드가 꼭 있어야 한다. = break;
        // boolean 변수를 써준다.
        // 문자열 변수 str에 scan.nextLine()을 저장해준다?..
        // javaScanner
        // = (int i = scan.nextint()) != 5(정수가 와야한다)
        // 사용자가 입력한 값이 null이 아니면 계속 반복해라 - 몇번인지는 정해지지 않았따. - 이걸 정하고 싶을때 for문
        while((str = scan.nextLine()) != null){
        	// 입력값이 채번한 값과 같나? 네:맞다, 아니요:else if 
            if(Integer.parseInt(str) == dap){ // parseInt 
                System.out.println("마따~");
                break;
            }
            // if문 조건에 수렴하지 않으면 아래로 온다.
            else if(Integer.parseInt(str) > dap){ // 너무 큰 숫자를 적었으니 낮춰라. 요구사항이다 - 요구사항 정의서 작성
                System.out.println("나차라~");
            }
            else if(Integer.parseInt(str) < dap){
                System.out.println("노피라~");
            }
        }//while ended
        System.out.println("while문을 탈출하면 여기가 출력된다");
	}//			<<<<<<end of gameStart>>>>>>
	public static void main(String[] args){
		// 메소드 호출시 구현된 메소드 앞에 static이 있으면 인스턴스화 없이 클래스 타입.메소드명() 호출가능
		RandomGame.gameStart();
	}//			<<<<<<end of main>>>>>>
}	