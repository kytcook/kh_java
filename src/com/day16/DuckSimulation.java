package com.day16;

public class DuckSimulation {

	public static void main(String[] args) {
		// MallardDuck은 FlyBehavior 의 구현체 클래스가 아니다.
		// MallardDuck은 fly메소드를 직접 오버라이딩 하지 않는다.
		Duck myDuck = new MallardDuck();
		myDuck.performFly();
		myDuck.display();
		myDuck = null;
		myDuck = new RubberDuck();
		myDuck.display();
		myDuck.performFly();
		WoodDuck herDuck = new WoodDuck();
		herDuck.display();
		herDuck.performFly();
//		herDuck = (WoodDuck)myDuck;// 오른쪽에 있는 것이 왼쪽에 있는 것보다 작아야 한다. (강제형전환 : 눈에 보이는 오류는 잡히지만 예외가 발생한다. )
//		herDuck.display();// 에러가 난다. ClassCastException
		//myDuck = herDuck;
		
	}

}
