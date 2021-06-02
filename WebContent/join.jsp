<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="header">
	<div class="header_container">
		<h1><a><img src="images/login/logo.png"></a></h1>
	</div>
</div>
<div class="contents">
	<h2 class="title">회원가입</h2>
	<form method="post" action="join" class="join_form">
		<h3>
			회원정보입력
			<span><small>*은 필수입력 항목입니다.</small></span>
		</h3>
		<div class="join1">
			<div class="join_col">
				<label for="">
					<em class="point_color">이름</em>
				</label>
			</div>
			<div class="join_col_input">
				<div class="input_wrap">
					<div class="ui_input">
						<input type="text" name="name" maxlength="13">
						<span class="placeholder">한글 또는 영문으로 입력해주세요.</span>
					</div>
				</div>
			</div>
		</div>
		<div class="join1">
			<div class="join_col">
				<label for="">
					<em class="point_color">아이디</em>
				</label>
			</div>
			<div class="join_col_input">
				<div class="input_wrap">
					<div class="ui_input">
						<input type="text" name="id" maxlength="15">
						<span class="placeholder">아이디를 입력해주세요.</span>
					</div>
					<button tyle="button" class="id_button">메일 발송</button>
				</div>
			</div>
		</div>
		
		
		비밀번호<input type="text" name="pwd"><br>
		이메일<input type="text" name="email"><br>
		생년월일<input type="text" name="year"><br>
		전화번호<input type="text" name="phone"><br>
		<input type="submit" value="등록">
	</form>
</div>
</body>
</html>