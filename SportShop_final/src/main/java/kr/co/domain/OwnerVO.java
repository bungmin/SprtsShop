package kr.co.domain;

public class OwnerVO {
	
	private int count;
	private String sex;
	private String age;
	private String state;
	private String id;
	private String o_category;
	
	public OwnerVO() {
		// TODO Auto-generated constructor stub
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getO_category() {
		return o_category;
	}

	public void setO_category(String o_category) {
		this.o_category = o_category;
	}

	@Override
	public String toString() {
		return "OwnerVO [count=" + count + ", sex=" + sex + ", age=" + age + ", state=" + state + ", id=" + id
				+ ", o_category=" + o_category + "]";
	}

	public OwnerVO(int count, String sex, String age, String state, String id, String o_category) {
		super();
		this.count = count;
		this.sex = sex;
		this.age = age;
		this.state = state;
		this.id = id;
		this.o_category = o_category;
	}

	
		
}
