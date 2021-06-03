<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title> lhj_booking.jsp </title>
<style type="text/css">
	.main{width: 1000px; height: 800px; background-color: gray;}
</style>
</head>
<body>
<div id="content" class="main">
	<div class="theater-part">
        <div class="booking-title">극장</div>
        <div id="theaterLoc-list">
        	<ul>
        		<c:forEach var="vo" items="${ requestScope.theaterList }">
        			<li onclick='theaterNameList("${vo.location}")'> ${ vo.location } </li>
        		</c:forEach>
        	</ul>
        </div>
        <div id="theaterName-list"></div>	
    </div>
    <div class="movie-part">
        <div class="booking-title">영화</div>
        <div class="sort-wrapper">
				<select id="movieField" onchange="changeMovie()">
					<option value="bookCount">관람순</option>
					<option value="starCount">평점순</option>
				</select>	
        </div>
        <div id="movie-list"></div>
    </div>
    <div class="date-part">
        <div class="booking-title">날짜</div>
        <div id="year-month"></div>
        <div id="date-list"></div>
    </div>
    <div class="time-part">
        <div class="booking-title">시간</div>
        <div>
   		  	<div id="show-list"> 관/석  </div>
   			<div id="time-list"> 상영시간</div>
        </div>
    </div>
</div>


<script type="text/javascript">
var vtheaterName='';
	function theaterNameList(location){
		//console.log(location);
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				let xml = xhr.responseXML;
				let theaterName_list = document.getElementById("theaterName-list");
				let tnList = xml.getElementsByTagName("tnList");
				theaterName_list.innerHTML = "";
				for(let i=0; i<tnList.length; i++){
					let div = document.createElement("div");
					let theaterName = tnList[i].getElementsByTagName("name")[0].textContent;
					div.innerHTML = theaterName + "<br>";
					div.className = "theaterNameBox";
					div.onclick=function(){
						vtheaterName=theaterName;
						//alert(this.inner)
						movieList(theaterName);
					}
					theaterName_list.appendChild(div);
				}	
			}
		};
		xhr.open('get','${pageContext.request.contextPath}/theater?location=' + location, true)
		xhr.send();
	}
	
	
	function changeMovie(){
		let cmv = "base";
		let movieField = document.getElementById("movieField")
		let mfIndex = movieField.options[movieField.selectedIndex].value;
		//console.log(mfIndex);
		cmv = mfIndex;
		//console.log(cmv);
		movieList(vtheaterName,cmv);
	}
	
	function movieList(theaterName,cmv){
		//console.log("dddddddd:"+ cmv)
		if(cmv == undefined) cmv='base';
		//console.log(theaterName);
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				let xml = xhr.responseXML;
				let movie_list = document.getElementById("movie-list");
				let movList = xml.getElementsByTagName("movList");
				movie_list.innerHTML = "";
				for(let i=0; i<movList.length; i++){
					let div2 = document.createElement("div2");
					let movieTitle = movList[i].getElementsByTagName("movieList")[0].textContent;
					div2.innerHTML = movieTitle + "<br>";
					div2.className = "movieListBox";
					div2.onclick=function(){
						//alert(this.inner)
						showList(begintime, movieTitle);
					}
					movie_list.appendChild(div2);
				}	
			}
		};
		xhr.open('get','${pageContext.request.contextPath}/movie?theaterName=' + theaterName +'&cmv=' + cmv, true)
		xhr.send();
	}
	// 달력
/*		
   const date = new Date(); //date객체
   const year = date.getFullYear();
   const month = date.getMonth();
   const firstDay = new Date(date.getFullYear(), date.getMonth(), 1); //달의 첫날
   const lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0); //한달의 마지막날
   const bookingDate = document.getElementById("date-list"); // 날짜 요일 저장할 곳
   const year_month = document.getElementById("year-month"); // 년도 월 저장할 곳
   year_month.innerHTML = date.getFullYear() + "년 " + (date.getMonth() + 1) + "월";
   const weekOfDay = ["일", "월", "화", "수", "목", "금", "토"];
  
   for (i = date.getDate(); i <= lastDay.getDate(); i++) {

       const button = document.createElement("button");
       const spanWeekOfDay = document.createElement("span");
       const spanDay = document.createElement("span");

       //class넣기
       button.classList = "movie_date_wrapper"
       spanWeekOfDay.classList = "movie_week_of_day";
       spanDay.classList = "movie_day";

       //weekOfDay[new Date(2021-06-날짜)]
       var dayOfWeek = week[date.getDay()];

       //요일 넣기
       if (dayOfWeek == "토") {
           spanWeekOfDay.classList.add("saturday");
           spanDay.classList.add("saturday");
       } else if (dayOfWeek == "일") {
           spanWeekOfDay.classList.add("sunday");
           spanDay.classList.add("sunday");
       }
       spanWeekOfDay.innerHTML = dayOfWeek;
       button.append(spanWeekOfDay);
       //날짜 넣기
       spanDay.innerHTML = i;
       button.append(spanDay);
       //button.append(i);
       bookingDate.append(button);

       dayClickEvent(button);
       }
 */	
    function showList(begintime, movieTitle){
    	let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				let xml = xhr.responseXML;
				let show_list = document.getElementById("show-list");
				let sList = xml.getElementsByTagName("sList");
				for(let i=0; i<sList.length; i++){
					let div3 = document.createElement("div3");
					let roomNum = sList[i].getElementsByTagName("rn")[0].textContent;
					let sitCount = sList[i].getElementsByTagName("sc")[0].textContent;
					div3.innerHTML = roomNum + "관 " + sitCount + "석";
					div3.className = "showListBox";
					div3.onclick=function(){
						//alert(this.inner)
						timeList(begintime, movieTitle);
					}
					show_list.appendChild(div3);
				}	
			}
		};
		xhr.open('get','${pageContext.request.contextPath}/show?begintime=' + begintime +'&movieTitle=' + movieTitle,true)
		xhr.send();
    }
    
    function timeList(begintime, movieTitle){
    	let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				let xml = xhr.responseXML;
				let time_list = document.getElementById("time-list");
				let stList = xml.getElementsByTagName("stList");
				for(let i=0; i<stList.length; i++){
					let div4 = document.createElement("div4");
					let begintime = stList[i].getElementsByTagName("time")[0].textContent;
					div4.innerHTML = begintime + "<br>";
					div4.className = "timeListBox";
					div4.onclick=function(){
						//alert(this.inner)
						location.href="/book";
					}
					time_list.appendChild(div4);
				}	
			}
		};
		xhr.open('get','${pageContext.request.contextPath}/time?begintime=' + begintime +'&movieTitle=' + movieTitle, true)
		xhr.send();
    }
</script>
</body>
</html>