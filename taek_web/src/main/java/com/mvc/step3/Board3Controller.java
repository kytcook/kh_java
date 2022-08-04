package com.mvc.step3;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

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
