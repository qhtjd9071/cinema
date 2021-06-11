<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movie.jsp</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="../css/moviecomments.css">
<link rel="stylesheet" href="../css/header2.css">
<link rel="stylesheet" href="../css/footer.css">
</head>
<body>

<div class="header2">
	<jsp:include page="../header2.jsp"/>
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
					<li class="sub_info1"></li>
					<li class="sub_info2"></li>
					<li class="sub_info3"></li>
				</ul>
			</div>
			<ul class="tab_wrap outer"></ul>
		</div>	
	</div>
</div>




<!-- 영화정보 -->
	<h1>영화제목 : ${vo.movieTitle }</h1>
	<ul>
		<li>내용 : ${vo.movieContent }</li>
		<li>감독 : ${vo.director }</li>
		<li>장르 : ${vo.genre }</li>
		<li>평점 : ${vo.rating }</li>
		<li>이미지 : ${vo.image }</li>
	</ul>
<!-- 영화정보끝 -->

<!-- 데이터 입력하는 부분  -->
	<div>
		<div id="commList"></div>
		<div id="commForm">
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
				<div id="result"></div>				
				</span>
				아이디 <br>
				<input type="text" id="id" value="${id }" readonly="readonly"><br>
				영화평 <br>
				<textarea rows="3" cols="30" id="content"></textarea><br>
			
		</div>
	</div>
<!-- 데이터 입력하는 부분 끝 -->

<!-- 별점 -->
<script src="../js/jquery-1.11.3.min.js"></script>
<script src="../js/star.js"></script>
<!-- 별점 -->

<div class="footer">
	<jsp:include page="../footer.jsp"/>
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
		      star = node.value;	//재할당.
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
				const commList=document.getElementById("commList");
				let childs=commList.childNodes;
				for(let i=childs.length-1;i>=0;i--){
					commList.removeChild(childs.item(i));
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
					commList.appendChild(div);
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
<div class="footer">
	<jsp:include page="../footer.jsp"/>
</div>

</body>
</html>