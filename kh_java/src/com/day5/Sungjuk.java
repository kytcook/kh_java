package com.day5;

// import javax.swing.JOptionPane;

public class Sungjuk {
	int kor  = 90;
	int eng  = 95;
	int math = 60;
	int total () {
		int hap = 0;
			hap	= kor+eng+math;
		return hap;
	}
	/**********************************************************
	 * 평균을 구하는 메소드 구현
	 * @param hap - 세과목에 대한 총점을 복사 해온다
	 * @return double - 총점을 국어, 수학, 영어 세 과목으로 나눈다
	 * double/double => double
	 *********************************************************/
	double averge(int hap) {
		double avg = hap / 3.0;
		return avg;
	}
	public static void main(String[] args) {
		Sungjuk sj = new Sungjuk () ; //클래스 인서턴스화
		// sj는 참조형 변수이다. 호출하면 주소번지가 출력된다
		// 언제 사용할까? 클래스 안에 선언된 변수나 메소드를 누릴때 사용한다.
		int hap = sj.total () ; 
		System.out.println("총점은 : " + sj.total());
		
		// insert here - 평균 구해보기
		double avg = sj.averge(hap);
		System.out.println("평균은 : " + avg);
	
		// intsert here - 업무 담당자가 화면에 과목명을 출력해 달라 한다.
		// non-static의 변수명을 static영역에서 사용하려면 인스턴스화를 한다.
		
		
		
		System.out.println("국어 : " + sj.kor);
		System.out.println("영어 : " + sj.eng);
		System.out.println("영어 : " + sj.math);
		
		System.out.println("국어 : " + sj.kor 
					   + ", 영어 : " + sj.eng
					   + ", 수학 : " + sj.math);

		System.out.println("국어 : " + sj.kor 
					   + "\n영어 : " + sj.eng
					   + "\n수학 : " + sj.math);
		
//		String subject = null;
//		subject = JOptionPane.showInputDialog("어떤 과목입니까?");
//		System.out.println("당신의\s" + subject + " 점수는 : " + )
		
		
	}
	
}
