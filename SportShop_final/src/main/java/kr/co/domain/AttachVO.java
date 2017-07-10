package kr.co.domain;

import java.io.Serializable;

public class AttachVO implements Serializable{
	
	private String fullname;
	private int bno;
	private String regdate;
	
	public AttachVO() {
		// TODO Auto-generated constructor stub
	}

	public AttachVO(String fullname, int bno, String regdate) {
		super();
		this.fullname = fullname;
		this.bno = bno;
		this.regdate = regdate;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "AttachVO [fullname=" + fullname + ", bno=" + bno + ", regdate=" + regdate + "]";
	}
	
	
	

}
