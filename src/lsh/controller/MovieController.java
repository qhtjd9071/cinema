package lsh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lsh.dao.MovieDao;
import semi.vo.movieVo2;

@WebServlet("/moviecomments.do")
public class MovieController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int movieNum=Integer.parseInt(req.getParameter("movieNum"));
		MovieDao dao=MovieDao.getInstance();
		movieVo2 vo=dao.getinfo(movieNum);
		req.setAttribute("vo", vo);
		
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		req.setAttribute("id", id);
		req.getRequestDispatcher("/moviecomments.jsp").forward(req, resp);
	}
}