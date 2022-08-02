<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터그리드 테스트</title>
<%@ include file="../common/easyui_common.jsp"%>
</head>
<body>
	<script type="text/javascript">
	$(document).ready(function(){/* ready함수를 쓰면 절차지형의 문제를 피해감?  */
		alert("돔구성이 완료되었음."+$("#dg_board"));
		$("#dg_board").datagrid({
			title : '계층형 게시판 목록',
			columns:[[
				{field: 'b_no', title: '글번호', width:100, align:'center'},
				{field: 'b_title', title: '제목', width:200, align:'left'},
				{field: 'b_writer', title: '작성자', width:100, align:'center'},
				]],
				data: [
					{b_no:1, b_title:'게시글 제목 연습이다', b_writer:'김유신'},	
					{b_no:1, b_title:'게시글 제목 연습이다2', b_writer:'이순신'},	
					{b_no:1, b_title:'게시글 제목 연습이다3', b_writer:'임은택'},	
				]
			})
		})
</script>
	<table id="dg_board"></table>
	<!-- 앞에있던 뒤에 있던 상관이 없다(?) -->
</body>
</html>