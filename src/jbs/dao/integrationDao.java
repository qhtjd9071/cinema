package jbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import semi.db.dbCon;
import semi.vo.integrationVo;

public class integrationDao {
	private static integrationDao instance=new integrationDao();
	private integrationDao() {}
	public static integrationDao getInstance() {
		return instance;
	}
	
	public void insert(integrationVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dbCon.getConnection();
			String sql="insert into integration values(int_seq.nextval,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getBookNumArr());
			pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}
	
	public int getBookNumArr(integrationVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="select intNum from integration where bookNumArray=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getBookNumArr());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int bna=rs.getInt("intNum");
				return bna;
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, null);
		}
		return 0;
	}
}
