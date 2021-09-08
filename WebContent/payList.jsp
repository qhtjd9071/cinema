<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예매 내역</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/payList.css">
</head>
<body>
	<div class="content">
		<div class="content_container">
			<h1 class="title">예매 내역</h1>
			<table>
				<tr>
					<th>제목</th>
					<th>좌석</th>
					<th>극장</th>
					<th>상영관</th>
					<th>시작 시간</th>
					<th>금액</th>
					<th>결제날짜</th>
					<th>취소</th>
				</tr>
				
				<c:forEach var="vo" items="${list}">
					<tr>
						<td>${vo.movieTitle}</td>
						<td>${vo.seatNumArr}</td>
						<td>${vo.theaterName}</td>
						<td>${vo.roomNum}</td>
						<td>${vo.beginTime}</td>
						<td>${vo.tot }</td>
						<td>${vo.payDate }</td>
						<td><a href="${pageContext.request.contextPath}/cancel?partner_order_id=${vo.intNum}">취소</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>