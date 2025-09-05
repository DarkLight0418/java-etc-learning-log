<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/test.css"/>
</head>
<body>
	<h2>회원가입</h2>
	<c:if test="${not empty registerError}">
		<div>이미 존재하는 이메일입니다.</div>
	</c:if>
	
	<form class="register" method="post" action="${pageContext.request.contextPath}/auth.do?t=register">
		이메일: <input type="email" name="email" required><br/>
  		이름(표시용): <input type="text" name="nickname" required><br/>
  		비밀번호(테스트): <input type="password" name="pwd" value="0000" required><br/>
  		<button class="btn" type="submit">가입</button>
	</form>
</body>
</html>