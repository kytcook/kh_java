package com.day3;

import javax.swing.JFrame;

public class JFrameTest_5 {
	//선언부
	JFrame jf = new JFrame ();
	int width = 500; //변수 선언
	int height = 400;
	String name = "리믄택";
	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");
		jf.setSize(width,height); 
		jf.setTitle(name); 
		jf.setLayout(null); 
		jf.setVisible(true); 
	
	} // end of initDisplay
	public static void main(String[] args) {
		// javac JFrameTest_5.java -> - Ctrl+s
		// [ 배 열 ] : java JFrameTest_5 "홍길동" "강감찬" "이순신"
		JFrameTest_5 jft = new JFrameTest_5();
		jft.initDisplay () ; //메소드 호출
		for(int i=0; i<3; i=i+1) { // i=0, i=1, i=2
			System.out.println(args[i]);
		}
	} // end of JFrameTest
//
}
