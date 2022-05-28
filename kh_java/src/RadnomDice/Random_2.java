package RadnomDice;

import java.util.Random;
import java.util.Scanner;

//class Random_3 {
//	int count;
//	public int Randomdice(int i) {
//		count = i;
//	}
//	
//}

public class Random_2 {
	Scanner scan = new Scanner(System.in); // 입력장치
	Random rd = new Random(); // 난수
	int result = rd.nextInt(10); // 채번한 숫자

	public Random_2() {
		// 생성자
	}

	public int RandomDice(int i) {
		int count = i;
//		for (count = 1; count < 6; count++) {// 1,2,3,4,5
		while (count <= i) {
			int mypick = scan.nextInt();
			if (mypick == result) {
				System.out.println("찍신");
				break;
			} else if (count == 0) {
				System.out.println("바보바보");
				break;
			} else if (result < mypick) {
				System.out.println("낮추어라;");
				System.out.println("남은기회 : " + count);
				count--;
			} else if (result > mypick) {
				System.out.println("높이라;");
				System.out.println("남은기회 : " + count);
				count--;
		}
	}
		return count; // i, count
}
	public static void main(String[] args) {
		Random_2 r2 = new Random_2();
		r2.RandomDice(10);
	}
}