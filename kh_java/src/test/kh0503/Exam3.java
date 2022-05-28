package test.kh0503;

public class Exam3 {
	
	public static void main(String[] args) {
		// 원시형 타입은 부르면 값이 나온다.
		// 원시형은 하나만 선언할 수 있다.
		// 참조형 타입은 부르면 주소번지가 출력된다.
		boolean isFail = false; // 기본 자료형
		System.out.println("isFail의 값" + isFail);
		Exam3 e3 = new Exam3();
		// e3은 참조형 변수라고 한다.
		// 참조형 변수에는 여러개의 변수가 있을 수 있다.
		// 클래스 안에는 여러개의 변수를 선언할 수 있다.
		System.out.println("참조변수 e3의 주소번지 출력: " + e3);// @45cba234주소번지 출력
		
		// 디폴트 생성자가 호출된다.
		// uVO를 인스턴스(참조형) 변수라고 한다.
		// 디폴트 생성자를 호출 했을 때는 
		// mem_id = null, mem_pw = null, birth = null 이렇게 초기화 되어있다.
		UserVO uVO = new UserVO();
		// mem_id = "banana", mem_pw = "156", birth = "1999-12-25" 이렇게 초기화 되어있다.
		// 참조형 변수는 한 번에 여러개의 전역변수를 갖는다.
		// 변수들에 대한 초기화를 할 수 있고, 그 값을 외부에서 접근(출력)할 수 있다.
		// uVO = new UserVO("Banana", "156", "1999-12-25");
		// 왜냐하면 접근제한자가 private이므로 class외부에서는 접근이 불가하다.
		System.out.println(uVO.getMem_id());
		System.out.println(uVO.getMem_pw());
		System.out.println(uVO.getBirth());
	}
		
}
