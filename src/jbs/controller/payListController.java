package jbs.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jbs.dao.bookDao;
import jbs.dao.integrationDao;
import jbs.dao.payDao;
import jbs.dao.usersDao;
import semi.vo.bsmJoinVo;
import semi.vo.integrationVo;
import semi.vo.payListVo;
import semi.vo.payVo;

@WebServlet("/payList")
public class payListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		payDao paydao=payDao.getInstance();
		integrationDao intdao=integrationDao.getInstance();
		bookDao bookdao=bookDao.getInstance();
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		System.out.println("id:"+id);
		usersDao usersdao=usersDao.getInstance();
		int userNum=usersdao.getUserNum(id);
		
		ArrayList<payListVo> plvoList=new ArrayList<payListVo>();
		
		ArrayList<payVo> list=paydao.payAll();
		for(int i=0;i<list.size();i++) {
			System.out.println();
			payVo vo=list.get(i);
			int intNum=vo.getIntNum();
			integrationVo intvo=intdao.getBookNumArr(intNum);
			String bookNumArr=intvo.getBookNumArr();
			String[] bookNumArr2=bookNumArr.split(",");
			String movieTitle = "";
			String seatNumArr = "";
			
			boolean usercheck=false;
			for(int j=0;j<bookNumArr2.length;j++) {
					int bookNum=Integer.parseInt(bookNumArr2[j]);
					System.out.println("bookNum:"+bookNum);
					bsmJoinVo bsmvo=bookdao.getUserBook(bookNum);
					System.out.println("userNum==bsmvo.getUserNum():"+(userNum==bsmvo.getUserNum()));
					usercheck=false;
					if(userNum==bsmvo.getUserNum()) {
						movieTitle="��ȭ:"+bsmvo.getMovieTitle()+"<br>";
						seatNumArr+=bsmvo.getSeatNum()+"�� ";
						usercheck=true;
					
				}
			}
			System.out.println(usercheck);
			payListVo plvo=new payListVo();
			if(usercheck==true) {
				plvo.setPayNum(vo.getPayNum());
				plvo.setIntNum(vo.getIntNum());
				plvo.setMethod(vo.getMethod());
				plvo.setPayDate(vo.getPayDate());
				plvo.setTot(vo.getTot());
				plvo.setMovieTitle(movieTitle);
				plvo.setSeatNumArr(seatNumArr);
				
				plvoList.add(plvo);
			}
		}
		
		request.setAttribute("list", plvoList);
		request.getRequestDispatcher("/payList.jsp").forward(request, response);
	}
}
