package lsh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lsh.dao.EventDao;
import lsh.dao.MovieDao;
import semi.vo.eventVo;
import semi.vo.movieVo;

@WebServlet("/LSH/event.do")
public class EventController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int eventNum=Integer.parseInt(req.getParameter("eventNum"));
		EventDao dao=EventDao.getInstance();
		eventVo vo=dao.getinfo(eventNum);
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/LSH/event.jsp").forward(req, resp);
	}
}
