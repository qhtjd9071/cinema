package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.showDao;
import semi.vo.mrsVo;
@WebServlet("/showlist")
public class showList extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String spageNum=request.getParameter("pageNum");
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		System.out.println("pageNum:"+pageNum);
		
		showDao dao=showDao.getInstance();
		int startRow=(pageNum-1)*10+1;
		int endRow=startRow+9;
		ArrayList<mrsVo> list=dao.list(startRow,endRow);
		System.out.println(list.get(0).getTheaterName());
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
		request.getRequestDispatcher("/showEnrollList.jsp").forward(request, response);
	}
}
