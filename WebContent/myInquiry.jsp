<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/myInquiry.css">
</head>
<body>
	<div class="content">
		<div class="content_container">
			<h1>내 문의내역</h1>
			<table>
				<tr class="tr1">
					<th>글번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>글내용</th>
					<th>삭제</th>
					<th>수정</th>
				</tr>
				<c:forEach var="vo" items="${requestScope.list }">
					<tr>
						<td class="td1">${vo.customerNum }</td>
						<td class="td1">${vo.writer }</td>
						<td>
							<a href="csdetail?customerNum=${vo.customerNum}">
							<c:if test="${vo.lev>0 }">
								<c:forEach var="i" begin="1" end="${vo.lev}">
								&nbsp;<span style="color:red">[re]</span>
								</c:forEach>
							</c:if>
							${vo.title }</a>
						</td>
						<td>${vo.content }</td>	
						<td class="td1"><a href="delMember?customerNum=${vo.customerNum}">삭제</a></td>
						<td class="td1"><a href="csupdate?customerNum=${vo.customerNum}">수정</a></td>
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
							<a href="cslist?pageNum=${i }"><span>[${i }]</span></a>
						</c:when>
						<c:otherwise>
							<a href="cslist?pageNum=${i }"><span>[${i }]</span></a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${endPageNum<pageCount }">
					<a href="cslist?pageNum=${endPageNum+1 }">[다음]</a>
				</c:if>
			</div>
		</div>
	</div> 
</body>
