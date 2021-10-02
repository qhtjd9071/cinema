<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>영화 선택</title>
</head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="${cp}/resources/css/booking.css">
<link rel="stylesheet" href="${cp}/resources/css/header2.css">
<link rel="stylesheet" href="${cp}/resources/css/footer.css">
</head>

<body>

<div class="header2">
	<jsp:include page="../layout/header.jsp"/>
</div>

<div id="content" class="booking_container">
	<div class="booking_wrapper_container">
		<div class="wrap_booking"> 
				<div class="theater-part">
			        <div class="booking-title">
			        	<h4 class="booking-title-top">극장</h4>
		        	</div>
			        <div id="theaterLoc-list" class="theater_inner">
			        	<ul class="tab_wrap.outer">
			        		<li class="movie_wrap_inner1">
				        		<button type="button" class="location">
				        			<span>지역</span>
				        		</button>	
				        		<c:forEach var="vo" items="${list}">
				        			<div class="theaterLoc-list" onclick='theaterNameList("${vo.location}")'> ${vo.location} </div>
				        		</c:forEach>
				        	</li>
				        	<li class="movie_wrap_inner2">
				        		<button type="button" class="theater_name">
				        			<span>영화관</span>
				        		</button>
					        	<div id="theaterName-list" class="theaterName_list"></div>
				        	</li>
			        	</ul>
			        </div>
			    </div>
			    <div class="movie-part">
			        <div class="booking-movie">
			        	<h4 class="booking-move-top">영화목록</h4>
			        </div>
			        <div class="sort-wrapper">
							<select id="movieField" class = "movieField" onchange="changeMovie()">
								<option value="starOrder">평점순</option>
							</select>	
			        </div>
			        <div id="movie-list" class="movie-list"></div>
			    </div>
			    <div class="date-part">
			        <div class="booking-date">
			        	<h4 class="booking-move-top">날짜</h4>
			        </div>
			        <div class="booking_date_wrap">
				        <div id="year-month" class="year_month"></div>
				        <div id="date-list" class="date_list"></div>
			        </div>
			    </div>
			    <div class="time-part">
			        <div class="booking-title">
			        	<h4 class="booking-title-top">상영시간표</h4>
			        </div>
			        <div>
			   		  	<div id="show-list"></div>
			        </div>
		    </div>
		</div>
	</div>
</div>
<div class="footer">
	<jsp:include page="../layout/footer.jsp"/>
</div>

<script type="text/javascript">

	var curDate;
	var curTheaterName;
	var curMovieTitle;
	var curRoomNum;
	
	function theaterNameList(location){
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				let result = xhr.responseText;
				let theaterName_list = document.getElementById("theaterName-list");
				let jsonArr = JSON.parse(result);
				theaterName_list.innerHTML = "";
				for(let i=0; i<jsonArr.length; i++){
					let div = document.createElement("div");
					let theaterName = jsonArr[i].theaterName;
					div.innerHTML = theaterName + "<br>";
					div.className = "theaterNameBox";
					div.onclick=function(){
						curTheaterName = theaterName;
						movieList(curTheaterName);
					}
					theaterName_list.appendChild(div);
				}
			}
		};
		xhr.open('post','${cp}/book/theater?location=' + location, true)
		xhr.send();
	}
	
	function changeMovie(){
		let sort = "starCount";
		let movieField = document.getElementById("movieField")
		let mfIndex = movieField.options[movieField.selectedIndex].value;
		sort = mfIndex;
		movieList(curTheaterName,sort);
	}
	
	function movieList(curTheaterName,sort){
		if(sort == undefined) sort='starCount';
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				
				let result = xhr.responseText;
				let movie_list = document.getElementById("movie-list");
				let movList = JSON.parse(result);
				movie_list.innerHTML = "";
				for(let i=0; i<movList.length; i++){
					let div2 = document.createElement("div");
					let movieTitle = movList[i].TITLE;
					div2.innerHTML = movieTitle + "<br>";
					div2.className = "movieListBox";
					div2.onclick=function(){
						curMovieTitle = movieTitle;
					}
					movie_list.appendChild(div2);
				}	
				
			}
		};
		xhr.open('post','${cp}/book/movieList?theaterName=' + curTheaterName +'&sort=' + sort, true)
		xhr.send();
	}
	
 	function createDate(){
	 
	 	const date_list = document.getElementById("date-list"); // 날짜 요일 저장할 곳
	   	const year_month = document.getElementById("year-month"); // 년도 월 저장할 곳
	 	
	 	var today = new Date();
	 	
	 	var year = today.getFullYear();
	 	var month = today.getMonth() + 1;
	 	var date = today.getDate();
	 	var lastDate = new Date(today.getFullYear(), today.getMonth() + 1, 0); //한달의 마지막날
	 	var day = today.getDay();
	 	
	 	var weekOfDay = ["일", "월", "화", "수", "목", "금", "토"];
	 	
	 	var html = "<ul>";
	 	
	 	for(var i=0; i<5; i++){
	 		var printDate = (date+i > lastDate)? (date + i) - lastDate : date + i;
	 		var printDay = (day + i >= 7)? (day + i) - 7 : day + i;
	 		var printMonth = (date+i > lastDate)? month + 1 : month;
	 		var printYear = year;
	 		if(printMonth >= 13) {
	 			printMonth = 1;
	 			printYear += 1;
	 		}

	 		
	 		var li = '<li';
	 		if(printDay == 0) li += ' class="sunday" style="color: red;"';
	 		if(printDay == 6) li += ' class="saturday" style="color: blue;"';
	 		li += ' onclick="selectDate(' + printYear + ',' + printMonth + ',' + printDate + ')">' + printDate + " " + weekOfDay[printDay] + "</li>";
	 		
	 		html += li;
	 	}
	 	
		for(var i=5; i<10; i++){
			var printDate = (date+i > lastDate)? (date + i) - lastDate : date + i;
	 		var printDay = (day + i >= 7)? (day + i) % 7 : day + i;
	 		var printMonth = (date+i > lastDate)? month + 1 : month;
	 		var printYear = year;
	 		if(printMonth >= 13) {
	 			printMonth = 1;
	 			printYear += 1;
	 		}
	 		
	 		var li = '<li style="color: gray;" class="off';
	 		if(printDay == 0) li += ' sunday';
	 		if(printDay == 6) li += ' saturday';
	 		li += '" onclick="selectDate(' + printYear + ',' + printMonth + ',' + printDate + ')">' + printDate + " " + weekOfDay[printDay] + "</li>";
	 		
	 		html += li;
	 	}
		
		html += "</ul>";
		
		year_month.innerHTML = year + "-" + month;
		date_list.innerHTML = html;
 	}
 
 	window.onload = function(){
 		createDate();
 	}
 	function selectDate(year, month, date){
		curDate = year + "/" + month + "/" + date;
		// 상영관, 상영시간 정보 얻어오기
		showList(curDate,curMovieTitle,curTheaterName);
	}
 	
    function showList(curDate,curMovieTitle,curTheaterName){
    	let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				let result = xhr.responseText;
				let jsonArr = JSON.parse(result);
				let show_list = document.getElementById("show-list");
				show_list.innerHTML = "";
				for(let i=0; i<jsonArr.length; i++){
					let json = jsonArr[i];
					let div3 = document.createElement("div");
					let roomNum = json.ROOMNUM;
					let seatCount = json.SEATCOUNT;
					div3.innerHTML = roomNum + "관 " + seatCount + "석" + "<br>";
					div3.className = roomNum;
					div3.className += " showListBox";
					show_list.appendChild(div3);
					timeList(curDate,curMovieTitle,curTheaterName,roomNum);
				}	
			}
		};
		xhr.open('get','${cp}/api/book/showList?begintime=' + curDate +'&movieTitle=' + curMovieTitle + '&theaterName=' + curTheaterName,true)
		xhr.send();
    }
    
  
    function timeList(curDate,curMovieTitle,curTheaterName,roomNum){
    	let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				let result = xhr.responseText;
				let time_list = document.getElementsByClassName(roomNum)[0];
				let jsonArr = JSON.parse(result);
				for(let i=0; i<jsonArr.length; i++){
					let json = jsonArr[i];
					let div4 = document.createElement("div");
					let begintime = json.BEGINTIME;
					let beginhour = new Date(begintime);
					let beginMin = (beginhour.getMinutes()<10?'0':'') + beginhour.getMinutes();
					let showId = json.ID;
					div4.innerHTML = beginhour.getHours() + " : " + (beginhour.getMinutes()<10?'0':'') + beginhour.getMinutes() + "<br>";
					div4.className = "timeListBox";
					div4.onclick=function(){
						location.href = "${cp}/book/countPeople?showId=" + showId;
					}
					time_list.appendChild(div4);
				}	
			}
			
		};
		xhr.open('post','${cp}/api/book/timeList', true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		let params = "begintime=" + curDate + "&movieTitle=" + curMovieTitle + "&theaterName=" + curTheaterName + "&roomNum=" + roomNum;
		xhr.send(params);
    }	   
</script>
</body>
</html>