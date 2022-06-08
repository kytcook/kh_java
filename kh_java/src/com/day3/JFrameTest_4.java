package com.day3;

import javax.swing.JFrame;

public class JFrameTest_4 {
	//선언부
	JFrame jf = new JFrame ();
	int width = 500; //변수 선언
	int height = 400;
	public void initDisplay() {
		// 변수선언 : 타입 변수명(마음대로 직관적이게) = 값을 왼쪽에 대입
		String name = "리믄택";
		System.out.println("initDisplay 호출 성공");
		
		jf.setSize(width,height); //변수 사용
		jf.setTitle(name); // 실행창에 제목
		jf.setLayout(null); // Layout관리자(?) : null은 관리자 미정
		jf.setVisible(true); // 창이 보이게 (False라고 실행이 안되는것이 아님)
		
	
	} // end of initDisplay
	public static void main(String[] args) {
		JFrameTest_4 jft = new JFrameTest_4();
		jft.initDisplay () ; //메소드 호출
	} // end of JFrameTest
//
}
