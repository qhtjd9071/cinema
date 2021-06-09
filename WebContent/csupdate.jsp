<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update.jsp</title>
</head>
<body>
<h1>1:1문의 수정</h1>
<form method="post" action="csupdate">
	글번호 <input type="text" name="customerNum" value="${vo.customerNum}" readonly="readonly"><br>
	작성자 <input type="text" name="writer" value="${vo.writer}" ><br>
	제목 <input type="text" name="title" value="${vo.title}"><br>
	글내용 <input type="text" name="content" value="${vo.content}" ><br>
	가입일  <input type="text"  value="${vo.writedate}" readonly="readonly"><br>
	<input type="submit" value="저장">
</form>
</body>
</html>