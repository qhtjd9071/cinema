<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal.username" var="logined"/>
</sec:authorize>
<!DOCTYPE html>
<html>
<head>
<title>header2.jsp</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="${cp}/resources/css/header2.css">
</head>

<body>
<div class="header">
	<h1 class="logo">
		<a href="${cp}/">LOTTE CINEMA</a>
	</h1>
	
	<div class="gnb">
		<ul class="g_menu1">
			<li><a href="#">관리자 페이지</a></li>
			<c:choose>
				<c:when test="${empty logined}">
					<li><a href="${cp}/login">로그인</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${cp}/logout">로그아웃</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
	
	
	
	<div class="nav">
		<ul>
			<li><a href="${cp}/" class="nav_ticketing">관리자 메인</a></li>
		</ul>
	</div>
</div>
</body>
</html>