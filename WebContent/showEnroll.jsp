<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/movieEnroll.css">
<link rel="stylesheet" href="css/header2.css">
<link rel="stylesheet" href="css/footer.css">
<style type="text/css">
	.wrapper{display:flex; justify-content:space-between;}
	.movieList{width:550px;height:500px;overflow:scroll;}
	.movieList div{display:flex;flex-direction:column;width:500px;height:200px;}
	.movieImg{width:100px;height:180px;}
</style>
</head>
<body>
	<div class="header2">
		<jsp:include page="header2.jsp"/>
	</div>
	
	<div class="movie">
		<div class="movie_container">
		
		<h1>상영등록</h1>
		<div class="wrapper">
			<div class="inputDiv" id="inputDiv">
				<form method="post" action="${pageContext.request.contextPath}/admin?cmd=showEnroll">
				영화제목
				<input type="text" id="title" readonly="readonly">
				<input type="hidden" id="movieNum" name="movieNum">
				상영시작시간
				<input type="date" name="beginDate" id="beginDate">
				<input type="time" name="beginTime" id="beginTime">
				<input type="hidden" name="begin" id="begin">
				상영종료시간
				<input type="date" name="endDate" id="endDate">
				<input type="time" name="endTime" id="endTime">
				<input type="hidden" name="end" id="end">
				<input type="submit" value="등록">
				상영관
				<input type="text" id="room" readonly="readonly">
				<input type="hidden" id="roomSerialNum" name="roomSerialNum">
				가격
				<input type="text" name="price">원
				</form>
			</div>
			영화목록
			<div class="movieList" id="movieList"></div>
			상영목록
			<div class="roomList" id="roomList"></div>
		</div>

		</div>
	</div>
	
	<div class="footer">
		<jsp:include page="footer.jsp"/>
	</div>
<script type="text/javascript">
	const beginDate=document.getElementById("beginDate");
	const begintTime=document.getElementById("beginTime");
	const begin=document.getElementById("begin");
	const endDate=document.getElementById("endDate");
	const emdtTime=document.getElementById("endTime");
	const end=document.getElementById("end");
	
	beginDate.addEventListener("change",()=>date(beginDate, begin));
	beginTime.addEventListener("change",()=>time(beginDate, beginTime, begin));
	endDate.addEventListener("change",()=>date(endDate, end));
	endTime.addEventListener("change",()=>time(endDate, endTime, end));
	
	function date(param1, param2) {
		param2.value=param1.value;
	}
	function time(param1, param2, param3) {
		if(param1.value==""){
			alert("날짜를 먼저 입력해주세요");
		}else{
			param3.value+=" "+param2.value;
			alert(param3.value);
		}
	}
</script>
<script type="text/javascript">
	const movieList=document.getElementById("movieList");
	const title=document.getElementById("title");
	const movieNum=document.getElementById("movieNum")
	
	const roomList=document.getElementById("roomList");
	const room=document.getElementById("room");
	const roomSerialNum=document.getElementById("roomSerialNum");
	
	function rlist(){
		let xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				let jsonArr=JSON.parse(xhr.responseText);
				for(let i=0;i<jsonArr.length;i++){
					let json=jsonArr[i];
					let div=document.createElement("div");
					div.innerHTML=json.theaterName+" "+json.roomNum+"번 상영관";
					roomList.appendChild(div);
					div.addEventListener("click",function(e){
						roomSerialNum.value=json.roomSerialNum;
						room.value=json.theaterName+" "+json.roomNum+"번 상영관";
					});
					
				}
			}
		}
		xhr.open("post", "${pageContext.request.contextPath}/rlist", true);
		xhr.send();
	}
	rlist();
	function mlist(){
		let xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				let jsonArr=JSON.parse(xhr.responseText);
				for(let i=0;i<jsonArr.length;i++){
					let json=jsonArr[i];
					let div=document.createElement("div");
					div.innerHTML=json.movieTitle;
					movieList.appendChild(div);
					let movieImg=document.createElement("img");
					movieImg.src=json.image;
					movieImg.className="movieImg";
					div.appendChild(movieImg);
					
					div.addEventListener("click",function(e){
						movieNum.value=json.movieNum;
						title.value=json.movieTitle;
					});
					
				}
			}
		}
		xhr.open("post", "${pageContext.request.contextPath}/mlist", true);
		xhr.send();
	}
	mlist();
	
</script>
</body>
</html>