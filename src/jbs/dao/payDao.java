package jbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import semi.db.dbCon;
import semi.vo.payVo;

public class payDao {
	private static payDao instance=new payDao();
	private payDao() {}
	public static payDao getInstance() {
		return instance;
	}
	public void insert(payVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dbCon.getConnection();
			String sql="insert into pay values(?,?,null,null,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getPayNum());
			pstmt.setInt(2, vo.getIntNum());
			pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}
	public void save(payVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dbCon.getConnection();
			String sql="update pay set method=?,tot=? where payNum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getMethod());
			pstmt.setInt(2, vo.getTot());
			pstmt.setString(3, vo.getPayNum());
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
	
	public void delete(int partner_order_id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dbCon.getConnection();
			String sql="delete from pay where intNum=?";
			pstmt=con.prepareStatement(sql);
			System.out.println(partner_order_id);
			pstmt.setInt(1, partner_order_id);
			pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}
	
	public payVo find(int partner_order_id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="select * from pay where intNum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, partner_order_id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				payVo vo=new payVo();
				System.out.println(rs.getString("payNum"));
				System.out.println(rs.getString(1));
				System.out.println(rs.getInt(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getInt(4));
				vo.setPayNum(rs.getString("payNum"));
				vo.setTot(rs.getInt("tot"));
				System.out.println(rs.getInt("tot"));
				return vo;
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, null);
		}
		return null;
	}
	
	public ArrayList<payVo> payAll() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="select * from pay";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<payVo> list=new ArrayList<payVo>();
			while(rs.next()) {
				payVo vo=new payVo();
				vo.setPayNum(rs.getString("payNum"));
				vo.setIntNum(rs.getInt("intNum"));
				vo.setMethod(rs.getString("method"));
				vo.setTot(rs.getInt("tot"));
				vo.setPayDate(rs.getDate("payDate"));
				list.add(vo);
			}
			return list;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}
}
