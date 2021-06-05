package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import semi.db.dbCon;
import semi.vo.showVo2;

public class showDao {
	private static showDao instance=new showDao();
	private showDao() {}
	public static showDao getInstance() {
		return instance;
	}
	
	public void insert(showVo2 vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dbCon.getConnection();
			String sql="insert into show values(show_seq.nextval,?,to_date(?,'yyyy-mm-dd hh24:mi:ss'),to_date(?,'yyyy-mm-dd hh24:mi:ss'),?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, vo.getMovieNum());
			pstmt.setString(2, vo.getBeginTime());
			pstmt.setString(3, vo.getEndTime());
			pstmt.setInt(4, vo.getRoomserialNum());
			pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}
}
