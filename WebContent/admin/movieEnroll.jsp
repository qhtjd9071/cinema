<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>영화등록</h1>
<form method="post" action="${pageContext.request.contextPath}/admin?cmd=movieEnroll">
	제목
	<input type="text" name="title"><br>
	내용
	<input type="text" name="content"><br>
	감독
	<input type="text" name="director"><br>
	장르	
	<input type="text" name="genre"><br>
	관람등급
	<input type="text" name="rating"><br>
	사진선택
    <input type="file" id="upload_file" name="upload_file">
	<input type="button" value="사진등록" id="imageEnroll">
	<input type="hidden" id="imgsrc" name="imgsrc">
	<input type="submit" value="등록">
</form>
<img id="img">
</body>
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
						img.src="${pageContext.request.contextPath }/upload/"+json.orgFileName;
						imgsrc.value=img.src;
					}
				}
			xhr.open("post", "${pageContext.request.contextPath}/fileup", true);
	    	xhr.send(formData);
			}
		});
</script>
</html>