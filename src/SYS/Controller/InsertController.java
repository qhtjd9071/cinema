package SYS.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SYS.dao.customerDao;
import semi.vo.customerVo;
@WebServlet("/csinsert")
public class InsertController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String csnum=req.getParameter("customerNum");
		System.out.println(csnum);
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		int customerNum=0;
		int ref=0;
		int lev=0;
		int step=0;
		System.out.println("1");
		if(csnum!=null && !csnum.equals("")) {
			System.out.println("2");
			System.out.println("--");
			System.out.println(csnum);
			customerNum=Integer.parseInt(csnum);
			System.out.println(customerNum);
			System.out.println("--");
			System.out.println("--");
			System.out.println(csnum);
			customerNum=Integer.parseInt(csnum);
			System.out.println("--");
			ref=Integer.parseInt(req.getParameter("ref"));
			lev=Integer.parseInt(req.getParameter("lev"));
			step=Integer.parseInt(req.getParameter("step"));
		}
		customerVo vo=new customerVo(customerNum,title,content,ref,lev,step, null, step);
		customerDao dao=new customerDao();
		int n=dao.insert(vo);
		if(n>0) {
			req.setAttribute("result", "success");
		}else {
			req.setAttribute("result", "fail");
		}
		req.getRequestDispatcher("/csresult.jsp").forward(req, resp);
	}
}
