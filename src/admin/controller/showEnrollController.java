package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.showDao;

public class showEnrollController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int movieNum=Integer.parseInt(request.getParameter("movieNum"));
		String beginTime=request.getParameter("begin")+":00";
		String endTime=request.getParameter("end")+":00";
		int roomSerialNum=Integer.parseInt(request.getParameter("roomSerialNum"));
		int price=Integer.parseInt(request.getParameter("price")); 
		
		showDao dao=showDao.getInstance();
		dao.insert(movieNum, beginTime, endTime, roomSerialNum, price);
		response.sendRedirect(request.getContextPath()+"/admin.jsp");
	}
}
