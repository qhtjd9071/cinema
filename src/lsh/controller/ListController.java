package lsh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lsh.dao.CommentsDao;
import semi.vo.movieCommentsVo;



@WebServlet("/list.do")
public class ListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CommentsDao dao=CommentsDao.getInstance();
		int movieNum=Integer.parseInt(req.getParameter("movieNum"));
		ArrayList<movieCommentsVo> list=dao.list(movieNum);
		
		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.print("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		pw.print("<result>");
		for(movieCommentsVo vo:list) {
			pw.print("<mcom>");
			pw.print("<movieCommentsNum>" + vo.getMovieCommentsNum() + "</movieCommentsNum>");
			pw.print("<id>" + vo.getId() + "</id>");
			pw.print("<content>" + vo.getContent() + "</content>");
			pw.print("<star>" + vo.getStar() + "</star>");
			pw.print("<writedate>" + vo.getWritedate() + "</writedate>");
			pw.print("<UserNum>" + vo.getUserNum() + "</UserNum>");
			pw.print("<movieNum>" + vo.getMovieNum() + "</movieNum>");
			pw.print("</mcom>");
		}
		pw.print("</result>");
		
	}
}
