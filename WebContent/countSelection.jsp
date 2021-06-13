<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인원 선택</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/countSelection.css">
<link rel="stylesheet" href="css/header2.css">
<link rel="stylesheet" href="css/footer.css">
<style type="text/css">
	#seatArea{width:560px;margin:0 auto; align-items:center;}
	#seatArea div{width:50px;height:50px;text-align:center;background-color:gray;display:inline-block;margin:10px;}
	#rating{width:600px; text-align:center; hegiht:150px;margin:0 auto;margin-bottom:30px;color:blue}
	#seatCount{width:200px;hegiht:150px;margin:0 auto;color:blue}
</style>
<script type="text/javascript">
		const count=new Array(${getCount });
		let totSeat=0;
		for(let i=0;i<count.length;i++){
			count[i]=0;
		}
</script>
</head>
<body>
<div class="header2">
	<jsp:include page="header2.jsp"/>
</div>

<div class="count_container">
	<div class="count_wrapper_container">
		<div class="count_wrapper">
			<div class="seat_select">
				<div class="group_top">
					<h4>인원 선택</h4>
				</div>
				<div class="seat_inner">
					<div class="person_count">
						<div class="select_numpeople">
							<form action="selection" method="post" class="select_form">
								<input type="hidden" value="${showNum}" name="showNum">
								<label id="adult" >
									성인
									<div class="count">
										<input type="button" value="-" id="adultBtnMinus" class="count_minus">
										<div id="adultCountDiv" class="count_number">0</div>
										<input type="hidden" value="0" id="adultCount" name="adultCount">
										<input type="button" value="+" id="adultBtnPlus" class="count_plus">
									</div>
								</label>
								<label id="teen">
									청소년
									<div class="count">
										<input type="button" value="-" id="teenBtnMinus" class="count_minus">
										<div id="teenCountDiv" class="count_number">0</div>
										<input type="hidden" value="0" id="teenCount" name="teenCount">
										<input type="button" value="+" id="teenBtnPlus" class="count_plus">
									</div>
								</label>
								<input type="submit" value="확인" id="ok">
							</form>
						</div>
					</div>
					<div id="rating">이 영화는 <span style="color:red">${rating}세</span>이상 관람가능한 영화입니다.</div>
					<div id="seatArea"></div>
					<div id="seatCount">
					좌석수 : 
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
	<c:forEach var="i" begin="1" end="${getCount }">
		<c:forEach var="vo" items="${list}">
			<script type="text/javascript">
			function cnt(){
				if(${vo.seatNum==i}){
					count[${i}-1]+=1;
					totSeat+=1;
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
				seatArea.appendChild(div);
				
			if(count[${i}-1]!=0){
				div.style.backgroundColor="black";
			}
		}
		controllSeat();
		</script>
	</c:forEach>

<div class="footer">
	<jsp:include page="footer.jsp"/>
</div>
</body>
<script type="text/javascript">
	const seatCount=document.getElementById("seatCount");
	seatCount.innerHTML+=totSeat+"석  /  "+${getCount}+"석";

	const abm=document.getElementById("adultBtnMinus");
	const abp=document.getElementById("adultBtnPlus");
	const ac=document.getElementById("adultCount");
	const acd=document.getElementById("adultCountDiv");
	
	const tbm=document.getElementById("teenBtnMinus");
	const tbp=document.getElementById("teenBtnPlus");
	const tc=document.getElementById("teenCount");
	const tcd=document.getElementById("teenCountDiv");
	
	let adultNum=parseInt(ac.value);
	abm.addEventListener("click",function(e){
		if(adultNum>0){
		adultNum-=1;
		ac.value=adultNum;
		acd.innerHTML=ac.value;
		}
	});
	abp.addEventListener("click",function(e){
		adultNum+=1;
		ac.value=adultNum;
		acd.innerHTML=ac.value;
	});
	
	let teenNum=parseInt(tc.value);
	tbm.addEventListener("click",function(e){
		if(teenNum>0){
		teenNum-=1;
		tc.value=teenNum;
		tcd.innerHTML=tc.value;
		}
	});
	if(${rating=="19"}){
		alert("성인만 선택 가능합니다.");
	}else{
		tbp.addEventListener("click",function(e){
			teenNum+=1;
			tc.value=teenNum;
			tcd.innerHTML=tc.value;
		});
	}
</script>
</html>