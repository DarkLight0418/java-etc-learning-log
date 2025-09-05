<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/test.css"/>
</head>
<body>
	<h1>
		로그인 성공!
	</h1>
	<a href="/mvcBoardPJ">인덱스로</a>
	<a class="btn actions" href="<%= request.getContextPath() %>/board.do?type=list">게시판으로</a>
</body>
</html>