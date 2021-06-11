package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.movieDao;
@WebServlet("/movieDel")
public class movieDelController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int movieNum=Integer.parseInt(req.getParameter("movieNum"));
		movieDao dao=movieDao.getInstance();
		dao.delete(movieNum);
		req.getRequestDispatcher("/movielist").forward(req, resp);
	}
}
