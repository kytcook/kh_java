package mvc.kh;

import java.util.ArrayList;

import org.apache.log4j.Logger;
// 카피본이 만들어지는 거다. 이른 인스턴스화.
// 주소번지가 세 개 이다.
public class NoticeService {
	Logger logger = Logger.getLogger(NoticeService.class);
	public ArrayList<Notice> selectList() {
		logger.info("selectList호출 성공");
//		ArrayList<Notice> list = new ArrayList<>();
		ArrayList<Notice> list = null;// 게이른 인스턴스화 : NullPointerException -> 17번줄에서 일어난다
		try {// 널 포인터가 나와도 리스크를 피해갑시다~ 
			Notice notice = new Notice();
			notice.setTitle("제목1");
			notice.setWriter("이순신");
			notice.setContent("내용1");
			list.add(notice);
			notice = new Notice();
			notice.setTitle("제목2");
			notice.setWriter("김유신");
			notice.setContent("내용2");
			list.add(notice);
			notice = new Notice();
			notice.setTitle("제목3");
			notice.setWriter("강감찬");
			notice.setContent("내용3");
			list.add(notice);
			
		} catch (NullPointerException e) {
			logger.info("NullPointerException : 선언만 했네요~ 초기화를 안했네~~~");
		}
		return list;
	}

}

