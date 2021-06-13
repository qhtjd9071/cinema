package sys.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import semi.db.dbCon;
import semi.vo.customerVo;
import semi.vo.customerVo2;

public class customerDao {
	public int getMaxNum() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dbCon.getConnection();
			String sql="select NVL(max(customernum),0) mnum from customer";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			int mnum=rs.getInt("mnum");
			return mnum;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
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
		String sql="select NVL(count(customerNum),0) from customer";
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		rs.next();
		int mnum=rs.getInt(1);
		return mnum;
	}catch(SQLException se) {
		se.printStackTrace();
		return -1;
	}finally {
		dbCon.close(con, pstmt, rs);
		}
	}
	public int insert(customerVo vo) {
	Connection con=null;
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt2=null;
	try {
		con=dbCon.getConnection();
		int boardNum=getMaxNum()+1;
		int num=vo.getCustomerNum();
		int ref=vo.getRef();
		int lev=vo.getLev();
		int step=vo.getStep();
		if(num==0) {
		    ref=boardNum;
		}else {		   			
			String sql1="update customer set step=step+1 where ref=? and step>?";
			pstmt2=con.prepareStatement(sql1);
			pstmt2.setInt(1,ref);
			pstmt2.setInt(2,step);
			lev+=1;
			step+=1;
		}
		String sql="insert into customer values(?,?,?,?,?,?,sysdate,?)";
		pstmt1=con.prepareStatement(sql);
		pstmt1.setInt(1,boardNum);
		pstmt1.setString(2,vo.getTitle());
		pstmt1.setString(3,vo.getContent());
		pstmt1.setInt(4, ref);
		pstmt1.setInt(5, lev);
		pstmt1.setInt(6, step);
		pstmt1.setInt(7, vo.getWriter());
		return pstmt1.executeUpdate();
	}catch(SQLException se) {
		se.printStackTrace();
		return -1;
	}finally {
		dbCon.close(null, pstmt2, null);
		dbCon.close(con, pstmt1, null);
	}
}
public ArrayList<customerVo2> list(int startRow,int endRow){
	String sql="select * from " + 
			"(" + 
			"  select g.*,rownum rnum from" + 
			"  (" + 
			"	 select * from customer join users on customer.writer=users.userNum order by ref desc,step asc" + 
			"  ) g" + 
			") where rnum>=? and rnum<=?";
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try {
		con=dbCon.getConnection();
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, startRow);
		pstmt.setInt(2,endRow);
		rs=pstmt.executeQuery();
		ArrayList<customerVo2> list=new ArrayList<customerVo2>();
		while(rs.next()) {
			int num=rs.getInt("customerNum");
			String title=rs.getString("title");
			String content=rs.getString("content");
			int ref=rs.getInt("ref");
			int lev=rs.getInt("lev");
			int step=rs.getInt("step");
			String writer=rs.getString("id");
			Date writeDate=rs.getDate("writedate");
			customerVo2 vo=new customerVo2(num, title, content, ref, lev, step, writeDate, writer);
			list.add(vo);
		}
		return list;
	}catch(SQLException s) {
		s.printStackTrace();
		return null;
	}finally {
		dbCon.close(con, pstmt, rs);
	}	
}

public ArrayList<customerVo2> questionList(int startRow,int endRow,int userNum,ArrayList<Integer> cusList){
	String sql="select * from " + 
			"(" + 
			"  select g.*,rownum rnum from" + 
			"  (" + 
			"	 select * from customer join users on customer.writer=users.userNum order by ref desc,step asc" + 
			"  ) g" + 
			") where rnum>=? and rnum<=? and writer=?";
		for(int i=0;i<cusList.size();i++) {
			sql+=" or ref=?";
		}
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try {
		con=dbCon.getConnection();
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, startRow);
		pstmt.setInt(2,endRow);
		pstmt.setInt(3,userNum);
		for(int i=0;i<cusList.size();i++) {
			pstmt.setInt(i+4, cusList.get(i));
		}
		rs=pstmt.executeQuery();
		ArrayList<customerVo2> list=new ArrayList<customerVo2>();
		while(rs.next()) {
			int num=rs.getInt("customerNum");
			String title=rs.getString("title");
			String content=rs.getString("content");
			int ref=rs.getInt("ref");
			int lev=rs.getInt("lev");
			int step=rs.getInt("step");
			String writer=rs.getString("id");
			Date writeDate=rs.getDate("writedate");
			customerVo2 vo=new customerVo2(num, title, content, ref, lev, step, writeDate, writer);
			list.add(vo);
		}
		return list;
	}catch(SQLException s) {
		s.printStackTrace();
		return null;
	}finally {
		dbCon.close(con, pstmt, rs);
	}	
}
public customerVo2 detail(int num) {
	String sql="select * from customer join users on customer.writer=users.userNum where customerNum=?";
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try {
		con=dbCon.getConnection();
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, num);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			String title=rs.getString("title");
			String content=rs.getString("content");
			int ref=rs.getInt("ref");
			int lev=rs.getInt("lev");
			int step=rs.getInt("step");
			String writer=rs.getString("id");
			customerVo2 vo=new customerVo2(num, title, content, ref, lev, step, null, writer);
			return vo;
		}
		return null;
	}catch(SQLException s) {
		s.printStackTrace();
		return null;
	}finally {
		dbCon.close(con, pstmt, rs);
	}	
}

public int update(customerVo vo) {
	String sql="update customer set writer=?,title=?,content=? where customerNum=?";
	Connection con=null;
	PreparedStatement pstmt=null;
	try {
		con=dbCon.getConnection();
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,vo.getWriter());
		pstmt.setString(2,vo.getTitle());
		pstmt.setString(3,vo.getContent());
		pstmt.setInt(4,vo.getCustomerNum());
		int n=pstmt.executeUpdate();
		return n;
	}catch(SQLException s) {
		s.printStackTrace();
		return -1;
	}finally {
		dbCon.close(con,pstmt,null);
	}
}

public customerVo getinfo(int num) {
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try {
		con=dbCon.getConnection();
		String sql="select * from customer where customerNum=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,num);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			customerVo vo=new customerVo(
					rs.getInt("customerNum"), 
					rs.getString("title"), 
					rs.getString("content"), 
					rs.getInt("ref"), 
					rs.getInt("lev"), 
					rs.getInt("step"), 
					rs.getDate("writedate"), 
					rs.getInt("writer"));							
			return vo;
		}
		return null;
	}catch(SQLException s) {
		s.printStackTrace();
		return null;
	}finally {
		dbCon.close(con, pstmt,rs);
	}
}

public int delete(int num){
	String sql="delete from customer where customerNum=?";
	Connection con=null;
	PreparedStatement pstmt=null;
	try {
		con=dbCon.getConnection();
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,num);
		int n=pstmt.executeUpdate();
		return n;
	}catch(SQLException s) {
		s.printStackTrace();
		return -1;
	}finally {
		dbCon.close(con,pstmt,null);
	}
}
public ArrayList<Integer> getCustomerNum(int userNum){
	String sql="select customerNum from customer where writer=?";
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try {
		con=dbCon.getConnection();
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,userNum);
		rs=pstmt.executeQuery();
		ArrayList<Integer> list=new ArrayList<Integer>();
		while(rs.next()) {
			int customerNum=rs.getInt("customerNum");
			list.add(customerNum);
		}
		return list;
	}catch(SQLException s) {
		s.printStackTrace();
		return null;
	}finally {
		dbCon.close(con,pstmt,rs);
	}
}
}
	
