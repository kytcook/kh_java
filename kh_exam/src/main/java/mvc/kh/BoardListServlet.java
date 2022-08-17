package mvc.kh;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.vo.Board;

public class BoardListServlet extends HttpServlet {
	Logger logger = Logger.getLogger(BoardListServlet.class);
	JDBCTemplate jt = JDBCTemplate.getInstance();
	Connection conn = null;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		logger.info("doGet 호출 성공");
		conn = jt.getConnect();// 커넥션 얻어옴
		// 아래에서 선언만 함
		List<Board> boardList = null;
		logger.info("boardList의 주소번지가 찍힐까? : " + boardList);//#1
		BoardDao boardDao = new BoardDao();
		// 31번에서 BoardDao의 selectBoard(conn)메소드의 리턴값으로 받음
		boardList = boardDao.selectBoard(conn);
		logger.info("boardList의 주소번지가 찍힐까? : " + boardList);//#2
		// 위치의 문제 - 뭐가 다른 거임?????
		// 32번에서 인스턴스화 한 후 아래에서 다시 인스턴스화 됨.
		// 결과적으로 31번에서 생성된 객체가 아니라 아래에서 다시 생성됨 -  타입은 같지만 주번이 다르다.
		boardList = new ArrayList<>();
		logger.info("boardList의 주소번지가 찍힐까? : " + boardList + "," + boardList.size());//#3
		req.setAttribute("boardList", boardList);
		RequestDispatcher view = req.getRequestDispatcher("/board/boardList.jsp");
		view.forward(req, res);		
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		logger.info("doPost 호출 성공");

	}	
}
