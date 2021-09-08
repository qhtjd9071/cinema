package sys.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/nthome")
public class NoticeHomeController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String top=(String)req.getAttribute("top");
		String content=(String)req.getAttribute("content");
		if(top==null) {
			top="/ntheader.jsp";
		}
		if(content==null) {
			content="/nthome.jsp";
		}
		req.setAttribute("top", top);
		req.setAttribute("content", content);
		
		String cp=req.getContextPath();
		ServletContext sc=getServletContext();
		sc.setAttribute("cp",cp);
		
		req.getRequestDispatcher("/ntindex.jsp").forward(req, resp);
	}
}
