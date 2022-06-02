//package com.day11;
//
//public class Test2 {
//	public static final double PI = 3.14;
//	public double radius;
//	
//	public Circle(double radius) {
//		this.radius = radius;
//	}
//	public double getRadius() {
//		return radius;
//	}
//	public void setRadius(double radius) {
//		this.radius = radius;
//	}
//	public static double getPI() {
//		return PI;
//	}
//	
//	public void draw() {
//		System.out.println("반지름 " + radius + "cm인 원을 그립니다.");
//	}
//}
////클래스 2개를 다이어그램을 이용하여
////런 클래스를 실행했을 때 서클이라는 
//// 22번줄 반지름을 담는 코드 전역변수.. 생성자 생략
//// 값을 결정하는 부분들이 써클 14번 메소드
//// 를 통해 3.1
//// 잘못된 부분 : 핵심이슈 : 생성자도 메소드 오버로딩의 
//// 규칙을 준수한다. 파라미터의 개수와 타입이 달라야 한다. 
//// 7번라인 생성자 : 파라미터가 있는 생성자
//// 7번 생성자를 인스턴스화를 통해 제대로 호출 하고 있는가?
//// 접근제한자는 영향이 있다 없다. 없다.
//// 오버로딩의 규칙을 지키지 않는다 몇번째 라인에 해당하는가?