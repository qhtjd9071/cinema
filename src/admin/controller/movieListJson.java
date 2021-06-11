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

import admin.dao.movieDao;
import semi.vo.movieVo;
@WebServlet("/mlist")
public class movieListJson extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		movieDao dao=movieDao.getInstance();
		ArrayList<movieVo> list=dao.list();
		JSONArray arr=new JSONArray();
		for(int i=0;i<list.size();i++) {
			JSONObject json=new JSONObject();
			movieVo vo=list.get(i);
			json.put("movieNum",vo.getMovieNum());
			json.put("movieTitle",vo.getMovieTitle());
			json.put("image",vo.getImage());
			arr.put(json);
		}
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.print(arr);
	}
}
