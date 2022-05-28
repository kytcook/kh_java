package com.day10;

public class Quiz26 {
	public static void main(String[] args) {
		int i = 1;
		int j = i++;
		System.out.println(i +", " + j);
		if ((i == ++j) && (i++ == j)) {
			//실행문 진행
			i += j;// i=i+j;
		}
		System.out.println(i);
	}
}
