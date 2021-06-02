<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>login.jsp</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/header2.css">
<link rel="stylesheet" href="css/footer.css">
</head>

<body>
<div id="header2">
	<jsp:include page="header2.jsp"/>
</div>

<div id="login" class="login_container">
	<div class="login_contents">
		<ul class="tab_wrap">
			<li>
				<button type="button" class="tab_tit"><span>회원</span></button>
				<div class="tab_content">
					<div class="member_login_wrap">
						<div class="login_inner">
							<div class="login_box">
								<div class="login_area">
									<input type="text" id="userId" class="login_id" maxlength="50" placeholder="아이디 또는 이메일을 입력해 주세요.">
									<input type="password" id="userPassword" class="login_pwd" maxlength="15" placeholder="비밀번호를 입력해 주세요.">
									<button type="button" class="btn_login">로그인</button>
								</div>
								<div class="login_bot_wrap">
									<div class="login_check">
										<input type="checkbox" name="loginCheck" class="logincheckid" id="checkSavedID">
										<label for="checkSavedID" class="logincheckid_label">아이디 저장</label>
									</div>
									<div class="login_menu">
										<a>회원가입</a>
										<a>아이디 찾기</a>
										<a>비밀번호 찾기</a>
									</div>
								</div>
							</div>
							<div class="login_ad">
								<a><img src="images/login/InTheHeights_450220.jpg"></a>
							</div>
						</div>
					</div>
				</div>
			</li>
		</ul>
	</div>
</div>

<div id="footer">
	<jsp:include page="footer.jsp"/>
</div>
</body>
</html>