package semi.vo;

import java.sql.Date;

public class customerVo {
	private int customerNum;
	private String title;
	private String content;
	private int ref;
	private int lev;
	private int step;
	private Date writedate;
	private int writer;
	public customerVo() {}
	public customerVo(int customerNum, String title, String content, int ref, int lev, int step, Date writedate,
			int writer) {
		super();
		this.customerNum = customerNum;
		this.title = title;
		this.content = content;
		this.ref = ref;
		this.lev = lev;
		this.step = step;
		this.writedate = writedate;
		this.writer = writer;
	}
	public int getCustomerNum() {
		return customerNum;
	}
	public void setCustomerNum(int customerNum) {
		this.customerNum = customerNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getLev() {
		return lev;
	}
	public void setLev(int lev) {
		this.lev = lev;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	public int getWriter() {
		return writer;
	}
	public void setWriter(int writer) {
		this.writer = writer;
	}
	
}
