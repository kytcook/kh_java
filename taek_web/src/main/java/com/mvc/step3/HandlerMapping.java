package com.mvc.step3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
// BeanNameUrlHandlerMapping
// SimpleUrlHandlerMapping
public class HandlerMapping {
   static Logger logger = Logger.getLogger(HandlerMapping.class);

//   왜 Object를 리턴값으로 했냐면! ----> '두가지 모드를 지원할게'라는 뜻.
//   String: redirect:board2/boardList.jsp
//            forward:board2/boardList
//                    board2/boardList -> WEB-INF/jsp/path+".jsp"
//   new ModelAndView();
	/***************************************************************
	 * 
	 * @param upmu(upmu[0]=업무폴더이름, upmu[1]=업무기능이름- 메소드명으로 사용하면 됨)
	 * @param req 1-2,3에서와는 다르게 Controller인터페이스를 implements하지 않고 있다.
	 * @param res 그렇다면 req,res를 어디서 전달 받는 걸까?
	 *  HttpServlet을 상속받아서 톰캣서버가 제공하는 요청객체와 응답객체를 사용함
	 * @return String/ModelAndView(유지를 위한 req.setAttribute()를 대신)
	 **************************************************************/
	public static Object getController(String[] upmu
			                         , HttpServletRequest req
			                         , HttpServletResponse res) {
		logger.info(upmu[0]+", "+upmu[1]);
		Controller3 controller = null;// 인터페이스이다.
		Board3Controller boardController = null;
		NoticeController noticeController = null;//공지사항 게시판
		Object obj = null;
		String path  = null;
		ModelAndView mav = null;
		if("board3".equals(upmu[0])) {//배열의 첫방에 업무폴더이름
			controller = new Board3Controller();
			// 게시판 글쓰기 메소드 호출
			// if문 사용하여 메소드이름을 결정지었다.
			// 코드의 양은 늘었다.왜 if문이 늘어가니까
			// 복잡도도 늘었나???
			if("boardDelete".equals(upmu[1])) {
				// 파리미터로 원본을 넘긴다
				obj = controller.boardDelete(req,res);
				if(obj instanceof String) {
					return (String)obj;
				}
			}
			else if("boardUpdate".equals(upmu[1])) {
				// 파리미터로 원본을 넘긴다
				obj = controller.boardUpdate(req,res);
				if(obj instanceof String) {
					return (String)obj;
				}
			}
			else if("boardInsert".equals(upmu[1])) {
				// 파리미터로 원본을 넘긴다
				obj = controller.boardInsert(req,res);
				if(obj instanceof String) {
					return (String)obj;
				}
			}
			//게시판 글목록 메소드 호출
			else if("boardList".equals(upmu[1])) {
				// 파리미터로 원본을 넘긴다
				obj = controller.boardList(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				}else if(obj instanceof String) {
					return (String)obj;
				}
			}
			else if("boardDetail".equals(upmu[1])) {
				// 파리미터로 원본을 넘긴다
				obj = controller.boardDetail(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				}else if(obj instanceof String) {
					return (String)obj;
				}
			}
		}
		else if("member".equals(upmu[0])) {
			controller = new MemberController();
			if("memberList".equals(upmu[1])) {
				obj = controller.memberList(req, res);
				if(obj instanceof String) {//  void doGet(req,res)-> ActionForward doService(req,res) -> String  메소드이름
					return (String)obj;
				}
			}
		}
		else if("auth".equals(upmu[0])) {//배열의 첫방에 업무폴더이름) {
			// 인스턴스화 -> 스프링에서는 이렇게 하지 않음 - 이 문장을 작성하지 않아야 한다.
			// 문제제기 -> NullPointerException이 발생하잖아 -> 스프링이 대신 할께 -> 의존성 주입(DI)
			// 외부(스프링)에서 필요할 때 주입[객체를 메모리에 로딩] 해줌(게으른 주입, 게으른 인스턴스화)
			// 스프링이 어떤 클래스인지는 어떻게 아는 걸까요? - xml문서에 미리 등록해둠.
			// setter객체 주입법과 생성자 객체 주입법
			controller = new AuthController();
			if("login".equals(upmu[1])) {
				// 파리미터로 원본을 넘긴다
				obj = controller.login(req,res);
				if(obj instanceof String) {
					return (String)obj;
				}
			}
		}
		else if("intro".equals(upmu[0])) {//배열의 첫방에 업무폴더이름) {
			controller = new AuthController();
			if("clogin".equals(upmu[1])) {
				// 파리미터로 원본을 넘긴다
				obj = controller.clogin(req,res);
				if(obj instanceof String) {
					return (String)obj;
				}
			}
		}
		else if("emp".equals(upmu[0])) {//배열의 첫방에 업무폴더이름) {
			controller = new EmpController();
			if("doEmp".equals(upmu[1])) {
				// 파리미터로 원본을 넘긴다
				obj = controller.doEmp(req,res);
				if(obj instanceof String) {
					return (String)obj;
				}
			}
		}
		return obj;
	}////////////end of getController
}
