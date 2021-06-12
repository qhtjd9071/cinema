<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movie.jsp1</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/moviecomments.css">
<link rel="stylesheet" href="css/star.css">
<link rel="stylesheet" href="css/header2.css">
<link rel="stylesheet" href="css/footer.css">

<style>
.star-input>.input,
.star-input>.input>label:hover,
.star-input>.input>input:focus+label,
.star-input>.input>input:checked+label{display: inline-block;vertical-align:middle;background:url('images/star/grade_img.png')no-repeat;}
.star-input{display:inline-block; white-space:nowrap;width:225px;height:40px;padding:25px;line-height:30px;}
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
.star-input>output{display:inline-block;width:60px; font-size:18px;text-align:right; vertical-align:middle;}
</style>

</head>
<body>

<div class="header2">
	<jsp:include page="header2.jsp"/>
</div>

<!-- 영화 상세정보 -->
<div class="movie">
	<div class="movie_container">
		<div class="contents_movie_detail">
			<div class="detail_top_wrap">
				<div class="poster_info">
					<img src="${vo.image }">
				</div>
				<div class="tit_info">
					<Strong>${vo.movieTitle }</Strong>
				</div>
				<ul class="detail_info1">
					<li class="sub_info1">${vo.rating }</li>
					<li class="sub_info2"></li>
					<li class="sub_info3"></li>
				</ul>
				<ul class="detail_info2">
					<li class="sub_info1">${vo.genre }</li>
					<li class="sub_info2">${vo.director }</li>
					<li class="sub_info3"></li>
				</ul>
			</div>
			<ul class="tab_wrap outer">
				<li class="active">
					<button type="button" class="tab_tit" style="width:50%; left:0%;"><span>영화정보</span></button>
					<div class="tab_con">
						${vo.movieContent }
					</div>
				</li>
				<li class="active">
					<div class="tab_con">
						<div class="movi_score_box">
							<p class="txt_info"><span>"영화 관람 후 관람평을 작성하시면"<br>"L.POINT 50P를 적립해 드립니다."</span></p>
						</div>
						<div class="movi_review_box">
							<span class="star-input">
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
							  	<output for="star-input"><b>0</b>점</output>
							  	<button onclick='getStars()'></button>		
							</span>
							<div id="result" style="display:none;"></div>	
							아이디 <br>
							<input type="text" id="id" value="${id }" readonly="readonly"><br>
							영화평 <br>
							<textarea rows="3" cols="30" id="content"></textarea><br>
							<input type="button" class="tab_tit" style="width:50%; left:0%;" value="평점 및 관람평" onclick="addComments()">
						</div>
						<div class="movi_review_list">
							<div class="review_top"></div>
							<ul class="review_con_list" id="review_con_list"></ul>
							<button type="button" class="btn_txt_more"></button>
						</div>
					</div>
				</li>
			</ul>
		</div>	
	</div>
</div>

<!-- 별점 -->
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/star.js"></script>
<!-- 별점 -->

<div class="footer">
<<<<<<< HEAD
	<jsp:include page="footer.jsp"/>
=======
	<jsp:include page="/footer.jsp"/>
>>>>>>> branch 'master' of https://github.com/qhtjd9071/semi.git
</div>



<script type="text/javascript">

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
				let xml=xhr.responseXML;
				let code=xml.getElementsByTagName("code")[0].textContent;
				alert(code);
				list();
			}
		};
		xhr.open('post','${pageContext.request.contextPath}/aa.do',true);
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		let params="movieNum=${vo.movieNum}&id=" +id+ "&content=" + content + "&star=" + star;
		xhr.send(params);
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
				
				let xml=xhr.responseXML;
				let mcom=xml.getElementsByTagName("mcom");	
				for(let i=0;i<mcom.length;i++){
					let div=document.createElement("div");
					let movieCommentsNum=mcom[i].getElementsByTagName("movieCommentsNum")[0].textContent;
					let id=mcom[i].getElementsByTagName("id")[0].textContent;
					let content=mcom[i].getElementsByTagName("content")[0].textContent;
					let star=mcom[i].getElementsByTagName("star")[0].textContent;
					let writedate=mcom[i].getElementsByTagName("writedate")[0].textContent;
					let UserNum=mcom[i].getElementsByTagName("UserNum")[0].textContent;
					let movieNum=mcom[i].getElementsByTagName("movieNum")[0].textContent;
					
					div.innerHTML=  "별점:" + star + "<br>" +
									"내용:" + content +
									"작성자:" + id +
									"<a href='javascript:delComments(" + movieCommentsNum + ")'>삭제</a>";
					
					div.className="commBox";
					review_con_list.appendChild(div);
				}
			}			
		};
		xhr.open('get','${pageContext.request.contextPath}/list.do?movieNum=${vo.movieNum}',true);
		xhr.send();
	}
	
	function delComments(movieCommentsNum){
		let xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				let xml=xhr.responseXML;
				let code=xml.getElementsByTagName("code")[0].textContent;
				alert(code);
				list();
			}
		};
		xhr.open('get','${pageContext.request.contextPath}/delete.do?movieCommentsNum='+movieCommentsNum,true);
		xhr.send();
	}
	
</script>
<!-- 페이징처리 -->
<!-- 페이징처리 -->
</body>
</html>