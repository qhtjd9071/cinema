package jhr.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jhr.dao.UsersDao;
<<<<<<< HEAD
import semi.vo.usersVo;
=======
import semi.vo.UserVo;
>>>>>>> branch 'master' of https://github.com/qhtjd9071/semi.git

@WebServlet("/join")
public class JoinController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("join.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name=req.getParameter("name");
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		String email=req.getParameter("email");
		String year=req.getParameter("year");
		String phone=req.getParameter("phone");

<<<<<<< HEAD
		usersVo vo=new UsersVo(name, id, pwd, email, year, phone);
=======
		UserVo vo=new UserVo(name, id, pwd, email, year, phone);
>>>>>>> branch 'master' of https://github.com/qhtjd9071/semi.git
		UsersDao dao=new UsersDao();
		int n=dao.insert(vo);
		
		if(n>0) {
			req.setAttribute("result","success");
		}else {
			req.setAttribute("result","fail");
		}
		req.getRequestDispatcher("/main.jsp").forward(req, resp);
	}
}














