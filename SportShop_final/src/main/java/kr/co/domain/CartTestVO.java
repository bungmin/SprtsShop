package kr.co.domain;

public class CartTestVO {
	private int cno;
	private int pno;
	private String id;
	private String p_category;
	private String p_title;
	private String p_name;
	private String p_brand_name;
	private String p_size;	
	private int p_ori_price;
	private int p_price;
	private int p_discount_rate;
	private String p_img_1;
	private String p_img_2;
	private int p_ori_amount;
	private int p_amount;
	private String p_made;
	private String p_content;
	private int p_goodcnt;
	private int p_viewcnt;
	private String regdate;
	private String updatedate;
	
	private int count;
	
	
	public int getCount() {
		return count;
	}




	public void setCount(int count) {
		this.count = count;
	}




	public CartTestVO(int cno, int pno, String id, String p_category, String p_title, String p_name,
			String p_brand_name, String p_size, int p_ori_price, int p_price, int p_discount_rate, String p_img_1,
			String p_img_2, int p_ori_amount, int p_amount, String p_made, String p_content, int p_goodcnt,
			int p_viewcnt, String regdate, String updatedate, int count) {
		super();
		this.cno = cno;
		this.pno = pno;
		this.id = id;
		this.p_category = p_category;
		this.p_title = p_title;
		this.p_name = p_name;
		this.p_brand_name = p_brand_name;
		this.p_size = p_size;
		this.p_ori_price = p_ori_price;
		this.p_price = p_price;
		this.p_discount_rate = p_discount_rate;
		this.p_img_1 = p_img_1;
		this.p_img_2 = p_img_2;
		this.p_ori_amount = p_ori_amount;
		this.p_amount = p_amount;
		this.p_made = p_made;
		this.p_content = p_content;
		this.p_goodcnt = p_goodcnt;
		this.p_viewcnt = p_viewcnt;
		this.regdate = regdate;
		this.updatedate = updatedate;
		this.count = count;
	}




	public CartTestVO() {
		// TODO Auto-generated constructor stub
	}
	
	


	public CartTestVO(int cno, int pno, String id, String p_category, String p_title, String p_name,
			String p_brand_name, String p_size, int p_ori_price, int p_price, int p_discount_rate, String p_img_1,
			String p_img_2, int p_ori_amount, int p_amount, String p_made, String p_content, int p_goodcnt,
			int p_viewcnt, String regdate, String updatedate) {
		super();
		this.cno = cno;
		this.pno = pno;
		this.id = id;
		this.p_category = p_category;
		this.p_title = p_title;
		this.p_name = p_name;
		this.p_brand_name = p_brand_name;
		this.p_size = p_size;
		this.p_ori_price = p_ori_price;
		this.p_price = p_price;
		this.p_discount_rate = p_discount_rate;
		this.p_img_1 = p_img_1;
		this.p_img_2 = p_img_2;
		this.p_ori_amount = p_ori_amount;
		this.p_amount = p_amount;
		this.p_made = p_made;
		this.p_content = p_content;
		this.p_goodcnt = p_goodcnt;
		this.p_viewcnt = p_viewcnt;
		this.regdate = regdate;
		this.updatedate = updatedate;
	}




	@Override
	public String toString() {
		return "CartTestVO [cno=" + cno + ", pno=" + pno + ", id=" + id + ", p_category=" + p_category + ", p_title="
				+ p_title + ", p_name=" + p_name + ", p_brand_name=" + p_brand_name + ", p_size=" + p_size
				+ ", p_ori_price=" + p_ori_price + ", p_price=" + p_price + ", p_discount_rate=" + p_discount_rate
				+ ", p_img_1=" + p_img_1 + ", p_img_2=" + p_img_2 + ", p_ori_amount=" + p_ori_amount + ", p_amount="
				+ p_amount + ", p_made=" + p_made + ", p_content=" + p_content + ", p_goodcnt=" + p_goodcnt
				+ ", p_viewcnt=" + p_viewcnt + ", regdate=" + regdate + ", updatedate=" + updatedate + ", count="
				+ count + "]";
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

	

	public String getP_category() {
		return p_category;
	}

	public void setP_category(String p_category) {
		this.p_category = p_category;
	}

	public String getP_title() {
		return p_title;
	}

	public void setP_title(String p_title) {
		this.p_title = p_title;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_brand_name() {
		return p_brand_name;
	}

	public void setP_brand_name(String p_brand_name) {
		this.p_brand_name = p_brand_name;
	}

	public String getP_size() {
		return p_size;
	}

	public void setP_size(String p_size) {
		this.p_size = p_size;
	}

	public int getP_ori_price() {
		return p_ori_price;
	}

	public void setP_ori_price(int p_ori_price) {
		this.p_ori_price = p_ori_price;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public int getP_discount_rate() {
		return p_discount_rate;
	}

	public void setP_discount_rate(int p_discount_rate) {
		this.p_discount_rate = p_discount_rate;
	}

	public String getP_img_1() {
		return p_img_1;
	}

	public void setP_img_1(String p_img_1) {
		this.p_img_1 = p_img_1;
	}

	public String getP_img_2() {
		return p_img_2;
	}

	public void setP_img_2(String p_img_2) {
		this.p_img_2 = p_img_2;
	}

	public int getP_ori_amount() {
		return p_ori_amount;
	}

	public void setP_ori_amount(int p_ori_amount) {
		this.p_ori_amount = p_ori_amount;
	}

	public int getP_amount() {
		return p_amount;
	}

	public void setP_amount(int p_amount) {
		this.p_amount = p_amount;
	}

	public String getP_made() {
		return p_made;
	}

	public void setP_made(String p_made) {
		this.p_made = p_made;
	}

	public String getP_content() {
		return p_content;
	}

	public void setP_content(String p_content) {
		this.p_content = p_content;
	}

	public int getP_goodcnt() {
		return p_goodcnt;
	}

	public void setP_goodcnt(int p_goodcnt) {
		this.p_goodcnt = p_goodcnt;
	}

	public int getP_viewcnt() {
		return p_viewcnt;
	}

	public void setP_viewcnt(int p_viewcnt) {
		this.p_viewcnt = p_viewcnt;
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
	

}
