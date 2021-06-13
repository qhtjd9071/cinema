<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>내 정보</title>
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
<form method="post" action="update" class="update_form" onsubmit="return formSubmit()">
	<h3>회원정보 수정</h3>
	<div class="join1">
		<div class="join_col1">
			<label for="">이름</label>
		</div>
		<div class="join_col_input">
			<div class="input_wrap">
				<div class="wrap_inner">
					<div class="ui_input">
						<input type="text" name="name" class="input_space" value="${vo.name}" readonly="readonly">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="join1">
		<div class="join_col1">
			<label for="">아이디</label>
		</div>
		<div class="join_col_input">
			<div class="input_wrap">
				<div class="wrap_inner">
					<div class="ui_input">
						<input type="text" name="id" class="input_space" value="${vo.id}" readonly="readonly">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="join1">
		<div class="join_col1">
			<label for="">생년월일</label>
		</div>
		<div class="join_col_input">
			<div class="input_wrap">
				<div class="wrap_inner">
					<div class="ui_input">
						<input type="text" name="year" class="input_space" value="${vo.year}" readonly="readonly">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="join1">
		<div class="join_col1">
			<label for="">휴대폰</label>
		</div>
		<div class="join_col_input">
			<div class="input_wrap">
				<div class="wrap_inner">
					<div class="ui_input">
						<input type="text" name="phone" class="input_space" value="${vo.phone}" readonly="readonly">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="join1">
		<div class="join_col1">
			<label for="">이메일</label>
		</div>
		<div class="join_col_input">
			<div class="input_wrap">
				<div class="wrap_inner">
					<div class="ui_input">
						<input type="text" name="email" class="input_space" value="${vo.email}" readonly="readonly">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="join1">
		<div class="join_col1">
			<label for="">비밀번호 변경</label>
		</div>
		<div class="join_col_input">
			<div class="input_wrap">
				<div class="wrap_inner">
					<div class="ui_input2">
						<a href="${pageContext.request.contextPath }/pwdUpdate.jsp"><input type="button" value="비밀번호 변경" class="btn_pwd"></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<input type="submit" value="수정" class="submit_btn">
</form>
</body>
</html>