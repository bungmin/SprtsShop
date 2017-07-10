package kr.co.domain;

import java.io.Serializable;

public class StateVO implements Serializable{
	
	private int count;
	private String state;
	
	public StateVO() {
		// TODO Auto-generated constructor stub
	}

	public StateVO(int count, String state) {
		super();
		this.count = count;
		this.state = state;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "StateVO [count=" + count + ", state=" + state + "]";
	}
	
	
	
	

			

}
