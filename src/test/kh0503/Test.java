package test.kh0503;

import java.util.Scanner;

public class Test {
	String exit = null; 
	//	String exit = "exit"
	// Test 앞에 void가 있으면 method가 된다.
	// 생성자가 되려면 void가 없어야 한다
	public Test () {} // 생략이 가능함 - 단 생성자가 하나도 선언된게 없을때만.. 
	public void count() {
		Scanner sc = new Scanner(System.in); // UI(User Interface : View계층)
		while(true) {//365일 매일 그리고 계속 실행된다. - 메모리(RAM:휘발성-오라클로 문제해결-Table 구조:MemberVO)에 계속 쌓인다.
			System.out.print("문자열을 입력해 주세요 : ");// 힌트
			String str = sc.nextLine();//nextLine의 리턴타입이 void라면 대입연산자를 써서 받을 수 없다. - 메소드의 재사용성
			if("exit".equals(str)) { //사용자가 도스창에 exit이라는 문자열을 입력하면. 그래서 같니? equals @abcd1234 == "exit"문자열 상수
				break;//while 문을 탈출한다. - 18번라인으로 이동한다.
			}else {
				System.out.println(str.length() + "글자 입니다.");
			}
		}///// end of while
		System.out.println("프로그램을 종료합니다.");//while문 안에 break문은 무한루프를 방지하는 코드 이다. 
	}///////// end of count
/* JVM 실행 순서
 * 25-26[인스턴스화]-27[메소드 호출]-7-8[사용자가 콘솔에 입력한 값 입력받기]-9[while:반복문, 괄호안이 false이면 실행불가]
 * 10-11[입력문자 저장됨]-12[입력문자가 exit과 같은 문자열인지 비교]-13[12번 조건이 참이면 실행됨:break호출하면 while문 탈출함]	
 * 14[사용자가 입력한 문자열이 exit이 아닐때 실행됨]-15-17-18
 */
	public static void main(String[] args) {
		Test t = new Test(); // 디폴트생성자 호출이 동시에 일어난다.-생략 가능하다.
		t.count();
	}

}

// while문 다음에 괄호 안에는 boolean타입이 온다.
// while문 좌중괄호 우중괄호 안에 있는 코드를 실행문 이라고 한다.
// 이 실행문은 괄호안에 true일때만 실행된다.
// 괄호안에 false이면 실행문은 한 번도 실행기회를 갖지 못한다.

// do {...}while(3<5); 무조건 한번은 실행된다.356 589 0스트라이크1볼