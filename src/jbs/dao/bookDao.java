package jbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import semi.db.dbCon;
import semi.vo.bookVo;
import semi.vo.payVo;

public class bookDao {
	private static bookDao instance=new bookDao();
	private bookDao() {}
	public static bookDao getInstance() {
		return instance;
	}
	
	public void insert(bookVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dbCon.getConnection();
			String sql="insert into book values(book_seq.nextval,?,sysdate,?,?,null,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, vo.getShowNum());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setInt(3, vo.getUserNum());
			pstmt.setInt(4, vo.getSeatNum());
			pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}
	
	public ArrayList<bookVo> select(){
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try {
		con=dbCon.getConnection();
		String sql="select * from book";
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		ArrayList<bookVo> list=new ArrayList<bookVo>();
		while(rs.next()){
			bookVo vo=new bookVo();
			vo.setSeatNum(rs.getInt("seatNum"));
			vo.setPrice(rs.getInt("price"));
			list.add(vo);
		}
		return list;
	}catch(SQLException se) {
		se.printStackTrace();
		return null;
	}finally {
		dbCon.close(con, pstmt, rs);
	}
	}
	
	public int getBookNum(bookVo vo){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="select bookNum from book where userNum=? and seatNum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, vo.getUserNum());
			pstmt.setInt(2, vo.getSeatNum());
			rs=pstmt.executeQuery();
			if(rs.next()){
				int bookNum=rs.getInt("bookNum");
				return bookNum;
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, rs);
		}
		return 0;
	}
	
	public boolean check(int seatNum, int showNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean check=false;
		try {
			con=dbCon.getConnection();
			String sql="select * from book where seatNum=? and showNum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, seatNum);
			pstmt.setInt(2, showNum);
			rs=pstmt.executeQuery();
			if(rs.next()){
				check=true;
			}
			return check;
		}catch(SQLException se) {
			se.printStackTrace();
			return check;
		}finally {
			dbCon.close(con, pstmt, rs);
		}
	}
	
	public int getCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			con=dbCon.getConnection();
			String sql="select sitcount from room";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()){
				count=rs.getInt("sitcount");
			}
			return count;
		}catch(SQLException se) {
			se.printStackTrace();
			return count;
		}finally {
			dbCon.close(con, pstmt, rs);
		}
	}
	
}
