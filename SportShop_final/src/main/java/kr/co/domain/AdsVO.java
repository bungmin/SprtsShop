package kr.co.domain;

import java.io.Serializable;

public class AdsVO implements Serializable{
	
	private int ano;
	private String id;
	private String position;
	private String a_title;
	private String a_img_link;
	private String a_img_name;
	private String regdate;
	private int readcnt;	
	private String updatedate;	
	private String register;
	
	
	
	public AdsVO() {
		// TODO Auto-generated constructor stub
	}
	
	

	
	public String getRegister() {
		return register;
	}




	public void setRegister(String register) {
		this.register = register;
	}

	public AdsVO(int ano, String id, String position, String a_title, String a_img_link, String a_img_name,
			String regdate, int readcnt, String updatedate, String register) {
		super();
		this.ano = ano;
		this.id = id;
		this.position = position;
		this.a_title = a_title;
		this.a_img_link = a_img_link;
		this.a_img_name = a_img_name;
		this.regdate = regdate;
		this.readcnt = readcnt;
		this.updatedate = updatedate;
		this.register = register;
	}




	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
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

	public String getA_title() {
		return a_title;
	}

	public void setA_title(String a_title) {
		this.a_title = a_title;
	}
	
	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}


	public String getA_img_link() {
		return a_img_link;
	}

	public void setA_img_link(String a_img_link) {
		this.a_img_link = a_img_link;
	}

	public String getA_img_name() {
		return a_img_name;
	}

	public void setA_img_name(String a_img_name) {
		this.a_img_name = a_img_name;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ano;
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
		AdsVO other = (AdsVO) obj;
		if (ano != other.ano)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AdsVO [ano=" + ano + ", id=" + id + ", position=" + position + ", a_title=" + a_title + ", a_img_link="
				+ a_img_link + ", a_img_name=" + a_img_name + ", regdate=" + regdate + ", updatedate=" + updatedate
				+ ", register=" + register + "]";
	}
	
	
	
	
}
