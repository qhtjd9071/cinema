package semi.vo;
/*
1. 지역정보
2. 영화관정보
3. 영화정보
4. 날짜선택
5. 상영관정보 & 상영정보
 * 
 */

import java.sql.Date;

public class showinfoVo {
	private int movieNum;
	private int showNum;
	private int roomNum;
	private int roomserialNum;
	private int sitCount;
	private Date begintime;
	private String location;
	private String theaterName;
	
	public showinfoVo() {
		
	}

	
	public showinfoVo(int movieNum, int showNum, int roomNum, int roomserialNum, int sitCount, Date begintime,
			String location, String theaterName) {
		super();
		this.movieNum = movieNum;
		this.showNum = showNum;
		this.roomNum = roomNum;
		this.roomserialNum = roomserialNum;
		this.sitCount = sitCount;
		this.begintime = begintime;
		this.location = location;
		this.theaterName = theaterName;
	}


	public int getMovieNum() {
		return movieNum;
	}

	public void setMovieNum(int movieNum) {
		this.movieNum = movieNum;
	}

	public int getShowNum() {
		return showNum;
	}

	public void setShowNum(int showNum) {
		this.showNum = showNum;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public int getRoomserialNum() {
		return roomserialNum;
	}

	public void setRoomserialNum(int roomserialNum) {
		this.roomserialNum = roomserialNum;
	}

	public int getSitCount() {
		return sitCount;
	}

	public void setSitCount(int sitCount) {
		this.sitCount = sitCount;
	}

	public Date getBegintime() {
		return begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
}
