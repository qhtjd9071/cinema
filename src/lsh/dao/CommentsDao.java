package lsh.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import semi.db.dbCon;
import semi.vo.movieCommentsVo;



public class CommentsDao {
	private static CommentsDao instance=new CommentsDao();
	private CommentsDao() {}
	public static CommentsDao getInstance() {
		return instance;
	}
	public int delete(int movieCommentsNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="delete from movieComments where movieCommentsNum=?";
		try {
			con=dbCon.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, movieCommentsNum);
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}
	public int insert(movieCommentsVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="insert into movieComments values(movieComments_seq.nextval,?,?,?,sysdate,?,?)";
		try {
			con=dbCon.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getStar());
			pstmt.setInt(4, vo.getUserNum());
			pstmt.setInt(5, vo.getMovieNum());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}
	public ArrayList<movieCommentsVo> list(int movieNum){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from movieComments where movieNum=?";
		try {
			con=dbCon.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, movieNum);
			rs=pstmt.executeQuery();
			ArrayList<movieCommentsVo> clist=new ArrayList<movieCommentsVo>();
			while(rs.next()) {
				movieCommentsVo vo=new movieCommentsVo(rs.getInt("movieCommentsNum"),
						rs.getString("id"),
						rs.getString("content"),
						rs.getInt("star"),
						rs.getDate("writedate"),
						rs.getInt("UserNum"),
						rs.getInt("movieNum"));
				clist.add(vo);
			}
			return clist;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			dbCon.close(con, pstmt, rs);
		}
	}
}
