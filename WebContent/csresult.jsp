<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
.btnwrap{margin: 60px 0;
    text-align: center;
}

.bgb{    background: (/css/login/e339dfaae8d74acfbf7b0c6987442ac8) no-repeat 50% 0;
    padding-top: 135px;
    margin: 55px 0 85px 0;
    text-align: center;}
.mainbtn{    height: 45px;
    line-height: 43px;
    padding: 0 18px;    margin: 0 3px;
    min-width: 160px;    text-decoration: none;
    cursor: pointer;    display: inline-block;
    box-sizing: border-box;
    border-radius: 4px;
    border: 1px solid #414141;
    font-size: 14px;
    color: #ffffff !important;
    text-align: center;
    vertical-align: middle;
    background-color: #414141;}
    
.cslistbtn{    height: 45px;
    line-height: 43px;
    padding: 0 18px;    margin: 0 3px;
    min-width: 160px;
    text-decoration: none;
    cursor: pointer;    display: inline-block;
    box-sizing: border-box;
    border-radius: 4px;
    border: 1px solid #000000;
    font-size: 14px;
    color: #000000 !important;
    text-align: center;
    vertical-align: middle;
    background-color: #ffffff;}    
</style>
<meta charset="UTF-8">
<title>결과</title>
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
   <div class="movie">
      <div class="movie_container">
      <c:choose>
	<c:when test="${result=='success'}">
	<img src="/images/sg.JPG">
	<div class="bgb">
		<h1>성공적으로 접수되었습니다.빠른 시간 내에 답변 드리겠습니다.
		<br>
		문의하신 내역은 문의목록 에서 확인하실수 있습니다.
		<br>
		항상 노력하는 로또시네마가 되겠습니다.</h1>
	</div>
	</c:when>
	<c:otherwise>
		<h1>요청작업 실패!!!</h1>
	</c:otherwise>
</c:choose>
		<div class="btnwrap">
<a href="csmain.jsp" class="mainbtn">메인으로 이동</a>
<a href="cslist?pageNum=1" class="cslistbtn">문의목록 가기</a>
		</div>
      </div>
   </div>
   <div class="footer">
      <jsp:include page="footer.jsp"/>
   </div>

</body>
</html>