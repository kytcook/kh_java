package homework;

import java.util.Random;

public class RandomArray_2 {
	int[] Array = null;
	int i;
	int n;

	public RandomArray_2(int n) {
		Array = new int[n];
		n += -1;
		for (i = 0; i <= n; i++) {
			Array = new int[n]; // 이 부분 배열안에 어떻게 n의 파라미터값을 넣을 수 있을까요??
			for (i = 0; i < n; i++) {
				Array[i] = (int) (Math.random() * 21) - 10;
				System.out.print(Array[i] + ", ");
				plushap();
			}
		}
		
	}

	public void plushap() {
		int plushap = 0;
		for (i = 0; i < n; i++) {
			if (Array[i] >= 0) {
				System.out.print(plushap + " + " + Array[i] + " = ");
				plushap += Array[i];
				System.out.println(plushap);
			}
		}
		
	}

	public void minushap() {
		int minushap = 0;
		for (i = 0; i < n; i++) {
			if (Array[i] >= 0) {
				minushap += Array[i];
			}
		}
		
	}
	
}
