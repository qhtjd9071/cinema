package sys.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sys.dao.customerDao;

@WebServlet("/delMember")
public class CustomerDelController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("customerNum"));
		customerDao dao=new customerDao();
		int n=dao.delete(num);
		if(n>0) {
			resp.sendRedirect(req.getContextPath()+"/cslist");
		}else {
			req.setAttribute("result", "fail");
			req.getRequestDispatcher("/csresult.jsp").forward(req, resp);
		}
	}
}
