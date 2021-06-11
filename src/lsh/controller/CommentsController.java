package lsh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbs.dao.usersDao;
import lsh.dao.CommentsDao;
import semi.vo.movieCommentsVo;

@WebServlet("/aa.do")
public class CommentsController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		String content=req.getParameter("content");
		int star=Integer.parseInt(req.getParameter("star"));
		String writedate=req.getParameter("writedate");
		
		usersDao usersdao=usersDao.getInstance();
		int UserNum=usersdao.getUserNum(id);
		
		int movieNum=Integer.parseInt(req.getParameter("movieNum"));
		movieCommentsVo vo=new movieCommentsVo(0, id, content, star, null, UserNum, movieNum);
		CommentsDao dao=CommentsDao.getInstance();
		int n=dao.insert(vo);
		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.print("<?xml version=\"1.0\" encoding=\"utf-8\"?>");	
		pw.print("<result>");
		if(n>0) {
			pw.print("<code>success</code>");
		}else {
			pw.print("<code>fail</code>");
		}
		pw.print("</result>");	
	}
}
