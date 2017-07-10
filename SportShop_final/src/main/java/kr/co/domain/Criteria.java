package kr.co.domain;

public class Criteria {
	
	private int page;	//현재 page curPage
	private int perPageNum;
	private String orderType;
	private String category;
		
	/*디폴트 생성자, 사용자 생성자*/
	
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getOrderType() {
		return orderType;
	}


	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}


	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", orderType=" + orderType + ", category="
				+ category + "]";
	}


	public Criteria() {
		// TODO Auto-generated constructor stub
		page=1;				// 첫번째 페이지
		perPageNum = 10;	// 무조건 10개씩
	
	}

	public Criteria(int page, int perPageNum) {
		super();
		this.page = page;
		this.perPageNum = perPageNum;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	// startRow 구하는 식
	public int getStartRow() {

		int startRow = (page - 1) * perPageNum + 1;
		

		return startRow;

	}

	// endRow 구하는식
	public int getEndRow() {

		//int endRow = ((page - 1) * perPageNum + 1) + (perPageNum - 1);
		//풀어헤치면 =page*perPageNum-perPageNum+1+perPageNum-1
		//결국엔 = page*perPageNum 이 나옴.
				
		int endRow = page*perPageNum;	
			

		return endRow;
	}

}
