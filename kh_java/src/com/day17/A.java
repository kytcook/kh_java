package com.day17;

public class A {
	int i = 100;
	void methodA(int i) {
		//for문 안에서 선언된 변수는 밖에서 사용 불가
		try {
			int z = i/0;
			
		} catch (Exception e) {
			System.out.println("[Exception]" + e.toString());
		}
	}
	public static void main(String[] args) throws Exception {
		int i = 5;
		int j = 0;
		A a = new A();
		a.methodA(i);
	}

}
