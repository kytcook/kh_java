package com.mvc.step3;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;
// 인터페이스에 대한 구현체 클래스이면 구현을 강제받기 때문에, 내가 쓰지도 않은 애들이 잔뜩 나온다.
// 메소드가 좌중괄호와 우중괄호로 묶여 있는것 만으로도 구현한것과 동일하다.
public class AuthController implements Controller3 {
	Logger logger = Logger.getLogger(AuthController.class);
	AuthLogic authLogic = new AuthLogic();
	@Override
	public Object login(HttpServletRequest req, HttpServletResponse res) {
		logger.info("login 호출 성공");
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		String s_name = null;
		Cookie c = new Cookie("c_name", s_name);
		c.setPath("/");
		c.setMaxAge(60*3);
		s_name = authLogic.login(pMap);
		res.addCookie(c);
		String path = "redirect:index.jsp";
		return path;
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

	@Override
	public Object boardList(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object boardDetail(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object boardInsert(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object boardUpdate(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object boardDelete(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}


}
