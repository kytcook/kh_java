package com.day1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;// 서블릿 사용을 위한 상속을 받아야 한다.
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Restful API - GET, POST
public class HelloServlet extends HttpServlet {
	// 그냥 자바가 아닌 서블릿이 되기 위한 전제 조건은 반드시 HttpServlet을 상속받는다.
	// 그냥 자바는 요청객체와 응답객체를 주입받을 수 없다.
	// 왜 서블릿 이어야 하나?
	// 자바로 어떻게 웹 서비스를 제공 하지?
	// 어노테이션(spring boot 어노테이션 주입, 설정)
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		System.out.println("doGet호출 성공");
//		res.setContentType("text/html;charset=UTF-8");// html양식을 받기 위해서
//		res.setContentType("./helloResponse.jsp");
//		out.print("<html>");
//		out.print("<head>");
//		out.print("<titel>서블릿 연습</title>");
//		out.print("</head>");
//		out.print("<body>");
//		out.print("<p>Hello Servlet!!</p>");
//		out.print("</body>");
//		out.print("</html>");
		
		
//		res.sendRedirect("./helloResponse.jsp");// 요청이 끊어졌기 때문에
//		
		req.setAttribute("name","scott");
		RequestDispatcher view = req.getRequestDispatcher("helloResponse.jsp");
		view.forward(req,res); // url주소 변경없이 응답한다.
		
//		PrintWriter out = res.getWriter();//io 임포트
	}
// 컨트롤 계층은 맡기지만 화면 계층은 힘들다. 태그를 일일이 적어줘야 한다.		
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException{
		
	}
	
}

/*
 * HelloServlet.java - helloResponse.jsp - web.xml 세 개를 같이 본다.
 * 
 * 서블릿 수업
 * 서블릿이 되기 위한 필요조건에 대해 설명할 수 있다.
 * 서블릿으로 웹페이지를 출력할 수 있다.
 * web.xml문서에 대해 말 할 수 있다.
 * ★★★★sendRedirect와 forward에 대해 이해하고 코드에 활용할 수 있다.★★★★
 * 
 * 
 * 톰캣 서버를 기동한다.
 * 프로젝트에서 web.xml문서(dd파일 - deployment descriptor : 배치서술자) 를 가장 먼저 로딩한다.
 * 배치서술자 : 데이터보다 앞뒤에 붙는 태그가 너무 많다. 
 * xml = nodejs, react : json의 역할
 * xml은 화면을 그리지 않는다.
 * xml은 데이터베이스의 역할을 할 수는 있지만, 비효율적이다.
 * 요청 URL과 서블릿 클래스의 매핑(배치서술자 - web.wml문서에서 매핑작업을 한다)
 * 사용자 입장에서는 브라우저에서 http://192.168.40.9:8000/day1/hello.do
 * 위와 같이 주소창에 요청하는 것은 GET방식이다. POST방식은 테스트 할 수 없다.
 * 나는 doGet메소드를 호출한 적이 없는데 어떻게 페이지가 출력되었을까?
 * web.xml의 <url-pattern>/day1/hello.do</url-pattern>
 * 
 * 문제제기
 * print메소드를 통해서 html태그를 작성하는건 많이 비효율적이다.
 * 그래서 JSP를 사용한다. - view계층
 * 서블릿은 컨트롤 계층을 맡기자 - 실제로 업무를 처리하는 클래스는 아니다.
 * 사용자가 입력한 값을 듣고 백엔드(자바, 오라클)에 전달
 * 어떤 응답 페이지로 출력이 나가야 되는지를 결정해 준다.
 * 
 * 화면을 직접 그리지 않는데 어떻게 출력페이지로 이동을 시킨다는 걸까?
 * 
 * get방식이고 주소창이 바뀐다. -> 현재 요청이 끊어지고 새로운 요청이 일어남.
 * http 비상태 프로토콜이다.
 * 
 * 
 * ★★★★jsp에서 페이지 이동하는 방법 2가지★★★★★
 * res.sendRedirect("XXX.jsp"); 응답 객체를 통해 페이지를 이동시킬 수 있다. 주소창이 바뀐다.
 * 기본의 요청이 끊어지고 새로운 요청이 일어났다.
 * 
 * RequestDispatcher view = req.getRequestDispatcher("XXX.jsp");
 * view.forward(req,res);// 주소창이 안바뀐다 -> 요청이 계속 유지되고 있다. - 톰캣
 * 
 * 
 * */
