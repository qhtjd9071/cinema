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
<c:choose>
	<c:when test="${result=='success'}">
		<h1>성공적으로 접수되었습니다. 빠른 시간 내에 답변 드리겠습니다.
		문의하신 내역은 문의목록 에서 확인하실수 있습니다.
		항상 노력하는 롯데시네마가 되겠습니다.</h1>
	</c:when>
	<c:otherwise>
		<h1>요청작업 실패!!!</h1>
	</c:otherwise>
</c:choose>
<a href="csmain.jsp">메인으로 이동</a>
</body>
</html>