<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>비밀번호 찾기</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/findid.css">
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
			<form method="post" action="findpwd.do" class="find_id" onsubmit="return check()">
				<div class="toparea">
					<h2 class="title">비밀번호 찾기</h2>
					<div class="headline">개인정보보호를 위해<br>본인 인증해주세요.</div>
				</div>
				<h3>인증정보 입력</h3>
					<div class="findid1">
						<div class="findid_col1">
							<label for="">아이디</label>
						</div>
						<div class="findid_col_input">
							<div class="input_wrap">
								<div class="wrap_inner">
									<div class="ui_input">
										<input type="text" name="id" class="input_space" maxlength="15" id="name" placeholder="아이디를 입력해주세요.">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="findid1">
						<div class="findid_col1">
							<label for="">이름</label>
						</div>
						<div class="findid_col_input">
							<div class="input_wrap">
								<div class="wrap_inner">
									<div class="ui_input">
										<input type="text" name="name" class="input_space" maxlength="15" id="name" placeholder="한글 또는 영문으로 입력해주세요.">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="findid1">
						<div class="findid_col1">
							<label for="">이메일</label>
						</div>
						<div class="findid_col_input">
							<div class="input_wrap">
								<div class="wrap_inner">
									<div class="ui_input">
										<input type="text" name="email" class="input_space" placeholder="이메일을 입력해주세요.">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="findid1">
						<div class="findid_col1">
							<label for="">생년월일</label>
						</div>
						<div class="findid_col_input">
							<div class="input_wrap">
								<div class="wrap_inner">
									<div class="ui_input">
										<input type="text" name="year" class="input_space" placeholder="생년월일 8자리를 입력해주세요. (ex.19990625)">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="findid1">
						<div class="findid_col1">
							<label for="">휴대폰 번호</label>
						</div>
						<div class="findid_col_input">
							<div class="input_wrap">
								<div class="wrap_inner">
									<div class="ui_input">
										<input type="text" name="phone" class="input_space" placeholder="휴대폰 번호를 입력해주세요. (숫자만 입력가능합니다.)">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="submit_container">
						<input type="submit" value="찾기" class="submit_btn">
					</div>
			</form>
		</div>
	</div>
	
	<div class="footer">
		<jsp:include page="footer2.jsp"/>
	</div>
</body>
<script type="text/javascript">
	function check(){
		var id=document.getElementsByName("id")[0];
		var name=document.getElementsByName("name")[0];
		var email=document.getElementsByName("email")[0];
		var ereg=/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		var year=document.getElementsByName("year")[0];
		var phone=document.getElementsByName("phone")[0];
		if(id.value.trim()==""){
			alert("아이디를 입력하세요.");
			id.focus();
			return false;
		}
		if(name.value.trim()==""){
			alert("이름을 입력하세요.");
			name.focus();
			return false;
		}
		if(email.value.trim()==""){
			alert("이메일을 입력하세요.");
			email.focus();
			return false;
		}
		if (!ereg.test(email.value)){
			alert("이메일형식에 맞게 입력하세요.");
			email.focus();
			return false;
		}
		if(year.value.trim()==""){
			alert("생년월일을 입력하세요.");
			year.focus();
			return false;
		}
		if(year.value.length!=8){
			alert("생년월일은 8자리로 입력하세요.");
			year.focus();
			return false;
		}
		if(phone.value.trim()==""){
			alert("휴대폰번호를 입력하세요.");
			phone.focus();
			return false;
		}
		if(phone.value.indexOf("-")!=-1){
			alert("휴대폰번호에 숫자만 입력해주세요.");
			phone.focus();
			return false;
		}
	}
</script>
</html>