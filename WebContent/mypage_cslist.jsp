<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id=(String)session.getAttribute("id");
	String pwd=(String)session.getAttribute("pwd");
%>
<!DOCTYPE html>
<html>
<head>
<title>내 문의내역</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/header2.css">
<link rel="stylesheet" href="css/mypage_payList.css">
<link rel="stylesheet" href="css/footer.css">
</head>

<body>
<div class="header2">
	<jsp:include page="header2.jsp"/>
</div>

<div class="mypage">
	<div class="mypage_container">
		<div class="mypage_lnb_wrap">
			<nav class="mypage_lnb">
				<p><a href="#">나의 로또시네마</a></p>
				<ul>
					<li><a href="${pageContext.request.contextPath }/payList">예매 내역</a></li>
					<li><a href="${pageContext.request.contextPath }/inquiry">나의 문의 내역</a></li>
					<li><a onclick="updatePop('<%=id %>','<%=pwd %>')">MY 정보관리</a></li>
					<li><a href="${pageContext.request.contextPath }/mypage_delAccount.jsp">회원 탈퇴</a></li>
				</ul>
			</nav>
		</div>
		<div class="mypage_content">
			<jsp:include page="myInquiry.jsp"/>
		</div>
	</div>
</div>

<div class="footer">
	<jsp:include page="footer.jsp"/>
</div>

<script type="text/javascript">
	function updatePop(id, pwd) {
		var pw=prompt("비밀번호를 입력하세요.","");
		if(pwd==pw) {
			location.href="${pageContext.request.contextPath }/update?id="+id;
		} else {
			alert("비밀번호가 일치하지 않습니다.");
		}
	}
</script>
</body>
</html>