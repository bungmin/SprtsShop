package kr.co.domain;

import java.io.Serializable;

public class UserInfoVO implements Serializable {
	
	private String id;
	private int cash;
	private int mileage;
	private int usedMileage;
	
	
	
	public UserInfoVO(String id, int cash, int mileage, int usedMileage) {
		super();
		this.id = id;
		this.cash = cash;
		this.mileage = mileage;
		this.usedMileage = usedMileage;
	}

	public int getUsedMileage() {
		return usedMileage;
	}

	public void setUsedMileage(int usedMileage) {
		this.usedMileage = usedMileage;
	}

	public UserInfoVO() {
		// TODO Auto-generated constructor stub
	}

	public UserInfoVO(String id, int cash, int mileage) {
		super();
		this.id = id;
		this.cash = cash;
		this.mileage = mileage;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	@Override
	public String toString() {
		return "UserInfoVO [id=" + id + ", cash=" + cash + ", mileage=" + mileage + ", usedMileage=" + usedMileage
				+ "]";
	}
	
}
