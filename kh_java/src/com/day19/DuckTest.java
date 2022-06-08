package com.day19;

import com.day16.Duck;
import com.day16.MallardDuck;
import com.day16.RubberDuck;
// 생성부와 선언부의 이름이 다르면 안된다. - 상속관계가 아니다, 인터페이스를 implemets(재정의) 하지 않았다.
// 접근제한자가 퍼블릭이니까 다른 폴더에 있는 클래스를 가져올 수 있다. 호출할 수 있다. 
public class DuckTest {
	public void methodA (Duck duck) {
		// 파라미터에 더 상위 클래스타입을 적어주면 다양한 구현체 클래스를 받을 수 있따. -> 다형성을 기대 할 수 있다.
		// 같은 이름의 메소드가 호출되더라도 기능이 서로 다르게 동작된다.
		// 선언부와 생성부의 이름이 다를 때 가능하다.
		// 이것이 가능하려면 상속관계 이거나 or 인터페이스의 구현체 클래스 이라면 가능하다.
		System.out.println("methodA(Duck)");
		if(duck instanceof RubberDuck) {	//너 RubberDuck타입 이니?
			System.out.println("나는 RubberDuck 타입입니다.");
		} else if(duck instanceof MallardDuck) {
			System.out.println("나는 MallardDuck 타입입니다.");
		} else {// 그 나머지 else인 경우에는 조건문이 올 수 없다.
			System.out.println("나는 기타 Duck 타입 입니다.");
		}
		System.out.println(duck);
		// 
	}
//	public void methodB (MallardDuck duck) {
	public void methodA (MallardDuck duck) {
		System.out.println("methodA(MallardDuck)");
		System.out.println(duck);
	}
	// 메소드의 파라미터 자리는 선언하는 자리이다. 초기화는 할 수 없다(그 변수의 값을 정할 수 없다)
	public void methodC (int i) {
		System.out.println(i);
	}
	public static void main(String[] args) {
		DuckTest dt = new DuckTest();
		Duck myDuck = new RubberDuck();
		Duck herDuck = new MallardDuck();
		// 생성자 호출 - 단독으로 인스턴스화할 수 없다. 구현체 클래스가 있어야 한다.
//		dt.methodA(new Duck()); // 이 자리에 new를 넣는다? 고수;
		// 인스턴스 변수가 있으면 다른 변수나 다른 메소드 호출시 재사용 가능하다.
		// new RubberDuck(); 한번만 사용가능함 - 재사용 불가
		dt.methodA(new RubberDuck()); // 9번라인은 상위개념(Duck)이기 때문에 받을 수 있따.
		dt.methodA(herDuck);
		dt.methodA(myDuck); // pass by value(주소번지 :원본) <-> call by value(복사본)
//		dt.methodA(null);
//		dt.methodB(null);
//		dt.methodB(new MallardDuck()); // 메소드 이름이 달라져서 오류가 난다
		
		dt.methodC(5); // call by value
//		dt.methodA(5); // 타입이 달라요...
//		dt.methodA(null); // 참조형타입
	}

}

/*
 * 명세서는 설계
 * 전역변수는 생략할 수 있다. 생성자가 해주니까(?)
 * call by value보다 pass by value가 더 상위개념( 더 위ㅣㅣㅣ로위로)
 * 단위테스트를 할 수 있게 되자!
 * 
 * */
