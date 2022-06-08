package homework;											// 패키지

import java.util.Scanner;									// java클래스.유틸클래스.스캐너

public class Gu9danSimulation_2 {							// class Gu9danSimulation_2 

	public static void main(String[] args) {				// method main
		Scanner sc = new Scanner(System.in);				// Scanner class 인스턴스화
		Gu9dan_2 g9;										// Gu9dan_2 변수선언?
		g9 = new Gu9dan_2(sc.next(), sc.next());			// 인스턴스화?? 스캔값을 파라미터 값으로 Gu9dan 생성자에 전달
//		Gu9dan_2 g9 = new Gu9dan_2(sc.next(), sc.next());	// 9-10 라인과 ==
		g9.result();										// Gu9dan class의 result 메소드 호출
	} //////////////////////////////////////////////////////[ end of method main ]

} //////////////////////////////////////////////////////////[ end of class Gu9danSumulation_2 ]

