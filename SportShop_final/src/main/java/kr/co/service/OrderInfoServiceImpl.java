package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.DateVO;
import kr.co.domain.OrderInfoVO;
import kr.co.persistence.OrderInfoDAO;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

	@Inject
	OrderInfoDAO dao;
	
	
	@Override
	public void insertOrderInfo(OrderInfoVO oVO) throws Exception {
		
		dao.insertOrderInfo(oVO);
		
		
	}

	@Override
	public int getOno() throws Exception {
		
		return dao.getOno();
	}

	@Override
	public void insertOrderInfo2(OrderInfoVO oVO) throws Exception {
	
		dao.insertOrderInfo2(oVO);
	}

	@Override
	public List<OrderInfoVO> myOrder(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.myOrder(id);
	}

	@Override
	public List<OrderInfoVO> orderAdmin() {
		// TODO Auto-generated method stub
		return dao.orderAdmin();
	}

	@Override
	public List<OrderInfoVO> dateOrder(DateVO vo) {
		// TODO Auto-generated method stub
		return dao.dateOrder(vo);
	}

}
