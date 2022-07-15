<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!-- jsp를 썼지만 실제로 이 페이지가 처리되는 주체는 HTML  -->
<!--
	jsp : java server page
	처리주체가 서버(WAS:Web Application Server) 이다. Was는 톱캣 9.0 사용하였다.
	동적페이지 처리가 가능하다. : Back-End Developer
	html, css, js는 정적페이지 처리 가능하다. - Front-End Developer
	VS-CODE에서 사용하던 live server는 사용이 불가한가요?? 네에~
	왜냐하면 이 서버에는 jsp엔진이 없다. 
-->
<%
	String name = "scott";
	out.print(name); //scott출력
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script defer src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<style>
	body {
		text-align : center
	} 
	table {
		margin-left : auto;
		margin-right: auto;
		border: thin dotted gray;
	}
	th, td {
		border: thin dotted gray;
	}
	th {
		background-color: #FFAAAA;
	}
</style>
<script>/* 통계를 내서 -뭔가- 보여준다 */
	function getBoardSold(){
		$.ajax({
			method:"get",
			url : "./boardSellAction.jsp?"+new Date().getTime(),
			success:function(result){
				console.log("result:" + result);
			}
		})
	}
</script type="text/css">
</head>
<body>
	<table width="300px" height="80px">
	    <tr>
	        <td align="center" colspan="2">보드판매집계</td>
	    </tr>
	    <tr>
	        <th width="120px">보드판매량</th>
	        <!-- 텍스트노드는 태그이름은 없고 태그값만 있다. -->
	        <td width="180px"><span id="boardSold">10</span></td>
	    </tr>
	    <tr>
	        <th width="120px">구매가</th>
	        <td width="180px"><span id="cost">700000</span></td>
	    </tr>
	    <tr>
	        <th width="120px">소비자가</th>
	        <td width="180px"><span id="price">850000</span></td>
	    </tr>        
	</table>
	<h2>마진금액 : <span id="cash">1500000</span></h2>
	<button onclick="getBoardSold()">마진금액은?</button>	
</body>