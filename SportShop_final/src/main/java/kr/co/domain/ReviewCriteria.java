package kr.co.domain;

public class ReviewCriteria {
	
	private int page;	//현재 page curPage
	private int perPageNum;
	
	public ReviewCriteria() {
		// TODO Auto-generated constructor stub
		page=1;				// 첫번째 페이지
		perPageNum = 10;	// 무조건 10개씩
	
	}

	public ReviewCriteria(int page, int perPageNum) {
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
