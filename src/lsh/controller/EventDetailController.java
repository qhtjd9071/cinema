package lsh.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import lsh.dao.EventDao;
import lsh.dao.EventDetailDao;
import semi.vo.eventVo;


@WebServlet("/eventdetail.do")
public class EventDetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EventDetailDao detaildao=EventDetailDao.getInstance();
		ArrayList<eventVo> dlist = detaildao.dlist();
		
		req.setAttribute("dlist", dlist);
		req.getRequestDispatcher("/event.jsp").forward(req, resp);
	}
}
