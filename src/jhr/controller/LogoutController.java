package jhr.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jbs.controller.bookCancel;

@WebServlet("/logout")
public class LogoutController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		bookCancel bc=new bookCancel();
		bc.cancel(session);
		session.invalidate();
		resp.sendRedirect(req.getContextPath()+"/main.jsp");
	}
}











