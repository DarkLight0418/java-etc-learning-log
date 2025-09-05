<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/form.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/test.css"/>
</head>
<body>
	<h1>로그인 테스트</h1>
	<form method="post" action="auth.do?t=check">
		ID : <input type="text" name="id" placeholder="id">
		<br>
		PW : <input type="password" name="pwd" placeholder="pwd">
		<br>
		<input type="submit" value="login">
	</form>
	
	<a class="btn actions" href="<%= request.getContextPath() %>/board.do?type=list">게시판으로</a>
</body>
</html>