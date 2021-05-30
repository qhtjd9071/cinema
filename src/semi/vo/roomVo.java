package semi.vo;

public class roomVo {
	private int roomserialNum;
	private String theaterName;
	private int sitCount;
	private String location;
	private int roomNum;
	public roomVo() {}
	public roomVo(int roomserialNum, String theaterName, int sitCount, String location, int roomNum) {
		super();
		this.roomserialNum = roomserialNum;
		this.theaterName = theaterName;
		this.sitCount = sitCount;
		this.location = location;
		this.roomNum = roomNum;
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
	public int getSitCount() {
		return sitCount;
	}
	public void setSitCount(int sitCount) {
		this.sitCount = sitCount;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	
}
