package lsh.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import semi.db.dbCon;
import semi.vo.eventVo;
import semi.vo.movieVo;

public class EventDao {
	private static EventDao instance=new EventDao();
	public EventDao() {}
	public static EventDao getInstance() {
		return instance;
	}
	
//	public eventVo getinfo(int eventNum) {
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;
//		try {
//			con=dbCon.getConnection();
//			String sql="update event set hit = hit+1 where eventNum=?";
//			pstmt=con.prepareStatement(sql);
//			pstmt.setInt(1, eventNum);
//			pstmt.executeUpdate();
//			
//			sql="select * from event where eventNum=?";
//			pstmt=con.prepareStatement(sql);
//			pstmt.setInt(1, eventNum);
//			rs=pstmt.executeQuery();
//			if(rs.next()) {
//				String title=rs.getString("title");
//				String content=rs.getString("content");
//				Date writedate=rs.getDate("writedate");
//				int hit=rs.getInt("hit");
//				String mainImage=rs.getString("mainImage");
//				String detailImage=rs.getString("detailImage");
//				eventVo vo=new eventVo(eventNum, title, content, writedate, hit, mainImage, detailImage);
//				return vo;
//			}else {
//				return null;
//			}
//		}catch(SQLException se) {
//			se.printStackTrace();
//			return null;
//		}finally {
//			dbCon.close(con, pstmt, rs);
//		}
//	}
	
	public ArrayList<eventVo> list() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="select * from event order by eventNum desc";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<eventVo> list=new ArrayList<eventVo>();
			while(rs.next()) {
				eventVo vo=new eventVo();
				vo.setEventNum(rs.getInt("eventNum"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWritedate(rs.getDate("writedate"));
				vo.setHit(rs.getInt("hit"));
				vo.setmainImage(rs.getString("mainImage"));
				vo.setdetailImage(rs.getString("detailImage"));
				list.add(vo);
			}
			return list;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}
	
}
