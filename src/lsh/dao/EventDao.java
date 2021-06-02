package lsh.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import semi.db.dbCon;
import semi.vo.eventVo;

public class EventDao {
	private static EventDao instance=new EventDao();
	private EventDao() {}
	public static EventDao getInstance() {
		return instance;
	}
	public eventVo getinfo(int eventNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="select * from event where eventNum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, eventNum);
			rs=pstmt.executeQuery();	
				if(rs.next()) {
					String title=rs.getString(title);
					String content=rs.getString(content);
					Date writedate=rs.getDate(writedate);  //while문으로 수정 
					int hit=rs.getInt(hit);
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
	}
