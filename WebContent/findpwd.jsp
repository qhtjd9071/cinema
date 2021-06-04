<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>findpwd.jsp</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/findid.css">
</head>

<body>
<div class="findpwd_container">
	<form method="post" action="findpwd.do" class="find_pwd">
		이름<input type="text" name="name"><br>
		이메일<input type="text" name="email"><br>
		생년월일<input type="text" name="year"><br>
		전화번호<input type="text" name="phone"><br>
		<input type="submit" value="찾기">
	</form>
</div>
</body>
</html>