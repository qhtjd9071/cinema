package sys.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.vo.noticeVo;
import sys.dao.noticeDao;
@WebServlet("/ntupdate")
public class NoticeUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("noticeNum"));
		noticeDao dao=noticeDao.getInstance();
		noticeVo vo=dao.getinfo(num);
		req.setAttribute("vo",vo);
		req.getRequestDispatcher("/ntupdate.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("noticeNum"));
		String title =req.getParameter("title");
		String content =req.getParameter("content");
		noticeVo vo=new noticeVo(num, title, content, null, num);
		noticeDao dao=noticeDao.getInstance();
		int n=dao.update(vo);
		if(n>0) {
			req.setAttribute("result", "update_success");
		}else {
			req.setAttribute("result", "update_fail");
		}
		req.getRequestDispatcher("/ntlist").forward(req, resp);
	
	}
}

