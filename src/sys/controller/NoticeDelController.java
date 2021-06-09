package sys.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sys.dao.noticeDao;
@WebServlet("/delMember2")
public class NoticeDelController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("noticeNum"));
		noticeDao dao=noticeDao.getInstance();
		int n=dao.delete(num);
		if(n>0) {
			resp.sendRedirect(req.getContextPath()+"/ntlist");
		}else {
			req.setAttribute("result", "fail");
			req.getRequestDispatcher("/ntresult.jsp").forward(req, resp);
		}
	}
}
