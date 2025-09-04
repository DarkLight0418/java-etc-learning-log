<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <title>게시판</title>
  <!-- 개발 중 캐시 무효화용 v=... 추가 -->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/test.css"/>
  
</head>
<body>
  <main class="container">
    <section class="hero">
      <h1 class="hero__title">게시판</h1>
      <div class="hero__actions">
        <a class="btn btn--primary" href="<%= request.getContextPath() %>/board.do?type=login">로그인</a><br>
      	<a class="btn btn--primary" href="<%= request.getContextPath() %>/board.do?type=list">게시판 임시</a><br>
      	<a class="btn btn--primary" href="<%= request.getContextPath() %>/board.do?type=view">게시글 페이지 테스트</a>
      </div>
    </section>
  </main>
</body>
</html>
