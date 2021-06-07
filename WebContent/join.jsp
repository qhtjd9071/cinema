<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join.jsp</title>
</head>
<body>
<div class="header">
	<div class="header_container">
		<h1><a><img src="images/login/logo.png"></a></h1>
	</div>
</div>
<div class="contents">
	<h2 class="title">회원가입</h2>
	<form method="post" action="join" class="join_form"  onsubmit="return check()">
		<h3>
			회원정보입력
			<span><small>*은 필수입력 항목입니다.</small></span>
		</h3>
		<div class="join1">
			<div class="join_col">
				<label for="">
					<em class="point_color">이름*</em>
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
					<em class="point_color">아이디*</em>
				</label>
			</div>
			<div class="join_col_input">
				<div class="input_wrap">
					<div class="ui_input">
						<input type="text" name="id" maxlength="15" id="id">
						<span class="placeholder">아이디를 입력해주세요.</span>
						<input type="button" value="중복확인" id="idoverlap" onclick="idcheck()">  
						<span id="result"></span><br>
					</div>
					<!-- <button type="button" class="id_button">메일 발송</button> -->
				</div>
			</div>
		</div>
		
		
		비밀번호*<input type="text" name="pwd"><br>
		이메일*<input type="text" name="email"><br>
		생년월일*<input type="text" name="year"><br>
		전화번호*<input type="text" name="phone"><br>
		<input type="submit" value="등록">
	</form>
</div>
</body>
<script type="text/javascript">
	function check(){
		var name=document.getElementsByName("name")[0];
		var id=document.getElementsByName("id")[0];
		var pwd=document.getElementsByName("pwd")[0];
		var email=document.getElementsByName("email")[0];
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
		if(pwd.value.trim()==""){
			alert("비밀번호를 입력하세요.");
			pwd.focus();
			return false;
		}
		if(email.value.trim()==""){
			alert("이메일을 입력하세요.");
			email.focus();
			return false;
		}
		if(year.value.trim()==""){
			alert("생년월일을 입력하세요.");
			year.focus();
			return false;
		}
		if(phone.value.trim()==""){
			alert("전화번호를 입력하세요.");
			phone.focus();
			return false;
		}
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
			xhr.open('get','idcheck.jsp?id=' + id,true);
			xhr.send();
		}
	};
</script>
</html>