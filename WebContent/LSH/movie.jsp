<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movie.jsp</title>
<style>
	.commBox{width:400px; height:100px; border:1px solid #aaa; margin-top: 5px;}
	.commForm{
		max-width: 480px;
		margin: 0 auto;
		background-color: #fff;
		height: 100%;
		padding: 20px;
		box-sizing: border-box;
	}
	.reviewform textarea{
		width: 100%;
		padding : 10px;
		box-sizing: border-box;
	}
	.rating .rate_radio{
		position: relative;
		display: inline-block;
		z-index: 20;
		opacity: 0.001;
		width: 60px;
		height: 60px;
		background-color: #fff;
		cursor: pointer;
		vertical-align: top;
		display: none;
	}
	.rating .rate_radio + label {
		position : relative;
		display : inline-block;
		margin-left: -4px;
		z-index: 10;
		width: 60px;
		height: 60px;
		background-image: url('../images/star/starrate.png');
		backogrund-repeat: no-repeat;
		background-size: 60px; 60px;
		cursor: pointer;
		background-color: #f0f0f0;
	}
	.rating .rate_radio:checked + label{
		background-color: #ff8;
	}
	.warning_msg{
		display:none;
		position: relative;
		text-align: center;
		background: #ffffff;
		line-height: 26px;
		width: 100%;
		color: red;
		padding: 10px;
		box-sizing: border-box;
		border: 1px solid #e0e0e0;
	}
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

	<div>
		<div id="commList"></div>
		<div id="commForm">
			별점 <br>
			<input type="text" id="star"><br>
			아이디 <br>
			<input type="text" id="id"><br>
			영화평 <br>
			<textarea rows="3" cols="30" id="content"></textarea><br>
			<input type="button" value="등록" onclick="addComments()">
		</div>
	</div>

<!-- 댓글목록 -->
<script type="text/javascript">
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