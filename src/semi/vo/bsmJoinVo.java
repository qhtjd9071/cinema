package semi.vo;

public class bsmJoinVo {
	private String movieTitle;
	private int seatNum;
	private int userNum;
	public bsmJoinVo() {}
	public bsmJoinVo(String movieTitle, int seatNum, int userNum) {
		super();
		this.movieTitle = movieTitle;
		this.seatNum = seatNum;
		this.userNum = userNum;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	
}
