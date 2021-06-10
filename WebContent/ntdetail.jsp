<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<title>공지사항 상세</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/ntdetail.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/footer.css">
</head>
<body>

<div class="main">
	<div class="title_top">
		<h1>공지사항 상세</h1>
	</div>
		<table>
			<colgroup>
				<col style="width: auto%">
				<col style="width: 25%">
				<col style="width: 20%">
			</colgroup>
			<tr>
				<th>제목</th>
				<td>${vo.title}</td>
				<th>등록일</th>
				<td>${vo.writedate}</td>
				<th>조회수</th>
				<td>${vo.hit}</td>
			</tr>	
			<tr>
				<td colspan="6" style="padding:80px">${vo.content }</td>
			</tr>
		</table>
		
		<div class="btn_wrap">
				<input type="button" value="목록" id="btn" style="
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
			    background-color:black;
			   	position: absolute; 
  				left: 42%; 
			    cursor: pointer;">
</div>


<div class="footer">
	<jsp:include page="footer.jsp"/>
</div>
<script type="text/javascript">
	const btn=document.getElementById("btn");
	btn.addEventListener("click", function(e) {
		location.href="${pageContext.request.contextPath}/ntlist";
	});
</script>
</body>
</html>