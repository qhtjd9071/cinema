<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id=(String)session.getAttribute("id");
	String pwd=(String)session.getAttribute("pwd");
%>
<!DOCTYPE html>
<html>
<head>
<title>mypage.jsp</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/header2.css">
<link rel="stylesheet" href="css/mypage.css">
<link rel="stylesheet" href="css/footer.css">
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
</head>

<body>
<div class="header2">
	<jsp:include page="header2.jsp"/>
</div>

<div class="mypage">
	<a href="${pageContext.request.contextPath }/reservation.jsp">예매 내역</a>
	<a href="${pageContext.request.contextPath }/inquiry.jsp">나의 문의 내역</a>
	<!-- <a href="${pageContext.request.contextPath }/update">MY 정보 관리</a> -->
	<input type="button" value="MY 정보 관리" onclick="updatePop('<%=id %>','<%=pwd %>')"/>
	<a href="${pageContext.request.contextPath }/delAccount.jsp">회원 탈퇴</a>
</div>

<div class="footer">
	<jsp:include page="footer.jsp"/>
</div>
</body>
</html>