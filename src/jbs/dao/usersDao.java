package jbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import semi.db.dbCon;
import semi.vo.usersVo;

public class usersDao {
	private static usersDao instance=new usersDao();
	private usersDao() {}
	public static usersDao getInstance() {
		return instance;
	}
	
	public int getUserNum(String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="select * from users where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int userNum=rs.getInt("userNum");
				return userNum;
			}
		}catch(SQLException s) {
			s.printStackTrace();
		}finally {
			dbCon.close(con, pstmt,rs);
		}
		return 0;
	}
	public String getId(int userNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="select * from users where userNum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,userNum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String id=rs.getString(userNum);
				return id;
			}
		}catch(SQLException s) {
			s.printStackTrace();
		}finally {
			dbCon.close(con, pstmt,rs);
		}
		return null;
	}
}
