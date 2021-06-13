<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>결과</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/findidResult.css">
<link rel="stylesheet" href="css/footer2.css">
</head>

<body>
	<div class="header">
		<div class="header_container">
			<h1><a href="${pageContext.request.contextPath }/main.jsp"><img src="images/login/logo.png"></a></h1>
		</div>
	</div>
	<div class="findid">
		<div class="findid_container">
			<h2 class="title">비밀번호 찾기</h2>
			<h1>${test }</h1>
			
			<div class="btn_area">
				<a href="login.jsp">확인</a>
			</div>
		</div>
	</div>
	<div class="footer">
		<jsp:include page="footer2.jsp"/>
	</div>
</body>
</html>