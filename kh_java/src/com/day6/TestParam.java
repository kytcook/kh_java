package com.day6;
// ECMAScript6 -> class지원하게 됨
class Param{
	// 생성자가 전변에 대한 초기화를 대신 해줌
	int ival; // 전번 초기화 생략 가능 - 0
}

public class TestParam {
	void effectParam(Param p) { // call by reference 값에의한 호출이 아니라 참조주소에 의하 호출. 원본의 주소번지 갖고있음
		p = new Param(); // 복사본이 생성되고 그러니까 새로운 객체가 생성됨. 타입은 같지만 객체는 다르다
		p.ival = 300; // 원본에 ival값이 0 -> 500 -> 300 변경됨
		System.out.println("sub ival : " + p.ival); //300
	}	
	public static void main(String[] args) {
		// 내 안에 있는 정의된 메소드라 할지라도 메인 메소드 안에서(non-static → static) 호출 불가
		// 인스턴스화를 해야 사용할 수 있다.
		TestParam tp = new TestParam();
		// 인스턴스화가 진행 - 메모리에 로딩됨
		// tp.effectParam(null);
		Param p = new Param() ;
		p.ival	= 500; // 지번 p에 500초기화
		tp.effectParam(p);	// 메인에서 출력전에 메소드호출이 먼저 일어남
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
