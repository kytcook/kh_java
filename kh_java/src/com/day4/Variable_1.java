package com.day4;

public class Variable_1 {
	// 선언부 - 전역변수(global variable, member variable)
	// 다른 클래스에서도 사용할 수 있다. 호출할 수 있다. 값을 참조할 수 있다. 타입이 안맞으면 컴파일이 실패한다.
	int age = 20; // 전역변수는 인스턴스화가 실행되고 나면, 다음에 heap메모리 안, 클래스 안에 초기화가 된다.
	void methodA() {
		// 실수를 담을 때는 double 타입으로 선언한다.
		// 지변은 클래스 외부에서는 사용할 수가 없다.(class내부에서는 사용할 수 없다.)
		// 전변은 클래스 외부에서도 사용할 수 있다.(class외부에서도 사용할 수 있다.)
		double pi = 3.14;
		// 6번 라인의 전역변수의 값을 20에서 30으로 재정의함
		// 아래에서 int를 붙여 선언하면 지역변수가 되고, 붙이지 않으면 전역변수에 저장된 값 20이 30으로 덮어쓰기 됨
		age = 30;
		Variable_1 v1 = new Variable_1(); 
		System.out.println("after : "+v1.age);	
	} // end of methodA
	// 20 - 24 - 3 - 26	- 30 - 7 - 11 - 14 - 15 - 16 - 17 - 39 - 41 - 42
	
	public static void main(String[] args) {
		// 메모리에 로딩 되면 6번 라인에 변수가 생성되고 20 값 으로 초기화됨
		// 인스턴스화 : 메모리에 로딩됨. 상주하게 한다.
		// 인스턴스화를 하면 변수와 메소드를 누릴 수 있다.
		Variable_1 v1 = new Variable_1(); 
		// 20이 출력된다. 그러나 7번 메소드를 경유하면 age가 30으로 초기화된다
		System.out.println("before : "+v1.age);
		// 메소드를 호출 할땐 ; 붙인다.
		// 메소드를 구현할 땐 { } 좌중괄호와 우중괄호 영역 표시
		// 그 때 그 안에 선언된 변수를 지역변수 라고 한다.
		v1.methodA(); // 메소드 호출 - age가 30으로 초기화된다.
		/* age가 30으로 출력된다
		 * 
		 * System.out.println("pi : " + v1.pi); 
		 * pi가 지변안에 선언 되었기 때문에 사용불가
	  	 해결방법 => pi 선언문을 method 바깥쪽, 전역변수로 바꿔준다.
	  	 혹은 class에서 double pi를 선언후 메소드안에서는 pi만 사용
	  	 메소드 안에 변수를 선언한다(타입을 정의)는 것은 class에서 선언된 변수와 이름이 같아도 다른 변수이다
		 */
		System.out.println("after : "+v1.age);	
	  
	} // end of main - 북마크를 한다
}
