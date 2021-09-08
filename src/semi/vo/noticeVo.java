package semi.vo;

import java.sql.Date;

public class noticeVo {
	private int noticeNum;
	private String title;
	private String content;
	private Date writedate;
	private int hit;
	public noticeVo() {}
	public noticeVo(int noticeNum, String title, String content, Date writedate, int hit) {
		super();
		this.noticeNum = noticeNum;
		this.title = title;
		this.content = content;
		this.writedate = writedate;
		this.hit = hit;
	}
	public int getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
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
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
}
