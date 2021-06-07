<%@page import="semi.vo.bookVo"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#seatArea{width:600px;margin:0 auto;}
	#seatArea div{width:50px;height:50px;text-align:center;background-color:gray;display:inline-block;margin:10px;}
	#rating{width:200px;hegiht:150px;margin:0 auto;color:blue}
</style>
<script type="text/javascript">
		//배열 초기화
		const book=new Array(${getCount });
		for(let i=0;i<book.length;i++){
			book[i]="";
		}
		const count=new Array(${getCount });
		for(let i=0;i<count.length;i++){
			count[i]=0;
		}
		let selectCount=0;
</script>
</head>
<body>
<div id="rating">이 영화는 <span style="color:red">${rating}세</span>이상 관람가능한 영화입니다.</div>
<div id="seatArea"></div>
<c:forEach var="i" begin="1" end="${getCount }">
<c:forEach var="vo" items="${list}">
	<script type="text/javascript">
	function cnt(){
		if(${vo.seatNum==i}){
			count[${i}-1]+=1;
		}
	}
	cnt();
	</script>
</c:forEach>
<script type="text/javascript">
	function controllSeat(){
		const seatArea=document.getElementById("seatArea");
		//좌석 배열
		let div=document.createElement("div");
		let seatNum=${i}%8;
		if(${i}%8==0){
			seatNum=8;
		}
		if(${i}/8<=1){
			div.innerHTML="A"+seatNum;
		}else if(${i}/8<=2){
			div.innerHTML="B"+seatNum;
		}else if(${i}/8<=3){
			div.innerHTML="C"+seatNum;
		}else if(${i}/8<=4){
			div.innerHTML="D"+seatNum;
		}
			seatArea.appendChild(div);
		
		//좌석에 값 할당
		let input=document.createElement("input");
		input.type="hidden";
		let input2=document.createElement("input");
		input2.type="hidden";
		input2.value=${i};
		if(count[${i}-1]!=0){
			div.style.backgroundColor="red";
			input.value="using";
		}
		
		//좌석 클릭처리
		div.addEventListener("click",function(e){
			if(input.value=="using"){
				alert("예매된 좌석입니다");
			}else{
				if(input.value=="check"){
					div.style.backgroundColor="gray";
					input.value="none";
					book[${i}-1]="";
					selectCount-=1;
				}else{
					if(selectCount<${totalCount}){
					div.style.backgroundColor="pink";
					input.value="check";
					book[${i}-1]=input2.value;
					selectCount+=1;
					}
				}
			}
		});
	}
	controllSeat();
	</script>
</c:forEach>
<a href="#" onclick="transfer()">결제하기</a>
<script type="text/javascript">
	//서버로 선택좌석 정보 전송
	function transfer(){
		var parameter={"array":book}
		var aa=JSON.stringify(parameter);
		console.log(aa);
		let xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
					let json=xhr.responseText;
					let bna=JSON.parse(json);
					alert(json);
					kakaoPay(xhr,json);
				}
		}
		xhr.open("post","book",true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send("aa="+aa);
	}
	
	function kakaoPay(xhr,json){
		let toss={"bookNum":json,"id":"testid","${sessionScope.id}":"testtitle","count":selectCount,"total":${adultCount}+${teenCount}};
		let jsonToss=JSON.stringify(toss);
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
					let json=xhr.responseText;
					location.href=json;
				}
		}
		xhr.open("post","kakao",true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send("toss="+jsonToss);
	}
</script>
</body>
</html>