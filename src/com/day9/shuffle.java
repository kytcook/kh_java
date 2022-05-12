package com.day9;

//.6
public class shuffle {
	int i = 3;
	int j = 6;
	public boolean whaffleA(int i,int j) {
		boolean isOk = false;
		int imsi; // 지역변수는 초기화를 반드시 해야한다.
		imsi = i;
		i = j;// 3 → 6
		j = imsi;
		System.out.println(i + ", " + j);
		if (i!=3 && j!=6) isOk = true;
		return isOk; //셔플이 성공하면 true, 실패하면 false
	}
	public void whaffleB() {}
	public static void main(String[] args) {
		shuffle sf = new shuffle();
		boolean isOK = sf.whaffleA(3, 6);
		// boolean isOK2 = sf.whaffle(); // error : 리턴타입이 보이드다
		if(isOK) {
			System.out.println("참 잘했어요^^");
		} else {
			System.out.println("다시 한 번 생각해보세요.");
		}
		sf.whaffleB();
	}

}

////.5
//public class shuffle {
//	public boolean whaffle(int i, int j) {
//		int imsi; // 지역변수는 초기화를 반드시 해야한다.
//		imsi = i;
//		i = j;// 3 → 6
//		j = imsi;
//		System.out.println(i + ", " + j);
//		return true; // 셔플이 성공하면 true, 실패하면 false
//		
//	}
//	
//	public static void main(String[] args) {
//		shuffle sf = new shuffle();
//		boolean isOK = sf.whaffle(3, 6);
//		// boolean isOK2 = sf.whaffle(); // error : 리턴타입이 보이드다
//		sf.whaffle(3, 6);
//	}
//
//}

////.4
//public class shuffle {
//	static int i = 2;
//	static int	j = 4;
//	static int imsi;
//	
//	public static void main(String[] args) {
//		imsi = i;
//		i = j;// 3 → 6
//		j = imsi;
//		System.out.println(i + ", " + j);
//	}
//
//}



////.3
//public class shuffle {
//	int i = 2;
//	int	j = 4;
//	int imsi;
//	
//	public void shuff() {
//		 i = imsi;
//		 i = j;
//		 j = imsi;
//	System.out.println(i + "\n" + j);
//	}
//	
//	public static void main(String[] args) {
//	shuffle sh = new shuffle();
//	sh.shuff();
//	}
//
//}

//.2
//public class shuffle {
//	int i = 2;
//	int	j = 4;
//	int imsi;
//	
//	public static void main(String[] args) {
//	shuffle sh = new shuffle();
//	sh.imsi = sh.i;
//	sh.i = sh.j;
//	sh.j = sh.imsi;
//	System.out.println(sh.i + ", " +sh.j);
//	}
//
//}

//.1
//public class shuffle {
////	int i;  선언부에는 선언과 초기화를 나누어서 작성할 수 없다.
////	i = 3;
//
//	public static void main(String[] args) {
//		int i = 3;
//		int j = 6;
//		int imsi = 0;
//		imsi = i;
//		i = j;// 3 → 6
//		j = imsi;
//		System.out.println(i + ", "+ j);
//		
//		
//		
//	}
//	
//}
