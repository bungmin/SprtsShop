package kr.co.domain;

import java.io.Serializable;

public class ReviewVO implements Serializable {
	
	private int revno;
	private int pno;
	private String id;
    private String content;
    private String regdate;
    private String updatedate;
    
    public ReviewVO() {
		// TODO Auto-generated constructor stub
	}

	public ReviewVO(int revno, int pno, String id, String content, String regdate, String updatedate) {
		super();
		this.revno = revno;
		this.pno = pno;
		this.id = id;
		this.content = content;
		this.regdate = regdate;
		this.updatedate = updatedate;
	}

	public int getRevno() {
		return revno;
	}

	public void setRevno(int revno) {
		this.revno = revno;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	@Override
	public String toString() {
		return "ReviewVO [revno=" + revno + ", pno=" + pno + ", id=" + id + ", content=" + content + ", regdate="
				+ regdate + ", updatedate=" + updatedate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + revno;
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
		ReviewVO other = (ReviewVO) obj;
		if (revno != other.revno)
			return false;
		return true;
	}
    
    
	
    
}
