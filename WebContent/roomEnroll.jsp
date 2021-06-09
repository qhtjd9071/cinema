<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/movieEnroll.css">
<link rel="stylesheet" href="css/header2.css">
<link rel="stylesheet" href="css/footer.css">
</head>
<body>
	<div class="header2">
		<jsp:include page="header2.jsp"/>
	</div>
	
	<div class="movie">
		<div class="movie_container">
		
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

		</div>
	</div>
	
	<div class="footer">
		<jsp:include page="footer.jsp"/>
	</div>
	
</body>
</html>