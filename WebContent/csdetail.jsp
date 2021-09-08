<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 상세</title>
<style>
	.dtlistbox{text-align: center !important;width: 100%;
    border-collapse: collapse;
    border-spacing: 0;
    border: 0;
    box-sizing: border-box;
    text-indent: initial;}
</style>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/csdetail.css">
<link rel="stylesheet" href="css/header2.css">
<link rel="stylesheet" href="css/footer.css">
</head>
<body>
<div class="header2">
      <jsp:include page="header2.jsp"/>
</div>
<div class="content">
	<div class="content_container">
		<h1>글상세페이지</h1>
		<table class="dtlistbox">
			<tr>
				<th>글번호</th>
				<td>${vo.customerNum }</td>
				<th>글제목</th>
				<td>${vo.title }</td>
				<th>작성자</th>
				<td>${vo.writer }</td>
			</tr>
			<tr>
				<td style="font-weight:bold;">내용</td>
				<td colspan="5"><div style="text-align:left;padding:10px;">${vo.content }</div></td>
			</tr>
			<c:if test="${sessionScope.id=='admin'}">
				<tr>
					<td colspan="2"><a href="csinsert.jsp?customerNum=${vo.customerNum}&ref=${vo.ref}&lev=${vo.lev}&step=${vo.step}">답글</a></td>
				</tr>
			</c:if>
		</table>
	</div>
</div>
<div class="footer">
   <jsp:include page="footer.jsp"/>
</div>
</body>
</html>
