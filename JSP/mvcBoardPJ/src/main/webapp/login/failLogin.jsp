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
<span>
	<div class="actions">
		<h1>
			로그인 실패...
		</h1>
	</div>
	<a class="btn" href="/mvcBoardPJ">인덱스로</a>
	<a class="btn" href="/mvcBoardPJ/board.do?type=login">로그인으로</a>
	<a class="btn" href="<%= request.getContextPath() %>/board.do?type=list">게시판으로</a>
	
	<!-- request.getContextPath() == /mvcBoardPJ -->
</span>
</body>
</html>