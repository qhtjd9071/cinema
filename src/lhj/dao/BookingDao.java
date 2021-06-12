package lhj.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

import semi.db.dbCon;
import semi.vo.movieVo;
import semi.vo.roomVo;
import semi.vo.roommovVo;
import semi.vo.showVo;
import semi.vo.showinfoVo;
import semi.vo.timeVo;

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
			String sql = "select distinct(m.movieTitle) from show s join movie m on m.movieNum = s.movieNum "
					   + " join room r on s.roomserialNum = r.roomserialnum where r.theaterName = ?";
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
	
	// 영화별 영화 불러오기 - 관람순
	public ArrayList<roommovVo> mCountList(String theaterName){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<roommovVo> mlist = new ArrayList<>();
		try {
			con = dbCon.getConnection();
			String sql = "select m.movieTitle, nvl(sh.sc,0) booking "
					+ "from movie m,"
					+ "("
					+ "select s.movieNum, sum(c) sc "
					+ "from show s, room r,"
					+ "("
					+ "select nvl(count(*),0) c, showNum "
					+ "from book "
					+ "group by showNum"
					+ ")b "
					+ "where b.showNum(+) = s.showNum and r.roomserialnum = s.roomserialnum and r.theaterName=?"
					+ "group by movieNum "
					+ "order by sc desc "
					+ ")sh "
					+ "where sh.movieNum =m.movieNum";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, theaterName);
			//System.out.println("booking: " + theaterName);
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

	// 영화별 영화 불러오기 - 평점순
	public ArrayList<roommovVo> mStarList(String theaterName){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<roommovVo> starlist = new ArrayList<roommovVo>();
		try {
			con = dbCon.getConnection();
			String sql = "select a.*, b.movieTitle from "
					+ "("
					+ "select m.movieNum from show s join movie m on m.movieNum = s.movieNum "
					+ "join room r on s.roomserialNum = r.roomserialnum "
					+ "where r.theaterName = ? "
					+ "group by m.movieNum "
					+ ") a, "
					+ "("
					+ "select m.movieTitle, m.movieNum, c.s from movie m, "
					+ "("
					+ "select avg(nvl(star,0)) s, movieNum from movieComments "
					+ "group by movieNum "
					+ "order by s desc "
					+ ")c "
					+ "where c.movieNum = m.movieNum "
		 			+ ")b "
					+ "where a.movieNum = b.movieNum "
					+ "order by s desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, theaterName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
					String movieTitle = rs.getString("movieTitle");
					System.out.println("별점: " + movieTitle);
					roommovVo vo = new roommovVo(movieTitle, 0, 0, null);
					starlist.add(vo);
				}	
			return starlist;
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
	//선택한 날짜와 영화에 맞는 상영관 총좌석수 불러오기
	public ArrayList<showinfoVo> roomSitDateList(Date begintime, String movieTitle, String theaterName){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<showinfoVo> rslist = new ArrayList<showinfoVo>();
		try {
			con = dbCon.getConnection();
			String sql = "select distinct(roomNum), sitCount from room join "
						+ "("
						+ "select * from show join movie on show.movieNum=movie.movieNum "
						+ ") sm "
						+ "on room.roomserialNum=sm.roomserialNum "
						+ "where theaterName=? "
						+ "and movieTitle=? "
						+ "and TO_CHAR(beginTime,'yyyy/mm/dd')= TO_CHAR(?,'yyyy/mm/dd')";
			pstmt = con.prepareStatement(sql);
			pstmt.setDate(3, begintime);
			//System.out.println("bookdao : " + begintime);
			pstmt.setString(2, movieTitle);
			//System.out.println("bookdao : " + movieTitle);
			pstmt.setString(1, theaterName);
			//System.out.println("bookdao : " + theaterName);
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
	public ArrayList<timeVo> showTimeList(Date begintime, String movieTitle, String theaterName, int roomNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<timeVo> stlist = new ArrayList<timeVo>();
		try {
			con = dbCon.getConnection();
			String sql =  "select to_char(begintime, 'yyyy-mm-dd hh24:mi:ss') hr, s.showNum from room r, show s, movie m "
						+ "where r.roomserialNum = s.roomserialNum and s.movieNum = m.movieNum "
						+ "and to_char(begintime, 'yyyy/mm/dd') = to_char(?, 'yyyy/mm/dd') "
						+ "and m.movietitle = ? "
						+ "and r.theaterName = ? "
						+ "and r.roomNum= ? "
						+ "order by hr";
			pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, begintime);
			//System.out.println("timedao : " + begintime);
			pstmt.setString(2, movieTitle);
			pstmt.setString(3, theaterName);;
			pstmt.setInt(4, roomNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Timestamp beginhour = rs.getTimestamp("hr");
				int showNum = rs.getInt("showNum");
				//System.out.println("timedao: " + beginhour);
				timeVo vo = new timeVo(0, showNum, 0, 0, 0, null, beginhour, null, null);
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
