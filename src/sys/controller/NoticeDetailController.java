package sys.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.vo.noticeVo;
import sys.dao.noticeDao;

@WebServlet("/ntdetail")
public class NoticeDetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int noticeNum=Integer.parseInt(req.getParameter("noticeNum"));
		noticeDao dao=noticeDao.getInstance();
		dao.hitPlus(noticeNum);
		noticeVo vo=dao.detail(noticeNum);
		String content=vo.getContent();
		content=content.replaceAll("\n","<br>");
		vo.setContent(content);
		req.setAttribute("vo",vo);
		req.getRequestDispatcher("/ntdetail.jsp").forward(req, resp);
	}
}
