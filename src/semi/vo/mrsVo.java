package semi.vo;

import java.sql.Date;

public class mrsVo {
	private int showNum;
	private String movieTitle;
	private String theaterName;
	private String beginTime;
	private String endTime;
	private int roomNum;
	private int price;
	public mrsVo() {}
	public mrsVo(int showNum, String movieTitle, String theaterName, String beginTime, String endTime, int roomNum,
			int price) {
		super();
		this.showNum = showNum;
		this.movieTitle = movieTitle;
		this.theaterName = theaterName;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.roomNum = roomNum;
		this.price = price;
	}
	public int getShowNum() {
		return showNum;
	}
	public void setShowNum(int showNum) {
		this.showNum = showNum;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
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
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
