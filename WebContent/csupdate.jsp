<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 수정</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap">

<link rel="stylesheet" href="css/csupdate.css">
<link rel="stylesheet" href="css/header2.css">
<link rel="stylesheet" href="css/footer.css">

</head>
<body>
<div class="header2">
   <jsp:include page="header2.jsp"/>
</div>

<div class="content">
	<div class="content_container">
		<h1>1:1문의 수정</h1><p style=color:red;>*필수입력</p>
		<dl class="titdiv">
			<dt class="tit">고객님의 문의에<span class="titcolor">답변하는 직원은 고객 여러분의 가족 중 한 사람</span>일 수 있습니다.</dt>
			<dd class="tit2">고객의 언어폭력(비하, 욕설, 반말, 성희롱 등)으로부터 직원을 보호하기 위해 관련 법에 따라 수사기관에 필요한 조치를 요구할 수 있으며, 형법에 의해 처벌 대상이 될수 있습니다.</dd>
		</dl>
		
		<label class="bun"for="movieoretc">*분류</label>
		<select name="movieoretc" id="movieoretc">
			<option value="영화관">영화관</option>
			<option value="기타">기타</option>
		</select>
	      
		<form method="post" action="csupdate">
			글번호<span class="nch">(변경불가)</span><br>
			<input class="num" type="text" name="customerNum" value="${vo.customerNum}" readonly="readonly"><br><br>
			
			작성자<span class="nch">(변경불가)</span><br>
			<input class="writer" type="text" name="writer" value="${vo.writer}" readonly="readonly"><br><br>
			
			*제목<br>
			<input class="title" type="text" name="title" value="${vo.title}"><br><br>
			
			*글내용<br>
			<input class="post_content" type="text" name="content" rows="20" cols="100" value="${vo.content}" ><br><br>
			
			등록일<span class="nch">(변경불가)</span><br>
			<input placeholder="자동등록"class="date" type="text"  value="${vo.writedate}" readonly="readonly"><br><br>
			
			<input style="width: 20%; left: 80%;" class="btn2" type="submit" value="저장">
			<input style="width: 20%; left: 60%;" class="btn3" type="button" value="취소" onclick="history.back()">
		</form>
	</div>
</div>
   
<div class="footer">
	<jsp:include page="footer.jsp"/>
</div>

</body>
</html>