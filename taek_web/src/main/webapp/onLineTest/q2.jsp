<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String test1 = request.getParameter("htest1");//이걸 쿠키에 담아보자
	out.print("1번문제 답안지 : "+test1);
	// 쿠키 생성하기 - insert here
	Cookie ctest1 = new Cookie("test1", test1);
	ctest1.setPath("/onLineTest");
	ctest1.setMaxAge(30*60);
	response.addCookie(ctest1);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function test(pcb) { // check에 대한 정보만 처리
		for(let i=0; i<document.f_test1.cb.length; i++){
			if(pcb == i)
				document.f_test1.cb[i].checked = 1;
			else
				document.f_test1.cb[i].checked = 0; //체크가 안됐다.
		}
	}
	function prev(){// 이전페이지로 갑니다.
		location.href = "q1.jsp";
	}
	function next(){// 아래 hidden이 있기 때문에 넘긴다.?
		let temp = 1;
		for(let i=0;i<document.f_test1.cb.length;i++){
			if(document.f_test1.cb[i].checked==1){
				document.f_test1.htest2.value = temp;
			}
			else {
				temp = temp + 1;
			}
		}////////end of
		document.f_test1.submit();
	}
</script>
</head>
<body>
	<form name="f_test1" method="get" action="q3.jsp">
		<input type="hidden" name="htest1" value=<%=test1 %>>
		<input type="hidden" name="htest2">
		문제2. 다음 중 DDL구문이 아닌 것을 고르시오.<br>
		<input type="checkbox" name="cb" onChange="test(0)">create<br>
		<input type="checkbox" name="cb" onChange="test(1)">drop<br>
		<input type="checkbox" name="cb" onChange="test(2)">alter<br>
		<input type="checkbox" name="cb" onChange="test(3)">delete<br>
		<br>
		<input type="button" value="이전문제" onClick="prev()">
		<input type="button" value="다음문제" onClick="next()">
	</form>
</body>
</html>