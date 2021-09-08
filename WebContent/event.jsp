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
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">
<link rel="stylesheet" href="css/event.css">
<link rel="stylesheet" href="css/header2.css">
<link rel="stylesheet" href="css/footer.css">
</head>
<body>
<div class="header2">
	<jsp:include page="header2.jsp"/>
</div>

<div class="contents_event">
	<div class="evnt_img"><img src="${pageContext.request.contextPath}/eventdetail.do?eventNum=${vo.detailImage }"></div>
	<div class="btn_btm_wrap">
		<a class="btn_col2 ty6" href="${pageContext.request.contextPath}/Eve_main.jsp">목록</a>
	</div>
</div>

<div class="footer">
	<jsp:include page="footer.jsp"/>
</div>
</body> 
</html>