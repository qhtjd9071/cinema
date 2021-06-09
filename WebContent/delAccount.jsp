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
<link rel="stylesheet" href="css/delaccount.css">
<link rel="stylesheet" href="css/footer.css">
</head>

<body>
<div class="delaccount">
	<h1>회원탈퇴</h1>
	[주의] 메가박스 회원탈퇴를 신청하기 전에 안내 사항을 꼭 확인해주세요.
	
	1. 30일간 회원 재가입이 불가능합니다.
	
	회원 탈퇴 후, 30일 경과 후 재가입할 수 있습니다.
	2. 탈퇴 후 삭제 내역
	
	(회원 탈퇴하시면 회원정보와 개인 보유 포인트 등 정보가 삭제되며 데이터는 복구되지 않습니다.)
	
	메가박스 멤버십 포인트 및 적립/차감 내역
	관람권 및 쿠폰
	영화 관람 내역
	간편 로그인 연동 정보
	3. 고객님께서 불편하셨던 점, 아쉬웠던 점을 알려주시면 앞으로 더 나은 모습으로 찾아 뵙겠습니다.
	
	서비스 장애가 잦아서
	이벤트 및 무료서비스 혜택이 적어서
	불만 및 불편사항에 대한 고객응대가 나빠서
	영화관람시 시설 및 가격등의 불만 때문에
	이용빈도가 낮고 개인정보 유출이 우려되어
	탈퇴 후 재가입을 위해
	기타 
	휴면계정 만료
	4. 회원님의 비밀번호를 입력하시고 [탈퇴] 버튼을 클릭해주세요.
		<table>
			<tr>
				<td>비밀번호</td>
				<form action="delCon" method="post">
					<td><input type="password" name="pwd"></td>
					<td><input type="submit" value="확인"></td>
				</form>
			</tr>
		</table>
</div>
</body>
</html>