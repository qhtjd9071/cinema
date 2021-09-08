<%@page import="jhr.dao.UsersDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>비밀번호 변경</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/pwdupdate.css">
<link rel="stylesheet" href="css/footer2.css">
<script type="text/javascript">
	function pwdCheck() {
		var currpwd=document.getElementsByName("currpwd")[0];
		var newpwd1=document.getElementsByName("newpwd1")[0];
		var newpwd2=document.getElementsByName("newpwd2")[0];
		
		if(currpwd.value=="") {
			alert("현재 비밀번호를 입력해 주세요.");
			currpwd.focus();
			return false;
		}
		
		if(newpwd1.value=="") {
			alert("새로운 비밀번호를 입력해 주세요.");
			newpwd1.focus();
			return false;
		}
		
		if(newpwd2.value=="") {
			alert("새로운 비밀번호 확인을 입력해 주세요.");
			newpwd2.focus();
			return false;
		}
		
		if (newpwd1.value!=newpwd2.value) {
			alert("새로운 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			newpwd1.value="";
			newpwd2.value="";
			newpwd1.focus();
			return false;
		}
		return true;
	}
</script>
</head>

<body>
	<div class="header">
		<div class="header_container">
			<h1><a href="${pageContext.request.contextPath }/main.jsp"><img src="images/login/logo.png"></a></h1>
		</div>
	</div>
	<div class="pwdupdate">
		<div class="pwdupdate_container">
			<h2 class="title">비밀번호 변경</h2>
			<form method="post" action="pwdupdate" class="join_form" onsubmit="return pwdCheck()">
				<div class="join1">
					<div class="join_col1">
						<label for="">현재 비밀번호</label>
					</div>
					<div class="join_col_input">
						<div class="input_wrap">
							<div class="wrap_inner">
								<div class="ui_input">
									<input type="password" name="currpwd" class="input_space" maxlength="20" id="currpwd" placeholder="현재 비밀번호를 입력해주세요.">
									<span id="result"></span><br>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="join1">
					<div class="join_col1">
						<label for="">새 비밀번호</label>
					</div>
					<div class="join_col_input">
						<div class="input_wrap">
							<div class="wrap_inner">
								<div class="ui_input">
									<input type="password" name="newpwd1" class="input_space" maxlength="20" id="newpwd1" placeholder="새 비밀번호를 입력해주세요.">
									<span id="result"></span><br>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="join1">
					<div class="join_col1">
						<label for="">새 비밀번호 재입력</label>
					</div>
					<div class="join_col_input">
						<div class="input_wrap">
							<div class="wrap_inner">
								<div class="ui_input">
									<input type="password" name="newpwd2" class="input_space" maxlength="20" id="newpwd2" placeholder="새 비밀번호를 재입력해주세요.">
									<span id="result"></span><br>
								</div>
							</div>
						</div>
					</div>
				</div>
				<ul>
					<li>생년월일, 전화번호 등 개인 정보와 관련된 숫자, 연속된 숫자와 같이 쉬운 비밀번호는 다른 사람이 쉽게 알아낼 수 있으니 사용을 자제해 주세요.</li>
					<li>비밀번호 설정 시 한글 및 특수문자는 비밀번호로 사용하실 수 없습니다.</li>
					<li>비밀번호는 3-6개월마다 꼭 바꿔 주세요.</li>
					<li>비밀번호 변경시 모바일 기기와 홈페이지에서 모두 로그아웃됩니다. 변경한 비밀번호로 다시 로그인해주세요.</li>
				</ul>
				<div class="submit_container">
					<input type="reset" value="초기화" class="reset_btn">
					<input type="submit" value="변경" class="submit_btn">
				</div>
			</form>
		</div>
	</div>
	<div class="footer">
		<jsp:include page="footer2.jsp"/>
	</div>
</body>
</html>