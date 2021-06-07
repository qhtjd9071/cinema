<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>myinfo.jsp</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/myinfo.css">
<script type="text/javascript">
	function formSubmit() {
		if(confirm("정말 수정하시겠습니까?")) {
			return true;
		}
		return false;
	}
</script>
</head>

<body>
<h1>회원정보 수정</h1>
<form method="post" action="update" onsubmit="return formSubmit()">
	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="${vo.name}" readonly="readonly"></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="${vo.id}" readonly="readonly"></td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><input type="text" name="year" value="${vo.year}" readonly="readonly"></td>
		</tr>
		<tr>
			<td>휴대폰</td>
			<td><input type="text" name="phone" value="${vo.phone}"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email" value="${vo.email}"></td>
		</tr>
		<tr>
			<td>비밀번호 변경</td>
			<td><a href="${pageContext.request.contextPath }/pwdUpdate.jsp"><input type="button" value="비밀번호 변경"></a></td>
		</tr>
	</table>
	<input type="submit" value="수정">
</form>
</body>
</html>