package lsh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lsh.dao.CommentsDao;

@WebServlet("/delete.do")
public class DeleteController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int movieCommentsNum=Integer.parseInt(req.getParameter("movieCommentsNum"));
		CommentsDao dao=CommentsDao.getInstance();
		int n=dao.delete(movieCommentsNum);
		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.print("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		pw.print("<result>");
		if(n>0) {
			pw.print("<code>댓글 삭제완료</code>");
		}else {
			pw.print("<code>댓글 삭제실패</code>");
		}
		pw.print("</result>");
	}
}
