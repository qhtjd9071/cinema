<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예매 내역</title>
</head>
<body>
<h1>예매 내역</h1>
<table border="1">
	<tr>
		<th>예매번호</th>
		<th>내역</th>
		<th>금액</th>
		<th>결제날짜</th>
		<th>취소</th>
	</tr>
	
	<c:forEach var="vo" items="${list}">
		<tr>
			<td>${vo.intNum}</td>
			<td>${vo.movieTitle}
				좌석 : ${vo.seatNumArr }
			</td>
			<td>${vo.tot }</td>
			<td>${vo.payDate }</td>
			<td><a href="#">취소</a></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>