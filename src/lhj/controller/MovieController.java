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
import semi.vo.movieVo;
import semi.vo.roommovVo;

@WebServlet("/movie")
public class MovieController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");	
		String theaterName = req.getParameter("theaterName");
		String cmd = req.getParameter("cmd");
		if(cmd.equals("base")) {
			BookingDao dao = BookingDao.getInstace();
			ArrayList<roommovVo> tlist = dao.movieList(theaterName);
			
			resp.setContentType("text/xml;charset=utf-8");
			PrintWriter pw = resp.getWriter();
			pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			pw.print("<result>");
			for(roommovVo vo : tlist) {
				pw.print("<movList>");
				pw.print("<movieList>"+ vo.getMovieTitle() + "</movieList>");
				pw.print("</movList>");
			}
			pw.print("</result>");
		}else if(cmd.equals("bookCount")) {
			BookingDao dao = BookingDao.getInstace();
			ArrayList<movieVo> mlist = dao.mCountList();
			
			resp.setContentType("text/xml;charset=utf-8");
			PrintWriter pw = resp.getWriter();
			pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			pw.print("<result>");
			for(movieVo vo : mlist) {
				pw.print("<movList>");
				pw.print("<movieList>"+ vo.getMovieTitle() + "</movieList>");
				pw.print("</movList>");
			}
			pw.print("</result>");
		}else if(cmd.equals("starCount")) {
			BookingDao dao = BookingDao.getInstace();
			ArrayList<movieVo> mlist = dao.mStarList();
			
			resp.setContentType("text/xml;charset=utf-8");
			PrintWriter pw = resp.getWriter();
			pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			pw.print("<result>");
			for(movieVo vo : mlist) {
				pw.print("<movList>");
				pw.print("<movieList>"+ vo.getMovieTitle() + "</movieList>");
				pw.print("</movList>");
			}
			pw.print("</result>");
		}
	}
}
