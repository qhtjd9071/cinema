package SYS.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SYS.dao.customerDao;
import semi.vo.customerVo;

@WebServlet("/csupdate")
public class UpdateController extends HttpServlet{
	//회원정보를 가지고 수정페이지로 이동
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("customerNum"));
		//System.out.println(num);
		customerDao dao=new customerDao();
		customerVo vo=dao.getinfo(num);
		req.setAttribute("vo",vo);
		req.getRequestDispatcher("/csupdate.jsp").forward(req, resp);
	}
	//update하기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int num=Integer.parseInt(req.getParameter("customerNum"));
		int writer=Integer.parseInt(req.getParameter("writer"));
		String title =req.getParameter("title");
		String content =req.getParameter("content");	
		
		//전송된 사용자 정보 db에 저장하기
		customerVo vo=new customerVo(num, title, content, 0, 0, 0, null, writer);
		customerDao dao=new customerDao();
		int n=dao.update(vo);
		
		//결과값을 가지고 뷰페이지로 이동하기
		if(n>0) {
			req.setAttribute("result", "success");
		}else {
			req.setAttribute("result", "fail");
		}
		req.getRequestDispatcher("/csresult.jsp").forward(req, resp);
	
	}
}











