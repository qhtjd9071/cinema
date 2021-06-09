package lhj.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.movieDao;
import semi.vo.movieVo;

@WebServlet("/movieList")
public class MovielistController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		movieDao dao=movieDao.getInstance();
		ArrayList<movieVo> list = dao.list();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/movieList.jsp").forward(req, resp);	
	}
}

