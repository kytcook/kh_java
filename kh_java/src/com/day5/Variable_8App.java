package com.day5;

import com.day4.Variable_8;

public class Variable_8App {

	public static void main(String[] args) {
		System.out.println(Variable_8.isOk);		
	
		// Variable_8.isOk = true; /직접 상수로 준 것이기 때문에 좋은 방법은 아니다.
		Variable_8 v8 = new Variable_8 () ;
		//System.out.println(!(Variable_8.isOk));
		System.out.println(Variable_8.isOk);

	}

}
