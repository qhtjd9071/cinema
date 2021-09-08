package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import admin.dao.roomDao;
import semi.vo.movieVo;
import semi.vo.roomVo;
@WebServlet("/rlist")
public class roomListJson extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		roomDao dao=roomDao.getInstance();
		ArrayList<roomVo> list=dao.list();
		JSONArray arr=new JSONArray();
		for(int i=0;i<list.size();i++) {
			JSONObject json=new JSONObject();
			roomVo vo=list.get(i);
			json.put("roomSerialNum",vo.getRoomSerialNum());
			json.put("theaterName",vo.getTheaterName());
			json.put("roomNum",vo.getRoomNum());
			arr.put(json);
		}
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.print(arr);
	}
}
