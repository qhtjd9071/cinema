package semi.vo;

import java.sql.Date;

public class showVo {
	private int showNum;
	private int movieNum;
	private Date beginTime;
	private Date endTime;
	private Date showDate;
	private int roomserialNum;
	public showVo() {}
	public showVo(int showNum, int movieNum, Date beginTime, Date endTime, Date showDate, int roomserialNum) {
		super();
		this.showNum = showNum;
		this.movieNum = movieNum;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.showDate = showDate;
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
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getShowDate() {
		return showDate;
	}
	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}
	public int getRoomserialNum() {
		return roomserialNum;
	}
	public void setRoomserialNum(int roomserialNum) {
		this.roomserialNum = roomserialNum;
	}
	
}
