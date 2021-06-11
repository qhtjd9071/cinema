package semi.vo;

import java.sql.Date;

public class eventVo {
	private int eventNum;
	private String title;
	private String content;
	private Date writedate;
	private int hit;
	private String image;
	public eventVo() {}
	public eventVo(int eventNum, String title, String content, Date writedate, int hit, String image) {
		super();
		this.eventNum = eventNum;
		this.title = title;
		this.content = content;
		this.writedate = writedate;
		this.hit = hit;
		this.image = image;
	}
	public int getEventNum() {
		return eventNum;
	}
	public void setEventNum(int eventNum) {
		this.eventNum = eventNum;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
