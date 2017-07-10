package kr.co.domain;

import java.io.Serializable;

public class UserVO implements Serializable {
	private String id;
	private String position;
	private String pw;
	private String name;
	private String addr1;
	private String addr2;
	private String state;
	private String email;
	private String birthday;
	private String phone;
	private String gender;
	private String regdate;
	private String updatedate;
	private int mCount;
	private int wCount;
	
	public UserVO() {
		// TODO Auto-generated constructor stub
	}

	public UserVO(String id, String position, String pw, String name, String addr1, String addr2, String state,
			String email, String birthday, String phone, String gender, String regdate, String updatedate, int mCount,
			int wCount) {
		super();
		this.id = id;
		this.position = position;
		this.pw = pw;
		this.name = name;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.state = state;
		this.email = email;
		this.birthday = birthday;
		this.phone = phone;
		this.gender = gender;
		this.regdate = regdate;
		this.updatedate = updatedate;
		this.mCount = mCount;
		this.wCount = wCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public int getmCount() {
		return mCount;
	}

	public void setmCount(int mCount) {
		this.mCount = mCount;
	}

	public int getwCount() {
		return wCount;
	}

	public void setwCount(int wCount) {
		this.wCount = wCount;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", position=" + position + ", pw=" + pw + ", name=" + name + ", addr1=" + addr1
				+ ", addr2=" + addr2 + ", state=" + state + ", email=" + email + ", birthday=" + birthday + ", phone="
				+ phone + ", gender=" + gender + ", regdate=" + regdate + ", updatedate=" + updatedate + ", mCount="
				+ mCount + ", wCount=" + wCount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserVO other = (UserVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}