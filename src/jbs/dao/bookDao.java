package jbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import semi.db.dbCon;
import semi.vo.bookVo;
import semi.vo.bsmrJoinVo;
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
			System.out.println("voshowNum:"+vo.getShowNum());
			pstmt.setInt(2, vo.getPrice());
			System.out.println("voprice:"+vo.getPrice());
			pstmt.setInt(3, vo.getUserNum());
			System.out.println("vouser:"+vo.getUserNum());
			pstmt.setInt(4, vo.getSeatNum());
			System.out.println("voseatNum:"+vo.getSeatNum());
			int n=pstmt.executeUpdate();
			System.out.println("bookInsertResult:"+n);
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}
	public void delete(int bookNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dbCon.getConnection();
			String sql="delete from book where bookNum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bookNum);
			pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}
	
	public ArrayList<bookVo> select(int showNum){
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try {
		con=dbCon.getConnection();
		String sql="select * from book where showNum=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, showNum);
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
	
	public bsmrJoinVo getUserBook(int bookNum){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="select * from room join (select * from movie join (select * from book join show on book.showNum=show.showNum) bs on movie.movieNum=bs.movieNum) bsm on room.roomSerialNum=bsm.roomSerialNum where bookNum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bookNum);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bsmrJoinVo vo=new bsmrJoinVo();
				vo.setMovieTitle(rs.getString("movieTitle"));
				vo.setSeatNum(rs.getInt("seatNum"));
				vo.setUserNum(rs.getInt("userNum"));
				vo.setTheaterName(rs.getString("theaterName"));
				vo.setRoomNum(rs.getInt("roomNum"));
				vo.setBeginTime(rs.getString("beginTime"));
				return vo;
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, rs);
		}
		return null;
	}
	
	public int getBookNum(bookVo vo){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="select bookNum from book where userNum=? and seatNum=? and showNum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, vo.getUserNum());
			pstmt.setInt(2, vo.getSeatNum());
			pstmt.setInt(3, vo.getShowNum());
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
	
	public int getCount(int showNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			con=dbCon.getConnection();
			String sql="select sitcount from room join show on room.roomSerialNum=show.roomSerialNum where showNum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, showNum);
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
