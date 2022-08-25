<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String test5 = request.getParameter("htest5");//이걸 쿠키에 담아보자
	out.print("5번문제 답안지 : "+test5);
	// 쿠키 생성하기 - insert here
	Cookie ctest5 = new Cookie("test", test5);
	ctest5.setPath("/onLineTest");
	ctest5.setMaxAge(30*60);
	response.addCookie(ctest5);
	// 5번 답안지 생성 후 판정 페이지로 이동하기
	// 한 문제당 배점을 담을 변수
	int perJumsu = 20;
	// 맞힌 개수
	int cnt = 0;
	// 판정 결과
	boolean isPass = false;
	// 합격 점수
	int pass = 60;
	String daps[] = {"3","4","1","2","4"};
	String tests[] = new String[5];
	Cookie[] cs = request.getCookies();
	if(cs !=null && cs.length > 0) {
		for(int i=0; i<cs.length; i++) {
			String c_name = cs[i].getName();
			if("test1".equals(c_name)){
				tests[0] = cs[0].getValue();
			}
			else if("test2".equals(c_name)){
				tests[1] = cs[1].getValue();
			}
			else if("test3".equals(c_name)){
				tests[2] = cs[2].getValue();
			}
			else if("test4".equals(c_name)){
				tests[3] = cs[3].getValue();
			}
			else if("test5".equals(c_name)){
				tests[4] = cs[4].getValue();
			}
		}
	}
	for(int i=0; i<daps.length; i++) {
		for(int j=0; j<daps.length; j++) {
			if(daps[i].equals(tests[j])){
				if(i==j) {
					cnt++;
				}
			}
		}
	}
	if(pass<=perJumsu*cnt){// 60보다 크거나 같니??
		isPass = true;
	}
	else{
		isPass = false;
	}
	// out도 내장객체이다. request, response처럼
	// 자바땅이다.
	// out.print("");
	// 무조건 페이지가 이동한다 - 이전페이지와는 연결이 끊어진다.
	// 아래 코드가 있는 상태에서는 score.jsp 페이지는 눈으로 볼 수가 없다. 하지만 거쳐간다. 계산된 결과를 다른 페이지로 보내준다.
	response.sendRedirect("account.jsp?isPass="+isPass); //insert-here 당신은 합격입니다. 불합격입니다 처리하기
%>
<!-- 여기는 html땅이다. -->
맞힌 개수 : <%=cnt%><!-- 익스프레션-출력 : 서버사이드에서 먼저 실행이 되고, 계산된 값이 화면으로 출력되는 것이다. 실행 순서는 얘네가 먼저  -->
<br>
당신의 점수는 <%=perJumsu*cnt%> 입니다.