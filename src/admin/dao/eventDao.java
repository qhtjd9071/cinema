package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import semi.db.dbCon;
import semi.vo.eventVo;

public class eventDao {
	private static eventDao instance=new eventDao();
	private eventDao() {}
	public static eventDao getInstance() {
		return instance;
	}
	
	public void insert(eventVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dbCon.getConnection();
			String sql="insert into event values(event_seq.nextval,?,?,sysdate,0,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getmainImage());
			pstmt.setString(4, vo.getdetailImage());
			pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}
}
