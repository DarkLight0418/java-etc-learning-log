<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 입력</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/test.css"/>
</head>
<body>
	<h1>게시글 입력 폼</h1>
	<form action="board.do?type=insert" method="post">
		<table>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email" required/></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" required/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" id="content"></textarea></td>
			</tr>
			<tr>
				<th>첨부파일(이미지)</th>
				<td><input type="file" name="file"/></td>
			</tr>
			<tr>
				<th>
					전송 및 다시 입력
				</th>
				<td colspan="2">
					<input type="submit" value="전송">
					<input type="reset" value="다시 입력">
					<a class="btn" href="${pageContext.request.contextPath}/board.do?type=list">목록으로</a> 
				</td>
			</tr>
		</table>
	</form>
</body>
</html>