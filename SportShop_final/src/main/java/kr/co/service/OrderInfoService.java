package kr.co.service;

import java.util.List;

import kr.co.domain.DateVO;
import kr.co.domain.OrderInfoVO;

public interface OrderInfoService {

	public abstract void insertOrderInfo(OrderInfoVO oVO) throws Exception;
	public abstract int getOno() throws Exception;
	public abstract void insertOrderInfo2(OrderInfoVO oVO) throws Exception;
	public abstract List<OrderInfoVO> myOrder(String id) throws Exception;
	public abstract List<OrderInfoVO> orderAdmin();
	public abstract List<OrderInfoVO> dateOrder(DateVO vo);
}
