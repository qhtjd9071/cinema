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
import semi.vo.showinfoVo;

@WebServlet("/time")
public class TimeController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookingDao dao = BookingDao.getInstace();
		ArrayList<showinfoVo> stList = dao.showTimeList();
		
		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.print("<result>");
		for(showinfoVo vo : stList) {
			pw.print("<stList>");
			pw.print("<time>"+ vo.getBegintime() + "</time>");
			pw.print("</stList>");
		}
		pw.print("</result>");
	}
}
