<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상영관 등록</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/roomEnroll.css">
<link rel="stylesheet" href="css/header2.css">
<link rel="stylesheet" href="css/footer.css">
</head>

<body>
<div class="header">
	<jsp:include page="ad_header.jsp"/>
</div>

<div class="main">
	<div class="title_top">
		<h1>상영관 등록</h1>
	</div>
	
	<form action="${pageContext.request.contextPath}/admin?cmd=roomEnroll" method="post">
		
		<input type="hidden"  value="${vo.writedate}">
		<input type="hidden" name="noticeNum" value="${vo.noticeNum}">
		<table>
			<tr>
				<th>영화관</th>
				<td><input type="text" name="theaterName" placeholder="제목을 입력해주세요." style="background-color: #F8F8F8;border-color: #DDD;width:800px;padding: 10px;font-size: 15px;"><td>
			</tr>
			<tr>
				<th>좌석수</th>
				<td><input type="text" name="seatCount" placeholder="좌석수를 입력해주세요." style="background-color: #F8F8F8;border-color: #DDD;width:800px;padding: 10px;font-size: 15px;"><td>
			</tr>
			<tr>
				<th>위치</th>
				<td><input type="text" name="location" placeholder="위치를 입력해주세요." style="background-color: #F8F8F8;border-color: #DDD;width:800px;padding: 10px;font-size: 15px;"><td>
			</tr>
			<tr>
				<th>상영관번호</th>
				<td><input type="text" name="roomNum" placeholder="상영관 번호를 입력해주세요." style="background-color: #F8F8F8;border-color: #DDD;width:800px;padding: 10px;font-size: 15px;"><td>
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
		</div>
	</form>	
	
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
</body>
</html>