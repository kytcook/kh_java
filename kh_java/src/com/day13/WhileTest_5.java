package com.day13;

public class WhileTest_5 {
	int i;
	int hap;
	// 파라미터를 갖는 생성자 선언 및 구현하기 - 파라미터가 2개
	// 생성자 선언시 절대로 반환타입이 있으면 안된다. - 만일 있으면 메소드가 된다.
//	public XXXXXXXXX_5(int i, int hap) {
	public WhileTest_5(int i, int hap) {
		this.i = i; //1
		this.hap = hap; //0
	}
//	public void account() {
	public int account(int i, int hap) {
		while (i < 6) {
//			hap = hap + X;
			hap = hap + i;
			System.out.println("i : " + i);
			System.out.println("hap : " + hap);
			i++;
		}
//		return XXX;
		return hap;
	}
	public static void main(String[] args) {
		int i = 1;
		int hap = 0;
//		WhileTest_5 X = new WhileTest_5(i, XXX);
		WhileTest_5 w = new WhileTest_5(i, hap);
//		w.account();
		w.account(i, hap);
//		System.out.println("1부터 5까지의 합은 " + X.hap);
		System.out.println("1부터 5까지의 합은 " + w.hap); // 0이 출력되므로 반드시 인스턴스 변수를 붙임
	}
}