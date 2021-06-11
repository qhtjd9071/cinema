package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import semi.db.dbCon;
import semi.vo.movieVo;
import semi.vo.noticeVo;
import semi.vo.showVo;

public class movieDao {
	private static movieDao instance=new movieDao();
	private movieDao() {}
	public static movieDao getInstance() {
		return instance;
	}
	
	public void insert(movieVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dbCon.getConnection();
			String sql="insert into movie values(movie_seq.nextval,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getMovieTitle());
			pstmt.setString(2, vo.getMovieContent());
			pstmt.setString(3, vo.getDirector());
			pstmt.setString(4, vo.getGenre());
			pstmt.setString(5, vo.getRating());
			pstmt.setString(6, vo.getImage());
			pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}
	
	public ArrayList<movieVo> list() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="select * from movie";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<movieVo> list=new ArrayList<movieVo>();
			while(rs.next()) {
				movieVo vo=new movieVo();
				vo.setMovieNum(rs.getInt("movieNum"));
				vo.setMovieTitle(rs.getString("movieTitle"));
				vo.setImage(rs.getString("image"));
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
	
	public void delete(int movieNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dbCon.getConnection();
			String sql="delete from movie where movieNum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, movieNum);
			pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}
	
	public ArrayList<movieVo> list(int startRow,int endRow){
		String sql="select * from " + 
					"( " + 
					"  select m.*,rownum rnum from " + 
					"  (" + 
					"	  select * from movie order by movieNum desc" + 
					"  ) m" + 
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
			ArrayList<movieVo> list=new ArrayList<>();
			while(rs.next()) {
				movieVo vo=new movieVo();
				vo.setDirector(rs.getString("director"));
				vo.setGenre(rs.getString("genre"));
				vo.setMovieContent("rating");
				vo.setMovieContent("movieContent");
				vo.setMovieNum(rs.getInt("movieNum"));
				vo.setMovieTitle(rs.getString("movieTitle"));
				vo.setImage(rs.getString("image"));
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
			String sql="select NVL(count(*),0) from movie";
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
	
	public String getMovieTitle(int movieNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="select * from movie where movieNum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, movieNum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String movieTitle=rs.getString("movieTitle");
				return movieTitle;
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, null);
		}
		return null;
	}
	public String getRating(int movieNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="select * from movie where movieNum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, movieNum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String rating=rs.getString("rating");
				return rating;
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, null);
		}
		return null;
	}
}
