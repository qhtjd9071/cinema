package jbs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import jbs.dao.bookDao;
import jbs.dao.integrationDao;
import jbs.dao.usersDao;
import semi.vo.bookVo;
import semi.vo.integrationVo;
import semi.vo.usersVo;



@WebServlet("/book")
public class bookController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String aa = request.getParameter("aa");
		JSONObject json=new JSONObject(aa);
		int showNum=json.getInt("showNum");
		System.out.println(showNum);
		int price=json.getInt("price");
		System.out.println(price);
		JSONArray array=json.getJSONArray("array");
		System.out.println(array.get(2));
		//String str=array.toString().substring(2,aa.length()-2);
		//String[] arr=str.split("\",\"");
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		String bookNumArr="";
		usersDao udao=usersDao.getInstance();
		int userNum=udao.getUserNum(id);
		
		bookDao dao=bookDao.getInstance();
		for(int i=0;i<array.length();i++) {
			if(!array.get(i).equals("")) {
				String seatNum=array.get(i).toString();
				System.out.println(seatNum);
				int seatNum2=Integer.parseInt(seatNum);
				bookVo vo=new bookVo();
				vo.setShowNum(showNum);
				vo.setPrice(price);
				vo.setUserNum(userNum);
				vo.setSeatNum(seatNum2);
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
