package com.week1;

public class Parameter_3 {
	static Dog methodA(Dog myDog) {
		// 같은 이름의 변수로 new사용해서 객체를 생성하게 되면 타입은 같지만 새로운 주소번지를 갖게 된다.
		// 이것은 서로 다른 객체라는 의미로 받아들여야 한다.
		myDog = new Dog (); // 타입은 같지만 주소번지가 다르다. 다른 객체이다.
		System.out.println("methodA 안에서" + myDog); // main method와 주소가 같다
		// 반환타입이 결정된 경우에는 대응하는 변수 혹은 객체 생성등이 필요 하다.
		return null;
	}
	public static void main(String[] args) {
		Dog myDog = new Dog();
		System.out.println("main 안에서" + myDog);
		// methodA가 static으로 선언되었으므로 가능함
		methodA(myDog);
	}

}
// Dog라는 클래스가 보이지 않는다. 