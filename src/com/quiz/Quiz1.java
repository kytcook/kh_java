package com.quiz;

import javax.swing.JOptionPane;

// 사용자로 부터 입력받는 값을 읽어오는데 필요한 다이얼로그 화면입니다

public class Quiz1 {
	

	public static void main(String[] args) {
		// 당신의 몸무게를 알고 싶다
		String yourWeight = null;
		yourWeight = JOptionPane.showInputDialog("당신의 몸무게는 지구에서 얼마입니까?");
		// 달의 몸무게를 담을 변수 선언
		double moon_weight = 10.0; // 입력값을 줄때는 초기화가 무적권 0?
		// Double.parseDouble
		// 메소드의 파라미터에 String을 주면 double으로 형전환을 해주는 메소드
		double earth_weight = Double.parseDouble(yourWeight);
		// yourWeight * (17/100)
		System.out.println(earth_weight * (17/100.0));
		moon_weight = earth_weight * (17/100.0);
		System.out.println(moon_weight);
	}

}