<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String menu = request.getParameter("menu");//[컨텐츠화면출력]<td></td>사이에 if문으로 끼워넣는다.
	String c_name = null;
	Cookie[] cooks = request.getCookies();
	if(cooks != null && cooks.length!=0) {
			for(int i=0; i<cooks.length; i++){
				if("c_name".equals(cooks[i].getName())){
					c_name = cooks[i].getValue();
				}
			}
		}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TerrGYM Project</title>
<script type="text/javascript">
	function login() {
		alret("login호출 성공");
		// 사용자가 입력한 아이디와 비번을 넘긴다. - 전송
		document.getElementById("f_login").sumit();
	}
	function logout() {
		location.href="clogout.jsp"
	}
</script>
</head>
<body>
<table align="center" width="1200px" height="550px">
	<tr>
		<td colspan="2" width="1200px" height="100px">
		<%@ include file="top.jsp" %>
		</td>
	</tr>
	<tr>
	<!-- =================[[ 컨텐츠 화면 출력 ]]====================== -->
		<td align="center" width="1000px" height="400px">
<%
	if(menu == null) {// 만약 menu가 비어있으면
%>
		<%@ include file="main.jsp" %><!-- main을 가져온다  -->
<%
	}else if("intro".equals(menu)) {// 아니면 intro가 menu와 같으면
%>		
		<%@ include file="intro.jsp" %>
<%
	}else if("notice".equals(menu)) {
%>
		<%@ include file="notice.jsp" %>
<%
	}else if("qna".equals(menu)) {
%>
		<%@ include file="qna.jsp" %>
<%
	}
%>
		</td>
	<!-- =================[[ 컨텐츠 화면 출력 ]]====================== -->
	<!-- =================[[  메뉴 화면 출력  ]]====================== -->
		<td align="center" width="200px"  height="400px">
		<%@ include file="menu.jsp" %>
		</td>
	<!-- =================[[  메뉴 화면 출력  ]]====================== -->
	</tr>
	<tr>
		<td colspan="2" width="1200px" height="50px">
		<%@ include file="bottom.jsp" %>
		</td>
	</tr>
</table>
</body>
</html>