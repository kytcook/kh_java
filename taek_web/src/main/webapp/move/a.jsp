<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a.jsp</title>
</head>
<body>
여기는 a.jsp페이지 입니다.
<%// jsp문법은 처리주체가 
	request.setAttribute("age", 30);
%>
1. 시작입니다.
<%@include file="b.jsp"%>
2. 마지막입니다.
</body>
</html>