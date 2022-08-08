package com.mvc.step3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class HandlerMapping {
	static Logger logger = Logger.getLogger(HandlerMapping.class);
	// 왜 Object인가 - 2가지 모드 지원하겠다
	// String : redirectLboard2/boardList.jsp
	// forwardL board2/boardList
	// board2/boardList ->WEB-INF -> jsp -> path +".jsp
	// new ModelAndView();
	/**************
	 * 
	 * @param upmu[0]=업무폴더이름, upmu[1]= 업무기능이름 - 메소드명으로 사용하면 됨)
	 * @param req 1-2,3 에서와는 다르게 Controller인터페이스를 implements 하지 않고 있따.
	 * @param res 그렇다면 req와 res를 어디서 전달 받는 걸가??
	 * HttpsServlet을 상속받아서 톰캣서버가 제공하는 요청객체와 응답객체를 사용함.
	 * @return String/ModelAndView(유지를 위한 req.setAttribute()를 대신함
	 */
	public static Object getController(String[] upmu
										, HttpServletRequest req
										, HttpServletResponse res) {
			logger.info(upmu[0]+","+upmu[1]);
			Controller3 controller = null;
			Board3Controller boardController = null;
			NoticeController noticeController = null; // 공지사항 게시판
			Object obj = null;
			String path = null;
			ModelAndView mav = null;
			if("board3".equals(upmu[0])) {
				controller = new Board3Controller();
				if("boardList".equals(upmu[1])) {
					// 파라미터로 원본을 넘긴다
					obj = controller.boardList(req,res);
					if(obj instanceof ModelAndView) {
						return(ModelAndView)obj;
					}else if (obj instanceof String) {
						return (String)obj;
					}
				}
			}
			return obj ;
		}
	}	
