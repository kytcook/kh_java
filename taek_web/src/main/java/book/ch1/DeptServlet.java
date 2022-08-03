package book.ch1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class DeptServlet extends HttpServlet {
	Logger logger = Logger.getLogger(DeptServlet.class);
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		// 페이지 이동이 일어나면 해당 부분이 경유되었다는 확인을 할 수가 없다.
		// 눈에 보이지 않는 코드가 된다. - 페이지 이동시 로그가 남지 않는다.
		// 그래서 불편하다.
		// 이 페이지를 경유했다는 흔적을 남기기 위해서 logger.info를 통해 기록을 남긴다.
		logger.info("doGet 호출 성공"); 
		String s_name = "이순신";
		req.setAttribute("s_name", s_name);
		res.sendRedirect("./deptList.jsp");
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		logger.info("doPost 호출 성공");
	}
}