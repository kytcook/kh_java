<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제 1</title>
<script type="text/javascript">// script의 기능을 -> q2에 그대로 가져간다. include로 대체할 수도 있다.
/*  
	•브라우저 DOM트리 구성할 때 하나이면 그 이름이 그대로 적용되지만, 같은 이름이 여러개이면 자동으로 배열전환처리(브라우저)
	•페이지 이동하는 연관된 코드들
		location.href, /JS
		form태그(action) 사용
		response.sendRedirect("a.jsp") /JSP
		view.forward(request, response) /JSP
		ajax({
			url:"XXX.jsp" or XXX.pj // pj로 요청이 들어오면 ActionSupport가
		})
*/
	function test(pcb) { // check에 대한 정보만 처리
		console.log(pcb);//pcb는 checkbox에 대한 index값이다. 그래서 0부터
		for(let i=0; i<document.f_test1.cb.length; i++){
			if(pcb == i)
				document.f_test1.cb[i].checked = 1;
			else
				document.f_test1.cb[i].checked = 0; //체크가 안됐다.
		}
	}
// 다음문제로 이동하기 - URL이 바뀐다 - 기존에 요청이 끊어진다. - 유지(세션과 쿠키)
	function next(){// 아래 hidden이 있기 때문에 넘긴다.?
		// 사용자가 선택한 답안정보를 기억
		// 현재 페이지에 대한 사용자의 선택을 전송하기
		console.log();
		let temp = 1;
		for(let i=0;i<document.f_test1.cb.length;i++){
			if(document.f_test1.cb[i].checked==1){
				document.f_test1.htest1.value = temp;
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
	<form name="f_test1" method="get" action="q2.jsp">
		<input type="hidden" name="htest1"><!-- hidden은 뭐지..?  -->
		문제1. 다음 중 DML구문이 아닌 것을 고르시오.<br>
		<input type="checkbox" name="cb" onChange="test(0)">select<br>
		<input type="checkbox" name="cb" onChange="test(1)">insert<br>
		<input type="checkbox" name="cb" onChange="test(2)">create<br>
		<input type="checkbox" name="cb" onChange="test(3)">delete<br>
		<br>
		<input type="button" value="다음문제" onClick="next()">
	</form>
</body>
</html>
<!-- 
	어떤 페이지에서 쿠키를 생성해야 되는 걸까요??
	우리는 왜 매번 쿠키를 생성해야 되는 걸까요???
	싱글페이지 어플리케이션 일때와 그렇지 않을때 차이가 있다|없다.?
	
	POJO 프레임워크 구현 - Spring 부트로 이관하기 - 공부하자.
 -->