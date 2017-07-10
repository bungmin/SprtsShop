package kr.co.persistence;


import java.util.List;

import kr.co.domain.CartTestVO;
import kr.co.domain.CartVO;

public interface CartDAO {
	public abstract void insertCart(CartVO vo) throws Exception;
	public abstract int getCno() throws Exception;
	
	public abstract List<CartVO> ListAllCart(String id) throws Exception;
	public abstract void updateCart(CartVO vo);
	public abstract void delete(int cno) throws Exception;
	public abstract List<CartTestVO> CartView(String id) throws Exception;
	
	public abstract void deleteAfterPurchase(String id) throws Exception;
	
	public abstract void deletById(String id) throws Exception;
	
}
