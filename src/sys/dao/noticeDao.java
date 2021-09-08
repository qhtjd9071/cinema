package sys.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import semi.db.dbCon;
import semi.vo.customerVo;
import semi.vo.noticeVo;

public class noticeDao {
		private static noticeDao instance=new noticeDao();
		private noticeDao() {}
		public static noticeDao getInstance() {
			return instance;
		}
	public int insert(noticeVo vo){
			Connection con=null;
			PreparedStatement pstmt=null;
		String sql="insert into notice values(notice_seq.nextval,?,?,sysdate,?)";
		try {
			con=dbCon.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,vo.getTitle());
			pstmt.setString(2,vo.getContent());
			pstmt.setInt(3, vo.getHit());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}
	public ArrayList<noticeVo> list(int startRow,int endRow){
		String sql="select * from " + 
					"( " + 
					"  select mynotice.*,rownum rnum from " + 
					"  (" + 
					"	  select * from notice order by noticenum desc" + 
					"  ) mynotice" + 
					") where rnum>=? and rnum<=?";
		    
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2,endRow);
			rs=pstmt.executeQuery();
			ArrayList<noticeVo> list=new ArrayList<noticeVo>();
			while(rs.next()) {
				noticeVo vo=new noticeVo(
					rs.getInt("noticeNum"),
					rs.getString("title"),
					rs.getString("content"),
					rs.getDate("writedate"),
					rs.getInt("hit"));
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
	
	public int getCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="select NVL(count(*),0) from notice";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int n=rs.getInt(1);
				return n;
			}
			return -1;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			dbCon.close(con, pstmt, rs);
		}
	}
	
	public noticeVo detail(int num) {
		String sql="select * from notice where noticeNum=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String title=rs.getString("title");
				String content=rs.getString("content");
				int hit=rs.getInt("hit");
				Date writeDate=rs.getDate("writeDate");
				noticeVo vo=new noticeVo(num, title, content, writeDate, hit);
				return vo;
			}
			return null;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			dbCon.close(con, pstmt, rs);
		}	
	}
	public int update(noticeVo vo) {
		String sql="update notice set title=?,content=? where noticeNum=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dbCon.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,vo.getTitle());
			pstmt.setString(2,vo.getContent());
			pstmt.setInt(3,vo.getNoticeNum());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			dbCon.close(con,pstmt,null);
		}
	}
	
	public noticeVo getinfo(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="select * from notice where noticeNum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,num);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				noticeVo vo=new noticeVo(
						rs.getInt("noticeNum"), 
						rs.getString("title"), 
						rs.getString("content"), 
						rs.getDate("writedate"), 
						rs.getInt("hit"));							
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
	public int delete(int num){
		String sql="delete from notice where noticeNum=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dbCon.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,num);
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			dbCon.close(con,pstmt,null);
		}
	}
	
	public void hitPlus(int noticeNum){
		String sql="update notice set hit=hit+1 where noticeNum=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dbCon.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,noticeNum);
			pstmt.executeUpdate();
		}catch(SQLException s) {
			s.printStackTrace();
		}finally {
			dbCon.close(con,pstmt,null);
		}
	}
}

