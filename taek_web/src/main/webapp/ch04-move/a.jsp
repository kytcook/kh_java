<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
//디클러레이션
	//다른 파일을 경유할 때, 우리가 작성한 클래스 이름과 다르다. 인스턴스화 할 수 없다. ※명명규칙 :
	int age = 10; // 전역변수 선언 - 쓸 일이 없다. 
	public String getName() {
		return "강감찬";
	}
	// 메소드 선언은 가능하지만, 쓰지는 않는다.
	// jsp역할은 화면이다.
	/* MVC패턴 - 쪼갠다. 관심사 분리(화면은 너가 해줘. 나는 로직을 구현할께[입력관심사, 출력관심사, 처리관심사]) 결합도를 낮출 수 있다.
		 a.jsp -> (jsp.api)컨테이너,엔진이 처리해준다 ->a.jsp.java(서블릿) 서블릿으로 바뀐다. 
			-> a_jsp.class(다시 컴파일을 진행하면서 문제가 생김:명명규칙)
		 		※ 명명규칙 : 서버는 톰캣 외에도 여러가지가 있다. 그때마다 이름이 바뀜. -> 
	 				브라우저 쓰기 document.write("<b>굵은글씨</b>") 더블쿼테이션에 플러스 쓰고 등등등 -> 매번 이렇게 하기가 너무 힘들엉 헤어져요
	 				컨벤션,약속,표준이 꼭 필요하다아아아아아앙아앙앙아앙아앙아앙앙아아아앙앙아앙아ㅏ아아ㅏ아ㅏ앙!
	*/ 
%>
<%
	String name = "이순신";
	request.setAttribute("r_name", name);
	//public String getName() {return "강감찬";}// 스크립틀릿 안에는 함수를 사용하면 안된다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
1. a.jsp를 요청합니다.
<br>
2. a.jsp페이지 내용이 출력 됩니다.
<br>
<hr>
<jsp:include page="b.jsp" flush="false"/>
<hr>
3. b.jsp를 경유한 후 출력 부분입니다.
</body>
</html>