package com.day8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame; // Ctrl + shif + O 임포트 단축키
/*
 * 이벤트 처리 순서
 * 1. 해당 컴퍼넌트가(독립적인 역할을 수행할 수 있는 클래스) 지원하는 이벤트 리스너 선정하기 - 
 * 						ActionListener : 인터페이스 - 추상메소드 - 메소드 오버라이딩
 * 2. 이벤트 소스와 이벤트 처리 핸들러 클래스를 매핑함.
 * 3. 이벤트 처리를 담당하는 메소드 구현하기 
 */
// ActionListener를 implements하는 클래스를 이벤트 처리를 담당하는 이벤트 핸들러 클래스라고 한다.
// JButtonTest_1은 ActionListener의 구현체 클래스 이다.
// 인터페이스는 단독으로 인스턴스화 할 수 없다.
// 인터페이스를 메모리에 로딩할 때는 선언부와 생성부의 이름이 다르다.
// 자바에서는 같은 이름의 메소드를 중복 선언할 수 있다.
// 이것을 가능하게 하는 컨벤션이 메소드 오버라이딩과 메소드 오버로딩이 있다.
public class JButtonTest_1 implements ActionListener { // 구현부가 없는 추상메소드를 오버라딩 하지 않았다.
	// 선언부 : 전역변수가 온다
	JFrame 	jf		   = new JFrame ();
	JButton jbtn_north = new JButton("조회"); //메모리에 로딩만 되어있다.
	
	// 생성자 ( 클래스 뒤에 괄호가 있으면 )
	// 생성자에는 리턴타입을 쓰면 안된다. 리턴타입이 없다.
	// 생성자 선언할 때 리턴타입을 사용하면 메소드가 된다.
	// 생성자가 있어서 전역변수는 초기화를 생략할 수 있는 것이다.(지역변수는 반드시 초기화를 해야한다)
	// 생성자도 호출이 된다.
	public JButtonTest_1() {
		System.out.println("JButtonTest_1 생성자 호출 성공");
	}
	
	// 화면처리부 - 사용자 정의 메소드
	
	// 사용자 정의메소드는 자동으로 실행되지 않는다. → 호출을 해야 실행이 된다.
	// 콜백메소드 : 자동으로 실행되는 메소드 - 시스템에서 자동으로 호출함 main()
	// static이 붙은 변수는 클래스 급이다. → 인스턴스화를 해야한다.
	public void initDisplay() {
		System.out.println("initDislpay 호출 성공");
		// 이 코드가 있어야 콜백메소드가 호출 된다.
		// 언제? 버튼이 눌려 졌을 때
		jbtn_north.addActionListener(this);
		// 순서 jf.setSize(400, 500); - JButton jbtn_north = new JButton("조회"); - jf.add("North", jbtn_north);
		jf.add("North", jbtn_north);
		jf.setSize(400, 500); // API 안에 / set사이즈 안에 파라미터가 2개 온다. / 
		jf.setVisible(true);
		
		
		
	}
	// 메인메소드 - exe파일로 만들 때만 필요하다.(메인메소드는 꼭 없어도 된다.)
	public static void main(String[] args) {
		// 인스턴스화
		// 생성부의 이름으로 객체가 만들어 진다.
		// 메모리에 로딩이 일어난다.
		// 메소드와 변수를 누릴(호출, 부를)수 있다.
		// 변수를 호출하면 값이 나온다. - 원시형 타입
		// 변수 : 하나만 담는다. 다른타입은 못담는다. 중복저장은 안된다. 클래스의 구성요소이다. 
		// 원시형 변수와 참조형 변수
		// 원시형 변수 : 값이 나온다
		// 참조형 변수 : 클래스이다, 객체이다. LAM에 대한 주소번지가 나온다
		// DB - 보안을 받으면서 파일을 관리하고 싶다. IDC센터(유료) -> 대체 : AWS
		// 변수 전역변수, 지역변수, 정적변수 
		// 인스턴스화에서 생성부는 생성자를 호출해주는 코드이다.
		
		
		JButtonTest_1 jbt = new JButtonTest_1(); 
		jbt.initDisplay (); // jbt : 인스턴스 변수 / 메소드를 호출하고 있다.
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// getSource() 호출하면 어떤 컴포넌트에 감지가 되었는지 알 수 있다.
		// pritln메소드는 메소드 오버로딩의 대표적인 예이다.
		// System.out.println(e.getSource()); //메소드 이름이 같다. 파라미터의 값이 다르거나
		Object obj = e.getSource();
		if(obj == jbtn_north)
			System.out.println("조회 버튼 클릭 성공");
		
	}

}
