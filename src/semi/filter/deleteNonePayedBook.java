package semi.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
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

@WebFilter("/list")
public class deleteNonePayedBook implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		payDao paydao=payDao.getInstance();
		integrationDao intdao=integrationDao.getInstance();
		bookDao bookdao=bookDao.getInstance();
		
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		System.out.println("id:"+id);
		usersDao usersdao=usersDao.getInstance();
		int userNum=usersdao.getUserNum(id);
		
		ArrayList<payVo> list=paydao.payAll();
		for(int i=0;i<list.size();i++) {
			System.out.println();
			payVo vo=list.get(i);
			int intNum=vo.getIntNum();
			if(vo.getMethod()==null) {
				integrationVo intvo=intdao.getBookNumArr(intNum);
				String bookNumArr=intvo.getBookNumArr();
				String[] bookNumArr2=bookNumArr.split(",");
				
				for(int j=0;j<bookNumArr2.length;j++) {
					int bookNum=Integer.parseInt(bookNumArr2[j]);
					System.out.println("bookNum:"+bookNum);
					bsmJoinVo bsmvo=bookdao.getUserBook(bookNum);
					System.out.println("userNum==bsmvo.getUserNum():"+(userNum==bsmvo.getUserNum()));
					//user체크 후 결제 취소된 결제테이블, 통합테이블, 예매테이블 삭제
					if(userNum==bsmvo.getUserNum()) {
						//예약 삭제
						bookdao.delete(bookNum);
						//결제 삭제
						paydao.delete(intNum);
						//통합 삭제
						integrationDao.getInstance().delete(intNum);
					}
				}
			}
		}
		
		chain.doFilter(request, response);
	}

}
