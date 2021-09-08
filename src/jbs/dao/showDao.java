package jbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import semi.db.dbCon;
import semi.vo.bookVo;
import semi.vo.showVo;

public class showDao {
	private static showDao instance=new showDao();
	private showDao() {}
	public static showDao getInstance() {
		return instance;
	}
	
	public showVo getPrice(int showNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="select * from show where showNum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, showNum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				showVo vo=new showVo();
				vo.setPrice(rs.getInt("price"));
				return vo;
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, null);
		}
		return null;
	}
	
	public int getMovieNum(int showNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="select * from show where showNum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, showNum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int movieNum=rs.getInt("movieNum");
				return movieNum;
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, null);
		}
		return 0;
	}
}
