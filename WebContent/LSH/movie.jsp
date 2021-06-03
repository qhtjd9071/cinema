<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<meta charset="UTF-8">
<title>movie.jsp</title>
<style>
.starR1{
    background: url('http://miuu227.godohosting.com/images/icon/ico_review.png') no-repeat -52px 0;
    background-size: auto 100%;
    width: 15px;
    height: 30px;
    float:left;
    text-indent: -9999px;
    cursor: pointer;
}
.starR2{
    background: url('http://miuu227.godohosting.com/images/icon/ico_review.png') no-repeat right 0;
    background-size: auto 100%;
    width: 15px;
    height: 30px;
    float:left;
    text-indent: -9999px;
    cursor: pointer;
}
.starR1.on{background-position:0 0;}
.starR2.on{background-position:-15px 0;}
</style>
</head>
<body>

<!-- 영화정보 -->
<div style="width:500px; height:300px; background-color:#bbb">
	<h1>영화제목 : ${vo.movieTitle }</h1>
	<ul>
		<li>내용 : ${vo.movieContent }</li>
		<li>감독 : ${vo.director }</li>
		<li>장르 : ${vo.genre }</li>
		<li>평점 : ${vo.rating }</li>
		<li>이미지 : ${vo.image }</li>
	</ul>
</div>
<!-- 영화정보끝 -->

<!-- 데이터 입력하는 부분  -->
	<div>
		<div id="commList"></div>
		<div id="commForm">
			별점선택 <br>
			<div class="starRev">
			  <span class="starR1 on" >별1_왼쪽</span>
			  <span class="starR2" >별1_오른쪽</span>
			  <span class="starR1" >별2_왼쪽</span>
			  <span class="starR2" >별2_오른쪽</span>
			  <span class="starR1" >별3_왼쪽</span>
			  <span class="starR2" >별3_오른쪽</span>
			  <span class="starR1" >별4_왼쪽</span>
			  <span class="starR2" >별4_오른쪽</span>
			  <span class="starR1" >별5_왼쪽</span>
			  <span class="starR2" >별5_오른쪽</span>
			</div><br>
			별점임의값입력<br>
			<input type="text" id="star"><br>
			아이디 <br>
			<input type="text" id="id"><br>
			영화평 <br>
			<textarea rows="3" cols="30" id="content"></textarea><br>
			<input type="button" value="등록" onclick="addComments()">
		</div>
	</div>
<!-- 데이터 입력하는 부분 끝 -->


<!-- 댓글목록 -->
<script type="text/javascript">
	<!-- 별점 -->
	$('.starRev span').click(function(){
		  $(this).parent().children('span').removeClass('on');
		  $(this).addClass('on').prevAll('span').addClass('on');
		  return false;
	});
	<!-- 별점 끝-->
	
	<!-- 등록버튼 클릭시 댓글 등록 -->
	function addComments(){
		const id=document.getElementById("id").value;	
		const content=document.getElementById("content").value;	//
		const star=document.getElementById("star").value;
		let xhr=new XMLHttpRequest();	
		xhr.onreadystatechange=function(){	
			if(xhr.readyState==4 && xhr.status==200){
				let xml=xhr.responseXML;
				let code=xml.getElementsByTagName("code")[0].textContent;
				alert(code);
				list();
			}
		};
		xhr.open('post','${pageContext.request.contextPath}/LSH/comments.do',true);
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		let params="movieNum=${vo.movieNum}&id=" +id+ "&content=" + content + "&star=" + star;
		xhr.send(params);
	}
	<!-- 등록버튼 클릭시 댓글 등록 끝 -->
	
	<!-- 댓글목록 -->
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
		xhr.open('get','${pageContext.request.contextPath}/LSH/list.do?movieNum=${vo.movieNum}',true);
		xhr.send();
	}
	<!-- 댓글목록 끝 -->	

	<!-- 댓글삭제 -->
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
		xhr.open('get','${pageContext.request.contextPath}/LSH/delete.do?movieCommentsNum='+movieCommentsNum,true);
		xhr.send();
	}
	<!-- 댓글삭제 끝 -->
</script>
</body>
</html>