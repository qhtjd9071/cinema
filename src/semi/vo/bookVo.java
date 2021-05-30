package semi.vo;

import java.sql.Date;

public class bookVo {
	private int bookNum;
	private String booker;
	private int showNum;
	private Date bookDate;
	private int price;
	private int userNum;
	private String cancel;
	private int seatNum;
	private String seatArray;
	public bookVo() {}
	public bookVo(int bookNum, String booker, int showNum, Date bookDate, int price, int userNum, String cancel,
			int seatNum, String seatArray) {
		super();
		this.bookNum = bookNum;
		this.booker = booker;
		this.showNum = showNum;
		this.bookDate = bookDate;
		this.price = price;
		this.userNum = userNum;
		this.cancel = cancel;
		this.seatNum = seatNum;
		this.seatArray = seatArray;
	}
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public String getBooker() {
		return booker;
	}
	public void setBooker(String booker) {
		this.booker = booker;
	}
	public int getShowNum() {
		return showNum;
	}
	public void setShowNum(int showNum) {
		this.showNum = showNum;
	}
	public Date getBookDate() {
		return bookDate;
	}
	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		userNum = userNum;
	}
	public String getCancel() {
		return cancel;
	}
	public void setCancel(String cancel) {
		this.cancel = cancel;
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	public String getSeatArray() {
		return seatArray;
	}
	public void setSeatArray(String seatArray) {
		this.seatArray = seatArray;
	}
	
}
