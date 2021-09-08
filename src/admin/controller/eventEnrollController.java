package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.eventDao;
import semi.vo.eventVo;

public class eventEnrollController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String img1=request.getParameter("imgsrc1");
		System.out.println(img1);
		String img2=request.getParameter("imgsrc2");
		System.out.println(img2);
		eventVo vo=new eventVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setmainImage(img1);
		vo.setdetailImage(img2);
		eventDao dao=eventDao.getInstance();
		dao.insert(vo);
		response.sendRedirect(request.getContextPath()+"/admin.jsp");
	}
}
