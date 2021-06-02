package semi.vo;

public class integrationVo {
	private int intNum;
	private String bookNumArr;
	public integrationVo() {}
	public integrationVo(int intNum, String bookNumArr) {
		super();
		this.intNum = intNum;
		this.bookNumArr = bookNumArr;
	}
	public int getIntNum() {
		return intNum;
	}
	public void setIntNum(int intNum) {
		this.intNum = intNum;
	}
	public String getBookNumArr() {
		return bookNumArr;
	}
	public void setBookNumArr(String bookNumArr) {
		this.bookNumArr = bookNumArr;
	}
	
}
