<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인원 선택</title>
	<style type="text/css">
		body {background-Color:black;}
		.wrapper {background-color:white;margin:0 auto;width:500px;height:40%;}
		#ok{width:80px;height:30px;background-color:}
	</style>
</head>
<body>
<%
	String showNum=request.getParameter("showNum");
%>
<div class="wrapper">
	<form action="selection" method="post">
		<input type="hidden" value="<%=showNum %>" name="showNum">
		<label id="adult">
		성인
		<input type="button" value="-" id="adultBtnMinus">
		<input type="text" id="adultCount" name="adultCount" value="0" readonly="readonly">
		<input type="button" value="+" id="adultBtnPlus">
		</label>
		<br>
		<label id="teen">
		청소년
		<input type="button" value="-" id="teenBtnMinus">
		<input type="text" id="teenCount" name="teenCount" value="0" readonly="readonly">
		<input type="button" value="+" id="teenBtnPlus">
		<br>
		<input type="submit" value="확인" id="ok">
		</label>
	</form>
</div>
</body>
<script type="text/javascript">
	const abm=document.getElementById("adultBtnMinus");
	const abp=document.getElementById("adultBtnPlus");
	const ac=document.getElementById("adultCount");
	
	const tbm=document.getElementById("teenBtnMinus");
	const tbp=document.getElementById("teenBtnPlus");
	const tc=document.getElementById("teenCount");
	
	let adultNum=parseInt(ac.value);
	abm.addEventListener("click",function(e){
		if(adultNum>0){
		adultNum-=1;
		ac.value=adultNum;
		}
	});
	abp.addEventListener("click",function(e){
		adultNum+=1;
		ac.value=adultNum;
	});
	
	let teenNum=parseInt(tc.value);
	tbm.addEventListener("click",function(e){
		if(teenNum>0){
		teenNum-=1;
		tc.value=teenNum;
		}
	});
	tbp.addEventListener("click",function(e){
		teenNum+=1;
		tc.value=teenNum;
	});
</script>
</html>