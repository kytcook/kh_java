package com.mvc.step2;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

// 반드시 ActionServlet 을 경유한 뒤 Board2Controller가 실행되어야 함
// 왜냐하면 Board2Controller가 서블릿이 아니니까
public class Board2Controller implements Controller {
	Logger logger = Logger.getLogger(Board2Controller.class);
	Board2Logic boardLogic = new Board2Logic();
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		logger.info("execute 호출 성공");
		String upmu[] = (String[]) req.getAttribute("upmu");
		// null로 두는 것이 맞지만 웹서비스에서 NullPointerException 발생시, 어떠한 화면도 확인이 불가하고
		// 힌트도 볼수 없기에 ""로 처리한다.
		String page = ""; 
		// upmu[0] => 업무이름, upmu[1] => 업무기능이름 -> 1-4(메소드이름 매칭)
		logger.info(upmu[0]+","+upmu[1]);
		if("boardList".equals(upmu[1])) {
			List<Map<String, Object>> boardList = null;
			boardList = boardLogic.boardList();
			// 오라클 서버에서 조회된 결과가 화면에 출력이 나가야 함
			// 유지의 문제 - (로그인 세션유지)
   	 	 // page = "board2/boardList";
			page = "forward:board2/boardList";
		} else if("jsonBoardList".equals(upmu[1])) {
			List<Map<String, Object>> boardList = null;
			boardList = boardLogic.boardList();
			req.setAttribute("boardList", boardList);
			// 오라클 서버에서 조회된 결과가 화면에 출력이 나가야 함
			// 유지의 문제 - (로그인 세션유지)
   	 	 // page = "board2/boardList";
			page = "forward:board2/jsonBoardList";
		} else if ("boardInsert".equals(upmu[1])) {
			page = "";
		}
		
		return page;
	}
	
}
