<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<h1>로그인 테스트</h1>
	<form method="post" action="board.do?type=check">
		ID : <input type="text" name="id" placeholder="id">
		<br>
		PW : <input type="password" name="pwd" placeholder="pwd">
		<br>
		<input type="submit" value="login">
	</form>
	
	<a href="<%= request.getContextPath() %>/board.do?type=list">게시판으로</a>
</body>
</html>