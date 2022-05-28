package com.day3;

import javax.swing.JFrame;

public class JFrameTest_2 {
	//선언부
	JFrame jf = new JFrame ();
	int width = 600;
	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");
		jf.setSize(500,400);
		jf.setSize(width,400);
		jf.setLayout(null);
		jf.setVisible(true);
		
	} // end of initDisplay
	public static void main(String[] args) {
		JFrameTest_2 jft = new JFrameTest_2();
		/* static이 붙어있는 main method안에서는 static이 붙어있지 않는 틀과 변수명을
		   non-static파일에 jft라는 변수명을 메인메소드 안에서는 사용할 수 없다. */
		jft.initDisplay () ; //메소드 호출
	} // end of JFrameTest
//
}
