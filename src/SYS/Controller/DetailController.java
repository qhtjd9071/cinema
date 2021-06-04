package SYS.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SYS.dao.customerDao;
import semi.vo.customerVo;
@WebServlet("/csdetail")
public class DetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("customerNum"));
		customerDao dao=new customerDao();
		customerVo vo=dao.detail(num);
		String content=vo.getContent();
		content=content.replaceAll("\n","<br>");
		vo.setContent(content);
		req.setAttribute("vo",vo);
		req.getRequestDispatcher("/csdetail.jsp").forward(req, resp);
	}
}
