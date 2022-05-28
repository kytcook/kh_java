package RadnomDice;

import java.util.Random;
import java.util.Scanner;


public class Random1 {
	Scanner scan = new Scanner(System.in);
	Random rd = new Random();

		public int rd() {
		int b = rd.nextInt(10);	
		return b;
	}//				[end of rd()]
	// 25-26(인스턴스화)-28-30-32-33[for진입]-
	//
	//
	//
	//	
	public static void main(String[] args) {
		Random1 rd1 = new Random1();
		//1부터 5까지 세는 변수 
		int i;
		//사용자가 입력한 값 담기
		// 컴터가 채번한 값 - 새게임이면 다시 채번하기
		int result = rd1.rd();//5
		for(i=1; i<6; i++) {// 1,2,3,4,5
			// 사용자가 입력한 값을 5번 받아오기
			int mypick = rd1.scan.nextInt();
			System.out.println("회차:"+i+", "+"사용자가 입력한 값 : "+mypick+", 채번한값:"+result);
			if ( mypick == result) { // 3==5 
				System.out.println("찍신");
				break;// 34번 for문 탈출
			}else {
				System.out.println("else 호출");
				if (i == 5) {
					System.out.println("바보바보");
				} else {
					System.out.println("꽝");
				}// [end of else2]
			}//		[end of else]
		}//			[end of for]
	}//				[end of main()]
}//  				[end of class Random1]