package jbs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/kakao")
public class kakaoPayController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		kakaoPay kakaoPay=new kakaoPay();
		
		String pg_token=request.getParameter("pg_token");
		String partner_order_id=request.getParameter("partner_order_id");
		
			if(pg_token==null) {
				String next_redirect_pc_url=kakaoPay.kakaoPayReady(request, response);
				PrintWriter pw=response.getWriter();
				pw.write(next_redirect_pc_url);
			}else {
				kakaoPay.kakaoPayApprove(partner_order_id, pg_token,request);
				response.sendRedirect(request.getContextPath()+"/payList");
			}
		}
		
	}
