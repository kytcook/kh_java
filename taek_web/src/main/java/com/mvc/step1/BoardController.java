package com.mvc.step1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class BoardController implements Action {
	Logger logger = Logger.getLogger(BoardController.class);
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward af = new ActionForward(); // ActionForward받아서 리턴해서 sendRidirect나 forward를 하겠다.
		String command = req.getParameter("gubun"); // MVC패턴
		StringBuilder path = new StringBuilder();// 이 스타일은 pojo이지만 스프링을 흉내내고 있다.
		path.append("/board-step1/");
		logger.info("command ===> " + command);
		boolean isRedirect = false;// true - sendRedirect false : forward : 유지-select // select면 몰라도 forward다
		// select면 몰라도 forward다 select면 몰라도 forward다 select면 몰라도 forward다 select면 몰라도 forward다 select면 몰라도 forward다 
		// select면 몰라도 forward다 select면 몰라도 forward다 select면 몰라도 forward다 select면 몰라도 forward다 select면 몰라도 forward다 
		// select면 몰라도 forward다 select면 몰라도 forward다 select면 몰라도 forward다 select면 몰라도 forward다 select면 몰라도 forward다 
		// select이면 유지이다. forward / sendRedirect XXXXXX 절대 쓰지 않는다
		// select 에는 조회결과가 있고 커서가 움직이니까 -> 맵에 상주하고 -> 맵에 상주하는 정보를 리스트에 담는거고 -> html에 뿌려준다. : forward
		// 글쓰기
		// 메소드 하나에서 4가지 경우를 따져야 한다.
		// forward 
		if("insert".equals(command)) {
			
		}
		// 글수정
		else if("update".equals(command)) {
			
		}
		// 글삭제
		else if("delete".equals(command)) {
			
		}
		// 글조회
		else if("select".equals(command)) {
			java.util.List<Map<String,Object>> boardList = new ArrayList<>();
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
