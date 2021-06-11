package admin.controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.showDao;
@WebServlet("/showDel")
public class showDelController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int showNum=Integer.parseInt(req.getParameter("showNum"));
		showDao dao=showDao.getInstance();
		int result=dao.delete(showNum);
		if(result<=0) {
			req.setAttribute("errMsg", "fail");
		}
		req.getRequestDispatcher("/showlist").forward(req, resp);
	}
}
