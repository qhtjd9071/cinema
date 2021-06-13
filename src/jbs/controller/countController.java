package jbs.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.movieDao;
import jbs.dao.bookDao;
import jbs.dao.showDao;
import semi.vo.bookVo;
import semi.vo.showVo;
@WebServlet("/count")
public class countController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int showNum=Integer.parseInt(request.getParameter("showNum"));
		
		bookDao dao=bookDao.getInstance();
		ArrayList<bookVo> list=dao.select(showNum);
		int getCount=dao.getCount(showNum);
		
		showDao dao2=showDao.getInstance();
		int movieNum=dao2.getMovieNum(showNum);
		
		movieDao dao3=movieDao.getInstance();
		String rating=dao3.getRating(movieNum);
		System.out.println("rating:"+rating);
		
		request.setAttribute("rating", rating);
		request.setAttribute("list", list);
		request.setAttribute("showNum", showNum);
		request.setAttribute("getCount", getCount);
		
		request.getRequestDispatcher("/countSelection.jsp").forward(request, response);
	}
}
