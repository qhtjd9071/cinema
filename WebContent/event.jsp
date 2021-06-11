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

<div class="contents_event">
	<div class="evnt_img"><img src="${vo.eventImage }"></div>
	<div class="btn_btm_wrap">
		<a class="btn_col2 ty6" href="${pageContext.request.contextPath}/Eve_main.jsp">목록</a>
	</div>
</div>
</body> 
</html>