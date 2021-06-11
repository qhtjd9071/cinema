package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import semi.db.dbCon;
import semi.vo.eventVo;
import semi.vo.movieVo;

public class eventDao {
	private static eventDao instance=new eventDao();
	private eventDao() {}
	public static eventDao getInstance() {
		return instance;
	}
	
	public void insert(eventVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dbCon.getConnection();
			String sql="insert into event values(event_seq.nextval,?,?,sysdate,0,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getmainImage());
			pstmt.setString(4, vo.getdetailImage());
			pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}
	
	public void delete(int eventNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dbCon.getConnection();
			String sql="delete from event where eventNum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, eventNum);
			System.out.println("check");
			pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, null);
		}
	}
	
	public ArrayList<eventVo> list(int startRow,int endRow){
		String sql="select * from " + 
					"( " + 
					"  select e.*,rownum rnum from " + 
					"  (" + 
					"	  select * from event order by eventNum desc" + 
					"  ) e" + 
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
			ArrayList<eventVo> list=new ArrayList<>();
			while(rs.next()) {
				eventVo vo=new eventVo();
				vo.setEventNum(rs.getInt("eventNum"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setmainImage(rs.getString("mainImage"));
				vo.setdetailImage(rs.getString("detailImage"));
				vo.setWritedate(rs.getDate("writedate"));
				vo.setHit(rs.getInt("hit"));
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
			String sql="select NVL(count(*),0) from event";
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
