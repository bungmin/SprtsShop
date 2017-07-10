package kr.co.persistence;

import java.util.List;

import kr.co.domain.DateVO;
import kr.co.domain.OrderInfoVO;

public interface OrderInfoDAO {

	public abstract void insertOrderInfo(OrderInfoVO oVO) throws Exception;
	public abstract int getOno() throws Exception;
	public abstract void insertOrderInfo2(OrderInfoVO oVO);	
	public abstract List<OrderInfoVO> myOrder(String id) throws Exception;
	public abstract List<OrderInfoVO> orderAdmin();
	public abstract List<OrderInfoVO> dateOrder(DateVO vo);
	
	public abstract void deletById(String id) throws Exception;
	
}
