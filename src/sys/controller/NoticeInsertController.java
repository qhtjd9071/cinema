package sys.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.vo.noticeVo;
import sys.dao.noticeDao;


@WebServlet("/ntinsert")
public class NoticeInsertController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("top", "/ntheader.jsp");
		req.setAttribute("content", "/ntinsert.jsp");
		req.getRequestDispatcher("/ntindex.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		noticeVo vo=new noticeVo(0,title,content,null,0);
		noticeDao dao=noticeDao.getInstance();
		int n=dao.insert(vo);
		if(n>0) {
			req.setAttribute("result", "success");
		}else {
			req.setAttribute("result", "fail");
		}
		req.setAttribute("top", "/ntheader.jsp");
		req.setAttribute("content", "/ntresult.jsp");
		req.getRequestDispatcher("/ntresult.jsp").forward(req, resp);
	}
}
