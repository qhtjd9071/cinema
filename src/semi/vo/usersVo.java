package semi.vo;

public class usersVo {
	private int userNum;
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String year;
	private String phone;
	private String delUser;
	public usersVo() {}
	public usersVo(int userNum, String id, String pwd, String name, String email, String year, String phone,
			String delUser) {
		super();
		this.userNum = userNum;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.year = year;
		this.phone = phone;
		this.delUser = delUser;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDelUser() {
		return delUser;
	}
	public void setDelUser(String delUser) {
		this.delUser = delUser;
	}
	
}
