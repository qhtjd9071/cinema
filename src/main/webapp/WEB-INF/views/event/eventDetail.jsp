<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 상세</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="${cp}/resources/css/eventDetail.css">
<link rel="stylesheet" href="${cp}/resources/css/header2.css">
<link rel="stylesheet" href="${cp}/resources/css/footer.css">
</head>
<body>
<div class="header2">
	<jsp:include page="../layout/header.jsp"/>
</div>

<div class="contents_event">
	<div class="movieImg">
		<img src="${vo.detailImage}">
	</div>	
</div>
<div class="footer">
	<jsp:include page="../layout/footer.jsp"/>
</div>
</body>
</html>