<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// sendRedirect - 불가(반드시 유지해야 하는 상황 - 쿠키,세션) -
	// forward - 가능 - 출력
	String s_name = (String)request.getAttribute("s_name");
out.print("서버에서 요청객체에 담은 값 : " + s_name);// null - forward를 처리했어야 하는데 sendredirect로 처리했기때문에 요청이 처리되고 있지 않다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
</body>
</html>