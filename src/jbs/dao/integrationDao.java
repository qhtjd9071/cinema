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
	public void delete(int intNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dbCon.getConnection();
			String sql="delete from integration where intNum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, intNum);
			pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}
	
	public int getIntNum(integrationVo vo) {
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
	
	public integrationVo getBookNumArr(int intNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="select bookNumArray from integration where intNum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, intNum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				integrationVo vo=new integrationVo();
				vo.setBookNumArr(rs.getString("bookNumArray"));
				return vo;
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, null);
		}
		return null;
	}
}
