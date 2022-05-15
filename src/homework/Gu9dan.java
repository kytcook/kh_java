package homework; 											// 패키지

import java.util.Scanner; 									// 자바클래스.유틸클래스.스캐너

public class Gu9dan {
	Scanner sc = new Scanner(System.in);
	int startNum = sc.nextInt();							// 시작단
	int endNum = sc.nextInt();								// 끝 단
	int result;												// 곱셈결과 변수
	
	public Gu9dan() {										// 생성자
		
		if (startNum > endNum) {							// 시작단이 끝단보다 크다면
			for (int i = startNum; i >= endNum; i--) {		// 갈수록 낮은 단으로 반복한다
			System.out.println(i + "단을 출력합니다.");			// 출력문 : 몇 단을 출력하나?
				for (int j = 1; j <= 9; j++) {				// 곱셈 1~9 까지
					result = i * j;							// 결과값 : 곱셈
					System.out.print(i + " X " + j);		// 출력문 : 곱셈식
					System.out.println(" = " + result);		// 출력문 : 곱셈 결과값
				} //////////////////////////////////////////[ end of 안쪽 for ]
			} //////////////////////////////////////////////[ end of 바깥쪽 for ]
		} else {											// 시작단이 끝단보다 작다면
			for (int i = startNum; i <= endNum; i++) {		// 갈수록 큰 단으로 반복한다
				System.out.println(i + "단을 출력합니다.");		// 출력문 : 몇 단을 출력하나?
				for (int j = 1; j <= 9; j++) {				// 곱셈 1~9 까지 
					result = i * j;							// 결과값 : 곱셈
					System.out.print(i + " X " +j);			// 출력문 : 곱셈식
					System.out.println(" = " + result);		// 출력문 : 곱셈 결과값
				} //////////////////////////////////////////[ end of 안쪽 for ]
			} //////////////////////////////////////////////[ end of 바깥쪽 for ]
		} //////////////////////////////////////////////////[ else의 우익 ]

	} //////////////////////////////////////////////////////[ end of constructor Gu9dan ]

	public void gugudan() {
		
	} //////////////////////////////////////////////////////[ end of method gugudan ]
	
} //////////////////////////////////////////////////////////[ end of class Gu9dan ]