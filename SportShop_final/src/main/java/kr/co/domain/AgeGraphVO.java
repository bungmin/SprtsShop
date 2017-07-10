package kr.co.domain;

import java.io.Serializable;

public class AgeGraphVO implements Serializable{
	
	private int count;
	private String age;
	
	public AgeGraphVO() {
		// TODO Auto-generated constructor stub
	}

	public AgeGraphVO(int count, String age) {
		super();
		this.count = count;
		this.age = age;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "AgeGraphVO [count=" + count + ", age=" + age + "]";
	}
	
	
	
	
	
		

}
