<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/header2.css">
<link rel="stylesheet" href="css/footer.css">
</head>
<body>
<%
	Cookie[] cooks=request.getCookies();
	String id="";
	String pwd="";
	boolean checked=false;
	if(cooks!=null){
		for(Cookie c:cooks){
			String name=c.getName();
			String value=c.getValue();
			if(name.equals("id")){
				id=value;
				checked=true;
			}else if(name.equals("pwd")){
				pwd=value;
			}
		}
	}
%>

<div class="header2">
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
								<form class="login_area" method="post" action="login">
									<input type="text" name="id" value="<%=id %>" id="userId" class="login_id" maxlength="50" placeholder="아이디 또는 이메일을 입력해 주세요.">
									<input type="password" name="pwd" value="<%=pwd %>" id="userPwd" class="login_pwd" maxlength="15" placeholder="비밀번호를 입력해 주세요.">
									<!-- <button type="button" class="btn_login">로그인</button> -->
									<input type="submit" class="btn_login" value="로그인">
									<div class="login_bot_wrap">
										<div class="login_check">
											<%
												if(checked){
											%>
												<input type="checkbox" name="chk" class="loginchkid" id="checkSavedID" checked="checked">
												<label for="checkSavedID" class="loginchkid_label">아이디 저장</label>
											<% 
												} else{
											%>
												<input type="checkbox" name="chk" class="loginchkid" id="checkSavedID">
												<label for="checkSavedID" class="loginchkid_label">아이디 저장</label>
											<%
												}
											%>
										</div>
									</div>
								</form>
								<div class="login_bot_wrap">
									<div class="login_menu">
										<a href="${pageContext.request.contextPath }/join.jsp">회원가입</a>
										<a href="${pageContext.request.contextPath }/findid.jsp">아이디 찾기</a>
										<a href="${pageContext.request.contextPath }/findpwd.jsp">비밀번호 찾기</a>
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

<div class="footer">
	<jsp:include page="footer.jsp"/>
</div>
<script type="text/javascript">
	let msg='${errMsg}';
	if(msg!='') {
		alert(msg);
	}
</script>
</body>
</html>