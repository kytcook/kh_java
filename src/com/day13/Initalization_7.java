package com.day13;

// 변수의 초기화는 언제? 어디에? 왜? 해야 하는거니?
// 문제 : 1부터 5까지의 합을 구하는 프로그램을 작성하시오.
public class Initalization_7 {
	int count;
	int hap = 0;

	public void account() {
		for(count = 1; count < 6; count++) {
			hap = hap + count;
		}
			System.out.println("after count" + count);
			System.out.println("after hap" + hap);
			// 만일 이어서 1부터 5까지 다시 세면서 홀수의 합을 구하라고 한다면?
			// 초기화는 어디에? 그리고 얼마로 해야 될까요?
//			XXXXX = 1;
			count = 1;
//			XXX = 0;
			hap = 0;
//			A > 0 ? 10 : 9;
//			for(;count?6; count++) {
			for(; count<6; count++) {
//				if(XXXXX%2 == 1)	
				if(count%2 == 1)	
					hap = hap + count; // 실행문이 한 줄 일때 { } 생략가능
		}
			// 6을 기대했는데 왜 21이 출력되는 거지!! 아앗 초기화
			System.out.println("홀수의 합은 : " + hap); //9
			
	}

	public static void main(String[] args) {
		Initalization_7 i7 = new Initalization_7();
		i7.account();
	}

}
