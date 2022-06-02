package test.kh0503;
// 더 큰 타입은 더 작은 타입에 대입연산자를 통해서 재정의 할 수 없다.
// 대인(=) 연산자를 기준으로 오른쪽이 왼쪽보다 큰 타입이 오면 폭망이다.

public class Exam1 {

	public static void main(String[] args) {
		int i = 5; // 지변
		double d; // 소수점까지 담는다.
		d = 1.5; // 초기화를 해야 ↓사용 가능하다.
		// 강제 형전환을 시키면 0.5는 담을 수가 없다.
		i = (int)d; //(int)casting 연산자 // 지변 : 초기화를 생략할 수 없다 
		System.out.println(i); // 5
		boolean isOk = false; // ☆알고리즘, workflow를 바꿔준다★
		if(isOk) {
			float f = 1.5f; 
			// 조건을 만족하지 않으면 단 한 번도 실행기회는 없다.
			// insert here -(false) 실행문 : 실행이 안된다
		}else {
		}
//		System.out.println(f); if문 안의 지변이기 때문에 불러올 수 없다
//		인스턴스 변수.지변 접근 불가 / 인스턴스 변수.전변 접근 가능
		Exam1 e1 = new Exam1();
		// 지변 : 인스턴스변수, 변수명 불가하다
//		System.out.println(e1.i); 지변이기 때문에 안돼
	}

}
