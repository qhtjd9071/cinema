package semi.vo;

import java.sql.Date;

public class movieCommentsVo {
	private int movieCommentsNum;
	private String id;
	private String content;
	private int star;
	private Date writedate;
	private int UserNum;
	private int movieNum;
	public movieCommentsVo() {}
	public movieCommentsVo(int movieCommentsNum, String id, String content, int star, Date writedate, int userNum,
			int movieNum) {
		super();
		this.movieCommentsNum = movieCommentsNum;
		this.id = id;
		this.content = content;
		this.star = star;
		this.writedate = writedate;
		UserNum = userNum;
		this.movieNum = movieNum;
	}
	public int getMovieCommentsNum() {
		return movieCommentsNum;
	}
	public void setMovieCommentsNum(int movieCommentsNum) {
		this.movieCommentsNum = movieCommentsNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	public int getUserNum() {
		return UserNum;
	}
	public void setUserNum(int userNum) {
		UserNum = userNum;
	}
	public int getMovieNum() {
		return movieNum;
	}
	public void setMovieNum(int movieNum) {
		this.movieNum = movieNum;
	}
	
}
