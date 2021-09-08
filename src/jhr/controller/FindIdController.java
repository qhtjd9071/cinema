package jhr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.db.dbCon;

@WebServlet("/findid.do")
public class FindIdController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String test=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=dbCon.getConnection();
			String sql="select * from users where name like '%'||?||'%' and email like '%'||?||'%'";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setString(2,email);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				test="<h1>���̵� ã�� ���</h1>"+"<br>"+"���̵� :"+ rs.getString("id")+"<br>";
			}else {
				test="<h1>����Ͻ� ������ ��ġ�ϴ� ���̵� �������� �ʽ��ϴ�</h1>";
			}		
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, rs);
		}
		req.setAttribute("test",test);
		req.getRequestDispatcher("/findidResult.jsp").forward(req, resp);
	}
}