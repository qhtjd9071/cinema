package lhj.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lhj.dao.EventShowDao;
import semi.vo.eventVo;

@WebServlet("/eventDetail")
public class EventDetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int eventNum = Integer.parseInt(req.getParameter("eventNum"));
		EventShowDao dao = EventShowDao.getInstance();
		eventVo vo = dao.getDetail(eventNum);
		
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/EventDetail.jsp").forward(req, resp);
	}
}
