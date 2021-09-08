package semi.vo;

public class roomVo {
	private int roomSerialNum;
	private String theaterName;
	private int sitCount;
	private String location;
	private int roomNum;
	public roomVo() {}
	public roomVo(int roomSerialNum, String theaterName, int sitCount, String location, int roomNum) {
		super();
		this.roomSerialNum = roomSerialNum;
		this.theaterName = theaterName;
		this.sitCount = sitCount;
		this.location = location;
		this.roomNum = roomNum;
	}
	public int getRoomSerialNum() {
		return roomSerialNum;
	}
	public void setRoomSerialNum(int roomSerialNum) {
		this.roomSerialNum = roomSerialNum;
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
