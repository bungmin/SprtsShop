package kr.co.domain;

public class IdFindDTO {
	private String name;
	private String email;
	private String birthday;
	
	public IdFindDTO() {
		// TODO Auto-generated constructor stub
	}

	public IdFindDTO(String name, String email, String birthday) {
		super();
		this.name = name;
		this.email = email;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "IdFindDTO [name=" + name + ", email=" + email + ", birthday=" + birthday + "]";
	}	
}
