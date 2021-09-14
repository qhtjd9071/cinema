<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 상세</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="${cp}/resources/css/moviecomments.css">
<link rel="stylesheet" href="${cp}/resources/css/header2.css">
<link rel="stylesheet" href="${cp}/resources/css/footer.css">

<style>
.star-input>.input,
.star-input>.input>label:hover,
.star-input>.input>input:focus+label,
.star-input>.input>input:checked+label{display: inline-block;vertical-align:middle;background:url('${cp}/resources/images/star/grade_img.png')no-repeat;}
.star-input{display:inline-block; white-space:nowrap;background-color:#F8F8F8;line-height:30px;}
.star-input>.input{display:inline-block;width:150px;background-size:150px;height:28px;white-space:nowrap;overflow:hidden;position: relative;}
.star-input>.input>input{position:absolute;width:1px;height:1px;opacity:0;}
star-input>.input.focus{outline:1px dotted #ddd;}
.star-input>.input>label{width:30px;height:0;padding:28px 0 0 0;overflow: hidden;float:left;cursor: pointer;position: absolute;top: 0;left: 0;}
.star-input>.input>label:hover,
.star-input>.input>input:focus+label,
.star-input>.input>input:checked+label{background-size: 150px;background-position: 0 bottom;}
.star-input>.input>label:hover~label{background-image: none;}
.star-input>.input>label[for="p1"]{width:30px;z-index:5;}
.star-input>.input>label[for="p2"]{width:60px;z-index:4;}
.star-input>.input>label[for="p3"]{width:90px;z-index:3;}
.star-input>.input>label[for="p4"]{width:120px;z-index:2;}
.star-input>.input>label[for="p5"]{width:150px;z-index:1;}
.star-input>output{display:block;width:100%; font-size:13px;text-align:center; vertical-align:middle;margin:10px 0 0 0;}
</style>

</head>
<body>

<div class="header2">
	<jsp:include page="../layout/header.jsp"/>
</div>

<!-- 영화 상세정보 -->
<div class="movie">
	<div class="movie_container">
		<div class="contents_movie_detail">
			<div class="detail_top_wrap">
				<div class="poster_info">
					<img src="${vo.image}">
				</div>
				<div class="tit_info">
					<strong>${vo.title}</strong>
				</div>
				<ul class="detail_info1">
					<li class="sub_info1">관람등급   <strong>${vo.rating}</strong></li>
					<li class="sub_info2">관람객평점 <strong>${grade}</strong></li>
				</ul>
				<ul class="detail_info2">
					<li class="sub_info1"><em>장르</em><strong>${vo.genre}</strong></li>
					<li class="sub_info2"><em>감독</em><strong>${vo.director}</strong></li>
				</ul>
			</div>
			<ul class="tab_wrap">
				<li>
					<input type="button" class="tab_tit" value="영화정보">
					<div class="tab_con">
						<strong>시놉시스</strong>
						<div class="movie_content">${vo.content}</div>
					</div>
				</li>
				<li>
					<input type="button" class="tab_tit" value="평점 및 관람평" style="margin-top:42px">
					<div class="tab_con">
						<div class="movi_score_box">
							<p class="txt_info">"영화 관람 후 관람평을 작성하시면"<br>"POINT 50P를 적립해 드립니다."</p>
						</div>
						<div class="movi_review_box">
							<span class="star-input">
							  	<output for="star-input"><b>0</b>점</output>
								<span class="input">
							    	<input type="radio" name="star-input" value="1" id="p1" onclick="getStars()">
							    	<label for="p1">1</label>
							    	<input type="radio" name="star-input" value="2" id="p2" onclick="getStars()">
							    	<label for="p2">2</label>
							    	<input type="radio" name="star-input" value="3" id="p3" onclick="getStars()">
							    	<label for="p3">3</label>
							    	<input type="radio" name="star-input" value="4" id="p4" onclick="getStars()">
							    	<label for="p4">4</label>
							    	<input type="radio" name="star-input" value="5" id="p5" onclick="getStars()">
							    	<label for="p5">5</label>
							  	</span>
							  	<button onclick='getStars()'></button>		
							</span>
							<div class="review_write_box">
								<div style="display:none" id="result"></div>
								<input style="display:none" type="text" id="userId" value="${logined}" readonly="readonly">
								<textarea rows="3" cols="30" id="content" placeholder="평점 및 영화 관람평을 작성해주세요.
주제와 무관한 리뷰 또는 스포일러는 표시제한 또는 삭제될 수 있습니다."></textarea>
								<input class="review_submit" type="button" value="관람평 등록" onclick="addComments()">
							</div>
						</div>
						<div class="movi_review_list">
							<ul class="review_con_list" id="review_con_list"></ul>
						</div>
					</div>
				</li>
			</ul>
		</div>	
	</div>
</div>

<!-- 별점 -->
<script src="${cp}/resources/js/jquery-1.11.3.min.js"></script>
<script src="${cp}/resources/js/star.js"></script>
<!-- 별점 -->

<div class="footer">
	<jsp:include page="../layout/footer.jsp"/>
</div>



<script type="text/javascript">

	window.onload = function(){
	    list();
	}
	
	function getStars() {
		  const stars
		  = document.getElementsByName("star-input");
		  
		  stars.forEach((node) => {
		    if(node.checked)  {
		      document.getElementById("result").innerText
		        = node.value;
		    }
		  }) 
		}
	
	function list(){
		let xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				const review_con_list=document.getElementById("review_con_list");
				let childs=review_con_list.childNodes;
				for(let i=childs.length-1;i>=0;i--){
					review_con_list.removeChild(childs.item(i));
				}
				
				let json=xhr.responseText;
				let mcom=xml.getElementsByTagName("mcom");	
				for(let i=0;i<mcom.length;i++){
					let li=document.createElement("li");
					let commentsId=mcom[i].getElementsByTagName("commentsId")[0].textContent;
					let id=mcom[i].getElementsByTagName("userId")[0].textContent;
					let content=mcom[i].getElementsByTagName("content")[0].textContent;
					let star=mcom[i].getElementsByTagName("star")[0].textContent;
					let creatDate=mcom[i].getElementsByTagName("createDate")[0].textContent;
					let userId=mcom[i].getElementsByTagName("userId")[0].textContent;
					let movieId=mcom[i].getElementsByTagName("movieId")[0].textContent;
					
					li.innerHTML=   "<div class=\"topinfo\">"+ "<span class=\"nameinfo\">"+userId +"</span>"+
									"<span class=\"scoreinfo\">"+"평점  " +star +"</div>"+ "</div>" +
									"<div class=\"reviewinfo\">" + content +"</div>"+
									"<a href='javascript:delComments(" + commentsId + ")'>삭제</a>";
					
					li.className="commBox";
					review_con_list.appendChild(li);
				}
			}			
		};
		xhr.open('get','${cp}/comments/list?movieId=${id}',true);
		xhr.send();
	}
	
	function addComments(){
		const id=document.getElementById("id").value;	
		const content=document.getElementById("content").value;	
		let star=0;
		const stars = document.getElementsByName("star-input");  
	  	stars.forEach((node) => {
	    	if(node.checked)  {
		      star = node.value;
		    }
	  	}) 
		let xhr=new XMLHttpRequest();	
		xhr.onreadystatechange=function(){	
			if(xhr.readyState==4 && xhr.status==200){
				let result=xhr.responseText;
				alert(result);
				list();
			}
		};
		xhr.open('post','${cp}/aa.do',true);
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		let params="movieId=${id}&userId=" +userId+ "&content=" + content + "&star=" + star;
		xhr.send(params);
	}
	
	function delComments(id){
		let xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				let xml=xhr.responseXML;
				let code=xml.getElementsByTagName("code")[0].textContent;
				alert(code);
				list();
			}
		};
		xhr.open('get','${cp}/comments/delete?id='+commentsId,true);
		xhr.send();
	}
	
</script>
<!-- 페이징처리 -->
<!-- 페이징처리 -->
</body>
</html>