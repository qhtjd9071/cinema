package lhj.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import semi.db.dbCon;
import semi.vo.eventVo;

public class EventShowDao {
	private static EventShowDao instance=new EventShowDao();
	public EventShowDao() {}
	public static EventShowDao getInstance() {
		return instance;
	}
	public eventVo getDetail(int eventNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con = dbCon.getConnection();
			String sql2="select * from event where eventNum=?";
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, eventNum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String title=rs.getString("title");
				String content=rs.getString("content");
				Date writedate=rs.getDate("writedate");
				String detailImage = rs.getString("detailImage");
				eventVo vo=new eventVo(eventNum, title, content, writedate, 0, null, detailImage);
				return vo;
			}else {
				return null;
			}
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			dbCon.close(con, pstmt, rs);
		}
	}
	
	public ArrayList<eventVo> list() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con = dbCon.getConnection();
			String sql="select * from event";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<eventVo> elist=new ArrayList<eventVo>();
			while(rs.next()) {
				int eventNum = rs.getInt("eventNum");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date writedate = rs.getDate("writedate");
				int hit = rs.getInt("hit");
				String mainImage = rs.getString("mainImage");
				eventVo vo = new eventVo(eventNum, title, content, writedate, hit, mainImage, null);
				elist.add(vo);
			}
			return elist;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}
}
