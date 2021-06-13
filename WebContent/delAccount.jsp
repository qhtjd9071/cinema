<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id=(String)session.getAttribute("id");
	String pwd=(String)session.getAttribute("pwd");
%>
<!DOCTYPE html>
<html>
<head>
<title>비밀번호 변경</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/header2.css">
<link rel="stylesheet" href="css/delaccount.css">
<link rel="stylesheet" href="css/footer.css">
</head>

<body>
	<div class="delaccount">
		<h3 class="title">회원탈퇴</h3>
		<p class="caution">[주의] 로또시네마 회원탈퇴를 신청하기 전에 안내 사항을 꼭 확인해주세요.</p>
		<div class="content">
			<ol>
				<li class="list_num">
					<p class="subtitle">1. 30일간 회원 재가입이 불가능합니다.</p>
					<ul>
						<li class="list_detail">회원 탈퇴 후, 30일 경과 후 재가입할 수 있습니다.</li>
					</ul>
				</li>
				<li class="list_num">
					<p class="subtitle">2. 탈퇴 후 삭제 내역</p>
					<p class="caution">(회원 탈퇴하시면 회원정보와 개인 보유 포인트 등 정보가 삭제되며 데이터는 복구되지 않습니다.)</p>
					<ul>
						<li class="list_detail">로또시네마 멤버십 포인트 및 적립/차감 내역</li>
						<li class="list_detail">관람권 및 쿠폰</li>
						<li class="list_detail">영화 관람 내역</li>
						<li class="list_detail">간편 로그인 연동 정보</li>
					</ul>
				</li>
				<li class="list_num">
					<p class="subtitle">3. 회원님의 비밀번호를 입력하시고 [탈퇴] 버튼을 클릭해주세요.</p>
					<form action="delCon" method="post" class="del_form">
						<div class="join1">
							<div class="join_col1">
								<label for="">비밀번호</label>
							</div>
							<div class="join_col_input">
								<div class="input_wrap">
									<div class="wrap_inner">
										<div class="ui_input">
											<input type="password" name="pwd" class="input_space">
										</div>
									</div>
								</div>
							</div>
							<input type="submit" value="확인" class="submit_btn">
						</div>
					</form>
				<li>
			</ol>
		</div>
	</div>
</body>
</html>