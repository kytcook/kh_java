package personal_study;

abstract class Animal {
	String a = " is animal";
	abstract void look();
	void show() {
		System.out.println("zoo");
	}
}

class Chicken extends Animal {
	Chicken() {
		look();
	}

	void look() {
		System.out.println("Chicken" + a);
	}

	void display() {
		System.out.println("two wings");
	}
}

public class Test2 {
	public static void main(String[] args) {
		Animal a = new Chicken();
//		Animal b = new Animal(); 추상 클래스는 내부에 실행 코드가 없는 추상 메소드를 포함하기 때문에
		// 객체 변수의 생성자로 사용할 수 없다.
		a.show();
	}
}


