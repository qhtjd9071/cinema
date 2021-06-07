package jbs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbs.dao.payDao;
@WebServlet("/cancel")
public class kakaoCancelController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		kakaoPay kakaoPay=new kakaoPay();
		
		String partner_order_id=request.getParameter("partner_order_id");
		
		kakaoPay.kakaoPayCancel(partner_order_id);
		payDao dao=payDao.getInstance();
		dao.delete(Integer.parseInt(partner_order_id));
		response.sendRedirect(request.getContextPath()+"/kakaoPayCancel.jsp");
	}
}
