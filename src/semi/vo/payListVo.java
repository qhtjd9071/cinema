package semi.vo;

import java.sql.Date;

public class payListVo {
	private String payNum;
	private int intNum;
	private String method;
	private int tot;
	private Date payDate;
	private String movieTitle;
	private String seatNumArr;
	private String theaterName;
	private String roomNum;
	private String beginTime;
	public payListVo() {}
	public payListVo(String payNum, int intNum, String method, int tot, Date payDate, String movieTitle,
			String seatNumArr, String theaterName, String roomNum, String beginTime) {
		super();
		this.payNum = payNum;
		this.intNum = intNum;
		this.method = method;
		this.tot = tot;
		this.payDate = payDate;
		this.movieTitle = movieTitle;
		this.seatNumArr = seatNumArr;
		this.theaterName = theaterName;
		this.roomNum = roomNum;
		this.beginTime = beginTime;
	}
	public String getPayNum() {
		return payNum;
	}
	public void setPayNum(String payNum) {
		this.payNum = payNum;
	}
	public int getIntNum() {
		return intNum;
	}
	public void setIntNum(int intNum) {
		this.intNum = intNum;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getSeatNumArr() {
		return seatNumArr;
	}
	public void setSeatNumArr(String seatNumArr) {
		this.seatNumArr = seatNumArr;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	
}
