package admin.controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.showDao;
@WebServlet("/eventDel")
public class eventDelController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int eventNum=Integer.parseInt(req.getParameter("eventNum"));
		showDao dao=showDao.getInstance();
		int result=dao.delete(eventNum);
		if(result<=0) {
			req.setAttribute("errMsg", "fail");
		}
		req.getRequestDispatcher("/eventlist").forward(req, resp);
	}
}
