package lhj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lhj.dao.BookingDao;
import semi.vo.showinfoVo;

@WebServlet("/show")
public class ShowController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] date = req.getParameter("begintime").split("/");
		int year = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]) - 1;
		int day = Integer.parseInt(date[2]);
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DATE, day);
		
		Date begintime = new Date(cal.getTimeInMillis());
		
		String movieTitle = req.getParameter("movieTitle");
		String theaterName = req.getParameter("theaterName");
		//System.out.println("showcontroller: " + begintime);
		//System.out.println("showcontroller: " + movieTitle);
		//System.out.println("showcontroller: " + theaterName);
		BookingDao dao = BookingDao.getInstace();
		ArrayList<showinfoVo> rsdList = dao.roomSitDateList(begintime, movieTitle, theaterName);
		//System.out.println("showlist: " + rsdList);
		
		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.print("<result>");
		for(showinfoVo vo : rsdList) {
			pw.print("<sList>");
			pw.print("<rn>"+ vo.getRoomNum() + "</rn>");
			pw.print("<sc>"+ vo.getSitCount()+ "</sc>");
			pw.print("</sList>");
		}
		pw.print("</result>");
	}
}
