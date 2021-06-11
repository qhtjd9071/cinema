<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>영화등록보기</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/ntlist.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/footer.css">
</head>
<body>
<div class="header">
		<jsp:include page="ad_header.jsp"/>
</div>

<div class="main">
	<div class="title_top">
		<h1>영화등록보기</h1>
	</div>
	<div class="tab">
		<table border="0" width="500" class="text_c">
			<colgroup>
				<col style="width: auto%">
				<col style="width: 15%">
				<col style="width: 15%">
				<col style="width: 15%">
				<col style="width: 15%">
			</colgroup>
				<tr style="border:solid;">
					<th>영화관</th>
					<th>위치</th>
					<th>좌석수</th>
					<th>상영관번호</th>
					<th>삭제</th>
				</tr>
			<c:forEach var="vo" items="${list}">
				<tr style="border:1px">
					<td>${vo.theaterName}</td>
					<td>${vo.location}</td>
					<td>${vo.sitCount}</td>
					<td>${vo.roomNum}</td>
					<td><a href="${pageContext.request.contextPath}/roomDel?roomSerialNum=${vo.roomSerialNum}">삭제</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="page">
		<c:if test="${startPageNum>10 }">
			<a href="${pageContext.request.contextPath}/roomlist?pageNum=${startPageNum-1 }">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
			<c:choose>
				<c:when test="${pageNum==i }">
					<a href="${pageContext.request.contextPath}/roomlist?pageNum=${i}"><span style="color:red">[${i }]</span></a>
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath}/roomlist?pageNum=${i}"><span style="color:black">[${i }]</span></a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${endPageNum<pageCount }">
			<a href="${pageContext.request.contextPath}/roomlist?pageNum=${endPageNum+1 }">[다음]</a>
		</c:if>
	</div>
</div>

<div class="footer">
	<jsp:include page="footer.jsp"/>
</div>
</body>
</html>
