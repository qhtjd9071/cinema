package semi.vo;

public class payVo {
	private String payNum;
	private int bookNum;
	private String method;
	private int count;
	private int tot;
	public payVo() {}
	public payVo(String payNum, int bookNum, String method, int count, int tot) {
		super();
		this.payNum = payNum;
		this.bookNum = bookNum;
		this.method = method;
		this.count = count;
		this.tot = tot;
	}
	public String getPayNum() {
		return payNum;
	}
	public void setPayNum(String payNum) {
		this.payNum = payNum;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	
}
