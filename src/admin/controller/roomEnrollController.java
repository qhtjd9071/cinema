package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.roomDao;
import semi.vo.roomVo;

public class roomEnrollController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String theaterName=request.getParameter("theaterName");
		int seatCount=Integer.parseInt(request.getParameter("seatCount"));
		String location=request.getParameter("location");
		int roomNum=Integer.parseInt(request.getParameter("roomNum"));
		
		System.out.println(theaterName);
		roomVo vo=new roomVo(0, theaterName, seatCount, location, roomNum);
		roomDao dao=roomDao.getInstance();
		dao.insert(vo);
		response.sendRedirect(request.getContextPath()+"/admin.jsp");
	}
}
