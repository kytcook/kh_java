package homework; 										// 패키지

public class Gu9dan_2 {									// Gu9dan_2 클래스
	String startNum;									// startNum의 전역변수							
	String endNum;										// endNum의 전역변수
	
	public Gu9dan_2(String startNum, String endNum) {	// Gu9dan_2 생성자
//		this.startNum = null; 							// 이건 왜 안될까??
//		this.endNum   = null;
		this.startNum = startNum; 						// 전역변수 startNum에 파라미터의 값을 넣음?
		this.endNum   = endNum;							// 전역변수   endNum에 파라미터의 값을 넣음?
	} //////////////////////////////////////////////////[ end of constructor Gu9dan_2 ]
	public void result() {																	// 메소드
		int result;																			// 변수선언 : 결과값
		if (Integer.parseInt(startNum) > Integer.parseInt(endNum)) {						// startNum과 endNum은 스트링 타입이니까 정수로 변환
			for (int i = Integer.parseInt(startNum); i >= Integer.parseInt(endNum); i--) {  // 이상동문. 줄어드는 곱셈
			System.out.println(i + "단을 출력합니다.");											// 출력문 : 몇단인가?
				for (int j = 1; j <= 9; j++) {												// 9까지 곱셈
					result = i * j;															// 곱셈결과
					System.out.print(i + " X " + j);										// 출력문 : 곱셈식
					System.out.println(" = " + result);										// 출력문 : 곱셈 결과값
				} //////////////////////////////////////////////////////////////////////////[ end of inner for ]
			} //////////////////////////////////////////////////////////////////////////////[ end of exterior for ]
		} else { 
			for (int i = Integer.parseInt(startNum); i <= Integer.parseInt(endNum); i++) {	// 시작단이 끝단보다 작을 때 반복
				System.out.println(i + "단을 출력합니다.");										// 출력문 : 몇단인가?
				for (int j = 1; j <= 9; j++) {												// 9까지 곱셈
					result = i * j;															// 곱셈결과
					System.out.print(i + " X " +j);											// 출력문 : 곱셈식
					System.out.println(" = " + result);										// 출력문 : 곱셈 결과값
				} //////////////////////////////////////////////////////////////////////////[ end of inner for ]
			} //////////////////////////////////////////////////////////////////////////////[ end of exterior for ]
		} //////////////////////////////////////////////////////////////////////////////////[ else의 우익 ]
		
	} //////////////////////////////////////////////////////////////////////////////////////[ end of method result]
	
} //////////////////////////////////////////////////////////////////////////////////////////[ end of class Gu9dan ]
