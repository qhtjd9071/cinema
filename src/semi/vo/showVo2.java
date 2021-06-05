package semi.vo;

import java.sql.Date;

public class showVo2 {
	private int showNum;
	private int movieNum;
	private String beginTime;
	private String endTime;
	private int roomserialNum;
	public showVo2() {}
	public showVo2(int showNum, int movieNum, String beginTime, String endTime, int roomserialNum) {
		super();
		this.showNum = showNum;
		this.movieNum = movieNum;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.roomserialNum = roomserialNum;
	}
	public int getShowNum() {
		return showNum;
	}
	public void setShowNum(int showNum) {
		this.showNum = showNum;
	}
	public int getMovieNum() {
		return movieNum;
	}
	public void setMovieNum(int movieNum) {
		this.movieNum = movieNum;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getRoomserialNum() {
		return roomserialNum;
	}
	public void setRoomserialNum(int roomserialNum) {
		this.roomserialNum = roomserialNum;
	}
	
}
