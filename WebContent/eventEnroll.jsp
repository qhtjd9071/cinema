<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 등록</title>
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
		<h1>이벤트 등록</h1>
	</div>
	
	<form action="${pageContext.request.contextPath}/admin?cmd=eventEnroll" method="post">	
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" placeholder="제목을 입력해주세요." style="background-color: #F8F8F8;border-color: #DDD;width:800px;padding: 10px;font-size: 15px;"><td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="20" cols="100" id="blank" name="content" placeholder="내용을 입력해주세요." style="background-color: #F8F8F8;border-color: #DDD;width:800px;
				font-size: 15px;padding: 10px;"></textarea></td>
			<tr>
				메인사진선택
			    <input type="file" id="upload_file1" name="upload_file1">
				<input type="hidden" id="imgsrc1" name="imgsrc1">
				<br>
				상세사진선택
			    <input type="file" id="upload_file2" name="upload_file2">
				<input type="hidden" id="imgsrc2" name="imgsrc2">
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
			    
			    <input type="button" value="메인사진등록" id="imageEnroll1" style="
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
			    
			    <input type="button" value="상세사진등록" id="imageEnroll2" style="
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
  				left: 66%; 
			    cursor: pointer;">
		</div>
	</form>	
	<img id="img1">
	<img id="img2">
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
		const imgBtn1=document.getElementById("imageEnroll1");
		const imgsrc1=document.getElementById("imgsrc1");
		imgBtn1.addEventListener("click",function(){
			let fileInput=document.getElementById("upload_file1").files[0];
			if(fileInput!=null){
			    let formData = new FormData();
			    formData.append("upload_file1" , fileInput);
				let xhr=new XMLHttpRequest();
				xhr.onreadystatechange=function(){
					let fileName=xhr.responseText;
					let json=JSON.parse(fileName);
					if(json!=""){
						let img=document.getElementById("img1");
						img.src="${pageContext.request.contextPath }/upload/event/"+json.orgFileName;
						imgsrc1.value="${pageContext.request.contextPath}/images/event/"+json.orgFileName;
					}
				}
			xhr.open("post", "${pageContext.request.contextPath}/fileup1", true);
	    	xhr.send(formData);
			}
		});
		const imgBtn2=document.getElementById("imageEnroll2");
		const imgsrc2=document.getElementById("imgsrc2");
		imgBtn2.addEventListener("click",function(){
			let fileInput=document.getElementById("upload_file2").files[0];
			if(fileInput!=null){
			    let formData = new FormData();
			    formData.append("upload_file2" , fileInput);
				let xhr=new XMLHttpRequest();
				xhr.onreadystatechange=function(){
					let fileName=xhr.responseText;
					let json=JSON.parse(fileName);
					if(json!=""){
						let img=document.getElementById("img2");
						img.src="${pageContext.request.contextPath }/upload/eventdetail/"+json.orgFileName;
						imgsrc2.value="${pageContext.request.contextPath}/images/eventdetail/"+json.orgFileName;
					}
				}
			xhr.open("post", "${pageContext.request.contextPath}/fileup2", true);
	    	xhr.send(formData);
			}
		});
</script>
</body>
</html>