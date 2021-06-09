<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>main.jsp</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/footer.css">
</head>

<body>
<div class="header">
	<jsp:include page="header.jsp"/>
</div>

<div class="main">
	<h1>공지사항</h1>
<table border="1" width="500">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>등록일</th>
		<c:if test="${sessionScope.id=='admin'}">
		<th>삭제</th>
		<th>수정</th>
		</c:if>
	<tr>
	<c:forEach var="vo" items="${list}">
		<tr>
			<td>${vo.noticeNum}</td>
			<td><a href="${pageContext.request.contextPath}/ntdetail?noticeNum=${vo.noticeNum}">${vo.title}</a></td>
			<td>${vo.writedate}</td>
			<c:if test="${sessionScope.id=='admin'}">
				<td><a href="${pageContext.request.contextPath}/delMember2?noticeNum=${vo.noticeNum}">삭제</a></td>
				<td><a href="${pageContext.request.contextPath}/ntupdate?noticeNum=${vo.noticeNum}">수정</a></td>
			</c:if>
		</tr>
	</c:forEach>
</table>

<div>
	<c:if test="${startPageNum>10 }">
		<a href="${pageContext.request.contextPath}/ntlist?pageNum=${startPageNum-1 }">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
		<c:choose>
			<c:when test="${pageNum==i }">
				<a href="${pageContext.request.contextPath}/ntlist?pageNum=${i}"><span style="color:blue">[${i }]</span></a>
			</c:when>
			<c:otherwise>
				<a href="${pageContext.request.contextPath}/ntlist?pageNum=${i}"><span style="color:gray">[${i }]</span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${endPageNum<pageCount }">
		<a href="${pageContext.request.contextPath}/ntlist?pageNum=${endPageNum+1 }">[다음]</a>
	</c:if>
</div>
</div>

<div class="footer">
	<jsp:include page="footer.jsp"/>
</div>
</body>
</html>
