package personal_study;

public class OverridingTest_2 {

	public static void main(String[] args) {
		Person person = new Person();
		Child child = new Child();
		Senior senior = new Senior();
		
		person.cry();
		child.cry();
		senior.cry();
	}
}

class Person {
	void cry() {
		System.out.println("흑흑");
	}
}

class Child extends Person {
	@Override
	protected void cry() {
		System.out.println("잉잉");
	}
}

class Senior extends Person {
	@Override
	public void cry() {
		System.out.println("훌쩍훌쩍");
	}
}