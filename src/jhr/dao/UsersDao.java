package jhr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import test.db.DBConnection;
import test.vo.UsersVo;

public class UsersDao {
	/*
	public int update(MembersVo vo) {
		System.out.println("vo:" + vo);
		String sql="update members set name=?,phone=?,addr=? where num=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);	
			pstmt.setString(1,vo.getName());
			pstmt.setString(2,vo.getPhone());
			pstmt.setString(3,vo.getAddr());
			pstmt.setInt(4,vo.getNum());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con,pstmt,null);
		}
	}
	public MembersVo getinfo(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select * from members where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				MembersVo vo=new MembersVo(
						rs.getInt("num"), 
						rs.getString("name"), 
						rs.getString("phone"), 
						rs.getString("addr"), 
						rs.getDate("regdate"));
				return vo;
			}
			return null;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con, pstmt,rs);
		}
	}
	
	public int delete(int num){
		String sql="delete from members where num=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,num);
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con,pstmt,null);
		}
	}
	*/
	public int insert(UsersVo vo){
		String sql="insert into users values(memnum.nextval,?,?,?,?,?,?,null)";
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,vo.getName());
			pstmt.setString(2,vo.getId());
			pstmt.setString(3,vo.getPwd());
			pstmt.setString(4,vo.getEmail());
			pstmt.setString(5,vo.getYear());
			pstmt.setString(6,vo.getPhone());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con,pstmt,null);
		}
	}
	public ArrayList<UsersVo> list(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select * from users";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<UsersVo> mlist=new ArrayList<UsersVo>();
			while(rs.next()) {
				UsersVo vo=new UsersVo(
						rs.getString("name"), 
						rs.getString("id"), 
						rs.getString("pwd"), 
						rs.getString("email"), 
						rs.getString("year"), 
						rs.getString("phone"));
				mlist.add(vo);
			}
			return mlist;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con, pstmt,rs);
		}
	}
}



























