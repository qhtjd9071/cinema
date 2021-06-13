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
				String[] bookNumArr2=bookNumArr.split(",");

				for(int j=0;j<bookNumArr2.length;j++) {
					int bookNum=Integer.parseInt(bookNumArr2[j]);
					System.out.println("bookNum:"+bookNum);
					bsmrJoinVo bsmvo=bookdao.getUserBook(bookNum);
					System.out.println("userNum==bsmvo.getUserNum():"+(userNum==bsmvo.getUserNum()));
					//userüũ �� ���� ��ҵ� �������̺�, �������̺�, �������̺� ����
					if(userNum==bsmvo.getUserNum()) {
						//���� ����
						bookdao.delete(bookNum);
						System.out.println("�������:"+bookNum);
						//���� ����
						paydao.delete(intNum);
						System.out.println("��������:"+intNum);
						//���� ����
						integrationDao.getInstance().delete(intNum);
					}
				}
			}
		}
	}
}
