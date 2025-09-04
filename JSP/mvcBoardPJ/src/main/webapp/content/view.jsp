<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="mvcBoardPJ.com.example.domain.*"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시글 조회</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/test.css"/>
</head>
<body>
	<div class="post-wrap">
  <c:choose>
    <c:when test="${not empty post}">
      <header class="post-header">
        <h1 class="post-title"><c:out value="${post.title}" /></h1>
        <div class="post-meta">
          작성자: <c:out value="${post.email}" />
          &nbsp;·&nbsp;
          작성일:
          <c:choose>
            <%-- post.createdDate 가 java.util.Date 라면 바로 fmt 사용 --%>
            <c:when test="${not empty post.createdDate}">
              <fmt:formatDate value="${post.createdDate}" />
            </c:when>
            <%-- LocalDateTime 등이라면, 컨트롤러/서비스에서 포맷 문자열로 넘기거나, 아래처럼 그냥 출력 --%>
            <c:otherwise>
              <c:out value="${post.createdDate}" />
            </c:otherwise>
          </c:choose>
          포스트 ID:<c:out value="${post.postId}" />
        </div>
      </header>
	
	<article class="post-body">
        <%-- DB에 HTML이 저장된 경우 (예: content_html) 렌더링: --%>
        <c:out value="${post.content}" escapeXml="false" />
        <%-- 만약 단순 텍스트라면 escapeXml="true"(기본)로 바꾸세요 --%>
      </article>

      <div class="btns">
        <%-- 목록으로: board/page 파라미터가 있으면 유지 --%>
        <a class="btn"
           href="${pageContext.request.contextPath}/board.do?type=list">
          목록으로
        </a>

		<%-- href="${pageContext.request.contextPath}/board.do?type=list&board=${param.board}&page=${param.page}"> --%>
        <%-- 필요 시 수정/삭제 (권한 체크 후 노출 권장) --%>
        <%-- 
        <c:if test="${loginUser.email == post.email}">
          <a class="btn" href="${pageContext.request.contextPath}/board.do?type=edit&post=${post.postId}">수정</a>
          <a class="btn" href="${pageContext.request.contextPath}/board.do?type=delete&post=${post.postId}"
             onclick="return confirm('정말 삭제할까요?');">삭제</a>
        </c:if>
        --%>
      </div>
    </c:when>

    <c:otherwise>
      <%-- 컨트롤러에서 404로 처리하는 편이 더 낫지만, 안전망으로 메시지 표시 --%>
      <p>게시글을 찾을 수 없습니다.</p>
      <p><a class="btn" href="${pageContext.request.contextPath}/board.do?type=list">목록으로</a></p>
    </c:otherwise>
  </c:choose>
</div>
</body>
</html>