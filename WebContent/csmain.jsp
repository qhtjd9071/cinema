<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/cslist.css">
<link rel="stylesheet" href="css/header2.css">
<link rel="stylesheet" href="css/footer.css">
</head>
<style>
.content_container h1 {
	margin-bottom:40px;
}
.content_container ul {
	display:block;
	list-style:none;
}
.content_container li {
	display:block;
	float:left;
	list-style:none;
	margin-bottom:70px;
	margin-right:50px;
}
.content_container a {
	display:inline-block;
	padding:30px 40px;
	background-color:#6E6E6E;
	color:white;
	border:none;
	border-radius:5px;
	text-decoration:none;
}
</style>
<body>
	<div class="header2">
	   <jsp:include page="header2.jsp"/>
	</div>
	
	<div class="content">
		<div class="content_container">  
		<h1>고객센터</h1>
		<ul>
		<c:if test="${sessionScope.id!=null}">
			<li><a href="${pageContext.request.contextPath}/csinsert.jsp">1:1 문의</a></li>
		</c:if>
			<li><a href="${pageContext.request.contextPath}/cslist">문의글 목록 보기</a></li>	
		</ul>
		</div>
	</div>
	
	<div class="footer">
	   <jsp:include page="footer.jsp"/>
	</div>
</body>
</html>