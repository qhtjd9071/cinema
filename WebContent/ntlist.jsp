<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>공지사항</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/ntlist.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/footer.css">
</head>
<script type="text/javascript">
	window.onload=function(){
		if("${result}"=="insert_success"){
			alert("글 등록 성공");
		}else if("${result}"=="insert_fail"){
			alert("글 등록 실패");
		}else if("${result}"=="update_success"){
			alert("글 수정 성공");
		}else if("${result}"=="update_fail"){
			alert("글 수정 실패");
		}else if("${result}"=="delete_success"){
			alert("글 삭제 성공");
		}else if("${result}"=="delete_fail"){
			alert("글 삭제 실패");
		}
	}
</script>
<body>
<div class="header">
	<c:if test="${sessionScope.id=='admin'}">
		<jsp:include page="ad_header.jsp"/>
	</c:if>
	<c:if test="${sessionScope.id!='admin'}">
		<jsp:include page="header2.jsp"/>
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
					<c:if test="${sessionScope.id=='admin'}">
					<th>삭제</th>
					<th>수정</th>
					</c:if>
				</tr>
			<c:forEach var="vo" items="${list}">
				<tr style="border:1px">
					<td>${vo.noticeNum}</td>
					<td class="text_l"><a style="color:gray;text-decoration:none;" href="${pageContext.request.contextPath}/ntdetail?noticeNum=${vo.noticeNum}">${vo.title}</a></td>
					<td>${vo.writedate}</td>
					<td>${vo.hit}</td>
					<c:if test="${sessionScope.id=='admin'}">
						<td><a href="${pageContext.request.contextPath}/delMember2?noticeNum=${vo.noticeNum}">삭제</a></td>
						<td><a href="${pageContext.request.contextPath}/ntupdate?noticeNum=${vo.noticeNum}">수정</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="page">
		<c:if test="${startPageNum>10 }">
			<a href="${pageContext.request.contextPath}/ntlist?pageNum=${startPageNum-1 }">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
			<c:choose>
				<c:when test="${pageNum==i }">
					<a href="${pageContext.request.contextPath}/ntlist?pageNum=${i}"><span style="color:red">[${i }]</span></a>
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath}/ntlist?pageNum=${i}"><span style="color:black">[${i }]</span></a>
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
