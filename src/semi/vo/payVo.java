package semi.vo;

import java.sql.Date;

public class payVo {
	private int payNum;
	private int userNum;
	private int bookNum;
	private String method;
	private int tot;
	private Date payDate;
	public payVo() {}
	public payVo(int payNum, int userNum, int bookNum, String method, int tot, Date payDate) {
		super();
		this.payNum = payNum;
		this.userNum = userNum;
		this.bookNum = bookNum;
		this.method = method;
		this.tot = tot;
		this.payDate = payDate;
	}
	public int getPayNum() {
		return payNum;
	}
	public void setPayNum(int payNum) {
		this.payNum = payNum;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
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
	
}
