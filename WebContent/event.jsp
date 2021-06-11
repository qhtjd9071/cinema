<%@page import="lsh.dao.EventDao"%>
<%@page import="semi.vo.eventVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EventDetai1l</title>
</head>
<body>
<!-- 이벤트 정보 -->

<div class="contents_event">
	<div class="evnt_img"><img src="${vo.eventImage }"></div>
	<div class="list_bdr_box">
		<h3 class="title txt_caution2">유의사항</h3>
		<div class="list_inner_box">
			● SIGNATURE ART CARD의 경우 150*200mm의 대형 사이즈 프리미엄 아트카드로 제작되었습니다.<br>
			● &lt;콰이어트 플레이스2&gt; SIGNATURE ART CARD의 앞면은 입체 렌티큘러 카드로 제작되었습니다.<br>
			● 실물티켓 인증 시에만 경품이 증정되며 PC/모바일앱(웹) 및 키오스크 예매티켓의 경우 상영 시작 1시간 이후 1회에 한해 실물 티켓 재출력 가능합니다.<br>
			● 본 이벤트 경품은 선착순으로 증정하며, 조기소진 될 수 있습니다. (소진 시점 지점별 상이)<br>
			● 본 경품은 관람 당일 티켓으로 관람 지점에서 &lt;콰이어트 플레이스2&gt; 관람 후 수령가능합니다.<br>
			● 본 경품의 경우 렌티큘러 보호필름이 부착되어있으며, 스크래치 및 먼지등의 경우 보호필름 위에 생긴 것들입니다.<br> 
			&nbsp;&nbsp; 이에따라, 보호필름을 제거하셔야 선명한 렌티큘러 효과를 보실수있습니다.<br>
			● 티켓 환불 시에는 경품도 함께 반납하셔야합니다.<br>
			● 1좌석 당 특전 1개가 증정됩니다.<br>
			● 경품 이미지는 실제와 차이가 있을 수 있습니다.<br>
			● 본 경품의 경우 공정 과정상 미세 스크래치, 흠집등이 있을 수 있으며, 이와 같은 사유는 교환 사유가 될 수 없습니다. (보호필름 제거 시 교환불가)
		</div>
	</div>
	<div class="btn_btm_wrap">
		
	</div>
</body> 
</html>