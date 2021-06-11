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

@WebServlet("/delCon")
public class delController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		String pwd=req.getParameter("pwd");
		UsersDao dao=new UsersDao();
		boolean check=dao.check(id, pwd);
		if(check==true) {
			usersVo vo=new usersVo();
			vo.setId(id);
			int n=dao.delaccount(vo);
			
			if(n>0) {
				req.setAttribute("result","success");
				session.invalidate();
				resp.sendRedirect(req.getContextPath()+"/main.jsp");
			}else {
				req.setAttribute("result","fail");
			}
		}else {
			resp.sendRedirect(req.getContextPath()+"/delAccount.jsp");
		}
		
	}
}
