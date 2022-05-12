package personal_study;
// [배열을 이용한 피보나치 수열]
public class Fibonacci_01 {
	public void Fibonacci() {
		int[] arry = new int[15];
		arry[0] = 1;
		arry[1] = 1;
		int i = 2;
//		for (i = 2; i <= 10; i++) {
		while (i <= 10) {
			arry[i] += arry[i - 1] + arry[i - 2];
			System.out.println(arry[i] + " ");
			i ++;
			
		} //	[end of for]
	} // 		[end of method Fibonacci]
	
	public static void main(String[] args) {
		Fibonacci_01 fbc01 = new Fibonacci_01();	
		fbc01.Fibonacci();
		
	} // 		[end of main]
} //			[end of class Fibonacci]
