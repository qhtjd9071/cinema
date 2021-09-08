package semi.vo;

import java.sql.Date;

public class eventVo {
	private int eventNum;
	private String title;
	private String content;
	private Date writedate;
	private int hit;
	private String mainImage;
	private String detailImage;
	public eventVo() {}
	public eventVo(int eventNum, String title, String content, Date writedate, int hit, String mainImage,String detailImage) {
		super();
		this.eventNum = eventNum;
		this.title = title;
		this.content = content;
		this.writedate = writedate;
		this.hit = hit;
		this.mainImage = mainImage;
		this.detailImage = detailImage;
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
	public String getmainImage() {
		return mainImage;
	}
	public void setmainImage(String mainImage) {
		this.mainImage = mainImage;
	}
	public String getdetailImage() {
		return detailImage;
	}
	public void setdetailImage(String detailImage) {
		this.detailImage = detailImage;
	}
}
