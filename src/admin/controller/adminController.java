package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class adminController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		System.out.println(cmd);
		
		HttpServlet adminAction;
		if(cmd.equals("movieEnroll")) {
			adminAction=new movieEnrollController();
			adminAction.service(request,response);
		}else if(cmd.equals("roomEnroll")) {
			adminAction=new roomEnrollController();
			adminAction.service(request,response);
		}else if(cmd.equals("showEnroll")) {
			adminAction=new showEnrollController();
			adminAction.service(request,response);
		}else if(cmd.equals("eventEnroll")) {
			adminAction=new eventEnrollController();
			adminAction.service(request,response);
		}
	}
}
