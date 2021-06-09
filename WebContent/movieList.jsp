<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> movieList.jsp </title>
</head>
<body>

<div id="main_List_wrap" class="main_list_wrap">
	<div id="movie_list" class= "movie_list">
		<c:forEach var="vo" items="${ requestScope.list }">
			<div style="background-color: red;"><a href='${pageContext.request.contextPath}/LSH/movie.do?movieNum=${vo.movieNum}'><img src="${vo.image}"></a></div>
			<div style="background-color: red;"> ${vo.movieTitle}</div>
		</c:forEach>
	</div>
</div>

<div class="footer">
	<jsp:include page="footer.jsp"/>
</div>
</body>
</html>