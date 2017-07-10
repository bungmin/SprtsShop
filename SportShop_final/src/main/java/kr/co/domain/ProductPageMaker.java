package kr.co.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class ProductPageMaker {
	private int totalCount;
	private int startPageNum;
	private int endPageNum;
	private ProductCriteria cri;
	private int totalPage;
	private int searchTotalCount;

	public int getSearchTotalCount() {
		return searchTotalCount;
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

	public ProductPageMaker() {
		// TODO Auto-generated constructor stub
	}

	public ProductPageMaker(int totalCount, int startPageNum, int endPageNum, ProductCriteria cri) {
		super();
		this.totalCount = totalCount;
		this.startPageNum = startPageNum;
		this.endPageNum = endPageNum;
		this.cri = cri;
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

	public ProductCriteria getCri() {
		return cri;
	}

	public void setCri(ProductCriteria cri) {
		this.cri = cri;
	}
	
	
	/*query문을 변경하기 위해서*/
	public String makeQuery(int page){
		/*스프링에 있는거 UriComponents
		 * builder로 끝나는거는 build를 해줘야됨.
		 * */
		//queryParam("page", cri.getPage()).
		
		UriComponents uc = 
				UriComponentsBuilder.newInstance().
				queryParam("page", page).
				queryParam("perPageNum", cri.getPerPageNum()).
				build(); 
		
		
		return uc.toUriString();
	}
	
	
	/*search의 query 값..*/
	public String makeSearch(int page){
		/*스프링에 있는거 UriComponents
		 * builder로 끝나는거는 build를 해줘야됨.
		 * */
		//queryParam("page", cri.getPage()).
		
		UriComponents uc = 
				UriComponentsBuilder.newInstance().
				queryParam("page", page).
				queryParam("perPageNum", cri.getPerPageNum()).
				queryParam("searchType", ((ProductSearchCriteria)cri).getSearchType()).
				queryParam("keyword", ((ProductSearchCriteria)cri).getKeyword()).
				build(); 
		
		// searchType을 가져오기 위해서  형변환함.((SearchCriteria)cri).getSearchType()
		// 마찬가지로 keyword도 형변환해서 가져오기......
		
		return uc.toUriString();
	}
	
	
	public String makeOrder(int page){
		/*스프링에 있는거 UriComponents
		 * builder로 끝나는거는 build를 해줘야됨.
		 * */
		//queryParam("page", cri.getPage()).
		
		UriComponents uc = 
				UriComponentsBuilder.newInstance().
				queryParam("page", page).
				queryParam("perPageNum", cri.getPerPageNum()).
				queryParam("searchType", ((ProductSearchCriteria)cri).getSearchType()).
				queryParam("keyword", ((ProductSearchCriteria)cri).getKeyword()).
				//queryParam("orderType", ((OrderCriteria)cri).getKeyword()).				
				build(); 
		
		// searchType을 가져오기 위해서  형변환함.((SearchCriteria)cri).getSearchType()
		// 마찬가지로 keyword도 형변환해서 가져오기......
		
		return uc.toUriString();
	}
	
	
	

}
