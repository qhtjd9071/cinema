package lhj.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.movieDao;
import lhj.dao.MovieListDao;
import semi.vo.movieVo;

@WebServlet("/movieList")
public class MovielistController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
/*		String spageNum = req.getParameter("pageNum");
		int pageNum = 1;
		if(spageNum != null) {
			pageNum = Integer.parseInt(spageNum);
		}
*/		
		MovieListDao dao = MovieListDao.getInstance();
		//int startRow = 5*pageNum-4;
		//int endRow = startRow*5;
		
		ArrayList<movieVo> list = dao.movList();
/*		int pageCount = (int)Math.ceil(dao.getCount()/10.0);
		int startPageNum = ((pageNum-1)/5*5)+1;
		int endPageNum = startPageNum+4;
		if(endPageNum > pageCount) {
			endPageNum = pageCount;
		}
*/
		req.setAttribute("list", list);
		//req.setAttribute("pageCount", pageCount);
		//req.setAttribute("pageNum", pageNum);
		//req.setAttribute("startPageNum", startPageNum);
		//req.setAttribute("endPageNum", endPageNum);
		req.getRequestDispatcher("/movieList.jsp").forward(req, resp);	
	}
}

