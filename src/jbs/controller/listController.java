package jbs.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbs.dao.bookDao;
import semi.vo.bookVo;
@WebServlet("/list")
public class listController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int showNum=Integer.parseInt(request.getParameter("showNum"));
		System.out.println(showNum);
		//int adultCount=Integer.parseInt(request.getParameter("adultCount"));
		int adultCount=1;
		//int teenCount=Integer.parseInt(request.getParameter("teenCount"));
		int teenCount=1;
		
		//String rating=request.getParameter("rating");
		String rating="15";
		request.setAttribute("rating", rating);
		request.setAttribute("adultCount", adultCount);
		request.setAttribute("teenCount", teenCount);
		request.setAttribute("totalCount", adultCount+teenCount);
		
		bookDao dao=bookDao.getInstance();
		ArrayList<bookVo> list=dao.select();
		bookVo priceVo=dao.getPrice(showNum);
		int price=priceVo.getPrice();
		
		//int price=1000;
		request.setAttribute("list", list);
		request.setAttribute("price", price);
		request.getRequestDispatcher("/getCount").forward(request, response);
	}
}
