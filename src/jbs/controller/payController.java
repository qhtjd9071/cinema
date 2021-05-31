package jbs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbs.dao.testDao;
import semi.vo.bookVo;



@WebServlet("/pay")
public class payController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aa = request.getParameter("aa");
		String str=aa.substring(11,aa.length()-3);
		String[] arr=str.split("\",\"");
		
		testDao dao=new testDao();
		for(int i=0;i<arr.length;i++) {
			if(!arr[i].equals("")) {
				int seatNum=Integer.parseInt(arr[i]);
				System.out.println(seatNum);
				bookVo vo=new bookVo();
				vo.setShowNum(1);
				vo.setPrice(10000);
				vo.setUserNum(1);
				vo.setSeatNum(seatNum);
				dao.insert(vo);
				System.out.println("ok");
			}
		}

	}

}
