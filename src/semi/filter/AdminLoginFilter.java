package semi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/admin.jsp")
public class AdminLoginFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		boolean login = false;
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		if(session != null) {
			String id = (String)session.getAttribute("id");
			if(id != null) {
				login = true;
			}
		}	
		if(login == true) {
			chain.doFilter(req, response);			
		}else {
			HttpServletResponse resp = (HttpServletResponse)response;
			resp.sendRedirect(req.getContextPath() + "/login.jsp");
		}
		
	}
}
