package lsh.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import lsh.dao.EventDao;
import semi.vo.eventVo;


@WebServlet("/event.do")
public class EventController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EventDao dao=EventDao.getInstance();
		ArrayList<eventVo> list = dao.list();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/Eve_main.jsp").forward(req, resp);
	}
}
