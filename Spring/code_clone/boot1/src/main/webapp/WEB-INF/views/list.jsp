<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <title>LIST</title>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
            th, td {
                padding: 5px;
            }
            a { text-decoration:none }
        </style>
    </head>

    <body style="text-align:center">
        <h1>
            테스트
        </h1>
        <a href="write.do">입력</a><br>
        <table border='1'>
            <tr>
            <th>번호</th>
            <th>이름</th>
            <th>주소</th>
            <th>날짜</th>
            <th>삭제</th>
            </tr>
        <c:if test="${empty list}">
            <tr>
                <td align="center" colspan="5">데이터가 하나도 없어요</td>
            </tr>
        </c:if>

        <c:forEach var="item" items="${list}">
            <tr>
                <td align="center">${address.seq}</td>
                <td>${address.name}</td>
                <td>${address.addr}</td>
                <td align="center">
                    <fmt:formatDate value="${address.rdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
                <td align="center"><a href="del.do?seq=${address.seq}">삭제</a></td>
            </tr>
        </c:forEach>
    </body>
</html>