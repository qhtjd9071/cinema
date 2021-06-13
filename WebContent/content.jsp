<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>content.jsp</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/content.css">
</head>

<body>
	<div class="visual_main">
		<jsp:include page="slide.jsp"/>
	</div>
	
	<div class="contents_main">
		<div class="movie_current_list"></div>
		<div class="main_specialCinema">
			<div class="sec_tit">스페셜관</div>
			<ul class="special_wrap">
				<li><a><img src="images/main/e2a94c82115c46f7b326baee6e10266a.png"></a></li>
				<li><a><img src="images/main/3ffca854b1844fdc8b54d8d9db45a03f.png"></a></li>
				<li><a><img src="images/main/ff43cb260a2647dbb5f3c62b709103c4.png"></a></li>
				<li><a><img src="images/main/c9078226c9ad4085b1b629bee2aba138.png"></a></li>
				<li><a><img src="images/main/61fb906fbd9b4ff1b34d6e0bd78dc655.png"></a></li>
				<li><a><img src="images/main/2a366799460a49359bf93250f50852cf.png"></a></li>
				<li><a><img src="images/main/208a5ede362244fb8ab2e5cc3ab07529.png"></a></li>
				<li><a><img src="images/main/5c23288d3a104f7fa4f7d3e725a2c6a8.png"></a></li>
			</ul>
			<button type="button" class="btn_txt_more">더보기</button>
		</div>
		<div class="main_eventList">
			<div class="sec_tit2">이벤트</div>
			<div class="event_wrap">
				<ul class="img_wrap">
					<li class="img_01"><a><img src="images/main/91d9f244442e477ca5bee3256ba362e6.jpg"></a></li>
					<li class="img_01"><a><img src="images/main/00ca0af6ef4c4dd481774b91e2fb980e.jpg"></a></li>
					<li class="img_02"><a><img src="images/main/f8505b1c5a624944b31359da8d0ae7ee.jpg"></a></li>
					<li class="img_03"><a><img src="images/main/Inbyu_295511.png"></a></li>
					<li class="img_04"><a><img src="images/main/54250fc5c47844bea4e6e4c212a1957e.jpg"></a></li>
					<li class="img_01"><a><img src="images/main/08e094fe46c54072b80b3228068aa597.jpg"></a></li>
				</ul>
			</div>
			<button type="button" class="btn_txt_more">더보기</button>
		</div>
		<div class="main_premiere">
			<div class="sec_tit2">시사회/무대인사</div>
			<div class="premiere_container">
				<ul class="premiere_wrap">
				<li><a><img src="images/main/396466108a034230a569310229027f80.jpg"></a></li>
				<li><a><img src="images/main/opera.jpg"></a></li>
				<li><a><img src="images/main/e9f290989a4b4c1b8385a36ed0ddc3ca.jpg"></a></li>
			</ul>
			</div>
			<button type="button" class="btn_txt_more" onclick="location.href='${pageContext.request.contextPath}/event'">더보기</button>
		</div>
		<div class="mid_menu_wrap">
			<a><img src="images/main/3423e358b74d49d5b12867c7d9c6f6a8.png"></a>
			<a><img src="images/main/16b056e5e6a04c609b94a5c21e786d3b.png"></a>
			<a><img src="images/main/9fd4a77cd6a44a39aa35d07e5bb8a010.png"></a>
			<a><img src="images/main/3633088df0644062b53cd88b34067895.png"></a>
			<a><img src="images/main/9c4e2721ecdd488d86df6d27e3c2a000.png"></a>
		</div>
		<div class="main_notice">
			<div class="sec_tit3">공지사항</div>
			<div class="rolling_menu_wrap">
				<ul class="rolling_menu">
					<li><a>로또시네마 관람요금 변경안내</a></li>
					<li><a>모바일로또상품권 시스템 점검 작업 안내</a></li>
					<li><a>로또시네마 시스템 점검 안내</a></li>
					<li><a>로또시네마 개인정보 처리방침 개정 안내</a></li>
					<li><a>푸시(알림) 서비스 점검 안내</a></li>
					<li><a>모바일관람권 시스템 점검 작업 안내</a></li>
					<li><a>로또시네마 시스템 점검 안내</a></li>
					<li><a>L.POINT 일부 서비스 일시 중단 안내</a></li>
					<li><a>로또시네마 시스템 점검 안내</a></li>
					<li><a>SKT T멤버십 영화예매 티켓 승급금액 반영 안내</a></li>
					<li><a>2021년 틴틴클럽/브라보클럽 안내</a></li>
					<li><a>로또시네마 회원약관 및 개인정보처리방침 개정 안내</a></li>
					<li><a>영화관람권 가격 변경 안내</a></li>
					<li><a>카카오페이 서비스 일시 중단 안내</a></li>
					<li><a>(극장판 귀멸의 칼날 : 무한열차편) 스페셜 굿즈 이벤트 관련 안내</a></li>
					<li><a>로또시네마 영상정보처리기기 운영 및 관리방침 개정 안내</a></li>
					<li><a>로또시네마 관람요금 변경안내</a></li>
				</ul>
			</div>
			<button type="button" class="btn_txt_more" onclick="location.href='${pageContext.request.contextPath}/ntlist'">더보기</button>
		</div>
	</div>
</body>
<script>
        let rolling_menu=document.querySelector(".rolling_menu");
        function move(){
        	let curIndex=0;
            setInterval(function(){
            	rolling_menu.style.transition = '0.2s';
            	rolling_menu.style.transform = "translate(0px, -"+15*(curIndex+1)+"px)";
                curIndex++;
                if(curIndex === 16){
                    setTimeout(function(){
                        ul.style.transition = '0s';
                        ul.style.transform = "translate(0px, 0px)";
                    },201)
                    curIndex = 0;
                }
            },500);
        }
        document.addEventListener("DOMContentLoaded",move());
    </script>
</html>