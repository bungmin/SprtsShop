package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.CartTestVO;
import kr.co.domain.CartVO;
import kr.co.domain.ProductVO;
import kr.co.persistence.CartDAO;

@Service
public class CartServiceImpl implements CartService{
	
	@Inject
	CartDAO dao;
	
	@Transactional
	@Override
	public void insertCart(CartVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.insertCart(vo);
		
	}

	@Override
	public int getCno() throws Exception {
		// TODO Auto-generated method stub
		
		
		return dao.getCno();
	}
	
	@Override
	public List<CartVO> listAllCart(String id) throws Exception {
		return dao.ListAllCart(id);
	}



	@Override
	public void updateCart(CartVO vo) {
		// TODO Auto-generated method stub
		dao.updateCart(vo);
	}

	@Override
	public void delete(int cno) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(cno);
		
	}

	@Override
	public List<CartTestVO> CartView(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.CartView(id);
	}
	
	
	@Override
	public void deleteAfterPurchase(String id) throws Exception {
		
		dao.deleteAfterPurchase(id);
	}


	
	

}
