package com.day21;
// 자바 + 스프링(객체주입, 의존성주입, 제어역전)
import com.day16.MallardDuck;

public class DuckTest {
	MallardDuck  myDuck = null; // 전역에서 사용하려면 전역변수로 선언한다.
	// 메소드를 통해서 객체를 주입 받을 수 있다.
	MallardDuck getInstance() {
		// 중급으로 가는 길 - 싱글톤 패턴 검색 - 도깨비 - 공유
		// 공유할 수 있는건 하나로 공유, 인스턴스화는 한번만 한다. null인지 확인 후에 객체를 만들어준다.
		if(myDuck == null) {
			myDuck = new MallardDuck();
		}
		return myDuck;
//		return new MallardDuck ();// 반환타입에 클래스가 왔다.
	}
	void test() {
		
//		myDuck.display();// 11번이 실행되지 않았다 NullPointerException 발생
		getInstance().display();// 11번이 실행되지 않았다 NullPointerException 발생
	}
	public static void main(String[] args) {
		// insert here
		DuckTest dt = new DuckTest();
		dt.test();
	}

}
