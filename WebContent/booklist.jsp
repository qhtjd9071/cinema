<%@page import="semi.vo.bookVo"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>좌석 선택</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/booklist.css">
<link rel="stylesheet" href="css/header2.css">
<link rel="stylesheet" href="css/footer.css">
<style type="text/css">
	#seatArea{width:600px;margin:0 auto; margin-top:50px; margin-bottom:50px;}
	#seatArea div{width:50px;height:50px;text-align:center;background-color:gray;display:inline-block;margin:10px; line-height:50px !important;}
	#rating{width:200px;hegiht:150px;margin:0 auto;color:blue}
	.btn{
			width:100px;
			background-color: #f8585b;
			border: none;
			color:white;
			padding: 15px 0;
			text-align: center;
			text-decoration: none;
			display: inline-block;
			font-size: 15px;
			margin: 4px;
			border-radius:10px;
			background-color:black;
			position: absolute; 
  			left: 45.5%; 
			cursor: pointer;
		}
</style>
<script type="text/javascript">
		//배열 초기화
		const book=new Array(${getCount });
		for(let i=0;i<book.length;i++){
			book[i]="";
		}
		const count=new Array(${getCount });
		for(let i=0;i<count.length;i++){
			count[i]=0;
		}
		let selectCount=0;
</script>
</head>
<body>
<div class="header2">
	<jsp:include page="header2.jsp"/>
</div>

<div class="count_container">
<div class="count_wrapper_container">
	<div class="count_wrapper">
		<div class="seat_select">
			<div class="group_top">
				<h4>좌석 선택</h4>
			</div>
			<div class="seat_inner">
				<div class="screen">SCREEN</div>
				<div id="seatArea"></div>
				<input type="button" value="결제하기" id="btn" onclick="transfer()" class="btn">
			</div>
		</div>
	</div>
</div>
</div>

<c:forEach var="i" begin="1" end="${getCount }">
<c:forEach var="vo" items="${list}">
	<script type="text/javascript">
	function cnt(){
		if(${vo.seatNum==i}){
			count[${i}-1]+=1;
		}
	}
	cnt();
	</script>
</c:forEach>
<script type="text/javascript">
	function controllSeat(){
		const seatArea=document.getElementById("seatArea");
		//좌석 배열
		let div=document.createElement("div");
		let seatNum=${i}%8;
		if(${i}%8==0){
			seatNum=8;
		}
		if(${i}/8<=1){
			div.innerHTML="A"+seatNum;
		}else if(${i}/8<=2){
			div.innerHTML="B"+seatNum;
		}else if(${i}/8<=3){
			div.innerHTML="C"+seatNum;
		}else if(${i}/8<=4){
			div.innerHTML="D"+seatNum;
		}else if(${i}/8<=5){
			div.innerHTML="E"+seatNum;
		}else if(${i}/8<=6){
			div.innerHTML="F"+seatNum;
		}else if(${i}/8<=7){
			div.innerHTML="G"+seatNum;
		}else if(${i}/8<=8){
			div.innerHTML="H"+seatNum;
		}
		seatArea.appendChild(div);
		
		//좌석에 값 할당
		let input=document.createElement("input");
		input.type="hidden";
		let input2=document.createElement("input");
		input2.type="hidden";
		input2.value=${i};
		if(count[${i}-1]!=0){
			div.style.backgroundColor="red";
			input.value="using";
		}
		
		//좌석 클릭처리
		div.addEventListener("click",function(e){
			if(input.value=="using"){
				alert("예매된 좌석입니다");
			}else{
				if(input.value=="check"){
					div.style.backgroundColor="gray";
					input.value="none";
					book[${i}-1]="";
					selectCount-=1;
				}else{
					if(selectCount<${totalCount}){
					div.style.backgroundColor="pink";
					input.value="check";
					book[${i}-1]=input2.value;
					selectCount+=1;
					}
				}
			}
		});
	}
	controllSeat();
	</script>
</c:forEach>
<script type="text/javascript">
	//서버로 선택좌석 정보 전송
	function transfer(){
		if(selectCount<${totalCount}){
			alert("좌석을 선택하세요");
		}else{
			var parameter={"showNum":${showNum},"price":${price},"array":book}
			var aa=JSON.stringify(parameter);
			let xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4 && xhr.status==200){
						let json=xhr.responseText;
						let bna=JSON.parse(json);
						kakaoPay(xhr,json);
					}
			}
			xhr.open("post","book",true);
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			xhr.send("aa="+aa);
		}
	}
	
	function kakaoPay(xhr,json){
		let toss={"bookNum":json,"id":"${sessionScope.id}","title":"${movieTitle}","count":selectCount,"total":${price*adultCount}+${price*0.7*teenCount}};
		let jsonToss=JSON.stringify(toss);
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
					let json=xhr.responseText;
					location.href=json;
				}
		}
		xhr.open("post","kakao",true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send("toss="+jsonToss);
	}
</script>
<script type="text/javascript">
		//결제페이지에서 뒤로가기 방지
		window.history.forward();
		function noBack() {
			window.history.forward();
		}
</script>
<div class="footer">
	<jsp:include page="footer.jsp"/>
</div>
</body>
</html>