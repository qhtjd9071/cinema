package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.eventDao;
import semi.vo.eventVo;
@WebServlet("/eventlist")
public class eventList extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String spageNum=request.getParameter("pageNum");
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		
		eventDao dao=eventDao.getInstance();
		int startRow=(pageNum-1)*10+1;
		int endRow=startRow+9;
		ArrayList<eventVo> list=dao.list(startRow,endRow);
		int pageCount=(int)Math.ceil(dao.getCount()/10.0);
		int startPageNum=((pageNum-1)/10*10)+1;
		int endPageNum=startPageNum+9;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		
		request.setAttribute("list",list);
		request.setAttribute("pageCount",pageCount);
		request.setAttribute("startPageNum",startPageNum);
		request.setAttribute("endPageNum",endPageNum);
		request.setAttribute("pageNum",pageNum);
		request.getRequestDispatcher("/eventEnrollList.jsp").forward(request, response);
	}
}
