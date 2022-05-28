package ArrayQuiz;

public class BinDoTemplate {
	int nanSus[] = new int[15];

	BinDoTemplate() {
		int size = 100;
		int nanSus[] = new int[100];
		int pCount[] = new int[10];
		// insert here
		initArray(nanSus, size);
		print10PerLine(nanSus, size);
		numberCount(nanSus, size, pCount);
	}

	// 배열의 초기화
	void initArray(int nanSus[], int size) {
		int i;
		int j;
		// insert here
		for (i = 0; i < size; i++) {
			nanSus[i] = (int) (Math.random() * 10);

		}
	}

	// 빈도 검사 nanSus에 들어 있는 숫자의 빈도를 pCount에 저장함
	void numberCount(int nanSus[], int size, int pCount[]) {
		//insert here
		for(int i = 0; i < size; i++) {
			Switch (nanSus[i]) {
			case 0:
				pCount[i]++;
				break;
			
			case 1: 
				pCount[i]++;
				break;
	
			}
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
//	// 빈도 출력 빈도 배열과 인덱스를 함께 출력
//	void printResult(int pCount[], int size) {
//		//insert here
//		
//	}
}