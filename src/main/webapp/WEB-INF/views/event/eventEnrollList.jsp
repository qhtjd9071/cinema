<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>이벤트 목록 보기</title>
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
		<jsp:include page="../layout/ad_header.jsp"/>
</div>

<div class="main">
	<div class="title_top">
		<h1>이벤트 목록 보기</h1>
	</div>
	<div class="tab">
		<table border="0" width="500" class="text_c">
			<colgroup>
				<col style="width: 30%">
				<col style="width: auto%">
				<col style="width: 20%">
				<col style="width: 20%">
			</colgroup>
				<tr style="border:solid;">
					<th>제목</th>
					<th>내용</th>
					<th>삭제</th>
					<th>작성일</th>
				</tr>
			<c:forEach var="vo" items="${list}">
				<tr style="border:1px;">
					<td>${vo.title}</td>
					<td>${vo.content}</td>
					<td><a href="${cp}/event/delete?id=${vo.id}">삭제</a></td>
					<td>${vo.createDate }</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="page">
		<c:if test="${pageUtil.startPageNum > 2 }">
			<a href="${cp}/event/list?pageNum=${pageUtil.startPageNum - 1}">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${pageUtil.startPageNum}" end="${pageUtil.endPageNum}">
			<c:choose>
				<c:when test="${pageUtil.pageNum==i }">
					<a href="${cp}/event/list?pageNum=${i}"><span style="color:red">[${i}]</span></a>
				</c:when>
				<c:otherwise>
					<a href="${cp}/event/list?pageNum=${i}"><span style="color:black">[${i}]</span></a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${pageUtil.endPageNum < pageUtil.totalPageCount}">
			<a href="${cp}/event/list?pageNum=${pageUtil.endPageNum + 1}">[다음]</a>
		</c:if>
	</div>
</div>

<div class="footer">
	<jsp:include page="../layout/footer.jsp"/>
</div>
</body>
</html>
