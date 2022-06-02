package com.day3;

import javax.swing.JFrame;

public class JFrameTest_3 {
	//선언부
	JFrame jf = new JFrame ();
	int width = 500; //변수 선언
	int height = 400;
	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");
		jf.setSize(100,100);
		jf.setSize(width,height); //변수 사용
		jf.setLayout(null); // Layout관리자(?)
		jf.setVisible(true); // 창이 보이게 (False라고 실행이 안되는것이 아님)
		jf.setTitle("보여 주세요"); //실행창에 제목
		
	} // end of initDisplay
	public static void main(String[] args) {
		JFrameTest_3 jft = new JFrameTest_3();
		jft.initDisplay () ; //메소드 호출
		// static이 붙어있는 main method안에서는 static이 붙어있지 않는 틀과 변수명을
		// non-static파일에 jft라는 변수명을 메인메소드 안에서는 사용할 수 없다.
	} // end of JFrameTest
//
}
