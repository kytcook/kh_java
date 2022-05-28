package com.day15;

import javax.swing.JDialog;
public class B_4 extends JDialog {
	String title = null;
	boolean isView = false;
	public B_4() { // 
		System.out.println("B_4() 생성자 호출 성공:전변초기화:선언시 초기화 생략가능");
		initDisplay();
	}
	public void set (String title, boolean isView) {
		this.setTitle(title);
		this.setVisible(isView);
	}
	public void initDisplay() {
		System.out.println("initDisplay 호출");
		this.setTitle("자손창-다이얼로그");
		this.setSize(300, 500);
		this.setVisible(isView);
	}
	public static void main(String[] args) {
		B_4 b = new B_4();
		System.out.println("before ===> " + b);
		b.initDisplay();
		// 메소드를 호출하지 않았기 때문에 생성자에서 한 번만 호출이 일어난다.
		b = new B_4(); // 새로운 선언으로 복사본이 같은 타입의 객체가 생성되었다.
		System.out.println("after ===> " + b);
	}
}
