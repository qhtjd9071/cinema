<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>saveid.jsp</title>
</head>
<body>
<%
	String id=request.getParameter("id");
	String chk=request.getParameter("chk");
	if(chk==null){
		Cookie cook1=new Cookie("id","");
		cook1.setMaxAge(0);
		cook1.setPath("/");
		response.addCookie(cook1);
	}else{
		Cookie cook1=new Cookie("id",id);
		cook1.setMaxAge(60*60*24*7);
		cook1.setPath("/");
		response.addCookie(cook1);
	}
%>
</body>
</html>
