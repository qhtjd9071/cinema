package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import semi.db.dbCon;
import semi.vo.mrsVo;

public class showDao {
	private static showDao instance=new showDao();
	private showDao() {}
	public static showDao getInstance() {
		return instance;
	}
	
	public void insert(int movieNum,String  beginTime,String  endTime,int roomSerialNum,int price) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dbCon.getConnection();
			String sql="insert into show values(show_seq.nextval,?,to_date(?,'yyyy-mm-dd hh24:mi:ss'),to_date(?,'yyyy-mm-dd hh24:mi:ss'),?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, movieNum);
			pstmt.setString(2, beginTime);
			pstmt.setString(3, endTime);
			pstmt.setInt(4, roomSerialNum);
			pstmt.setInt(5, price);
			pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}
	
	public int delete(int showNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dbCon.getConnection();
			String sql="delete from show where showNum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, showNum);
			int result=pstmt.executeUpdate();
			return result;
		}catch(SQLException se) {
			se.printStackTrace();
			return 0;
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}
	
	public ArrayList<mrsVo> list(int startRow,int endRow){
		String sql="select * from (select msr.*,rownum rnum from (select * from room join (select * from movie join show on movie.movieNum=show.movieNum) ms on room.roomSerialNum=ms.roomSerialNum order by showNum desc) msr) where rnum>=? and rnum<=?";
		    
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2,endRow);
			rs=pstmt.executeQuery();
			ArrayList<mrsVo> list=new ArrayList<>();
			while(rs.next()) {
				mrsVo vo=new mrsVo();
				vo.setShowNum(rs.getInt("showNum"));
				vo.setRoomNum(rs.getInt("roomNum"));
				vo.setMovieTitle(rs.getString("movieTitle"));
				vo.setBeginTime(rs.getString("beginTime"));
				vo.setEndTime(rs.getString("endTime"));
				vo.setTheaterName(rs.getString("theaterName"));
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
			String sql="select NVL(count(*),0) from show";
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
	
}
