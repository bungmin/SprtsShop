package kr.co.domain;

public class OrderInfoVO {
	
	
	private int ono;
	private int pno;
	private String id;
	private String o_category;
	private String o_title;
	private String o_name;
	private String o_brand_name;
	private String o_size;
	private String o_img_1;
	private int o_amount;
	private String o_date;
	private int o_price;
	private int o_mileage_gain;
	private int o_mileage_usage;
	private int o_final_price;
	//----------------------------2차 삽입 내용들 update로 집어넣음--------------------------------------------
	private String u_name;
	private String u_addr1;
	private String u_addr2;
	private String u_phone;
	
	//----------주문 발송 현황-------------
	private String deliveryCheck;
	
	
	
	public OrderInfoVO(int ono, int pno, String id, String o_category, String o_title, String o_name,
			String o_brand_name, String o_size, String o_img_1, int o_amount, String o_date, int o_price,
			int o_mileage_gain, int o_mileage_usage, int o_final_price, String u_name, String u_addr1, String u_addr2,
			String u_phone, String deliveryCheck, int totalDiscount, int totalMileage, int totalPrice, int useMileage,
			int count) {
		super();
		this.ono = ono;
		this.pno = pno;
		this.id = id;
		this.o_category = o_category;
		this.o_title = o_title;
		this.o_name = o_name;
		this.o_brand_name = o_brand_name;
		this.o_size = o_size;
		this.o_img_1 = o_img_1;
		this.o_amount = o_amount;
		this.o_date = o_date;
		this.o_price = o_price;
		this.o_mileage_gain = o_mileage_gain;
		this.o_mileage_usage = o_mileage_usage;
		this.o_final_price = o_final_price;
		this.u_name = u_name;
		this.u_addr1 = u_addr1;
		this.u_addr2 = u_addr2;
		this.u_phone = u_phone;
		this.deliveryCheck = deliveryCheck;
		this.totalDiscount = totalDiscount;
		this.totalMileage = totalMileage;
		this.totalPrice = totalPrice;
		this.useMileage = useMileage;
		this.count = count;
	}



	public int getO_mileage_usage() {
		return o_mileage_usage;
	}



	public void setO_mileage_usage(int o_mileage_usage) {
		this.o_mileage_usage = o_mileage_usage;
	}



	//----------- 밑에 부분은 결제 이후 받을 내용 --------------------
	private int totalDiscount;
	private int totalMileage;
	private int totalPrice;
	private int useMileage;
	private int count;
	
	
	
	public OrderInfoVO() {
		// TODO Auto-generated constructor stub
	}



	public int getOno() {
		return ono;
	}



	public void setOno(int ono) {
		this.ono = ono;
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



	public String getO_category() {
		return o_category;
	}



	public void setO_category(String o_category) {
		this.o_category = o_category;
	}



	public String getO_title() {
		return o_title;
	}



	public void setO_title(String o_title) {
		this.o_title = o_title;
	}



	public String getO_name() {
		return o_name;
	}



	public void setO_name(String o_name) {
		this.o_name = o_name;
	}



	public String getO_brand_name() {
		return o_brand_name;
	}



	public void setO_brand_name(String o_brand_name) {
		this.o_brand_name = o_brand_name;
	}



	public String getO_size() {
		return o_size;
	}



	public void setO_size(String o_size) {
		this.o_size = o_size;
	}



	public String getO_img_1() {
		return o_img_1;
	}



	public void setO_img_1(String o_img_1) {
		this.o_img_1 = o_img_1;
	}



	public int getO_amount() {
		return o_amount;
	}



	public void setO_amount(int o_amount) {
		this.o_amount = o_amount;
	}



	public String getO_date() {
		return o_date;
	}



	public void setO_date(String o_date) {
		this.o_date = o_date;
	}



	public int getO_price() {
		return o_price;
	}



	public void setO_price(int o_price) {
		this.o_price = o_price;
	}



	public int getO_mileage_gain() {
		return o_mileage_gain;
	}



	public void setO_mileage_gain(int o_mileage_gain) {
		this.o_mileage_gain = o_mileage_gain;
	}



	public int getO_final_price() {
		return o_final_price;
	}



	public void setO_final_price(int o_final_price) {
		this.o_final_price = o_final_price;
	}



	public String getU_name() {
		return u_name;
	}



	public void setU_name(String u_name) {
		this.u_name = u_name;
	}



	public String getU_addr1() {
		return u_addr1;
	}



	public void setU_addr1(String u_addr1) {
		this.u_addr1 = u_addr1;
	}



	public String getU_addr2() {
		return u_addr2;
	}



	public void setU_addr2(String u_addr2) {
		this.u_addr2 = u_addr2;
	}



	public String getU_phone() {
		return u_phone;
	}



	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}



	public String getDeliveryCheck() {
		return deliveryCheck;
	}



	public void setDeliveryCheck(String deliveryCheck) {
		this.deliveryCheck = deliveryCheck;
	}



	public int getTotalDiscount() {
		return totalDiscount;
	}



	public void setTotalDiscount(int totalDiscount) {
		this.totalDiscount = totalDiscount;
	}



	public int getTotalMileage() {
		return totalMileage;
	}



	public void setTotalMileage(int totalMileage) {
		this.totalMileage = totalMileage;
	}



	public int getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}



	public int getUseMileage() {
		return useMileage;
	}



	public void setUseMileage(int useMileage) {
		this.useMileage = useMileage;
	}



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	@Override
	public String toString() {
		return "OrderInfoVO [ono=" + ono + ", pno=" + pno + ", id=" + id + ", o_category=" + o_category + ", o_title="
				+ o_title + ", o_name=" + o_name + ", o_brand_name=" + o_brand_name + ", o_size=" + o_size
				+ ", o_img_1=" + o_img_1 + ", o_amount=" + o_amount + ", o_date=" + o_date + ", o_price=" + o_price
				+ ", o_mileage_gain=" + o_mileage_gain + ", o_mileage_usage=" + o_mileage_usage + ", o_final_price="
				+ o_final_price + ", u_name=" + u_name + ", u_addr1=" + u_addr1 + ", u_addr2=" + u_addr2 + ", u_phone="
				+ u_phone + ", deliveryCheck=" + deliveryCheck + ", totalDiscount=" + totalDiscount + ", totalMileage="
				+ totalMileage + ", totalPrice=" + totalPrice + ", useMileage=" + useMileage + ", count=" + count + "]";
	}



	public OrderInfoVO(int ono, int pno, String id, String o_category, String o_title, String o_name,
			String o_brand_name, String o_size, String o_img_1, int o_amount, String o_date, int o_price,
			int o_mileage_gain, int o_final_price, String u_name, String u_addr1, String u_addr2, String u_phone,
			String deliveryCheck, int totalDiscount, int totalMileage, int totalPrice, int useMileage, int count) {
		super();
		this.ono = ono;
		this.pno = pno;
		this.id = id;
		this.o_category = o_category;
		this.o_title = o_title;
		this.o_name = o_name;
		this.o_brand_name = o_brand_name;
		this.o_size = o_size;
		this.o_img_1 = o_img_1;
		this.o_amount = o_amount;
		this.o_date = o_date;
		this.o_price = o_price;
		this.o_mileage_gain = o_mileage_gain;
		this.o_final_price = o_final_price;
		this.u_name = u_name;
		this.u_addr1 = u_addr1;
		this.u_addr2 = u_addr2;
		this.u_phone = u_phone;
		this.deliveryCheck = deliveryCheck;
		this.totalDiscount = totalDiscount;
		this.totalMileage = totalMileage;
		this.totalPrice = totalPrice;
		this.useMileage = useMileage;
		this.count = count;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ono;
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
		OrderInfoVO other = (OrderInfoVO) obj;
		if (ono != other.ono)
			return false;
		return true;
	}

	
}
