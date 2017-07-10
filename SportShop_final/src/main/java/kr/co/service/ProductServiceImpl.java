package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.Criteria;
import kr.co.domain.OwnerPageVO;
import kr.co.domain.ProductCriteria;
import kr.co.domain.ProductSearchCriteria;
import kr.co.domain.ProductVO;
import kr.co.persistence.ProductDAO;
import kr.co.persistence.ReviewDAO;


@Service
public class ProductServiceImpl implements ProductService {

	@Inject
	ProductDAO dao;
	
	@Inject
	ReviewDAO reviewDao;

	@Transactional
	@Override
	public void insertProduct(ProductVO vo) throws Exception {
		
		dao.insertProduct(vo);
	}

	@Override
	public int getPno() throws Exception {
		// TODO Auto-generated method stub
		return dao.getPno();
	}

	@Override
	public List<ProductVO> ListAllProduct() throws Exception {
		
		
		// TODO Auto-generated method stub
		return dao.ListAllProduct();
	}

	@Override
	public void updateProduct(ProductVO vo) throws Exception {
		dao.updateProduct(vo);
		
	}

	@Override
	public ProductVO readProduct(int pno) throws Exception {
		// TODO Auto-generated method stub
		return dao.readProduct(pno);
	}

	
	@Transactional
	@Override
	public void deleteProduct(int pno) throws Exception{
		
		/*reviewDao.de*/
		
		reviewDao.deleteByPno(pno);
	
		dao.deleteProduct(pno);
	}

	@Override
	public List<ProductVO> listCriteria(ProductCriteria cri) {
		// TODO Auto-generated method stub
		return dao.listCriteria(cri);
	}

	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		Integer i = dao.totalCount();
		
		if(i == null){
			return 0;
		}
		return i;
	}

	@Override
	public List<ProductVO> listSearch(ProductSearchCriteria cri,String category, String orderType) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSearch(cri, category, orderType);
	}

	@Override
	public int listSearchCount(ProductSearchCriteria cri, String category) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSearchCount(cri, category);
	}

	@Override
	public List<ProductVO> SoccerProList() throws Exception {
		// TODO Auto-generated method stub
		return dao.SoccerProList();
	}

	@Override
	public List<ProductVO> baseBallList() throws Exception {
		// TODO Auto-generated method stub
		return dao.baseBallList();
	}

	@Override
	public List<ProductVO> basketBallList() throws Exception {
		// TODO Auto-generated method stub
		return dao.basketBallList();
	}

	@Override
	public void addViewCnt(int pno) throws Exception {
		// TODO Auto-generated method stub
		
		dao.addViewCnt(pno);
		
	}

	@Override
	public void addGoodCnt(int pno) throws Exception {
		// TODO Auto-generated method stub
		
		dao.addGoodCnt(pno);
		
	}

	@Override
	public List<ProductVO> listCriteriaAdmin(Criteria cri) {
		// TODO Auto-generated method stub
		return dao.listCriteriaAdmin(cri);
	}

	@Override
	public void amountBalance(ProductVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		dao.amountBalance(vo);
		
		
	}
	
	@Override
	public void insertOwnerPage(OwnerPageVO opvo) throws Exception {
	
		dao.insertOwnerPage(opvo);
	}

	@Override
	public int getOpnum() throws Exception {
		// TODO Auto-generated method stub
		return dao.getOpnum();
	}

	@Override
	public void insertOwnerPage2(OwnerPageVO opvo) throws Exception {
		dao.insertOwnerPage2(opvo);
		
	}

	@Override
	public OwnerPageVO getBeforeInfo(int opnum) throws Exception {
		// TODO Auto-generated method stub
		return dao.getBeforeInfo(opnum);
	}
	
	
	
}
