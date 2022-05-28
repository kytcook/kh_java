package ArrayQuiz;
// 의도 : 100개의 채번된 숫자들이 1차 배열의 인덱스 값과 같다.
// int a[] = new int[100];
// int b[] = new int[10]; 카운트 값을 담는다.
// 다른사람의 생각을 이해하기. 받아들이는 과정 - 소통
public class BinDoTeacher {
	public BinDoTeacher() {
		int nanSus[] = new int[100];
		int pCount[] = new int[10];
		// insert here
		initArray(nanSus, nanSus.length);// 배열의 길이를 파라미터로 보낸다.
		numberCount(nanSus, nanSus.length, pCount);
		print10PerLine(nanSus, nanSus.length);
		printResult(pCount, 10);
	}

	// 배열의 초기화
	void initArray(int nanSus[], int size) {// size : 배열의 길이값을 받는다. 이름은 상관없다. 타입이 중요하다.
		// insert here
//			System.out.println(nanSus+ ", " + size);
		for (int i = 0; i < nanSus.length; i++) {
			// 0.0 ~ 10.0 실수 채번한다 0.0포함, 10.0미포함
			nanSus[i] = (int) (Math.random() * 10);
		}
	}
	
	// int is[] = new int[3];
	// is[0] = 0;
	// is[1] = 4; / println(is[1]) = 4 /
	// is[2] = 0;
	// 빈도 검사 nanSus에 들어 있는 숫자의 빈도를 pCount에 저장함
	void numberCount(int nanSus[], int size, int pCount[]) {
		// insert here
		int nIndex = 0;
		// 채번된 100가지의 숫자에 대해 판정을 해야 한다.
		for(int i = 0; i < size; i++) {
			// 카운트 하기 위해서 배열의 값을 담았다.
			// 채번된 숫자를 배열(pCount)의 인덱스 변수에 담는다.
			nIndex = nanSus[i];// nIndex에 nanSus의 n번째 배열위치에 있는 값을 저장한다.
			// pCount는 100개의 숫자에 대한 빈도수를 관리하는 1차배열이다.
			pCount[nIndex]++;// 위의 값을 pCount의 배열 위치값으로 들고와서 1증가 시킨다.
		}

	}

	// 배열 출력 한 줄에 10개씩 출력하고 줄바꿈 하기
	void print10PerLine(int nanSus[], int size) {
		System.out.printf("원본 : 	");
		for (int i = 0; i < size; i++) {
			System.out.printf("%3d", nanSus[i]);
			if (i % 10 == 9)
				System.out.printf("\n	");
		}
	}

	// 빈도 출력 빈도 배열과 인덱스를 함께 출력
	void printResult(int pCount[], int size) {
		// insert here
		System.out.println("\n ");// 개행 처리하기
		System.out.print("숫자 :");
		for(int i = 0; i < size; i++) {
//			System.out.print("   " + i);
			System.out.printf("%3d", i);
		}
		System.out.printf("\n");//개행 처리하기
		System.out.printf("개수 :");//개행 처리하기
		for(int i = 0; i < size; i++) {
			System.out.printf("%3d", pCount[i]);
		}		
	}

	public static void main(String[] args) {
		new BinDoTeacher();
	}

}
