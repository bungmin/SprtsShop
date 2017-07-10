package kr.co.domain;

public class ProductSearchCriteria extends ProductCriteria{
	
	private String searchType;
	private String keyword;
	
	/*상속을 받았기 때문에, 눈에 보이지 않지만, page랑 perPageNum이 있음.
	 * get,set 만들기..
	 * toString만 overriding
	 * */
	
	
	public String getSearchType() {
		return searchType;
	}
	
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public String toString() {
		return super.toString()+"SearchCriteria [searchType=" + searchType + ", keyword=" + keyword + "]";
		//super.toString() 부모가 가지고있는 toString도 표현..
	}
	
}
