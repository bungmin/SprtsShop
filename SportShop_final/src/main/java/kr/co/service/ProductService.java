package kr.co.service;

import java.util.List;

import kr.co.domain.BoardVO;
import kr.co.domain.Criteria;
import kr.co.domain.OwnerPageVO;
import kr.co.domain.ProductCriteria;
import kr.co.domain.ProductSearchCriteria;
import kr.co.domain.ProductVO;
import kr.co.domain.SearchCriteria;

public interface ProductService {
	public abstract void insertProduct(ProductVO vo) throws Exception;
	public abstract int getPno() throws Exception;
	List<ProductVO> ListAllProduct() throws Exception;
	void updateProduct(ProductVO vo) throws Exception; 
	ProductVO readProduct(int pno) throws Exception;
	public abstract void deleteProduct(int pno) throws Exception;
	public abstract List<ProductVO> listCriteria(ProductCriteria cri);
	public abstract int totalCount();
	
	public abstract List<ProductVO> listSearch(ProductSearchCriteria cri,String category, String orderType) throws Exception;	
	public abstract int listSearchCount(ProductSearchCriteria cri, String category) throws Exception;
	
	
	
	public abstract List<ProductVO> SoccerProList() throws Exception;
	public abstract List<ProductVO> baseBallList() throws Exception;
	public abstract List<ProductVO> basketBallList() throws Exception;
	
	public abstract void addViewCnt(int pno) throws Exception;
	public abstract void addGoodCnt(int pno) throws Exception;
	
	public abstract void amountBalance(ProductVO vo) throws Exception;
	
	public abstract List<ProductVO> listCriteriaAdmin(Criteria cri);
	
	
	public abstract void insertOwnerPage(OwnerPageVO opvo) throws Exception;
	public abstract int getOpnum() throws Exception;
	public abstract void insertOwnerPage2(OwnerPageVO opvo) throws Exception;
	public abstract OwnerPageVO getBeforeInfo(int opnum) throws Exception;
}
