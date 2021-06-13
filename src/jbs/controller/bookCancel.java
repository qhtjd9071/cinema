package jbs.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import jbs.dao.bookDao;
import jbs.dao.integrationDao;
import jbs.dao.payDao;
import jbs.dao.usersDao;
import semi.vo.bsmrJoinVo;
import semi.vo.integrationVo;
import semi.vo.payVo;

public class bookCancel{
	public void cancel(HttpSession session){
		payDao paydao=payDao.getInstance();
		integrationDao intdao=integrationDao.getInstance();
		bookDao bookdao=bookDao.getInstance();
		String id=(String)session.getAttribute("id");
		System.out.println("id:"+id);
		usersDao usersdao=usersDao.getInstance();
		int userNum=usersdao.getUserNum(id);

		ArrayList<payVo> list=paydao.payAll();
		for(int i=0;i<list.size();i++) {
			System.out.println();
			payVo vo=list.get(i);
			int intNum=vo.getIntNum();
			System.out.println("cancel-intNum:"+intNum);
			if(vo.getMethod()==null) {
				integrationVo intvo=intdao.getBookNumArr(intNum);
				String bookNumArr=intvo.getBookNumArr();
				System.out.println("bookNumArr:"+bookNumArr);
				String[] bookNumArr2=bookNumArr.split(",");

				for(int j=0;j<bookNumArr2.length;j++) {
					int bookNum=Integer.parseInt(bookNumArr2[j]);
					System.out.println("bookNum:"+bookNum);
					bsmrJoinVo bsmvo=bookdao.getUserBook(bookNum);
					System.out.println("userNum==bsmvo.getUserNum():"+(userNum==bsmvo.getUserNum()));
					//user체크 후 결제 취소된 결제테이블, 통합테이블, 예매테이블 삭제
					if(userNum==bsmvo.getUserNum()) {
						//예약 삭제
						bookdao.delete(bookNum);
						System.out.println("예약삭제:"+bookNum);
						//결제 삭제
						paydao.delete(intNum);
						System.out.println("결제삭제:"+intNum);
						//통합 삭제
						integrationDao.getInstance().delete(intNum);
					}
				}
			}
		}
	}
}
