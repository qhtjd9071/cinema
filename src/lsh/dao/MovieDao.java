package lsh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import semi.db.dbCon;
import semi.vo.movieVo;


public class MovieDao {
	private static MovieDao instance=new MovieDao();
	public MovieDao() {}
	public static MovieDao getInstance() {
		return instance;
	}
	public movieVo getinfo(int movieNum) {
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
				String movieContent=rs.getString("movieContent");
				String director=rs.getString("director");
				String genre=rs.getString("genre");
				String rating=rs.getString("rating");
				String image=rs.getString("image");
				movieVo vo=new movieVo(movieNum, movieTitle, movieContent, director, genre, rating, image);
				return vo;
			}else {
				return null;
			}
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			dbCon.close(con, pstmt, rs);
		}
	}
}
