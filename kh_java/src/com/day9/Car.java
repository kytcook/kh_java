package com.day9;

public class Car {
	int wheelNum = 0;
	public void stop() { // 추상메소드 : abstract
	
	}
}

class Sonata extends Car{ // extends 상속
	@Override
	public void stop() {
		
	}
	// 메소드 오버로딩 규칙을 준수 했으니까..
	public int stop(int i) {
		return 0;
	}
	public int stop (double i) {
		return 0;
	}
//	public double stop (double i) { return 0; }
	
	
}