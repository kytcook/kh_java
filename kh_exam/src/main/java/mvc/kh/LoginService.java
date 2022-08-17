package mvc.kh;

import org.apache.log4j.Logger;

// 여러개의 Dao를 호출할 수 있다. - 트랜잭션 처리
// 하나의 테이블에서 조회된 정보를 가지고 A테이블에서는 insert B테이블에는 update처리한다.- 하나의 업무라고 한다면 트랜잭션 처리가 필요하다. 컨벤션
// 트랜잭션 처리는 로직클래스에서 해야만 한다.
public class LoginService {
	Logger logger = Logger.getLogger(LoginService.class);
	// 이른 인스턴스화 이다. -> 스프링에서 나오는 용어입니다. <> 게으른 인스턴스화 | 멤버위치
	// 게으른 인스턴스화 - 필요할 때 바로 직전에 주입해준다. - 효율적이다. 퍼포먼스가 좋다 - NullPointerException
	// 로컬성격 - 지역변수
	// 로그인 서버에대한 인스턴스화가 될 때. 멤버변수는 초기화가 먼저 된다.
	LoginDao loginDao = new LoginDao(); // 이른 인스턴스화의 위치는 클래스 선언 바로 뒤에 위치하는 것이 좋다.
	public String login(String mem_id, String mem_pw) {
		// TODO Auto-generated method stub
		String mem_name = null;
		mem_name = loginDao.login(mem_id, mem_pw);
		return mem_name;
	}
}
