package lhj.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lhj.dao.BookingDao;
import semi.vo.movieVo;



@WebServlet("/SelectMovie")
public class SelectMovieController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		BookingDao dao = BookingDao.getInstace();
		ArrayList<movieVo> mlist1 = dao.mCountList();
		
		req.setAttribute("mlist1", mlist1);
		req.getRequestDispatcher("/Booking.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		BookingDao dao = BookingDao.getInstace();
		ArrayList<movieVo> mlist2 = dao.mStarList();
		
		req.setAttribute("mlist2", mlist2);
		req.getRequestDispatcher("/Booking.jsp").forward(req, resp);
	}
}
