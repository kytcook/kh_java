<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹 서버에서 쿠키 생성하기</title>
</head>
<body>
<%
	Cookie cook1 = new Cookie("notebook","갤럭시9");
	cook1.setMaxAge(60); // 1분
	// 생성자는 메소드 오버로딩
	// Cookie cook2 = new Cookie("age",30);// 쿠키는 상수가 안되네???
	// Cookie cook2 = new Cookie("age",new Integer(30));
	Cookie cook2 = new Cookie("age",String.valueOf(30));
	List<String> names = new ArrayList<>();
	// cook2 = new Cookie("names", names);
	session.setAttribute("s_age", 30);// 세션은 상수가 가능
	session.setAttribute("s_names", names);
	cook2.setMaxAge(60); // 1분
	cook2.setPath("/");
	Cookie cook3 = new Cookie("coffee","콜드블루");
	cook3.setMaxAge(60); // 1분
	response.addCookie(cook1);
	response.addCookie(cook2);
	response.addCookie(cook3);
%>
</body>
</html>