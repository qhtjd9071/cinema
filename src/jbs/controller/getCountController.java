package jbs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbs.dao.bookDao;


@WebServlet("/getCount")
public class getCountController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bookDao dao=new bookDao();
		int getCount=dao.getCount();
		request.setAttribute("getCount", getCount);
		request.getRequestDispatcher("/booklist.jsp").forward(request, response);
	}

}
