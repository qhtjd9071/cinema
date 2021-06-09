<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</body>
</html>






