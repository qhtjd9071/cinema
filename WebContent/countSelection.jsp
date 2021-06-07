<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>
<%
	String showNum=request.getParameter("showNum");
%>
<div class="header2">
	<jsp:include page="header2.jsp"/>
</div>

<div class="count_container">
<div class="count_wrapper_container">
	<div class="count_wrapper">
		<div class="count_content">
			<div class="seat_select">
				<div class="group_top">
					<h4>인원 선택</h4>
				</div>
				<div class="seat_inner">
					<div class="person_count">
						<div class="select_numpeople">
							<form action="selection" method="post" class="select_form">
								<input type="hidden" value="<%=showNum %>" name="showNum">
								<label id="adult" >
									성인
									<div class="count">
										<input type="button" value="-" id="adultBtnMinus" class="count_minus">
										<div id="adultCountDiv" class="count_number">0</div>
										<input type="hidden" value="0" id="adultCount">
										<input type="button" value="+" id="adultBtnPlus" class="count_plus">
									</div>
								</label>
								<label id="teen">
									청소년
									<div class="count">
										<input type="button" value="-" id="teenBtnMinus" class="count_minus">
										<div id="teenCountDiv" class="count_number">0</div>
										<input type="hidden" value="0" id="teenCount">
										<input type="button" value="+" id="teenBtnPlus" class="count_plus">
									</div>
								</label>
								<input type="submit" value="확인" id="ok">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
<div class="footer">
	<jsp:include page="footer.jsp"/>
</div>
</body>
<script type="text/javascript">
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
	tbp.addEventListener("click",function(e){
		teenNum+=1;
		tc.value=teenNum;
		tcd.innerHTML=tc.value;
	});
</script>
</html>