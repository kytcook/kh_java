<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("message");
	out.print("request.getContextPath():"+request.getContextPath());
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center"><%= msg %></h1>
	<div align="center">
		<button onclick="history.back()">이전페이지</button>
		<button onclick="location.href='/kh_exam/index.jsp">홈으로 돌아가기</button>
	</div>
</body>
</html>