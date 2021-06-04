<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인원 선택</title>
</head>
<body>
<form action="selection" method="post">
	성인
	<input type="button" value="-" id="adultBtnMinus">
	<input type="text" id="adultCount" name="adultCount" value="0" readonly="readonly">
	<input type="button" value="+" id="adultBtnPlus">
	
	청소년
	<input type="button" value="-" id="teenBtnMinus">
	<input type="text" id="teenCount" name="teenCount" value="0" readonly="readonly">
	<input type="button" value="+" id="teenBtnPlus">
	<input type="submit" value="확인">
</form>
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