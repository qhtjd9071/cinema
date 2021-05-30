package semi.vo;

import java.sql.Date;

public class commentsVo {
	private int commentNum;
	private String content;
	private Date writedate;
	private int noticeNum;
	private String writer;
	public commentsVo() {}
	public commentsVo(int commentNum, String content, Date writedate, int noticeNum, String writer) {
		super();
		this.commentNum = commentNum;
		this.content = content;
		this.writedate = writedate;
		this.noticeNum = noticeNum;
		this.writer = writer;
	}
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
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
	public int getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
}
