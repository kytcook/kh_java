package com.day13;

public class WhileTest_2 {
//	public XXXX account() {
//	public void account() {
	int hap = -1; // -1 : end of file 끝을 의미하는 내부적인 코드
	public int account() {
		int i = 1;
		int hap = 0;
		while (i < 6) {
			hap = hap + i;
			System.out.println("i : " + i);
			System.out.println("hap : " + hap);
//			X++;
			i++;
		}
//		System.out.println("1부터 5까지의 합은 " + XXX);
		System.out.println("1부터 5까지의 합은 " + hap);
		return hap;
	}
	public static void main(String[] args) {
//		WhileTest_2 w = XXX WhileTest_2();
		WhileTest_2 w = new WhileTest_2();
		int hap = w.account();
		System.out.println("main 메소드에서 출력하기 : " + hap);
		// 인스턴스 변수.변수명 으로 호출하면 전변 호출
		System.out.println("main 메소드에서 출력하기 : " + w.hap); // 전역변수 확인
		System.out.println("지변 hap 출력하기 : " + hap); // 전역변수 확인
 //		X.account();
//		w.account();
	}
}