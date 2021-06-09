<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>글상세페이지</h1>
<table border="1" width="500">
	<tr>
		<td style="width:100px;">글번호</td>
		<td>${vo.customerNum }</td>
	</tr>
	<tr>
		<td>글제목</td>
		<td>${vo.title }</td>
	</tr>
	
	<tr>
		<td>작성자</td>
		<td>${vo.writer }</td>
	</tr>
	<tr>
		<td>내용</td>
		<td><div style="width:350px;height: 200px">${vo.content }</div></td>
	</tr>
	<tr>
		<td colspan="2"><a href="csinsert.jsp?customerNum=${vo.customerNum}&ref=${vo.ref}&lev=${vo.lev}&step=${vo.step}">답글</a></td>
	</tr>
</table>
</body>
</html>
