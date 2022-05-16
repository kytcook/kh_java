package homework;

import java.util.Random;

public class RandomArray_1 {
	Random r = new Random();
// 0.0~21.0
// 0.0 vhgka
// 21.0은 포함하지 않는다. API
	
	public RandomArray_1() {
		int nansu = (int)(Math.random()*21)-10;
		System.out.println(nansu);
//		int randompick = r.nextInt(10);
		int randompick2 = r.nextInt(21)-10;
		System.out.println(randompick2);		
	}
}

