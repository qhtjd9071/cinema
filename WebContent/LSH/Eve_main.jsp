<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 이벤트페이지 메인 -->
<style>
	*{margin:0px;padding:0px;}
	#wrap{width:1000px;height:1200px;margin:auto;margin-top:40px;}
	#header{width:100%;height:20%;background-color:gray;}
	#main{width:100%;height:70%;}
	#footer{width:100%;height:10%;background-color:pink;}
</style>
</head>
<body>

<div id="wrap">
	<div id="header">
		<h1 align="center">롯데시네마 로고</h1>
		<h2 align="center">메뉴</h2>
		<div id="header2">
			<h2 align="left">전체 이벤트</h2>
		</div>
	</div>
	<div id="main">
		<div id="movie">
		<h3 align="left">영화</h3>
			<a href="/LSH/event.do?eventNum=1"><img src="../images/event/1.jpg"></a>
			<a href=""><img src="../images/event/2.jpg"></a>
			<a href=""><img src="../images/event/3.jpg"></a>
		</div>
		<div id="showcase">
		<h3 align="left">시사회/무대인사</h3>
			<a href=""><img src="../images/event/4.jpg"></a>
			<a href=""><img src="../images/event/5.jpg"></a>
			<a href=""><img src="../images/event/6.jpg"></a>
		</div>
		<div id="hot">
		<h3 align="left">HOT</h3>
			<a href=""><img src="../images/event/7.jpg"></a>
			<a href=""><img src="../images/event/8.jpg"></a>
			<a href=""><img src="../images/event/9.jpg"></a>
		</div>
		<div id="sale">
		<h3 align="left">제휴할인</h3>
			<a href=""><img src="../images/event/10.jpg"></a>
			<a href=""><img src="../images/event/11.jpg"></a>
			<a href=""><img src="../images/event/12.jpg"></a>
		</div>
	</div>
	<div id="footer">
		
	</div>
</div>
</body>
</html>
