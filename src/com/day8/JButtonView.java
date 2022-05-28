package com.day8;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonView {
	JFrame 	jf		   = new JFrame ();
	JButton jbtn_north = new JButton("조회");
	// 생성자 파라미터에 this는 자기자신을 가리키는 예약어이다.
	// (this) = JButtonView Class를 가리킨다.
	// 그런데 아래 코드에서 컴파일 에러가 발생하는 이유는 파라미터가 JButtonView 타입인 생성자가 선언되어 있지 않아서 발생한 오류.
	JButtonEventHandler event = new JButtonEventHandler(this); // (this)를 넣음으로써 원본을 공유한다.
	public void initDisplay() {
		System.out.println("initDislpay 호출 성공");
		jbtn_north.addActionListener(event);
		jf.add("North", jbtn_north);
		jf.setSize(400, 500); 
		jf.setVisible(true);
	}

	public static void main(String[] args) {
		JButtonView jbt = new JButtonView(); 
		jbt.initDisplay ();
	}

}
