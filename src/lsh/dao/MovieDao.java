package lsh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import semi.db.dbCon;
import semi.vo.movieVo2;


public class MovieDao {
	private static MovieDao instance=new MovieDao();
	public MovieDao() {}
	public static MovieDao getInstance() {
		return instance;
	}
	public movieVo2 getinfo(int movieNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="select movieNum,movieTitle,movieContent,director,genre,rating,image,(select ROUND(AVG(NVL(star,0)),1) from movieComments where movieNum=?) grade from movie where movieNum=?";

			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, movieNum);
			pstmt.setInt(2, movieNum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String movieTitle=rs.getString("movieTitle");
				String movieContent=rs.getString("movieContent");
				String director=rs.getString("director");
				String genre=rs.getString("genre");
				String rating=rs.getString("rating");
				String image=rs.getString("image");
				String grade=rs.getString("grade");
				movieVo2 vo=new movieVo2(movieNum, movieTitle, movieContent, director, genre, rating, image, grade);
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
