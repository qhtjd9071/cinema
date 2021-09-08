package lhj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import semi.db.dbCon;
import semi.vo.movieVo;

public class MovieListDao {
	private static MovieListDao instance = new MovieListDao();
	private MovieListDao() {}
	public static MovieListDao getInstance() {
		return instance;
	}
	//전체 글 갯수
/*	public int getCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dbCon.getConnection();
			String sql = "SELECT NVL(COUNT(*),0) FROM movie";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			int cnt = rs.getInt(1);
			return cnt;
		} catch(SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			dbCon.close(con, pstmt, rs);
		}
	}
	
	public ArrayList<movieVo> MovieList(int startRow, int endRow) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="SELECT * FROM "
					+ "("
					+ " SELECT M.*, ROWNUM RNUM FROM "
					+ "("
					+ " SELECT * FROM movie ORDER BY movieNum DESC "
					+ ")M "
					+ ")"
					+ " WHERE RNUM>=? AND RNUM <=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			ArrayList<movieVo> movlist = new ArrayList<movieVo>();
			while(rs.next()) {
				movieVo vo=new movieVo();
				vo.setMovieNum(rs.getInt("movieNum"));
				vo.setMovieTitle(rs.getString("movieTitle"));
				vo.setImage(rs.getString("image"));
				movlist.add(vo);
				//System.out.println(movlist);
			}
			return movlist;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}
*/	
	public ArrayList<movieVo> movList() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="SELECT * FROM MOVIE ORDER BY MOVIENUM DESC";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<movieVo> mlist = new ArrayList<movieVo>();
			while(rs.next()) {
				movieVo vo=new movieVo();
				vo.setMovieNum(rs.getInt("movieNum"));
				vo.setMovieTitle(rs.getString("movieTitle"));
				vo.setImage(rs.getString("image"));
				mlist.add(vo);
			}
			return mlist;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}		
}
