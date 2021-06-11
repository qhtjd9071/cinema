<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 이벤트페이지 메인11s -->
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">
<link rel="stylesheet" href="css/Eve_main.css">
<link rel="stylesheet" href="css/header2.css">
<link rel="stylesheet" href="css/footer.css">

</head>
<body>
<div class="header2">
	<jsp:include page="header2.jsp"/>
</div>


<div class="movie">
	<div class="movie_container">
		<div class="contnets_event_home" style="margin-top:120px;">
			<div class="title_top"></div>
			<div class="lst_wrap">
				<h3 class="tit">영화</h3>
				<ul class="img_lst_wrap">
					<li>
						<c:forEach var="vo" items="${ requestScope.list }">
						<div><a href='${pageContext.request.contextPath}/event.do?eventNum=${vo.eventNum}'><img src="${vo.mainImage }"></a></div>
						<div> ${vo.title}</div>
						</c:forEach>
						<div class="itm_tit"></div>
						<div class="itm_date">${vo.writedate }></div>
					</li>
					<li></li>
					<li></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<div class="footer">
	<jsp:include page="footer.jsp"/>
</div>

</body>
</html>