<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>공지글 수정</h1>
<form method="post" action="${pageContext.request.contextPath}/ntupdate">
	공지글번호 <input type="text" name="noticeNum" value="${vo.noticeNum}" readonly="readonly"><br>
	제목 <input type="text" name="title" value="${vo.title}"><br>
	글내용 <input type="text" name="content" value="${vo.content}" ><br>
	등록일 <input type="text"  value="${vo.writedate}" readonly="readonly"><br>
	<input type="submit" value="저장">
</form>
</body>
</html>