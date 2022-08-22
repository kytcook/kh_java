<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	
	/* 
	 String s_name = (String)session.getAttribute("s_name");
	 Integer s_age = (Integer)session.getAttribute("s_age");
	 out.print("세션에 담긴 값 들"+s_name+", "+s_age);
	*/
%>	
<table border="1" borderColor="gray" width="100%" height="100%">
	<tr>
		<td align="left" valign="top">
			<table>
				<tr>
					<td><a href="index.jsp?menu=intro">인트로</a></td>
				</tr>
				<tr>
					<td><a href="index.jsp?menu=notice">공지사항</a></td>
				</tr>
				<tr>
					<td><a href="index.jsp?menu=qna">Q&A게시판</a></td>
				</tr>
			</table>
		</td>
	</tr>
</table>