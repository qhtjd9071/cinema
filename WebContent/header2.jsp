<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>header2.jsp</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/header2.css">
</head>
<body>
<div class="header">
	<h1 class="logo">
		<a href="${pageContext.request.contextPath }/main.jsp">LOTTE CINEMA</a>
	</h1>
	
	<div class="gnb">
		<ul class="g_menu1">
			<li><a href="${pageContext.request.contextPath}/csmain.jsp">고객센터</a></li>
			<c:choose>
				<c:when test="${empty sessionScope.id }">
					<li><a href="${pageContext.request.contextPath }/login.jsp">로그인</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="logout">로그아웃</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		
		<ul class="g_menu2">
			<c:if test="${sessionScope.id!=null }">
				<li><a href="${pageContext.request.contextPath }/payList" class="btn_my">마이페이지</a></li>
			</c:if>
			<c:if test="${sessionScope.id==null }">
				<li><a href="${pageContext.request.contextPath }/join.jsp" class="btn_my">회원가입</a></li>
			</c:if>
			<li><a href="${pageContext.request.contextPath }/booking" class="btn_reserve">바로 예매</a></li>
		</ul>
	</div>
	
	<div class="nav">
		<ul>
			<li><a href="${pageContext.request.contextPath }/booking" class="nav_ticketing">예매</a></li>
			<li><a href="${pageContext.request.contextPath }/movieList" class="nav_movie">영화</a></li>
			<li><a href="${pageContext.request.contextPath }/event" class="nav_event">이벤트</a></li>
			<li><a href="${pageContext.request.contextPath }/ntlist" class="nav_noticelist">공지사항</a></li>
		</ul>
	</div>
</div>
</body>
</html>