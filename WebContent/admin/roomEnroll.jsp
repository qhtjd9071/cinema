<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>상영관등록</h1>
<form method="post" action="${pageContext.request.contextPath}/admin?cmd=roomEnroll">
	영화관이름
	<input type="text" name="theaterName"><br>
	좌석수
	<input type="text" name="seatCount"><br>
	위치
	<input type="text" name="location"><br>
	상영관번호
	<input type="text" name="roomNum"><br>
	<input type="submit" value="등록">
</form>
</body>
</html>