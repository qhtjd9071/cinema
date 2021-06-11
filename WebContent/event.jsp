<%@page import="lsh.dao.EventDao"%>
<%@page import="semi.vo.eventVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EventDetai1l</title>
</head>
<body>
<!-- 이벤트 정보 -->
<table width="500" cellpadding="0" cellspacing="0" border="1">
	<tr>
		<td>이벤트제목${vo.title }</td>
		<td>내용 : ${vo.content }</td>
		<td>날짜 : ${vo.writedate }</td>
		<td>조회수 : ${vo.hit }</td>
	</tr>
</table>
</div>
<!-- 이벤트 정보 -->
</body> 
</html>