package mvc.kh;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class NoticeSelectServlet extends HttpServlet {
	Logger logger = Logger.getLogger(NoticeSelectServlet.class);
	NoticeService noticeService = new NoticeService();
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		logger.info("doGet 호출 성공");
		ArrayList<Notice> list = new NoticeService().selectList();
		req.setAttribute("list", list);
		String page = null;
		if(list !=null) {
			page = "/WEB-INF/views/notice/noticeList.jsp";
		}else {
			page = "/WEB-INF/views/common/errorPage.jsp";
			
		}
		// 별로인 것은 NullPointerException 방어코드를 작성할 수 없기 때문에...
		// req.getRequestDispatcher(page).forward(req, res);
		// ↓ 코드의 양은 두 줄로 늘어났지만 복잡도는 증가하지 않게 코딩한다 - 리팩토링
		RequestDispatcher view = req.getRequestDispatcher(page);
		view.forward(req, res);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		logger.info("doPost 호출 성공");

	}	
}
