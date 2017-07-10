package kr.co.domain;

import java.io.Serializable;

public class VisitVO implements Serializable{
	private String visit_date;
	private String id;
	private int count;
	
	
	
	public VisitVO(String visit_date, String id, int count) {
		super();
		this.visit_date = visit_date;
		this.id = id;
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public VisitVO(String visit_date, String id) {
		super();
		this.visit_date = visit_date;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public VisitVO() {
		// TODO Auto-generated constructor stub
	}
	
	public VisitVO(String visit_date) {
		super();
		this.visit_date = visit_date;
	}

	@Override
	public String toString() {
		return "VisitVO [visit_date=" + visit_date + ", id=" + id + ", count=" + count + "]";
	}

	public String getVisit_date() {
		return visit_date;
	}

	public void setVisit_date(String visit_date) {
		this.visit_date = visit_date;
	}/*

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}*/
	
}
