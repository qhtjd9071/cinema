package jhr.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jhr.dao.UsersDao;
import semi.vo.usersVo;

@WebServlet("/update")
public class UpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		UsersDao dao=new UsersDao();
		usersVo vo=dao.getinfo(id);
		req.setAttribute("vo",vo);
		req.getRequestDispatcher("/mypage_myinfo.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");	
		String pwd=req.getParameter("pwd");	
		String name=req.getParameter("name");
		String email=req.getParameter("email");	
		String phone=req.getParameter("phone");
		String year=req.getParameter("year");	
		String delUser=req.getParameter("delUser");	
		usersVo vo=new usersVo(0, id, pwd, name, email, phone, year, null);
		UsersDao dao=new UsersDao();
		int n=dao.update(vo);
		if(n>0) {
			req.setAttribute("result","success");
		}else {
			req.setAttribute("result","fail");
		}
		req.getRequestDispatcher("/mypage_payList.jsp").forward(req, resp);
	}
}











