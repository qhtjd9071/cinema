<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>전체글목록</h1>
<table border="1" width="500">
	<tr>
		<th>글번호</th>
		<th>작성자</th>
		<th>제목</th>
		<th>글내용</th>
		<th>작성날짜</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	<c:forEach var="vo" items="${requestScope.list }">
		<tr>
			<td>${vo.customerNum }</td>
			<td>${vo.writer}</td>
			<td><a href="csdetail?customerNum=${vo.customerNum}">
			<c:if test="${vo.lev>0 }">
				<c:forEach var="i" begin="1" end="${vo.lev}">
					&nbsp;[re]
				</c:forEach>
			</c:if>
			${vo.title }</a></td></td>
			<td>${vo.content }</td>	
			<td>${vo.writeDate}</td>
			<td><a href="delMember?customerNum=${vo.customerNum}">삭제</a></td>
			<td><a href="csupdate?customerNum=${vo.customerNum}">수정</a></td>
			<!-- 답글인경우 들여쓰기하기 -->
		</tr>
	</c:forEach>
</table>
<!-- 페이징 처리 -->
<div>
	<c:if test="${startPageNum>10 }">
		<a href="cslist?pageNum=${startPageNum-1 }">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
		<c:choose>
			<c:when test="${pageNum==i }"><%--현재페이지인경우 --%>
				<a href="cslist?pageNum=${i }"><span style="color:blue">[${i }]</span></a>
			</c:when>
			<c:otherwise>
				<a href="cslist?pageNum=${i }"><span style="color:gray">[${i }]</span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${endPageNum<pageCount }">
		<a href="cslist?pageNum=${endPageNum+1 }">[다음]</a>
	</c:if>
</div>
</body>
</html>
