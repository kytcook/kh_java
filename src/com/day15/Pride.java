package com.day15;
// 이 때, Pride를 MoveBehavior 인터페이스의 구현체 클래스라고 말한다.
// 추상클래스와 인터페이스의 공통점 - 단독으로 인스턴스화가 불가하다.
public class Pride extends Car implements MoveBehavior {
	// MoveBehavior 인터페이스 이므로 추상메소드만 가질 수 있다
	// 추상메소드는 세미콜론으로 끝난다.
	// run이라는 메소드 좌중괄호, 우중괄호가 있는 것 만으로도 구현이다.
	// MoveBehavior 인터페이스에 선언된 추상메소드르르 재정의 함
	@Override
	public void run() {
		// 내 안에서 선언된 변수가 아닌데 어떻게 사용이 가능한가?
		// Car를 상속 받았기 때문에.. 그래서 가능하다
		// 원래 Car에서는 엑셀을 밟을 때마다 1씩 증가하였는데, 자손 클래스에서는 2씩 증가한다.
		// 오버라이딩이다.
		//// Car라는 추상클래스 선언 - display를 선언만 하였다(결정할 수 없어서) 
		speed = speed + 2;
	}

	@Override
	public int stop() {
		return 0;
		
	}

	@Override
	public void display() {
		
	}

}
