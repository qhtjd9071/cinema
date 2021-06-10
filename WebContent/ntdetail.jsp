<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>공지사항 상세페이지</h1>
<table border="1" width="500">
	<tr>
		<td style="width:100px;">공지글번호</td>
		<td>${vo.noticeNum }</td>
	</tr>
	<tr>
		<td>공지글제목</td>
		<td>${vo.title }</td>
	</tr>
	<tr>
		<td>내용</td>
		<td><div style="width:350px;height: 200px">${vo.content }</div></td>
	</tr>
</table>
</body>
</html>