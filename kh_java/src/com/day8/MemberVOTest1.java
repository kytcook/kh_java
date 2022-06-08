package com.day8;

import com.method.MemberVO;

public class MemberVOTest1 {

	public static void main(String[] args) {
		// 변수를 선언할 때 타입이 먼저이다.
		MemberVO mVO = new MemberVO();
		mVO.setName("이순신");
		// 파라미터에 입력한 문자열 상수는 어디에 저장되어 있을까요?
		// MemberVO 클래스의 전역변수인 name변수에 들어있다.
		// MemberVO인스턴스 변수의 setName메소드
		// 변수 선언시 접근제한자가 private으로 되어있어서 그렇다
		// System.out.println(name);
		// 그럼 어떻게 가져올까요?
		System.out.println(mVO.getName());
		// 같은 타입의 클래스라 하더라도 new를 통해서 인스턴스화를 여러번 하면
		// 타입은 같지만 다른 객체가 여러개 만들어지는 것이다.
		// 타입을 적게 되면(9번) 같은 이름의 변수를 중복선언 할 수 없다. 
		// -> (MemberVO mVO = new MemberVO()
		mVO = new MemberVO(); // 주소번지가 다르다..(MemberVO mVO = new MemberVO();
		mVO = new MemberVO(); // 새로운 객체를 계속 만들면 주소가 다르다
		mVO.setName("이순신");
		System.out.println(mVO.getName());
	}

}
