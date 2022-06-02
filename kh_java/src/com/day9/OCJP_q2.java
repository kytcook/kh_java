package com.day9;
// 메소드에 이름이 다르면 메소드오버로딩이나 메소드 오버라이딩을 따질 필요가 없다.
public class OCJP_q2 {
		 public void setVar(int a, int b, float c) {}
		 // 메소드의 개수는 동일하지만 타입의 순서가 다르다
		 private void setVar(int a, float c, int b) {}
		 // 파라미터의 순서가 같으면 무조건 안된다. > String name 추가
		 protected void setVar(int a, int b, float c, String name ) {}
		 // 6번과 경합이 벌어졌다. - 6번과 중복이다.
		 // 답을 찾는건 4번 라인과의 중복을 찾는 것이다.
//		 public int setVar(int a, float c, int b) { return a; }
//		 public int setVar(int a, int b, float c) { return a; }
//		 protected float setVar(int a, int b, float c) { return c; }
         
}//    
