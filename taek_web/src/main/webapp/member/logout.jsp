<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//세션에 담긴 모든 정보가 다 삭제됨.
	session.invalidate();
	// 세션에 담긴 정보중 특정한 정보만 삭제하려면
	// sesstion.removeAttribute("이름");// 이름에 대응하는 값만 삭제가능함.
	response.sendRedirect("./loginForm.jsp");// 싹 다 지워졌는데 둘 중에 어디로 갈까요??
%>
