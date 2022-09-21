package com.mvc.step1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class BoardController implements Action {
	Logger logger = Logger.getLogger(BoardController.class);
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("execute 호출 성공");
		String upmu[] = (String[])req.getAttribute("upmu");
		ActionForward af = new ActionForward(); // ActionForward받아서 리턴해서 sendRidirect나 forward를 하겠다.
		StringBuilder path = new StringBuilder();// 이 스타일은 pojo이지만 스프링을 흉내내고 있다.
		path.append("/board/");// 변수나 경로의 이름을 통일 하였다. <- board-step1
		logger.info("upmu[1] ===>" + upmu[1]);
		boolean isRedirect = false;// true - sendRedirect false : forward : 유지-select // select면 몰라도 forward다
		// select이면 유지이다. forward / sendRedirect XXXXXX 절대 쓰지 않는다
		// select 에는 조회결과가 있고 커서가 움직이니까 -> 맵에 상주하고 -> 맵에 상주하는 정보를 리스트에 담는거고 -> html에 뿌려준다. : forward
		// 글쓰기
		// 메소드 하나에서 4가지 경우를 따져야 한다.
		// forward 
		// 1-1에서는 메소드내에서 분기문으로 처리를 함 -> 가독성 별로... 재사용성 별로,,
		if("boardInsert".equals(upmu[1])) {
			logger.info("boardInsert 호출 성공");
		}
		// 글수정
		else if("boardUpdate".equals(upmu[1])) {
			logger.info("boardUpdate 호출 성공");
		}
		// 글삭제
		else if("boardDelete".equals(upmu[1])) {
			logger.info("boardDelete 호출 성공");
		}
		// 글조회
		else if("boardselect".equals(upmu[1])) {
			logger.info("boardSelect 호출 성공");
			List<Map<String,Object>> boardList = new ArrayList<>();
			// 선언부와 생성부의 타입이 다를 때 다형성 - 폴리모피즘
			// rmap으로 자손의 메소드는 호출이 불가하다.
			Map<String, Object> rmap = new HashMap<>();//map의 구현체 클래스 Hashmap
			rmap.put("코치명", "치타");
			rmap.put("수업유형", "A형(90분)");
			rmap.put("hp", "010-555-8888");
			boardList.add(rmap);
			req.setAttribute("boardList", boardList);
			path.append("boardList.jsp"); // 조립중이다.
			
		}
		af.setPath(path.toString());
		af.setRedirect(isRedirect);
		return af;
	}
	
}
