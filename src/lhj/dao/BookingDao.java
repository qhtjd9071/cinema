package lhj.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import semi.db.dbCon;
import semi.vo.movieVo;
import semi.vo.roomVo;
import semi.vo.roommovVo;
import semi.vo.showVo;
import semi.vo.showinfoVo;

public class BookingDao {
	private static BookingDao instance = new BookingDao();
	private BookingDao() {
		
	}
	public static BookingDao getInstace() {
		return instance;
	}
	// 상영관 위치 출력
	public ArrayList<roomVo> theaterList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dbCon.getConnection();
			String sql = "select distinct(location) from room";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ArrayList<roomVo> rlist = new ArrayList<roomVo>();
			while(rs.next()) {
				String location = rs.getString("location");
				//System.out.println(location);
				roomVo vo = new roomVo(0, null, 0, location, 0);
				rlist.add(vo);
			}
			return rlist;
		} catch(SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			dbCon.close(con, pstmt, rs);
		}
	}
	// 지역 선택했을 때 상영관 가져오기
	public ArrayList<roomVo> locationList(String location){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dbCon.getConnection();
			String sql = "select distinct(theaterName) from room where location=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, location);
			rs = pstmt.executeQuery();
			ArrayList<roomVo> rlist = new ArrayList<roomVo>();
			while(rs.next()) {
				String theaterName = rs.getString("theaterName");
				roomVo vo = new roomVo(0, theaterName, 0, null, 0);
				rlist.add(vo);
			}
			return rlist;
		} catch(SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			dbCon.close(con, pstmt, rs);
		}
	}
	// 상영관 모든 영화 불러오기
	public ArrayList<roommovVo> movieList(String theaterName){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<roommovVo> mlist = new ArrayList<roommovVo>();
		try {
			con = dbCon.getConnection();
			String sql = "select m.movieTitle "
					+ "from movie m, room r, show s "
					+ "where m.movieNum = s.movieNum and s.roomserialNum = r.roomserialNum "
					+ "and r.theaterName=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, theaterName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String movieTitle = rs.getString("movieTitle");
				//System.out.println(movieTitle);
				roommovVo vo = new roommovVo(movieTitle, 0, 0, null);
				mlist.add(vo);
			}
			return mlist;
		} catch(SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			dbCon.close(con, pstmt, rs);
		}
	}
	
	// 영화별 영화 불러오기 - 관람순
	public ArrayList<roommovVo> mCountList(String theaterName){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<roommovVo> mlist = new ArrayList<>();
		try {
			con = dbCon.getConnection();
			String sql = "select m.movieTitle "
						+ "from movie m, room r,"
						+ "("
						+ "select s.movieNum, sum(c) sc "
						+ "from show s,"
						+ "("
						+ "select count(*) c, showNum "
						+ "from book "
						+ "group by showNum"
						+ ")b "
						+ "where b.showNum = s.showNum"
						+ "group by movieNum"
						+ "order by sc desc"
						+ ")sh "
						+ "where sh.movieNum =m.movieNum and theaterName=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, theaterName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String movieTitle = rs.getString("movieTitle");
				roommovVo vo = new roommovVo(movieTitle, 0, 0, null);
				mlist.add(vo);
			}
			return mlist;
		} catch(SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			dbCon.close(con, pstmt, rs);
		}
	}
	
	// 영화별 영화 불러오기 - 평점순
	public ArrayList<roommovVo> mStarList(String theaterName){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<roommovVo> mlist = new ArrayList<roommovVo>();
		try {
			con = dbCon.getConnection();
			String sql = "select m.movieTitle from movie m, room r,"
					+ "("
					+ "select avg(star) s, movieNum from movieComments "
					+ "group by movieNum "
					+ "order by s desc "
					+ ")c"
					+ "where m.movieNum = c.movieNum and r.theaterName=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, theaterName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String movieTitle = rs.getString("movieTitle");
				roommovVo vo = new roommovVo(movieTitle, 0, 0, null);
				mlist.add(vo);
			}
			return mlist;
		} catch(SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			dbCon.close(con, pstmt, rs);
		}
	}
	
	// 오늘 날짜에 맞는 상영관 총좌석수 불러오기
	/*public ArrayList<roomVo> roomSitList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<roomVo> rslist = new ArrayList<roomVo>();
		try {
			con = dbCon.getConnection();
			String sql = "select r.roomnum, r.sitCount from room r,"
					+ "("
					+ "select roomserialnum, to_char(begintime, 'hh24:mi'), s.shownum, b.cnt from show s "
					+ "("
					+ "select showNum, count(showNum) as cnt"
					+ "from book"
					+ "group by showNum"
					+ ")b"
					+ "where s.shownum = b.shownum and to_char(begintime,'yyyy/mm/dd') = to_char(sysdate,'yyyy/mm/dd')"
					+ ") rb"
					+ "where rb.roomserialnum = r.roomserialnum";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int roomNum = rs.getInt("roomNum");
				int sitCount = rs.getInt("sitCount");
				roomVo vo = new roomVo(0, null, sitCount, null, roomNum);
				rslist.add(vo);
			}
			return rslist;
		} catch(SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			dbCon.close(con, pstmt, rs);
		}
	}
	*/
	//선택한 날짜에 맞는 상영관 총좌석수 상영시간 불러오기
	public ArrayList<showinfoVo> roomSitDateList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<showinfoVo> rslist = new ArrayList<showinfoVo>();
		try {
			con = dbCon.getConnection();
			String sql = "select r.roomnum, r.sitCount from room r,"
					+ "("
					+ "select roomserialnum, to_char(begintime,'hh24:mi'), s.shownum, b.cnt from show s "
					+ "("
					+ "select showNum, count(showNum) as cnt"
					+ "from book"
					+ "group by showNum"
					+ ")b"
					+ "where s.shownum = b.shownum and to_char(begintime,'yyyy/mm/dd') = to_char(?,'yyyy/mm/dd')"
					+ ") rb"
					+ "where rb.roomserialnum = r.roomserialnum";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "begintime");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int roomNum = rs.getInt("roomNum");
				int sitCount = rs.getInt("sitCount");
				showinfoVo vo = new showinfoVo(0, 0, roomNum, 0, sitCount, null, null, null);
				rslist.add(vo);
			}
			return rslist;
		} catch(SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			dbCon.close(con, pstmt, rs);
		}
	}
	
	
	// 상영시간 불러오기
	public ArrayList<showinfoVo> showTimeList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<showinfoVo> stlist = new ArrayList<showinfoVo>();
		try {
			con = dbCon.getConnection();
			String sql =  "select to_char(begintime, 'hh24:mi') from show s,"
						+ "("
						+ "select showNum, count(showNum) as cnt"
						+ "from book"
						+ "group by showNum"
						+ ")b "
						+ "where s.shownum = b.shownum and to_char(begintime,'yyyy/mm/dd') = to_char(?,'yyyy/mm/dd')";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "begintime");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Date begintime = rs.getDate("begintime");
				showinfoVo vo = new showinfoVo(0, 0, 0, 0, 0, begintime, null, null);
				stlist.add(vo);
			}
			return stlist;
		} catch(SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			dbCon.close(con, pstmt, rs);
		}
	}
	// 빈좌석수 불러오기
}
