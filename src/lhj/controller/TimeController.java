package lhj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lhj.dao.BookingDao;
import semi.vo.timeVo;

@WebServlet("/time")
public class TimeController extends HttpServlet {
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
		Timestamp beginhour = new Timestamp(begintime.getTime());
		
		
		String movieTitle = req.getParameter("movieTitle");
		String theaterName = req.getParameter("theaterName");
		int roomNum = Integer.parseInt(req.getParameter("roomNum"));
		//System.out.println("roomNum: " + roomNum);
		BookingDao dao = BookingDao.getInstace();
		ArrayList<timeVo> stList = dao.showTimeList(begintime, movieTitle, theaterName, roomNum);
		
		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.print("<result>");
		for(timeVo vo : stList) {
			pw.print("<stList>");
			pw.print("<time>"+ vo.getBeginhour() + "</time>");
			pw.print("<shownum>"+ vo.getShowNum() + "</shownum>");
			pw.print("</stList>");
		}
		pw.print("</result>");
	}
}
