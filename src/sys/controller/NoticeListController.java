package sys.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.vo.noticeVo;
import sys.dao.noticeDao;
@WebServlet("/ntlist")
public class NoticeListController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String spageNum=req.getParameter("pageNum");
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		System.out.println("pageNum:"+pageNum);
		
		noticeDao dao=noticeDao.getInstance();
		int startRow=(pageNum-1)*10+1;
		int endRow=startRow+9;
		ArrayList<noticeVo> list=dao.list(startRow,endRow);
		for(int i=0;i<list.size();i++) {
			String a=list.get(i).getTitle();
			System.out.println("Á¦¸ñ:"+a);
		}
		int pageCount=(int)Math.ceil(dao.getCount()/10.0);		
		int startPageNum=((pageNum-1)/10*10)+1;
		int endPageNum=startPageNum+9;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		
		req.setAttribute("list",list);
		req.setAttribute("pageCount",pageCount);
		req.setAttribute("startPageNum",startPageNum);
		req.setAttribute("endPageNum",endPageNum);
		req.setAttribute("pageNum",pageNum);
		req.getRequestDispatcher("/ntlist.jsp").forward(req, resp);
	}
	
	
}