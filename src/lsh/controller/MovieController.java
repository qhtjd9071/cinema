package lsh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lsh.dao.MovieDao;
import semi.vo.movieVo;

@WebServlet("/LSH/movie.do")
public class MovieController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int movieNum=Integer.parseInt(req.getParameter("movieNum"));
		MovieDao dao=MovieDao.getInstance();
		movieVo vo=dao.getinfo(movieNum);
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/LSH/movie.jsp").forward(req, resp);
	}
}