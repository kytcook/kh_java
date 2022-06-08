package com.day13;

public class Initalization_4 {
	int count;
	int hap = 0;
	public void account() {
		for(count = 1; count < 6; count++) {
			System.out.println("count" + count);
			System.out.println("hap " + hap);
//			XXX = XXX + count;
			hap = hap + count;
			System.out.println("after count" + count);
			System.out.println("after hap" + hap);
		}
	}
	public static void main(String[] args) {
		Initalization_4 i4 = new Initalization_4();
		i4.account();
	}
	
}
