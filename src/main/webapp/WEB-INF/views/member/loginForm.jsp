<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="${cp}/resources/css/login.css">
<link rel="stylesheet" href="${cp}/resources/css/header.css">
<link rel="stylesheet" href="${cp}/resources/css/footer.css">
</head>
<body>

	<div class="header">
		<jsp:include page="../layout/header.jsp" />
	</div>

	<div id="login" class="login_container">
		<div class="login_contents">
			<ul class="tab_wrap">
				<li>

					<div class="tab_content">
						<div class="member_login_wrap">
							<div class="login_inner">
								<div class="login_box">
									관리자 아이디:admin 비밀번호:abcd1234
									<form class="login_area" method="post" action="${cp}/login">
										<input type="text" name="id" id="userId" class="login_id"
											maxlength="50" placeholder="아이디 또는 이메일을 입력해 주세요."> <input
											type="password" name="pwd" id="userPwd" class="login_pwd"
											maxlength="15" placeholder="비밀번호를 입력해 주세요."> <input
											type="submit" class="btn_login" value="로그인">
										<div class="login_bot_wrap">
											<div class="login_check"></div>
										</div>
									</form>
									<div class="login_bot_wrap">
										<div class="login_menu">
											<a href="${cp}/member/joinForm">회원가입</a> <a
												href="${cp}/member/findId">아이디 찾기</a> <a
												href="${cp}/member/findPwd">비밀번호 찾기</a>
										</div>
									</div>
								</div>
								<div class="login_ad">
									<a><img
										src="${cp}/resources/images/login/InTheHeights_450220.jpg"></a>
								</div>
							</div>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</div>

	<div class="footer">
		<jsp:include page="../layout/footer.jsp" />
	</div>
</body>
</html>