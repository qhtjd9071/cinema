<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 작성</title>
<style>
.movie {
	width:100%;
	display:block;
	box-sizing:border-box;
	margin:0;
	padding:200px 0 0 0;
}
.movie_container {
	max-width:980px;
	display:block;
	box-sizing:border-box;
	margin:0 auto;
	padding:0;
}

#movieoretc{margin-left: 5px;}
	.titdiv{    margin: 20px 0 50px 0;display: block;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;}
    
	.tit{    padding-bottom: 5px;
    font-size: 15px;
    color: #000;}
    
    .tit2{    font-size: 12px;
    color: #707070;
    line-height: 1.3;}
    
    .titcolor{    color: #ff7787 !important;}
    
	.bun{    border:none;
    background: #fff url(../images/icon/arr_dw_13.png);
    background-repeat: no-repeat;
    background-position: right 6px top 50%;
    height: 40px;
    line-height: 40px;
    padding: 0 20px 0 0;
    font-size: 14px;
    box-sizing: border-box;
    font-size:16px;}
    
	.title{border: 1px solid #DDD;
    background: #fff url(../images/icon/arr_dw_13.png);
    background-repeat: no-repeat;
    background-position: right 6px top 50%;
    height: 40px;
    line-height: 40px;
    padding: 0 35px 0 18px;
    padding-bottom:0 !important;
    font-size: 14px;
    box-sizing: border-box;
    background-color: #F8F8F8;
    border-color: #DDD;
    border-bottom:1px solid #DDD !important;}
    
    .content{background-color: #F8F8F8;
    border-color: #DDD;
    padding:18px !important;
    }
	
    .btn2{    height: 45px;
    line-height: 43px;
    padding: 0 18px;margin: 0 3px;
    min-width: 160px;text-decoration: none;
    cursor: pointer;    display: inline-block;
    box-sizing: border-box;
    border-radius: 4px;
    border: 1px solid #414141;
    font-size: 14px;
    color: #ffffff !important;
    text-align: center;
    vertical-align: middle;
    background-color: #414141;}
    
     .btn3{height: 45px;
    line-height: 43px;
    padding: 0 18px;margin: 0 3px;
    min-width: 160px;text-decoration: none;
    cursor: pointer;   display: inline-block;
    box-sizing: border-box;
    border-radius: 4px;
    border: 1px solid #000000;
    font-size: 14px;
    color: #000000 !important;
    text-align: center;
    vertical-align: middle;
    background-color: #ffffff;}
    .mov_title {padding-bottom:40px; border-bottom:1px solid #000; margin-bottom:30px;}
</style>
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
      <h1 class="mov_title">문의내용</h1><p style=color:red;>*필수입력</p>
      <dl class="titdiv">
      <dt class="tit">고객님의 문의에<span class="titcolor">답변하는 직원은 고객 여러분의 가족 중 한 사람</span>일 수 있습니다.</dt>
      <dd class="tit2">고객의 언어폭력(비하, 욕설, 반말, 성희롱 등)으로부터 직원을 보호하기 위해 관련 법에 따라 수사기관에 필요한 조치를 요구할 수 있으며, 형법에 의해 처벌 대상이 될수 있습니다.</dd>
      </dl>
<label class="bun"for="movieoretc">*분류</label>
<select name="movieoretc" id="movieoretc">
	<option value="영화관">영화관</option>
	<option value="기타">기타</option>
</select>

<form action="csinsert" method="post">
	<input type="hidden" name="customerNum" value="${param.customerNum}">
	<input type="hidden" name="ref" value="${param.ref}">
	<input type="hidden" name="lev" value="${param.lev}">
	<input type="hidden" name="step" value="${param.step}">
	*제목<br>
	<input placeholder="제목을 입력해주세요" class="title" type="text" name="title"><br>
	*내용<br>
	<textarea placeholder="내용을 입력해주세요"class="content" rows="20" cols="100" name=content></textarea><br>
	<input style="width: 20%; left: 80%;" class="btn2" type="submit" value="등록" >
	<input style="width: 20%; left: 60%;" class="btn3" type="button" value="취소" onclick="history.back()">


	
	

	</div>
</form>
      </div>
   </div>
   <div class="footer">
      <jsp:include page="footer.jsp"/>
   </div>

</body>
</html>