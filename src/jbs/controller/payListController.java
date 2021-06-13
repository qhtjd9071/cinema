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
import semi.vo.bsmrJoinVo;
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
			String theaterName="";
			String roomNum="";
			String beginTime="";
			
			boolean usercheck=false;
			for(int j=0;j<bookNumArr2.length;j++) {
					int bookNum=Integer.parseInt(bookNumArr2[j]);
					bsmrJoinVo bsmrvo=bookdao.getUserBook(bookNum);
					usercheck=false;
					if(userNum==bsmrvo.getUserNum()) {
						movieTitle=bsmrvo.getMovieTitle();
						//seatNum이름부여
						System.out.println("bsmrvo.seatNum:"+bsmrvo.getSeatNum());
						int tempSeatNum=bsmrvo.getSeatNum()%8;
						System.out.println("tsn"+tempSeatNum);
						String seatNum=null;
						if(tempSeatNum==0){
							System.out.println(true);
							tempSeatNum=8;
						}else {
							System.out.println(false);
						}
						System.out.println(tempSeatNum);
						if(bsmrvo.getSeatNum()/8.0<=1){
							seatNum="A"+tempSeatNum;
						}else if(bsmrvo.getSeatNum()/8.0<=2){
							seatNum="B"+tempSeatNum;
						}else if(bsmrvo.getSeatNum()/8.0<=3){
							seatNum="C"+tempSeatNum;
						}else if(bsmrvo.getSeatNum()/8.0<=4){
							seatNum="D"+tempSeatNum;
						}else if(bsmrvo.getSeatNum()/8.0<=5){
							seatNum="E"+tempSeatNum;
						}else if(bsmrvo.getSeatNum()/8.0<=6){
							seatNum="F"+tempSeatNum;
						}else if(bsmrvo.getSeatNum()/8.0<=7){
							seatNum="G"+seatNum;
						}else if(bsmrvo.getSeatNum()/8.0<=8){
							seatNum="H"+seatNum;
						}
						
						seatNumArr+=seatNum+" ";
						System.out.println(seatNum);
						theaterName=bsmrvo.getTheaterName();
						roomNum=bsmrvo.getRoomNum()+"번";
						beginTime=bsmrvo.getBeginTime();
						usercheck=true;
					
				}
			}
			payListVo plvo=new payListVo();
			if(usercheck==true) {
				plvo.setPayNum(vo.getPayNum());
				plvo.setIntNum(vo.getIntNum());
				plvo.setMethod(vo.getMethod());
				plvo.setPayDate(vo.getPayDate());
				plvo.setTot(vo.getTot());
				plvo.setMovieTitle(movieTitle);
				plvo.setSeatNumArr(seatNumArr);
				plvo.setTheaterName(theaterName);
				plvo.setBeginTime(beginTime);
				plvo.setRoomNum(roomNum);
				
				plvoList.add(plvo);
			}
		}
		
		request.setAttribute("list", plvoList);
		request.getRequestDispatcher("/mypage_payList.jsp").forward(request, response);
	}
}
