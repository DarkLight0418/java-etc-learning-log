<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, java.time.LocalDateTime, mvcBoardPJ.com.example.domain.*"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="content-Language" content="ko">
<meta charset="UTF-8">
<title>게시판 (EL)</title>
</head>
<body>
	<h1>
		게시판 (EL)
	</h1>
	<a href="input.jsp">글쓰기(구현X)</a>
	<a href="index.jsp">인덱스</a>
	<a href="<%= request.getContextPath() %>/board.do?type=login">로그인</a>
	
	
	<table border='1' cellpadding='7' cellspacing='2' width='50%'>
		<tr>
			<th>글번호</th>
			<th>작성자(이메일)</th>
			<th>글제목</th>
			<th>작성시각</th>
			<th>수정시각</th>
		</tr>

	<c:if test="${empty list}">
		<tr>
			<td align='center' colspan="4">데이터가 하나도 없습니다..ㅜㅠ</td>
		</tr>
	</c:if>
	
	<!-- Post의 getter와 동일하게 필드명 맞춰줍시다 -->
	
	<c:forEach items="${list}" var="post">
		<tr>
			<td align="center">${post.postId}</td>
			<td>${post.email}</td>
			<td>${post.title}</td>
			<td><c:out value="${post.createdDateStr}"/></td>
			<td><c:out value="${post.updatedDateStr}"/></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>