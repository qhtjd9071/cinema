package jhr.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jhr.dao.MyUsersDao;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		MyUsersDao dao=new MyUsersDao();
		boolean b=dao.isMember(id, pwd);
		if(b) {
			HttpSession session=req.getSession();
			session.setAttribute("id",id);
			resp.sendRedirect("main.jsp");
		}else {
			req.setAttribute("errMsg","아이디, 비밀번호가 일치하지 않습니다.");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}
}






