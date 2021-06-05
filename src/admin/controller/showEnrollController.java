package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.showDao;
import semi.vo.showVo2;

public class showEnrollController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int movieNum=Integer.parseInt(request.getParameter("movieNum"));
		String beginTime=request.getParameter("begin")+":00";
		String endTime=request.getParameter("end")+":00";
		int roomSerialNum=Integer.parseInt(request.getParameter("roomSerialNum"));
		
		showVo2 vo=new showVo2(0, movieNum, beginTime, endTime, roomSerialNum);
		showDao dao=showDao.getInstance();
		dao.insert(vo);
	}
}
