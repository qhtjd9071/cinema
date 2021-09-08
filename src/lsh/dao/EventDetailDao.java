package lsh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import semi.db.dbCon;
import semi.vo.eventVo;

public class EventDetailDao {
	private static EventDetailDao instance=new EventDetailDao();
	public EventDetailDao() {}
	public static EventDetailDao getInstance() {
		return instance;
	}
	
	public ArrayList<eventVo> dlist() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="select * from event order by eventNum desc";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<eventVo> dlist=new ArrayList<eventVo>();
			while(rs.next()) {
				eventVo vo=new eventVo();
				vo.setEventNum(rs.getInt("evnetNum"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWritedate(rs.getDate("writedate"));
				vo.setHit(rs.getInt("hit"));
				vo.setmainImage(rs.getString("mainImage"));
				vo.setdetailImage(rs.getString("detailImage"));
				dlist.add(vo);
			}
			return dlist;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			dbCon.close(con, pstmt, rs);
		}
	}
}
