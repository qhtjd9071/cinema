<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 문의글</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/cslist.css">
<link rel="stylesheet" href="css/header2.css">
<link rel="stylesheet" href="css/footer.css">
</head>
<body>
	<div class="header2">
	   <jsp:include page="header2.jsp"/>
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
				<c:forEach var="vo" items="${requestScope.list }">
					<tr class="tr1">
						<td class="td1">${vo.customerNum }</td>
						<td class="td1">${vo.writer }</td>
						<td style="text-align:left">
							<a href="csdetail?customerNum=${vo.customerNum}" style="color:gray;text-decoration:none;">
							<c:if test="${vo.lev>0 }">
								<c:forEach var="i" begin="1" end="${vo.lev}">
								&nbsp;<span style="color:red">[re]</span>
								</c:forEach>
							</c:if>
							${vo.title }</a>
						</td>
						<td>${vo.writedate}</td>
						<!-- 답글인경우 들여쓰기하기 -->
					</tr>
				</c:forEach>
			</table>
			<!-- 페이징 처리 -->
			<div class="pagenum">
				<c:if test="${startPageNum>10 }">
					<a href="cslist?pageNum=${startPageNum-1 }">[이전]</a>
				</c:if>
				<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
					<c:choose>
						<c:when test="${pageNum==i }"><%--현재페이지인경우 --%>
							<a href="cslist?pageNum=${i }"><span style="color:red">[${i }]</span></a>
						</c:when>
						<c:otherwise>
							<a href="cslist?pageNum=${i }"><span style="color:black">[${i }]</span></a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${endPageNum<pageCount }">
					<a href="cslist?pageNum=${endPageNum+1 }">[다음]</a>
				</c:if>
			</div>
		</div>
	</div>
	   
	<div class="footer">
	   <jsp:include page="footer.jsp"/>
	</div>
</body>
</html>
