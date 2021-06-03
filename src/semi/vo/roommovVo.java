package semi.vo;

public class roommovVo {
	private String movieTitle;
	private int movieNum;
	private int roomserialNum;
	private String theaterName;
	
	public roommovVo() {
		
	}

	public roommovVo(String movieTitle, int movieNum, int roomserialNum, String theaterName) {
		super();
		this.movieTitle = movieTitle;
		this.movieNum = movieNum;
		this.roomserialNum = roomserialNum;
		this.theaterName = theaterName;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public int getMovieNum() {
		return movieNum;
	}

	public void setMovieNum(int movieNum) {
		this.movieNum = movieNum;
	}

	public int getRoomserialNum() {
		return roomserialNum;
	}

	public void setRoomserialNum(int roomserialNum) {
		this.roomserialNum = roomserialNum;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
}
