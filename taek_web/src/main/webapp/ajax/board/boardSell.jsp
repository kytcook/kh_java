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
				const boardSold = $("#boardSold")}.text(result);
				//const cost = document.getElementById("cost");
				const costEl; = ${"#cost"}; // jquery : 위의 코드와 같다.
				const costValue = getText(costEl); // 입력한 텍스트를 구매가에 저장한다.
				alert("구매가 가져오기 : "+costValue); // 구매가
				const price = $"#price".text();
				const cashPerBoead = price - cost;
				alert("구매가 가져오기 : " + cost)
				alert("보드 당 마진금액 : "+ cashPerBoard);
				$("#cash").text(cashPerBoard*result);
			}
		})
	}
	// 2번째 파라미터로 받은 무낮열을 첫번째 파라미터 받은 위치에 붙여준다.
	function replaceText(el,text){
		if(el !=null){
			//기존의 노드에 들어있는 값은 초기화 시킨다.
			clearText(el);
			var newNode = document.createTextNode(text);
			el.appendChild(newNode);
		}
	}//replaceText ended
	​
	function clearText(el){//element도 태그로 생각해 일단은
		if(el !=null){
			if(el.childNodes){// 자바 스크립트에서는 0이 아니면 모두 true
			//replaceText(boardsSoldEl, newTotal);
				for(var i=0;i<el.childNodes.length;i++){
					var childNode = el.childNodes[i];
					el.removeChild(childNode);// el태그의 자식요소를 지워주세요~ 보드판매량의 10을 지울 때 사용할 수 있겠다.~
				}//for ended
			}//if ended
		}//if ended 노드가 널이 아니면
	}//clearText ended 지워줭
	​
	//childNodes는 지정된 개체의 직접적인 자식개체인  HTML elements와
	//TextNode개체들의 컬렉션을 반환한다.
	function getText(el){
		alert("getText 호출 성공"); 
		let text = "";
		if(el !=null){
			if(el.childNodes){
				for(let i=0;i<el.childNodes.length;i++){
					let childNode = el.childNodes[i];
					//너 텍스트 노드니?
					if(childNode.nodeValue !=null){
						text = text + childNode.nodeValue;
					}
				}//같은 노드가 n개 있을 때를 위해
			}//
		}//자식 노드가 존재하니?
		return text;// 반환값이 없으면 undefined 반환된다.
	}//getText ended
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
</html>