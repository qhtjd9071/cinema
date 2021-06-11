<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/movielist.css">
<link rel="stylesheet" href="css/header2.css">
<link rel="stylesheet" href="css/footer.css">
<title> movieList.jsp </title>
</head>
<body>
<div class="header2">
	<jsp:include page="header2.jsp"/>
</div>
<div class="movie">
	<div class="movie_container">
		<div id="movie_list" class= "movie_list">
			<ul class="movie_list_wrap">
				<c:forEach var="vo" items="${ requestScope.list }">
					<li class= "movie_selected">
						<span class="movieImg">
							<a href='${pageContext.request.contextPath}/moviecomments.do?movieNum=${vo.movieNum}'>
								<img src="${vo.image}">
							</a>
						</span>
						<div class="movieTitle_wrap">
							<div class="movieTitle"> ${vo.movieTitle}</div>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>
<div class="footer">
	<jsp:include page="footer.jsp"/>
</div>
</body>
</html>