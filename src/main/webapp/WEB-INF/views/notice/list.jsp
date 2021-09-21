<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal.username" var="logined"/>
</sec:authorize>
<!DOCTYPE html>
<html>
<head>
<title>공지사항</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="${cp}/resources/css/ntlist.css">
<link rel="stylesheet" href="${cp}/resources/css/header.css">
<link rel="stylesheet" href="${cp}/resources/css/footer.css">
</head>
<body>
<div class="header">
	<c:if test="${logined == 'admin'}">
		<jsp:include page="../layout/ad_header.jsp"/>
	</c:if>
	<c:if test="${logined != 'admin'}">
		<jsp:include page="../layout/header.jsp"/>
	</c:if>
</div>

<div class="main">
	<div class="title_top">
		<h1 class="title">공지사항</h1>
	</div>
	<div class="tab">
		<table border="0" width="500" class="text_c">
			<colgroup>
				<col style="width: 20%">
				<col style="width: auto%">
				<col style="width: 15%">
				<col style="width: 15%">
			</colgroup>
				<tr style="border:solid;">
					<th>번호</th>
					<th>제목</th>
					<th>등록일</th>
					<th>조회수</th>
					<c:if test="${logined == 'admin'}">
					<th>삭제</th>
					<th>수정</th>
					</c:if>
				</tr>
			<c:forEach var="vo" items="${list}">
				<tr style="border:1px">
					<td>${vo.id}</td>
					<td class="text_l"><a style="color:gray;text-decoration:none;" href="${cp}/notice/detail?id=${vo.id}">${vo.title}</a></td>
					<td>${vo.createDate}</td>
					<td>${vo.hit}</td>
					<c:if test="${logined == 'admin'}">
						<td><a href="${cp}/notice/delete?id=${vo.id}">삭제</a></td>
						<td><a href="${cp}/notice/update?id=${vo.id}">수정</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="page">
		<c:if test="${pageUtil.startPageNum > 2 }">
			<a href="${cp}/notice/list?pageNum=${pageUtil.startPageNum - 1}">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${pageUtil.startPageNum}" end="${pageUtil.endPageNum}">
			<c:choose>
				<c:when test="${pageUtil.pageNum==i }">
					<a href="${cp}/notice/list?pageNum=${i}"><span style="color:red">[${i}]</span></a>
				</c:when>
				<c:otherwise>
					<a href="${cp}/notice/list?pageNum=${i}"><span style="color:black">[${i}]</span></a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${pageUtil.endPageNum < pageUtil.totalPageCount}">
			<a href="${cp}/notice/list?pageNum=${pageUtil.endPageNum + 1}">[다음]</a>
		</c:if>
	</div>
</div>

<div class="footer">
	<jsp:include page="../layout/footer.jsp"/>
</div>
</body>
</html>
