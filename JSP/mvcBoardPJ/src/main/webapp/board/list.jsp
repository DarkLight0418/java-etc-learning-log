<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, java.time.LocalDateTime, mvcBoardPJ.com.example.domain.*"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="content-Language" content="ko">
<meta charset="UTF-8">
<title>게시판</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/test.css"/>
</head>



<body>
	<div class="actions">
		<h1>게시판</h1>
	</div>
	<div class="actions">
		<a class="btn" href="<%= request.getContextPath() %>/board.do?type=insert">글쓰기(구현X)</a>
		<a class="btn" href="index.jsp">인덱스</a>
		<a class="btn" href="<%= request.getContextPath() %>/board.do?type=login">로그인</a>
	</div>
	
	<table align="center" border='1' cellpadding='6' cellspacing='2' width='100%'>
		<colgroup>
			<col width="20%">
			<col width="40%">
			<col width="15%">
			<col width="15%">
			<col width="5%">
			<col width="5%">
		</colgroup>
		<tr height="10px">
			<th>작성자(이메일)</th>
			<th>글제목</th>
			<th>작성시각</th>
			<th>수정시각</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>

	<c:if test="${empty list}">
		<tr>
			<td align='center' colspan="6">데이터가 하나도 없습니다..ㅜㅠ</td>
		</tr>
	</c:if>
	
	
	<c:forEach items="${list}" var="post">
		<tr>
			<!-- Post의 getter와 동일하게 필드명 맞춰줍시다 -->
			<c:url var="viewUrl" value="/board.do">
				<c:param name="type" value="view"/>
				<c:param name="post" value="${post.postId}"/>
			</c:url>
			<td>${post.email}</td>
			<td><a href="${viewUrl}"><c:out value="${post.title}"/></a></td>
			<td><c:out value="${post.createdDate}"/></td>
			<td><c:out value="${post.updatedDate}"/></td>
			<td>수정</td>
			<td>삭제</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>