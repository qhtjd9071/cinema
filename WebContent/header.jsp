<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>header.jsp</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/header.css">
</head>

<body>
<div class="header">
	<h1 class="logo">
		<a href="https://www.lottecinema.co.kr/NLCHS/">LOTTE CINEMA</a>
	</h1>
	
	<div class="gnb">
		<ul class="g_menu1">
			<li><a href="https://www.lottecinema.co.kr/NLCHS/Mypage/MemberVipzone">멤버십</a></li>
			<li><a href="https://www.lottecinema.co.kr/NLCHS/Customer">고객센터</a></li>
			<li><a href="https://www.lottecinema.co.kr/NLCHS/Member/login">로그인</a></li>
		</ul>
		
		<ul class="g_menu2">
			<li><a href="https://www.lottecinema.co.kr/NLCHS/Membership/l_point" class="btn_my">회원가입</a></li>
			<li><a href="https://www.lottecinema.co.kr/NLCHS/Ticketing" class="btn_reserve">바로 예매</a></li>
			<li>
				<a class="btn_menu_all">전체 메뉴 레이어 열기</a>
				<div id="allmenu"></div>
			</li>
		</ul>
	</div>
	
	<div class="nav">
		<ul>
			<li><a href="https://www.lottecinema.co.kr/NLCHS/Ticketing" class="nav_ticketing">예매</a></li>
			<li><a href="https://www.lottecinema.co.kr/NLCHS/Movie" class="nav_movie">영화</a></li>
			<li><a href="https://event.lottecinema.co.kr/NLCHS/Event" class="nav_event">이벤트</a></li>
			<li><a href="https://www.lottecinema.co.kr/NLCHS/Customer/NoticeList" class="nav_noticelist">공지사항</a></li>
		</ul>
	</div>
</div>
</body>
</html>