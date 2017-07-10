package kr.co.domain;

public class CartVO {
	private int cno;
	private int pno;
	private String id;
	private int count;
	
	
	public CartVO(int cno, int pno, String id, int count) {
		super();
		this.cno = cno;
		this.pno = pno;
		this.id = id;
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public CartVO() {
		// TODO Auto-generated constructor stub
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
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

	public CartVO(int cno, int pno, String id) {
		super();
		this.cno = cno;
		this.pno = pno;
		this.id = id;
	}

	@Override
	public String toString() {
		return "CartVO [cno=" + cno + ", pno=" + pno + ", id=" + id + ", count=" + count + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		CartVO other = (CartVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
