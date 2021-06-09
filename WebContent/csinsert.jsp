<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert.jsp</title>
</head>
<body>

<h1>문의내용</h1><p style=color:red;>*필수입력</p>
<label for="movieoretc">*분류</label>
<select name="movieoretc" id="movieoretc">
	<option value="영화관">영화관</option>
	<option value="기타">기타</option>
</select>

<form action="csinsert" method="post">
	<input type="hidden" name="customerNum" value="${param.customerNum}">
	<input type="hidden" name="ref" value="${param.ref}">
	<input type="hidden" name="lev" value="${param.lev}">
	<input type="hidden" name="step" value="${param.step}">
	*제목<br>
	<input type="text" name="title"><br>
	*내용<br>
	<textarea rows="20" cols="100" name=content></textarea><br>
	<input type="file" name="file1">첨부 파일형식 : jpg / jpeg / png / bmp / gif / pdf (5MB X 1개)<br> 
	<input type="submit" value="등록" >
</form>
</body>
</html>