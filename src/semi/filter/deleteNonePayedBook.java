package semi.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jbs.controller.bookCancel;
import jbs.dao.bookDao;
import jbs.dao.integrationDao;
import jbs.dao.payDao;
import jbs.dao.usersDao;
import semi.vo.bsmrJoinVo;
import semi.vo.integrationVo;
import semi.vo.payListVo;
import semi.vo.payVo;

@WebFilter("/main.jsp")
public class deleteNonePayedBook implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		
		bookCancel bc=new bookCancel();
		HttpSession session=req.getSession();
		bc.cancel(session);
		String id=(String)session.getAttribute("id");
		if(id!=null && id.equals("admin")) {
			HttpServletResponse resp = (HttpServletResponse)response;
			resp.sendRedirect(req.getContextPath() + "/admin.jsp");
		}
		
		chain.doFilter(request, response);
	}

}
