<%@page import="semi.db.MyDBCP"%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id=request.getParameter("id");
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	boolean using=false;
	try{
		con=MyDBCP.getConnection();
		String sql="select * from users where id=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,id);
		rs=pstmt.executeQuery();
		if(rs.next()){
			using=true;
		}
	}catch(SQLException s){
		s.printStackTrace();
	}finally{
		MyDBCP.close(con, pstmt, rs);
	}
	response.setContentType("text/plain;charset=utf-8");
	PrintWriter pw=response.getWriter();
	JSONObject json=new JSONObject();
	json.put("using",using);
	pw.print(json);
%>