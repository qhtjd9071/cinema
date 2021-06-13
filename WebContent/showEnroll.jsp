<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>상영등록</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/showEnroll.css">
</head>
<body>

<div class="header">
	<jsp:include page="ad_header.jsp"/>
</div>

<div class="content">
	<div class="content_container">
		<h1>상영등록</h1>
		<div class="wrapper">
			<form method="post" action="${pageContext.request.contextPath}/admin?cmd=showEnroll" class="inputDiv">
				<ul>
					<li>
						<h3>영화제목</h3>
						<input type="text" id="title" readonly="readonly">
						<input type="hidden" id="movieNum" name="movieNum">
					</li>
					<li>
						<h3>상영관</h3>
						<input type="text" id="room" readonly="readonly">
						<input type="hidden" id="roomSerialNum" name="roomSerialNum">
					</li>
					<li>
						<h3>가격</h3>
						<input type="text" name="price"> 원
					</li>
				</ul>
				<ul>
					<li class="movietime">
						<h3>상영시작시간</h3>
						<input type="date" name="beginDate" id="beginDate">
						<input type="time" name="beginTime" id="beginTime">
						<input type="hidden" name="begin" id="begin">
					</li>
					<li class="movietime">
						<h3>상영종료시간</h3>
						<input type="date" name="endDate" id="endDate">
						<input type="time" name="endTime" id="endTime">
						<input type="hidden" name="end" id="end">
						<input type="submit" value="등록" class="timesubmit">
					</li>
				</ul>
			</form>
			<ul class="listul">
				<li>
					<div class="roomlist">
						<h3>상영목록</h3>
						<div class="roomlist1" id="roomList"></div>
					</div>
				</li>
				<li>
					<div class="movielist">
						<h3>영화목록</h3>
						<ul class="movielist1" id="movieList"></ul>
					</div>
				</li>
			</ul>
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
					let li=document.createElement("li");
					li.innerHTML=json.movieTitle;
					movieList.appendChild(li);
					let movieImg=document.createElement("img");
					movieImg.src=json.image;
					movieImg.className="movieImg";
					li.appendChild(movieImg);
					
					li.addEventListener("click",function(e){
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