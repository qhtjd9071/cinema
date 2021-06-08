package lsh.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import semi.db.dbCon;
import semi.vo.eventVo;

public class EventDao {
	private static EventDao instance=new EventDao();
	public EventDao() {}
	public static EventDao getInstance() {
		return instance;
	}
	//이벤트 정보
	public eventVo getinfo(int eventNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="update event set hit = hit+1 where eventNum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, eventNum);
			pstmt.executeUpdate();
			
			sql="select * from event where eventNum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, eventNum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String title=rs.getString("title");
				String content=rs.getString("content");
				Date writedate=rs.getDate("writedate");
				int hit=rs.getInt("hit");
				eventVo vo=new eventVo(eventNum, title, content, writedate, hit);
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
	//이벤트 정보 끝
}
