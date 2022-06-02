package com.day6;

class Param{
	int ival; // 전번 초기화 생략 가능 - 0
}

public class TestParam {
	void effectParam(Param p) {
		p = new Param(); // 18번과 9번의 Param은 다른 객체이다. 타입은 같다.
		p.ival = 300;
		System.out.println("sub ival : " + p.ival); //300
	}	
	public static void main(String[] args) {
		// 내 안에 있는 정의된 메소드라 할지라도 메인 메소드 안에서(non-static → static) 호출 불가
		// 인스턴스화를 해야 사용할 수 있다.
		TestParam tp = new TestParam();
		// tp.effectParam(null);
		Param p = new Param() ;
		p.ival	= 500;
		tp.effectParam(p);
		// 20번 라인의 값은 몇일까요?
		System.out.println("main ival : " + p.ival); //500
		
	}

}

/*
 * 9번 : 나 자신에 대한 인스턴스화 이다.
 * 왜 인스턴스화를 했나? - 20번의 effectParam메소드를 호출하기 위해
 * 19번에서는 18번에서 인스턴스화 된 클래스의 전변인 ival변수에
   초기값이 0대신 500으로 덮어쓰기가 발생함
 * 아직은 출력하는 문장을 만나지 못함
 * 20번 effectParam의 메소드를 경유하게 되는데 이 때 18번에서
   정의된 객체의 주소번지를 가지고 8번으로 진입합니다.
 * 8번의 지변 p는 18번 p의 주소번지와 같다 if(s==s1)
 * 따라서 8번의 iaval 변수의 300은 
 */
