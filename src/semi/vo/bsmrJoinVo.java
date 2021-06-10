package semi.vo;

public class bsmrJoinVo {
	private String movieTitle;
	private int seatNum;
	private int userNum;
	private String beginTime;
	private String theaterName;
	private int roomNum;
	public bsmrJoinVo() {}
	public bsmrJoinVo(String movieTitle, int seatNum, int userNum, String beginTime, String theaterName, int roomNum) {
		super();
		this.movieTitle = movieTitle;
		this.seatNum = seatNum;
		this.userNum = userNum;
		this.beginTime = beginTime;
		this.theaterName = theaterName;
		this.roomNum = roomNum;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	
	
}
