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
<meta charset="UTF-8">
<title>전체 문의글</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="${cp}/resources/css/cslist.css">
<link rel="stylesheet" href="${cp}/resources/css/header2.css">
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
	
	<div class="content">
		<div class="content_container">
			<h1 class="title">문의글 목록</h1>
			<table>
				<colgroup>
					<col style="width: 15%">
					<col style="width: 15%">
					<col style="width: auto%">
					<col style="width: 15%">
				</colgroup>
				<tr>
					<th>글번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>작성일</th>
				</tr>
				<c:forEach var="vo" items="${list}">
					<tr class="tr1">
						<td class="td1">${vo.id}</td>
						<td class="td1">${vo.userId}</td>
						<td style="text-align:left">
							<a href="${cp}/customer/detail?id=${vo.id}" style="color:gray;text-decoration:none;">
							<c:if test="${vo.lev>0 }">
								<c:forEach var="i" begin="1" end="${vo.lev}">
								&nbsp;<span style="color:red">[re]</span>
								</c:forEach>
							</c:if>
							${vo.title}</a>
						</td>
						<td>${vo.createDate}</td>
					</tr>
				</c:forEach>
			</table>
			
			<div class="pagenum">
				<c:if test="${pageUtil.startPageNum > 2}">
					<a href="${cp}/customer/list?pageNum=${pageUtil.startPageNum - 1}">[이전]</a>
				</c:if>
				<c:forEach var="i" begin="${pageUtil.startPageNum }" end="${pageUtil.endPageNum}">
					<c:choose>
						<c:when test="${pageUtil.pageNum==i }"><%--현재페이지인경우 --%>
							<a href="${cp}/customer/list?pageNum=${i}"><span style="color:red">[${i}]</span></a>
						</c:when>
						<c:otherwise>
							<a href="${cp}/customer/list?pageNum=${i}"><span style="color:black">[${i}]</span></a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${pageUtil.endPageNum < pageUtil.totalPageCount}">
					<a href="${cp}/customer/list?pageNum=${pageUtil.endPageNum + 1}">[다음]</a>
				</c:if>
			</div>
		</div>
	</div>
	   
	<div class="footer">
	   <jsp:include page="../layout/footer.jsp"/>
	</div>
</body>
</html>
