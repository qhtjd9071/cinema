package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.movieDao;
import semi.vo.movieVo;

public class movieEnrollController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String director=request.getParameter("director");
		String genre=request.getParameter("genre");
		String rating=request.getParameter("rating");
		String img=request.getParameter("imgsrc");
		
		movieVo vo=new movieVo(0, title, content, director, genre, rating, img);
		movieDao dao=movieDao.getInstance();
		dao.insert(vo);
		response.sendRedirect(request.getContextPath()+"/admin.jsp");
	}
}
