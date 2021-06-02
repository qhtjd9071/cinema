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
	<div>
		<div id="commList"></div>
		<div id="commForm">
		<h1>평점 및 관람평</h1>
			<form name="reviewform" class="reviewform" method="post" action="/save">
			<input type="hidden" name="rate" id="rate" value="0"/>
			<p class="title_star">영화 관람 후 관람평을 작성하시면 L.POINT 50P를 적립해 드립니다.</p>
			
			<div class="review_rating">
				<div class="warning_msg">별점을 선택해 주세요.</div>
				<div class="rating">
					<input type="checkbox" name="rating" id="rating1" value="1" class="rate_radio" title="1점">
					<label for="rating1"></label>
					<input type="checkbox" name="rating" id="rating2" value="2" class="rate_radio" title="2점">
					<label for="rating2"></label>
					<input type="checkbox" name="rating" id="rating3" value="3" class="rate_radio" title="3점">
					<label for="rating3"></label>
					<input type="checkbox" name="rating" id="rating4" value="4" class="rate_radio" title="4점">
					<label for="rating4"></label>
					<input type="checkbox" name="rating" id="rating5" value="5" class="rate_radio" title="5점">
					<label for="rating5"></label>
				</div>
			</div>
			<div class="review_contents">
				<div class="warning_msg">평점 및 영화 관람평을 작성해주세요.</div>
				<textarea rows="10" class="review_textarea" id="content"></textarea>
			</div>
			<div class="cmd">
				<input type="button" value="등록" name="save" id="save" onclick="addComments()">	
			</div>
			</form>
		</div>
</div>
<script type="text/javascript">
	document.addEventListener('DOMcontentLoaded',function(){
		document.querySelector('.rating').addEventListener('click',function(e){
			let elem=e.target;
			if(elem.classList.contains('rate_radio')){
				rating.setRate(parseInt(elem.value));
			}
		})
	});
	
	documnet.querySelector('.review_textarea').addEventListener('keydown',function(){
		let review=document.querySelector('.review_textarea');
		let lengthCheckEx = /^.{100,}$/;
		if(lengthCheckEx.text(review.value)){
			review.value=review.value.substr(0,100);
		}
	});
	
	document.querySelector('#save').addEventListener('click',function(e){
		if(rating.rate==0){
			rating.showMessage('rate');
			return false;
		}
		if(document.querySelector('.review_textarea').value.length < 5) {
			rating.showMessage('review');
			return false;
		}
	});
	
	Rating.prototype.showMessage = function(type) {
		switch(type){
		case 'rate':
			//안내메시지
			documnet.querySelector('.review_rating.warning_msg').style.display='block';
			setTimeout(function(){
				document.querySelector('.review_rating.warning_msg').style.display='none';
			},1000);
			break;
			
		case 'review':
			documnet.querySelector('.review_contents.warning_msg').style.display='block';
			setTimeout(function(){
				document.querySelector('.review_contents.warning_msg').style.display='none';
			},1000);
			break;
		}
	}
	function Rating(){};
	Rating.prototype.rate = 0;
	Rating.prototype.setRate = function(newrate) {
		this.rate=newrate;
		document.querySelector('.ratefill').style.width=parseInt(newrate * 60) + 'px';
		let items=document.querySelectorAll('.rate_radio');
		items.forEach(function(item,idx){
			if(idx < newrate){
				item.checked = true;
			}else{
				item.checked = false;
			}
		});
	}
	let rating=new Rating();
<!-- --------------------------------------------------------- -->
	function list(){
		let xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				//댓글목록이 붙여질 div
				const commList=document.getElementById("commList");
				//기존의 댓글목록 지우기
				let childs=commList.childNodes;
				for(let i=childs.length-1;i>=0;i--){
					commList.removeChild(childs.item(i));
				}
				
				let xml=xhr.responseXML;
				let comm=xml.getElementsByTagName("comm");
				for(let i=0;i<comm.length;i++){
					let div=document.createElement("div");
					let movieCommentsNum=comm[i].getElementsByTagName("movieCommentsNum")[0].textContent;
					let id=comm[i].getElementsByTagName("id")[0].textContent;
					let content=comm[i].getElementsByTagName("content")[0].textContent;
					let star=comm[i].getElementsByTagName("star")[0].textContent;
					let writedate=comm[i].getElementsByTagName("writedate")[0].textContent;
					let UserNum=comm[i].getElementsByTagName("UserNum")[0].textContent;
					let movieNum=comm[i].getElementsByTagName("movieNum")[0].textContent;
					
					div.innerHTML="작성자:" + id + "<br>" +
									"내용:" + content +
									"별점:" + star +
									"<a href='javascript:delComments(" + movieCommentsNum + ")'>삭제</a>";
					
					div.className="commBox";
					commList.appendChild(div);
				}
			}			
		};
		xhr.open('get','${pageContext.request.contextPath}/LSH/list.do?movieNum=${vo.movieNum}',true);
		xhr.send();
	}
	list();

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
		
	function addComments(){
		const id=document.getElementById("id").value;
		const content=document.getElementById("content").value;
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
</script>
</body>
</html>