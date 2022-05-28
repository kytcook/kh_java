package com.basic;
 	/*
 	Ctrl + s 누르면 저장과 동시에 javac Hello.java => Hello.class
	java Hello 엔터
	public은 접근 제한자라고 한다.
	public > protected > friendly > private 순서로 접근제한. 예약어는 변수명 사용x
	public : 누구나 사용가능
  	*/
public class Hello {
	/*
	• Class는 클래스 선언시 사용하는 예약어임
	• 선언부 : 변수 선언 및 초기화를 할 수 있다.
  	       - 변수와 메소드를 선언할 수 있다.
  	• 변수 선언을 통해서 데이터를 담을 수 있다. (ex - int age = 25;)
  	     
  ----------------------------------------------------------
	• 여기는 클래스 영역입니다.
	• 클래스 안에는 변수와 메소드가 살고 있습니다.
	※ 클래스
	- 명사 : 속성
	- 동사 : 메소드(기능)
	- 값  : 변수
	-> 객체지향언어(OOP:Oriented Objected Programing)
	 : 재사용성을 높인다 - 메소드 중심의 코딩을 전개한다.
	   이식성의 향상 - 
	• 변수는 데이터(숫자, 문자열, 참 또는 거짓)를 담는다.
	• 고급언어(자연어)를 저급언어(0,1 : 2진수)로 컴파일한다.
	*/
	
	/*
		메인 메소드가 있어야 exe 즉, 실행 파일로 만들 수 있다.
		메인 스레드 이다.
		코드가 많아도 가장 먼저 시행되는 곳이 main메소드 이다.
		메인 메소드가 entry point이다 - 제일 먼저 실행된다.
		
		메소드와 변수를 구분하기
		어떤 이름 뒤에 괄호가 있으면 메소드 이다.
		static 영역에서는 non-static 변수나 메소드는 사용이 불가하다.
	*/
	public static void main(String[] args) {
		
		// System이 가리키는 건 내가 사용하는 PC
		// out변수는 출력장치를 의미한다.
		// println은 메소드이다 - 출력 기능을 담당하는 메소드이다.
		// 어디에 출력하지? - 콘솔창에
		// 출력을 해야 소통할 수 있다.
		System.out.println("Hello World");

	}// end of main method - 기능, 처리, event

} // end of Hello - 사용자 정의 클래스 선언 및 구현이 끝나는 것
