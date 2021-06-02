package lhj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lhj.dao.BookingDao;
import semi.vo.roomVo;

@WebServlet("/theater")
public class TheaterController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String location = req.getParameter("location");
		BookingDao dao = BookingDao.getInstace();
		ArrayList<roomVo> list = dao.locationList(location);
		
		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.print("<result>");
		for(roomVo vo : list) {
			pw.print("<tnList>");
			pw.print("<name>"+ vo.getTheaterName() + "</name>");
			pw.print("</tnList>");
		}
		pw.print("</result>");
	}
}
