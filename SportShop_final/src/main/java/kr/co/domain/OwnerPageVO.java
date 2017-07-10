package kr.co.domain;

public class OwnerPageVO {
	private int opnum;
	private int revenue;
	private int discount;
	private int usedmileage;
	private int unusedmileage;

	private int stack_revenue;
	private int stack_discount;
	private int stack_usedmileage;
	private int stack_unusedmileage;
	private int cost;
	private int profit;
	private String regdate;
	
	 public OwnerPageVO() {
		// TODO Auto-generated constructor stub
	}

	public int getOpnum() {
		return opnum;
	}

	public void setOpnum(int opnum) {
		this.opnum = opnum;
	}

	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getUsedmileage() {
		return usedmileage;
	}

	public void setUsedmileage(int usedmileage) {
		this.usedmileage = usedmileage;
	}

	public int getUnusedmileage() {
		return unusedmileage;
	}

	public void setUnusedmileage(int unusedmileage) {
		this.unusedmileage = unusedmileage;
	}

	public int getStack_revenue() {
		return stack_revenue;
	}

	public void setStack_revenue(int stack_revenue) {
		this.stack_revenue = stack_revenue;
	}

	public int getStack_discount() {
		return stack_discount;
	}

	public void setStack_discount(int stack_discount) {
		this.stack_discount = stack_discount;
	}

	public int getStack_usedmileage() {
		return stack_usedmileage;
	}

	public void setStack_usedmileage(int stack_usedmileage) {
		this.stack_usedmileage = stack_usedmileage;
	}

	public int getStack_unusedmileage() {
		return stack_unusedmileage;
	}

	public void setStack_unusedmileage(int stack_unusedmileage) {
		this.stack_unusedmileage = stack_unusedmileage;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "OwnerPageVO [opnum=" + opnum + ", revenue=" + revenue + ", discount=" + discount + ", usedmileage="
				+ usedmileage + ", unusedmileage=" + unusedmileage + ", stack_revenue=" + stack_revenue
				+ ", stack_discount=" + stack_discount + ", stack_usedmileage=" + stack_usedmileage
				+ ", stack_unusedmileage=" + stack_unusedmileage + ", cost=" + cost + ", profit=" + profit
				+ ", regdate=" + regdate + "]";
	}

	public OwnerPageVO(int opnum, int revenue, int discount, int usedmileage, int unusedmileage, int stack_revenue,
			int stack_discount, int stack_usedmileage, int stack_unusedmileage, int cost, int profit, String regdate) {
		super();
		this.opnum = opnum;
		this.revenue = revenue;
		this.discount = discount;
		this.usedmileage = usedmileage;
		this.unusedmileage = unusedmileage;
		this.stack_revenue = stack_revenue;
		this.stack_discount = stack_discount;
		this.stack_usedmileage = stack_usedmileage;
		this.stack_unusedmileage = stack_unusedmileage;
		this.cost = cost;
		this.profit = profit;
		this.regdate = regdate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + opnum;
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
		OwnerPageVO other = (OwnerPageVO) obj;
		if (opnum != other.opnum)
			return false;
		return true;
	}

	 
	 
}
