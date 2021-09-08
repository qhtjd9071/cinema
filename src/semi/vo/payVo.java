package semi.vo;

import java.sql.Date;

public class payVo {
	private String payNum;
	private int intNum;
	private String method;
	private int tot;
	private Date payDate;
	public payVo() {}
	public payVo(String payNum, int intNum, String method, int tot, Date payDate) {
		super();
		this.payNum = payNum;
		this.intNum = intNum;
		this.method = method;
		this.tot = tot;
		this.payDate = payDate;
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
	
	
}
