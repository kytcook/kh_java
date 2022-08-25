<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String test4 = request.getParameter("htest4");//이걸 쿠키에 담아보자
	out.print("4번문제 답안지 : "+test4);
	// 쿠키 생성하기 - insert here
	Cookie ctest4 = new Cookie("test4", test4);
	ctest4.setPath("/onLineTest");
	ctest4.setMaxAge(30*60);
	response.addCookie(ctest4);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제5</title>
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
		location.href = "q4.jsp";
	}
	function next(){// 아래 hidden이 있기 때문에 넘긴다.?
		let temp = 1;
		for(let i=0;i<document.f_test1.cb.length;i++){
			if(document.f_test1.cb[i].checked==1){
				document.f_test1.htest5.value = temp;
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
	<form name="f_test1" method="get" action="score.jsp">
		<input type="hidden" name="htest5">
		문제5. 다음 중 프로시저에 대한 설명으로 틀린 것을 고르시오.<br>
		<input type="checkbox" name="cb" onChange="test(0)">
		프로시저를 생성할 때 파라미터를 선언할 수 있다.<br>
		<input type="checkbox" name="cb" onChange="test(1)">
		파라미터에 여러 변수를 선언할 수 있다.<br>
		<input type="checkbox" name="cb" onChange="test(2)">
		프로시저안에서 SELECT,INSERT,UPDATE, DELETE 모두 사용 할 수 있다.<br>
		<input type="checkbox" name="cb" onChange="test(3)">
		프로시저 안에서 commit할 수 없다.
		<br>
		<br>
		<input type="button" value="이전문제" onClick="prev()">
		<input type="button" value="다음문제" onClick="next()">
	</form>	
</body>
</html>