package jbs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbs.dao.bookDao;
import jbs.dao.integrationDao;
import semi.vo.bookVo;
import semi.vo.integrationVo;



@WebServlet("/book")
public class bookController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String aa = request.getParameter("aa");
		String str=aa.substring(11,aa.length()-3);
		String[] arr=str.split("\",\"");
		String bookNumArr="";
		bookDao dao=new bookDao();
		for(int i=0;i<arr.length;i++) {
			if(!arr[i].equals("")) {
				int seatNum=Integer.parseInt(arr[i]);
				bookVo vo=new bookVo();
				vo.setShowNum(1);
				vo.setPrice(10000);
				vo.setUserNum(1);
				vo.setSeatNum(seatNum);
				if(dao.check(vo.getShowNum(), vo.getSeatNum())!=true) {
					dao.insert(vo);
					//id³Ö±â
					bookNumArr+=dao.getBookNum(vo)+",";
				}
			}
		}
		
		integrationVo vo=new integrationVo();
		vo.setBookNumArr(bookNumArr);
		integrationDao intDao=integrationDao.getInstance();
		intDao.insert(vo);
		String intNum=Integer.toString(intDao.getBookNumArr(vo));
		PrintWriter pw=response.getWriter();
		pw.write(intNum);

	}

}
