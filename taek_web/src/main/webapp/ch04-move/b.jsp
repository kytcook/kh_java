<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>b.jsp</title>
</head>
<body>
<%
	String r_name = (String)request.getAttribute("r_name");
	// 위의 코드에서 선언이 안되어있으면, 페이지 오류(상태500)가 난다.
	// metadata에 저장된 경로 내에서도 폴더가 컴파일 되지 않는 것을 관찰 할 수 있다.
	// why? 인클루드 방식은 스크립틀릿 안의 선언문은 유지하며 넘겨주지 않는다(?)
	out.print(r_name);
	
%>
1. 이 페이지는 a.jsp페이지내에 출력됩니다.
<br>
2. 여기는 b.jsp페이지 내용 입니다.
</body>
</html>