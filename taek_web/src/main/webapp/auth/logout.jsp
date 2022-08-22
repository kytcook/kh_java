<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	
	/* 
		세션이 보안상 유리하다. 
	*/
	session.invalidate();
	response.sendRedirect("./index.jsp");
%>