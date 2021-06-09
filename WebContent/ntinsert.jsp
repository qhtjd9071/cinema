<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>공지등록하기</h1>
<form action="${pageContext.request.contextPath}/ntinsert" method="post">
	제목<br>
	<input type="text" name="title"><br>
	내용<br>
	<textarea rows="20" cols="100" name=content></textarea><br>
	<input type="file" name="file1">첨부 파일형식 : jpg / jpeg / png / bmp / gif / pdf (5MB X 1개)<br> 
	<input type="submit" value="등록" >
</form>
