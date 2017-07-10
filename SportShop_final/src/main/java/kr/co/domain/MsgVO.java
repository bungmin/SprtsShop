package kr.co.domain;

import java.io.Serializable;

public class MsgVO implements Serializable {

	private int mno;
	private String id;
	private String m_category;
	private String title;
	private String content;
	private String regdate;
	private String replycheck;
	
	

	public MsgVO(int mno, String id, String m_category, String title, String content, String regdate,
			String replycheck) {
		super();
		this.mno = mno;
		this.id = id;
		this.m_category = m_category;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.replycheck = replycheck;
	}

	public String getReplycheck() {
		return replycheck;
	}

	public void setReplycheck(String replycheck) {
		this.replycheck = replycheck;
	}

	public MsgVO() {
		// TODO Auto-generated constructor stub
	}

	public MsgVO(int mno, String id, String m_category, String title, String content, String regdate) {
		super();
		this.mno = mno;
		this.id = id;
		this.m_category = m_category;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getM_category() {
		return m_category;
	}

	public void setM_category(String m_category) {
		this.m_category = m_category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	@Override
	public String toString() {
		return "MsgVO [mno=" + mno + ", id=" + id + ", m_category=" + m_category + ", title=" + title + ", content="
				+ content + ", regdate=" + regdate + ", replycheck=" + replycheck + "]";
	}
}
