package jhr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import semi.db.dbCon;
import semi.vo.usersVo;

public class UsersDao {
	/*
	private static UsersDao instance=new UsersDao();
	private UsersDao() {}
	public static UsersDao getInstance() {
		return instance;
	}
	*/
	public int pwdupdate(usersVo vo) {
		String sql="update users set pwd=? where id=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dbCon.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,vo.getPwd());
			pstmt.setString(2,vo.getId());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			dbCon.close(con,pstmt,null);
		}
	}
	public int update(usersVo vo) {
		String sql="update users set name=?,email=?,phone=?,year=? where id=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dbCon.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,vo.getName());
			pstmt.setString(2,vo.getEmail());
			pstmt.setString(3,vo.getPhone());
			pstmt.setString(4,vo.getYear());
			pstmt.setString(5,vo.getId());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			dbCon.close(con,pstmt,null);
		}
	}
	public usersVo getinfo(String id) {
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
				usersVo vo=new usersVo(
						rs.getInt("userNum"),
						rs.getString("id"), 
						rs.getString("pwd"), 
						rs.getString("name"), 
						rs.getString("email"), 
						rs.getString("phone"),
						rs.getString("year"), 
						rs.getNString("delUser"));
				return vo;
			}
			return null;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			dbCon.close(con, pstmt,rs);
		}
	}
	
	public boolean check(String id,String pwd) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="select * from users where id=? and pwd=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,pwd);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			return false;
		}catch(SQLException s) {
			s.printStackTrace();
			return false;
		}finally {
			dbCon.close(con, pstmt,rs);
		}
	}

	public int delaccount(usersVo vo) {
		String sql="update users set delUser='yes' where id=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dbCon.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,vo.getId());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			dbCon.close(con,pstmt,null);
		}
	}
	
	public int insert(usersVo vo){
		String sql="insert into users values(users_seq.nextval,?,?,?,?,?,?,null)";
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dbCon.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,vo.getId());
			pstmt.setString(2,vo.getPwd());
			pstmt.setString(3,vo.getName());
			pstmt.setString(4,vo.getEmail());
			pstmt.setString(5,vo.getPhone());
			pstmt.setString(6,vo.getYear());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			dbCon.close(con,pstmt,null);
		}
	}
	public boolean isMember(String id,String pwd) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="select * from users where id=? and pwd=? and delUser is null";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,pwd);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException se) {
			se.printStackTrace();
			return false;
		}finally {
			dbCon.close(con, pstmt, rs);
		}
	}
}