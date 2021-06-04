package SYS.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SYS.dao.customerDao;
import semi.vo.customerVo;


@WebServlet("/list")
public class ListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String spageNum=req.getParameter("pageNum");
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		customerDao dao=new customerDao();
		int startRow=(pageNum-1)*10+1;
		int endRow=startRow+9;
		//해당 페이지에 해당하는 글목록 얻어오기
		ArrayList<customerVo> list=dao.list(startRow, endRow);
		//전체 페이지 갯수 구하기
		int pageCount=(int)Math.ceil(dao.getCount()/10.0);		
		//시작페이지 번호
		int startPageNum=((pageNum-1)/10*10)+1;
		//끝페이지 번호
		int endPageNum=startPageNum+9;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		req.setAttribute("list",list);
		req.setAttribute("pageCount",pageCount);
		req.setAttribute("startPageNum",startPageNum);
		req.setAttribute("endPageNum",endPageNum);
		req.setAttribute("pageNum",pageNum);
		req.getRequestDispatcher("list.jsp").forward(req, resp);
			
	}
}