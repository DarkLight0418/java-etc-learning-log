<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>
		로그인 실패...
	</h1>
	<a href="/mvcBoardPJ">인덱스로</a><br>
	<a href="/mvcBoardPJ/board.do?type=login">로그인으로</a>
	<a href="<%= request.getContextPath() %>/board.do?type=list">게시판으로</a>
</body>
</html>