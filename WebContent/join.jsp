<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/join.css">
<link rel="stylesheet" href="css/footer2.css">
</head>

<body>
<div class="header">
	<div class="header_container">
		<h1><a href="${pageContext.request.contextPath }/main.jsp"><img src="images/login/logo.png"></a></h1>
	</div>
</div>
<div class="contents">
	<div class="contents_container">
		<h2 class="title">회원가입</h2>
		<form method="post" action="join" class="join_form" onsubmit="return check()">
			<h3>
				회원정보입력
				<span class="point_color"><small>*은 필수입력 항목입니다.</small></span>
			</h3>
			<div class="join1">
				<div class="join_col1">
					<label for=""><span class="point_color">*</span>이름</label>
				</div>
				<div class="join_col_input">
					<div class="input_wrap">
						<div class="wrap_inner">
							<div class="ui_input">
								<input type="text" name="name" class="input_space" maxlength="12" placeholder="한글 또는 영문으로 입력해주세요.">
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="join1">
				<div class="join_col1">
					<label for=""><span class="point_color">*</span>아이디</label>
				</div>
				<div class="join_col_input">
					<div class="input_wrap">
						<div class="wrap_inner">
							<div class="ui_input">
								<input type="text" name="id" class="input_space" maxlength="15" id="id" placeholder="아이디를 입력해주세요.">
								<span id="result"></span><br>
							</div>
							<button type="button" class="ui_button" id="idoverlap">중복확인</button>
						</div>
					</div>
				</div>
			</div>
			<div class="join1">
				<div class="join_col1">
					<label for=""><span class="point_color">*</span>비밀번호</label>
				</div>
				<div class="join_col_input">
					<div class="input_wrap">
						<div class="wrap_inner">
							<div class="ui_input">
								<input type="password" name="pwd" class="input_space" maxlength="20" id="pwd" placeholder="비밀번호를 입력해주세요."><br>
							</div><br>
							<span class="point_color"><small>8-15자리의 영문/숫자를 함께 입력해주세요.</small></span><br>
							<div class="ui_input">
								<input type="password" name="pwd2" class="input_space" maxlength="20" id="pwd" placeholder="입력하신 비밀번호를 다시 한번 입력해주세요.">
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="join1">
				<div class="join_col1">
					<label for=""><span class="point_color">*</span>이메일</label>
				</div>
				<div class="join_col_input">
					<div class="input_wrap">
						<div class="ui_input">
							<input type="text" name="email" class="input_space" placeholder="이메일주소를 입력해주세요.">
						</div>
					</div>
				</div>
			</div>
			<div class="join1">
				<div class="join_col1">
					<label for=""><span class="point_color">*</span>생년월일</label>
				</div>
				<div class="join_col_input">
					<div class="input_wrap">
						<div class="ui_input">
							<input type="text" name="year" class="input_space" maxlength="20" placeholder="생년월일 8자리를 입력해주세요. (ex.19990625)">
						</div>
					</div>
				</div>
			</div>
			<div class="join1">
				<div class="join_col1">
					<label for=""><span class="point_color">*</span>휴대폰 번호</label>
				</div>
				<div class="join_col_input">
					<div class="input_wrap">
						<div class="ui_input">
							<input type="text" name="phone" class="input_space" maxlength="15" placeholder="휴대폰 번호를 입력해주세요. (숫자만 입력가능합니다.)">
						</div>
					</div>
				</div>
			</div>
			<div class="submit_container">
				<input type="submit" value="등록" class="submit_btn">
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
		var name=document.getElementsByName("name")[0];
		var id=document.getElementsByName("id")[0];
		var pwd1=document.getElementsByName("pwd")[0];
		var pwd2=document.getElementsByName("pwd2")[0];
		var email=document.getElementsByName("email")[0];
		var ereg=/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		var year=document.getElementsByName("year")[0];
		var phone=document.getElementsByName("phone")[0];
		if(name.value.trim()==""){
			alert("이름을 입력하세요.");
			name.focus();
			return false;
		}
		if(id.value.trim()==""){
			alert("아이디를 입력하세요.");
			id.focus();
			return false;
		}
		if(pwd1.value.trim()==""){
			alert("비밀번호를 입력하세요.");
			pwd.focus();
			return false;
		}
		if(pwd1.value.length<8 || pwd1.value.length>15){
			alert("비밀번호는 8-15자리의 영문/숫자를 함께 입력해주세요.");
			pwd1.focus();
			return false;
		}
		if(pwd2.value.trim()==""){
			alert("비밀번호 확인을 입력하세요.");
			pwd.focus();
			return false;
		}
		if (pwd1.value!=pwd2.value) {
			alert("새로운 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			pwd1.value="";
			pwd2.value="";
			pwd1.focus();
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
		alert("회원가입에 성공했습니다!");
		return true;
	}
	
	window.onload=function(e){
		let idoverlap=document.getElementById("idoverlap");
		idoverlap.onclick=function(e){
			const id=document.getElementById("id").value;
			let xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4 && xhr.status==200){
					let result=xhr.responseText;
					let json=JSON.parse(result);
					if(json.using==true){
						alert("사용중인 아이디입니다.");
					}else{
						if((id<"0"||id>"9")&&(id<"A"||id>"Z")&&(id<"a"||id>"z")) {
							alert("한글 및 특수문자는 아이디로 사용하실 수 없습니다.");
						} else {
							alert("사용 가능한 아이디입니다.");
						}
					}
				}
			};
			xhr.open('get','${pageContext.request.contextPath }/idcheck.jsp?id=' + id,true);
			xhr.send();
		}
	};
	
</script>
</html>