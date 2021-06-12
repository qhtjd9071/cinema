<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화정보 등록</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">
<link rel="stylesheet" href="css/movieEnroll2.css">
<link rel="stylesheet" href="css/ad_header.css">
<link rel="stylesheet" href="css/footer.css">
</head>

<body>
<div class="header">
	<jsp:include page="ad_header.jsp"/>
</div>

<div class="main">
	<div class="title_top">
		<h1>영화정보 등록</h1>
	</div>
	
	<form action="${pageContext.request.contextPath}/admin?cmd=movieEnroll" method="post">	
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" placeholder="제목을 입력해주세요." style="background-color: #F8F8F8;border-color: #DDD;width:800px;padding: 10px;font-size: 15px;"><td>
			</tr>
			<tr>
				<th>감독</th>
				<td><input type="text" name="director" placeholder="감독을 입력해주세요." style="background-color: #F8F8F8;border-color: #DDD;width:800px;padding: 10px;font-size: 15px;"><td>
			</tr>
			<tr>
				<th>장르</th>
				<td><input type="text" name="genre" placeholder="장르를 입력해주세요." style="background-color: #F8F8F8;border-color: #DDD;width:800px;padding: 10px;font-size: 15px;"><td>
			</tr>
			<tr>
				<th>관람등급</th>
				<td><input type="text" name="rating" placeholder="관람등급를 입력해주세요." style="background-color: #F8F8F8;border-color: #DDD;width:800px;padding: 10px;font-size: 15px;"><td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="20" cols="100" id="blank" name="content" placeholder="내용을 입력해주세요." style="background-color: #F8F8F8;border-color: #DDD;width:800px;
				font-size: 15px;padding: 10px;"></textarea></td>
			<tr>
				사진선택
			    <input type="file" id="upload_file" name="upload_file">
				<input type="hidden" id="imgsrc" name="imgsrc">
			</tr>
		</table>
		<div class="btn_wrap">
				<input type="button" value="메인" id="btn" style="
				width:100px;
			    background-color: #f8585b;
			    border: none;
			    color:black;
			    padding: 15px 0;
			    text-align: center;
			    text-decoration: none;
			    display: inline-block;
			    font-size: 15px;
			    margin: 4px;
			    border-radius:10px;
			    background-color:gray;
			   	position: absolute; 
  				left: 42%; 
			    cursor: pointer;">
			    
				<input type="submit" value="등록" style="
				width:100px;
			    background-color: #f8585b;
			    border: none;
			    color:#fff;
			    padding: 15px 0;
			    text-align: center;
			    text-decoration: none;
			    display: inline-block;
			    font-size: 15px;
			    margin: 4px;
			    border-radius:10px;
			    background-color: black;
			   	position: absolute; 
  				left: 50%; 
			    cursor: pointer;">
			    
			    <input type="button" value="사진등록" id="imageEnroll" style="
				width:100px;
			    background-color: #f8585b;
			    border: none;
			    color:white;
			    padding: 15px 0;
			    text-align: center;
			    text-decoration: none;
			    display: inline-block;
			    font-size: 15px;
			    margin: 4px;
			    border-radius:10px;
			    background-color:blue;
			   	position: absolute; 
  				left: 58%; 
			    cursor: pointer;">
		</div>
	</form>	
	<img id="img">
</div>


<div class="footer">
	<jsp:include page="footer.jsp"/>
</div>

<script type="text/javascript">
	const btn=document.getElementById("btn");
	btn.addEventListener("click", function(e) {
		location.href="${pageContext.request.contextPath}/admin.jsp";
	});
</script>
<script type="text/javascript">
		const imgBtn=document.getElementById("imageEnroll");
		const imgsrc=document.getElementById("imgsrc");
		imgBtn.addEventListener("click",function(){
			let fileInput=document.getElementById("upload_file").files[0];
			if(fileInput!=null){
			    let formData = new FormData();
			    formData.append("upload_file" , fileInput);
				let xhr=new XMLHttpRequest();
				xhr.onreadystatechange=function(){
					let fileName=xhr.responseText;
					let json=JSON.parse(fileName);
					if(json!=""){
						let img=document.getElementById("img");
						img.src="${pageContext.request.contextPath }/upload/movie/"+json.orgFileName;
						imgsrc.value="${pageContext.request.contextPath }/images/movie/"+json.orgFileName;
					}
				}
			xhr.open("post", "${pageContext.request.contextPath}/fileup", true);
	    	xhr.send(formData);
			}
		});
</script>
</body>
</html>