package personal_study;
// [배열을 이용한 피보나치 수열]
public class Fibonacci_02 {
	int i;
	public void Fibonacci() {
		int preNum = 1;
		int pre2Num = 1;
		
//		for (int i = 3; i < 20; i++) {
		while (i < 20) {
			int curNum = preNum + pre2Num;
			System.out.println(curNum + " ");
			preNum = curNum;
			pre2Num = preNum;
			i++;
			
		}
		
	}
	public static void main(String[] args) {
		Fibonacci_02 fbc02 = new Fibonacci_02();	
		fbc02.Fibonacci();
		
	} // 		[end of main]
} //			[end of class Fibonacci]
