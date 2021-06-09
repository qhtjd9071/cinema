<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/admin.css">
<link rel="stylesheet" href="css/header2.css">
<link rel="stylesheet" href="css/footer.css">
</head>
<body>
	<div class="header2">
      <jsp:include page="ad_header.jsp"/>
   </div>
   
   <div class="movie">
      <div class="movie_container">
	      <ul class="mbtn_list">
		      <li><a href="movieEnroll.jsp">영화정보등록</a></li>
		      <li><a href="roomEnroll.jsp">상영관등록</a></li>
		      <li><a href="showEnroll.jsp">상영영화등록</a></li>
	      </ul>
	      <ul class="mbtn_list">
		      <li><a href="movieEnroll.jsp">영화정보보기</a></li>
		      <li><a href="roomEnroll.jsp">상영관보기</a></li>
		      <li><a href="showEnroll.jsp">상영영화보기</a></li>
	      </ul>
      </div>
   </div>
   
   <div class="footer">
      <jsp:include page="footer.jsp"/>
   </div>
</body>
</html>