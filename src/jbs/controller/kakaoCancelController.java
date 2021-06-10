package jbs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbs.dao.bookDao;
import jbs.dao.integrationDao;
import jbs.dao.payDao;
import semi.vo.bsmrJoinVo;
import semi.vo.integrationVo;
@WebServlet("/cancel")
public class kakaoCancelController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		kakaoPay kakaoPay=new kakaoPay();
		
		String partner_order_id=request.getParameter("partner_order_id");
		
		integrationDao intdao=integrationDao.getInstance();
		integrationVo intvo=intdao.getBookNumArr(Integer.parseInt(partner_order_id));
		String bookNumArr=intvo.getBookNumArr();
		System.out.println("bookNumArr:"+bookNumArr);
		String[] bookNumArr2=bookNumArr.split(",");
		
		bookDao bookdao=bookDao.getInstance();
		for(int j=0;j<bookNumArr2.length;j++) {
			int bookNum=Integer.parseInt(bookNumArr2[j]);
			System.out.println("bookNum:"+bookNum);
			bookdao.delete(bookNum);
		}
		
		kakaoPay.kakaoPayCancel(partner_order_id);
		payDao dao=payDao.getInstance();
		dao.delete(Integer.parseInt(partner_order_id));
		response.sendRedirect(request.getContextPath()+"/payList");
	}
}
