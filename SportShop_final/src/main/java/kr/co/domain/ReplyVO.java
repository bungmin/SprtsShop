package kr.co.domain;

import java.io.Serializable;

public class ReplyVO implements Serializable {
	/**
	 * 
	 */
	
	private int rno;
	private int bno;
	private String replyText;
	private String id;
	private String regDate;
	private String updateDate;
	private int rnum;

	public ReplyVO() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "ReplyVO [rno=" + rno + ", bno=" + bno + ", replyText=" + replyText + ", id=" + id + ", regDate="
				+ regDate + ", updateDate=" + updateDate + ", rnum=" + rnum + "]";
	}

	public ReplyVO(int rno, int bno, String replyText, String id, String regDate, String updateDate, int rnum) {
		super();
		this.rno = rno;
		this.bno = bno;
		this.replyText = replyText;
		this.id = id;
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.rnum = rnum;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getReplyText() {
		return replyText;
	}

	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bno;
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
		ReplyVO other = (ReplyVO) obj;
		if (bno != other.bno)
			return false;
		return true;
	}

	
}
