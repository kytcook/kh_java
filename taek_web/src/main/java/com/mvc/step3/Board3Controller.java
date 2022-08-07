package com.mvc.step3;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

// 컨트롤 계층을 담당하는 클래스는 서블릿이 아니어도 괜찮아
// 혼자서는 아무것도 완성할 수 없는 나 - 전체적인 틀, 와꾸, 패턴, 기준
// Board3Controller는 Controller3 인터페이스의 구현체 클래스 이다.(메소드를 누릴 수 있다)
// 서블릿은 아니지만 req와 res는 필요해
// 형 어디서 가져와야 하죠?? => 
// ActionSupport에서 주입 받고, HandlerMapping 클래스의 메소드 호출할 때
// 파라미터를 통해서 가져올 수 있다. - 원본
public class Board3Controller implements Controller3 {
	Logger logger = Logger.getLogger(Board3Controller.class);
	Board3Logic boardLogic = new Board3Logic();
	@Override
	public ModelAndView boardList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("boardList 호출 성공");
		// ModelAndView객체를 설계함에 따라서 req가 없어도 조회결과를 담을 수 있게 되었다.-의미
		ModelAndView mav = new ModelAndView(req);
		List<Map<String, Object>> boardList = null;
		boardList = boardLogic.boardList();
		mav.addObject("boardList", boardList);
		mav.setViewName("board3/boardList");
		return mav;
	}

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res, Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

}
