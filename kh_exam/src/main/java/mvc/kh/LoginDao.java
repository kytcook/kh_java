package mvc.kh;

import org.apache.log4j.Logger;

// 리액트와 조인
// DAO[JSON포맷출력, XML포맷출력기 : DataSet] - Data Access Object - 오라클 서버와 연계하는 일만 전담하는 클래스이다.
// Logic 실제프로젝트에서는 반드시 필요합니다. 꼭 넣읍시다.
// XXXLogic 클래스의 하나의 메소드 안에 여러개의 Dao 메소드 호출을 받아 낸다.	
// -> 여러개의 Dao메소드를 호출한다는 것은 업무에 대한 프로세스를 알고 있다. - 판단할 수 있습니다.
// DAO라는 디자인 패턴은 모델계층의 일부이다. - DAO가 있고 없고는 MVC 기준이 아니다.
// DataSet은 프론트앤드와 만난다. - 응답이 없다.
// MyBatis와 같은 ORM솔루션과 연계하는데 있어서 아주 종요한 포지션이 있는 - 클래스 설계이다. - MyBatis와의 의존관계 포함 : 마이바티스의 위치에 하이버네이트를 담아낼 수 있다.
// 의존관계에 대해 말 할 수 있다. 
public class LoginDao {
	Logger logger = Logger.getLogger(LoginDao.class);
	
	public String login(String mem_id, String mem_pw) {
		String mem_name = null;
		mem_name = "이순신";
		//mem_name = null;
		return mem_name;
	}
	
}
