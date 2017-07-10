package kr.co.domain;

public class DateVO {
	private String date1;
	private String date2;
	private String id;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DateVO(String date1, String date2, String id) {
		super();
		this.date1 = date1;
		this.date2 = date2;
		this.id = id;
	}

	public DateVO() {
		// TODO Auto-generated constructor stub
	}

	public DateVO(String date1, String date2) {
		super();
		this.date1 = date1;
		this.date2 = date2;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	@Override
	public String toString() {
		return "DateVO [date1=" + date1 + ", date2=" + date2 + ", id=" + id + "]";
	}
	
}