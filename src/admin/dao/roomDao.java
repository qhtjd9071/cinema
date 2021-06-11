package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import semi.db.dbCon;
import semi.vo.movieVo;
import semi.vo.roomVo;
import semi.vo.showVo;

public class roomDao {
	private static roomDao instance=new roomDao();
	private roomDao() {}
	public static roomDao getInstance() {
		return instance;
	}
	
	public void insert(roomVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dbCon.getConnection();
			String sql="insert into room values(room_seq.nextval,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getTheaterName());
			pstmt.setInt(2, vo.getSitCount());
			pstmt.setString(3, vo.getLocation());
			pstmt.setInt(4, vo.getRoomNum());
			pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}
	
	public void delete(int roomSerialNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dbCon.getConnection();
			String sql="delete from room where roomSerialNum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, roomSerialNum);
			pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}
	
	public ArrayList<roomVo> list(int startRow,int endRow){
		String sql="select * from " + 
					"( " + 
					"  select r.*,rownum rnum from " + 
					"  (" + 
					"	  select * from room order by roomSerialNum desc" + 
					"  ) r" + 
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
			ArrayList<roomVo> list=new ArrayList<>();
			while(rs.next()) {
				roomVo vo=new roomVo();
				vo.setRoomSerialNum(rs.getInt("roomSerialNum"));
				vo.setLocation(rs.getString("location"));
				vo.setRoomNum(rs.getInt("roomNum"));
				vo.setSitCount(rs.getInt("sitCount"));
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
			String sql="select NVL(count(*),0) from room";
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
	
	public ArrayList<roomVo> list() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="select * from room";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<roomVo> list=new ArrayList<roomVo>();
			while(rs.next()) {
				roomVo vo=new roomVo();
				vo.setRoomSerialNum(rs.getInt("roomSerialNum"));
				vo.setTheaterName(rs.getString("theaterName"));
				vo.setRoomNum(rs.getInt("roomNum"));
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
}
