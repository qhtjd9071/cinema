package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.eventDao;
@WebServlet("/eventDel")
public class eventDelController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int eventNum=Integer.parseInt(req.getParameter("eventNum"));
		eventDao dao=eventDao.getInstance();
		dao.delete(eventNum);
		req.getRequestDispatcher("/eventlist").forward(req, resp);
	}
}
