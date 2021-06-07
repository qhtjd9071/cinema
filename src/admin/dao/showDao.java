package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import semi.db.dbCon;

public class showDao {
	private static showDao instance=new showDao();
	private showDao() {}
	public static showDao getInstance() {
		return instance;
	}
	
	public void insert(int movieNum,String  beginTime,String  endTime,int roomSerialNum,int price) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dbCon.getConnection();
			String sql="insert into show values(show_seq.nextval,?,to_date(?,'yyyy-mm-dd hh24:mi:ss'),to_date(?,'yyyy-mm-dd hh24:mi:ss'),?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, movieNum);
			pstmt.setString(2, beginTime);
			pstmt.setString(3, endTime);
			pstmt.setInt(4, roomSerialNum);
			pstmt.setInt(5, price);
			pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}
}
