package sys.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jbs.dao.usersDao;
import semi.vo.customerVo2;
import sys.dao.customerDao;


@WebServlet("/inquiry")
public class InquriyController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		usersDao usersdao=usersDao.getInstance();
		int userNum=usersdao.getUserNum(id);
		
		String spageNum=req.getParameter("pageNum");
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		customerDao dao=new customerDao();
		int startRow=(pageNum-1)*10+1;
		int endRow=startRow+9;
		
		ArrayList<Integer> cusList=dao.getCustomerNum(userNum);
		
		ArrayList<customerVo2> list=dao.questionList(startRow, endRow, userNum, cusList);
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
		req.getRequestDispatcher("/mypage_cslist.jsp").forward(req, resp);
			
	}
}