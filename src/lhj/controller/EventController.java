package lhj.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lhj.dao.EventShowDao;
import semi.vo.eventVo;


@WebServlet("/event")
public class EventController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EventShowDao dao = EventShowDao.getInstance();
		ArrayList<eventVo> mainList = dao.list();
		
		req.setAttribute("mainList", mainList);
		req.getRequestDispatcher("/EventMain.jsp").forward(req, resp);
	}
}
