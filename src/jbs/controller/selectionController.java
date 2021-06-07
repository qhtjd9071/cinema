package jbs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/selection")
public class selectionController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int adultCount=Integer.parseInt(request.getParameter("adultCount"));
		int teenCount=Integer.parseInt(request.getParameter("teenCount"));
		String showNum=request.getParameter("showNum");
		
		request.setAttribute("adultCount", adultCount);
		request.setAttribute("teenCount", teenCount);
		request.setAttribute("totalCount", adultCount+teenCount);
		request.setAttribute("showNum", showNum);
		request.getRequestDispatcher("list").forward(request, response);
	}
}
