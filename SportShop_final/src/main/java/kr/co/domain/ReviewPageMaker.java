package kr.co.domain;

public class ReviewPageMaker {
	
	private int totalCount;
	private int startPageNum;
	private int endPageNum;
	private ReviewCriteria cri;
	private int totalPage;
	private int searchTotalCount;

	public int getSearchTotalCount() {
		return searchTotalCount;
	}
	

	public ReviewPageMaker(int totalCount, int startPageNum, int endPageNum, ReviewCriteria cri, int totalPage,
			int searchTotalCount) {
		super();
		this.totalCount = totalCount;
		this.startPageNum = startPageNum;
		this.endPageNum = endPageNum;
		this.cri = cri;
		this.totalPage = totalPage;
		this.searchTotalCount = searchTotalCount;
	}




	public ReviewCriteria getCri() {
		return cri;
	}




	public void setCri(ReviewCriteria cri) {
		this.cri = cri;
	}




	public void setSearchTotalCount(int searchTotalCount) {
		this.searchTotalCount = searchTotalCount;

		totalPage = totalCount / cri.getPerPageNum();
		
		if (totalCount % cri.getPerPageNum() != 0) {
			++totalPage;
		}

		int page = cri.getPage();
		if(page > totalPage){
			page = totalPage;
			cri.setPage(totalPage);
		}	
		
		startPageNum = ((page-1) / 10) * 10 + 1;
		//startPageNum = ((page-1) / cri.getPerPageNum()) * cri.getPerPageNum() + 1;

		// totalPage를 구한이유는 int endPageNum = startPageNum + 9; 이거 때문임
		endPageNum = startPageNum + 9;
		//endPageNum = startPageNum + cri.getPerPageNum();

		if (totalPage < endPageNum) {
			endPageNum = totalPage;
		}
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public ReviewPageMaker() {
		// TODO Auto-generated constructor stub
	}


	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;

		totalPage = totalCount / cri.getPerPageNum();
		
		if (totalCount % cri.getPerPageNum() != 0) {
			++totalPage;
		}

		int page = cri.getPage();
		
		if(page > totalPage){
			page = totalPage;
			cri.setPage(totalPage);
		}	
		
		startPageNum = ((page-1) / 10) * 10 + 1;
		//startPageNum = ((page-1) / cri.getPerPageNum()) * cri.getPerPageNum() + 1;

		// totalPage를 구한이유는 int endPageNum = startPageNum + 9; 이거 때문임
		endPageNum = startPageNum + 9;
		//endPageNum = startPageNum + cri.getPerPageNum();

		if (totalPage < endPageNum) {
			endPageNum = totalPage;
		}

	}

	public int getStartPageNum() {
		return startPageNum;
	}

	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}

	public int getEndPageNum() {
		return endPageNum;
	}

	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}
	
	@Override
	public String toString() {
		return "ReviewPageMaker [totalCount=" + totalCount + ", startPageNum=" + startPageNum + ", endPageNum="
				+ endPageNum + ", cri=" + cri + ", totalPage=" + totalPage + ", searchTotalCount=" + searchTotalCount
				+ "]";
	}



	
	
	
	
	

}
