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

@WebServlet("/findpwd.do")
public class FindPwdController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String year=req.getParameter("year");
		String phone=req.getParameter("phone");
		String test=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=dbCon.getConnection();
			String sql="select * from users where id=? and name=? and email=? "
					+ "and year=? and phone=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,name);
			pstmt.setString(3,email);
			pstmt.setString(4,year);
			pstmt.setString(5,phone);
			rs=pstmt.executeQuery();
			if(rs.next()) {
					test="<h1>비밀번호 찾기 결과</h1>"+"<br>"+"비밀번호 :"+ rs.getString("pwd")+"<br>";
			}else {
				test="<h1>등록하신 정보와 일치하는 비밀번호가 존재하지 않습니다</h1>";
			}		
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, rs);
		}
		req.setAttribute("test",test);
		req.getRequestDispatcher("/findpwdResult.jsp").forward(req, resp);
	}
}