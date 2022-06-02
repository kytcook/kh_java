package com.day15;

public class JumsuSimulation {
	public static void main(String[] args) {
		int i = 0;
		int total = 0;
		double avg = 0;
		Jumsu_2 js = new Jumsu_2(i);					// Jumsu클래스 인스턴스화와 동시에 생성자 실행(?)
		js.tot(i, total);
		js.avg(avg);
	}

}
