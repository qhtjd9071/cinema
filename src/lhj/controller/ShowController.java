package lhj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

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
		Date begintime = Date.valueOf(req.getParameter("begintime"));
		BookingDao dao = BookingDao.getInstace();
		ArrayList<showinfoVo> rsdList = dao.roomSitDateList(begintime);
		
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
