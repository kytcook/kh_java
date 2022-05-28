package gong2_import;

public class Bindo {
	int[] baek;
	int[] ten;
	int size, count;

	public Bindo() { // 디폴트 생성자 
		// 0부터 9까지의 숫자를 랜덤으로 100개를 채번하여 1개의 배열에 출력
		// 10개씩 10개의 배열에 분배하기
		int[] baek = new int[100]; // 배열 길이 100 초기화 	
		int[] ten = new int[10]; // 배열 길이 10 초기화
		int size = 10;
		int count = 0;
		
		initArray(baek, ten, size);
		bindoTest(baek, ten, count);
	}
	
	public void initArray(int[] baek, int[] ten, int size) { // 숫자 100개를 넣는 곳
		this.baek = baek;
		this.ten = ten;
		
		// 디폴트 생성자에서 선언한 배열 baek에 0~9 까지의 랜덤 숫자 채번하여 저장
		for(int i=0; i<baek.length; i++) { // 배열 baek의 길이만큼 
			baek[i] = (int)(Math.random() * 10); // 랜덤숫자 출력 (범위 0~9)
		}
		
		// 배열 출력 - 한 줄에 10개씩 출력하고 줄바꿈 (10x10)
		for(int i=0; i<size; i++) { // 0번 부터 9번 까지
			for(int j=0; j<size; j++) {
				System.out.print(baek[(i * 10) + j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
	public void bindoTest(int[] baek, int[] ten, int count) { // 0 부터 9까지 랜덤으로 출력된 수의 각 빈도 확인 
		// 0~9 까지의 각 숫자를 나타낼 배열 ten 
		for(int i=0; i<ten.length; i++) {
			ten[i] = i;
			System.out.print(ten[i] + "x "); // 배열 ten 출력
		}
		System.out.println();
		
		// baek 배열의 0~9 까지의 각 수의 갯수 출력 
		for(int i=0; i<ten.length; i++) { // 배열 ten의 인덱스 번호와
			for(int j=0; j<baek.length; j++) { // 배열 baek의 요소가 같을 때
				if(ten[i] == baek[j]) {
					count++;
				}
			}
		}
		System.out.println(count + " "); // 빈도수 출력
		count = 0; // count 초기화 (다음 숫자의 빈도수를 세기 위해)
		return;
	}
	
	public static void main(String[] args) { // 메인 메소드
		new Bindo(); // 디폴트 생성자 호출
	}

}
