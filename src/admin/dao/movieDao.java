package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import semi.db.dbCon;
import semi.vo.movieVo;
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
}
