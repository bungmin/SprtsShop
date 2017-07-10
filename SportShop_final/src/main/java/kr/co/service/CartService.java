package kr.co.service;

import java.util.List;

import kr.co.domain.CartTestVO;
import kr.co.domain.CartVO;

public interface CartService {
	public abstract int getCno() throws Exception;
	public abstract void insertCart(CartVO vo) throws Exception;
	
	public abstract void updateCart(CartVO vo);
	public abstract List<CartVO> listAllCart(String id) throws Exception;
	public abstract void delete(int cno) throws Exception;
	public abstract void deleteAfterPurchase(String id) throws Exception;
	
	
	public abstract List<CartTestVO> CartView(String id) throws Exception;
	


}
