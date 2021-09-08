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
@WebServlet("/list")
public class listController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int showNum=Integer.parseInt(request.getParameter("showNum"));
		System.out.println("showNum:"+showNum);
		int adultCount=Integer.parseInt(request.getParameter("adultCount"));
		int teenCount=Integer.parseInt(request.getParameter("teenCount"));
		
		request.setAttribute("adultCount", adultCount);
		request.setAttribute("teenCount", teenCount);
		
		bookDao dao=bookDao.getInstance();
		ArrayList<bookVo> list=dao.select(showNum);
		showDao dao2=showDao.getInstance();
		showVo vo2=dao2.getPrice(showNum);
		int price=vo2.getPrice();
		System.out.println(price);
		int movieNum=dao2.getMovieNum(showNum);
		
		
		System.out.println(movieNum);
		movieDao dao3=movieDao.getInstance();
		String movieTitle=dao3.getMovieTitle(movieNum);;
		System.out.println("movietitle:"+movieTitle);
		
		request.setAttribute("list", list);
		request.setAttribute("showNum", showNum);
		request.setAttribute("price", price);
		request.setAttribute("movieTitle", movieTitle);
		request.getRequestDispatcher("/getCount").forward(request, response);
	}
}
