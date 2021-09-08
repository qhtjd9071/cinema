package lhj.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lhj.dao.BookingDao;
import semi.vo.roomVo;

@WebServlet("/booking")
public class BookingController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookingDao dao = BookingDao.getInstace();
		ArrayList<roomVo> theaterList = dao.theaterList();
		
		req.setAttribute("theaterList", theaterList);
		req.getRequestDispatcher("/Booking.jsp").forward(req, resp);
	}
}
