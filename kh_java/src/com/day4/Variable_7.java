package com.day4;

public class Variable_7 {
	/**
	 * 
	 */
	void methodA () {
		//return 5; 에러가 난다. why? void
	}
	/**
	 * 
	 * @return
	 */
	int methodB () {
		int x = 5;
		int y;
		y = x;
//		return 0; // 없다면 methodB는 에러
		return y;
	}
	
	public static void main(String[] args) {
		Variable_7 v7 = new Variable_7() ;
		int x;
//		int x = v7.methodA(); // void니까 안된다. ※int를 없앤다
		v7.methodA();
		x = v7.methodB();
		x  = x + 2;
		System.out.println(x);
		
	}

}
