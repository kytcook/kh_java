package ajdbc.zipcode;

import java.util.Scanner;

public class ZipcodeSearch {
	// 선언부
	
	// 생성자
	
	// 사용자로부터 동을 입력받는 메소드 구현
	public String userInput() {
		String dong = null;
		//insert here
		Scanner scan = new Scanner(System.in);
		dong = scan.nextLine();
		return dong;
	}
	// 우편번호 조회 메소드 구현
	
	// 조회된 우편번호 목록 출력하기
	
	public static void main(String[] args) {
		String userDong = null;
		ZipcodeSearch zs = new ZipcodeSearch();
		while("1".equals(userDong) || userDong == null) {
			System.out.println("동을 입력하세요(예 : 당산동)");
			userDong = zs.userInput();
			if("그만".equals(userDong)) {
				break;				
			}
			System.out.println("사용자가 입력한 동 ====> " + userDong);
//			zs.getZipCodeList(userDong);
			userDong = "1";
		}
		System.out.println("while 탈출하면 출력됨");
	}

}
