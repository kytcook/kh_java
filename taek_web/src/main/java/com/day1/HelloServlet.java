package com.day1;

import java.io.IOException;
import java.io.PrintWriter;

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
//		PrintWriter out = res.getWriter();
//		out.print("<html><head>" + out);
		req.setAttribute("name", "scott");
//		res.sendRedirect("./helloResponse.jsp");
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
		
//		req.setAttribute("name","scott");
		RequestDispatcher view = req.getRequestDispatcher("helloResponse.jsp");
		view.forward(req,res); // url주소 변경없이 응답한다.-> 요청이 계속 유지되고 있다. - 톰캣이 
		
//		PrintWriter out = res.getWriter();//io 임포트
	}
// 컨트롤 계층은 맡기지만 화면 계층은 힘들다. 태그를 일일이 적어줘야 한다.		
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException{
		
	}
	
}

/* 22.07.21
 * 
 * HelloServlet.java - helloResponse.jsp - web.xml 세 개를 같이 본다.
 * 
 * 서블릿 수업
 * 서블릿이 되기 위한 필요조건에 대해 설명할 수 있다.
 * 서블릿으로 웹페이지를 출력할 수 있다.
 * web.xml문서에 대해 말 할 수 있다.
 * ★★★★sendRedirect와 forward에 대해 이해하고 코드에 활용할 수 있다.★★★★
 * 
 * 서블릿은 컨트롤계층 담당하게 한다.(Server + Applet)
 * JSP는 화면을 담당하게 한다. -> 자바를 담을 수 있다 - 오라클서버 - List, Map을 통해 뽑아낸다 - JSON을 통해 서버에 뿌린다 -<% 스크립틀릿String name="";%>
 * html은 자바를 담을 수 없다
 * 
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
 * -------------------------------------------------------------------------------------
 * 
 * 22.07.22
 * 
 * servlet-api.jar ( 서블릿 컨테이너 )
 * jsp-api.jar → JSP컨테이너( 엔진 - 내부에 클래스 정보를 가지고 있다. 확인:경로 - tomcat-lib )
 * 
 * 애플리케이션 배포
 * (압축방식 - zip방식 동일)
 * 
 * jar - 로컬 어플리케이션
 * 폴더 -> Export -> jar file -> 
 * 
 * war - 웹 어플리케이션 
 * web폴더 -> Export -> WAR file -> 웹에 배포하면 자동으로 압축이 풀리게 된다.
 * WEB-INF 까지의 트리구조는 알고 있어야 한다.
 * 배포하세요~> WAR 파일로 추출하장
 * 엔터프라이즈급 서버
 * JBOSS, WebSpear, Weblogic
 * 
 * ejb기술 
 * -> spring프레임워크 - 경량컨테이너
 * 
 * ear - 엔터프라이즈 어플리케이션( EJB - Enterprise JAVA Beans ) - 금융권 - 제 1금융, 제 2금융, 제 3금융
 * 보안 - 언마샬링
 * 금강원 감독
 * 
 * 	web.xml 기술하기
 *	데이터의 캡슐화, 축소
 *	- 배치서술자라고 한다(dd파일) 
 *	- 서블릿 클래스 등록, URL매핑 - 요청(get:링크,단위테스트, header,post:자스, body)
 *	- 톰캣서버 기동시 가장 먼저 스캔한다.
 *	- servlet-mapping>-> url-pattern -> URL주소 -> main없자나 -> 브라우저 
 *	- -> get방식(쿼리스트링으로 값을 전달 할 수 있다. 단위테스트 가능하다. 넘길 수 있는 값의 크기가 제한된다.노출된다.) / 로그인은 POST
 *	-
 *  
 * 	엑스플랫폼 (업무 뎁스가 깊은 UI, UX기반 플랫폼)
 *  
 *  부트스트랩과 자바의 만남, 부트스트랩과 html의 만남, 부트스트랩과 파베의 만남 
 *  
 * 요청객체와 응답객체를 선점하zaza!! express - get방식 post방식 / restful / 화면 페이지 전환 API는 몽땅 정리(?)
 * XXX.jsp를 만들면 -> XXX.jsp.java 로 만들어진다. -> XXX_jsp.class -> res.setContentType("text/html") -> 응답객체 반드시 있어야 한다.
 * JSP컨테이너 자바에는 있고(톰캣) html에는 없다		servlet컨테이너
 * 
 * 
 * 물리적인 경로 - 브라우저에 쓰기를 해준다. 
 * D:\java_study\workspace_java\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\ROOT\org\apache\jsp 
 *  
 * 서블릿이 되기 위한 조건 -> 반드시 HttpServlet을 상속 받기
 * 일반 자바 : 상복받는 클랙스가 Object -> HttpServlet ( http를 상속받게 되서 http서블릿이 된다)
 * doGet():void 
 * doPost():void
 * 
 * sendRedirect
 * : url이 바뀐다.
 * : 유지 안된다.
 * : get방식과 동일한 취급
 * 
 * forward
 * : url이 안바뀐다.
 * : 유지된다.
 * : view.forward(req,res)
 * 
 * req.setAttribute("key","value");
 * 저장소 역할
 * 
 * String key = (String)req.getAttribute("key");
 * 
 * response으로 할 수 있는 일
 * PrintWriter out = res.getWriter(); // 메소드의 형태로 객체 주입
 * 
 * request로 할 수 있는 일
 * 듣기
 * HttpServletRequest req
 * 
 * 내장 객체 제공
 * 서블릿에서 사용시에는 메소드 파라미터(지역) 주입 - req - NullPorinterException 발생 하지 않는다 - 톰캣서버가 주입해줌. 필요할 때 
 * String mem_id = request.getParameter("mem_id");
 * 
 *  
 * */
