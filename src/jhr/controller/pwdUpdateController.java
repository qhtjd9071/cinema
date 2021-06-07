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

@WebServlet("/pwdupdate")
public class pwdUpdateController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		String currPwd=req.getParameter("currpwd");
		String newPwd=req.getParameter("newpwd1");
		
		UsersDao dao=new UsersDao();
		usersVo vo= new usersVo(0, id, newPwd, null, null, null, null, null);
		boolean check=dao.check(id, currPwd);
		if(check==true) {
			int n=dao.pwdupdate(vo);
			
			if(n>0) {
				req.setAttribute("vo",vo);
				session.setAttribute("pwd", newPwd);
				req.getRequestDispatcher("/mypage.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("/pwdUpdate.jsp").forward(req, resp);
			}
		} else {
			req.getRequestDispatcher("/pwdUpdate.jsp").forward(req, resp);
		}
	}
}











