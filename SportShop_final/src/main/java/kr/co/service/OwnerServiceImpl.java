package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.OrderInfoVO;
import kr.co.domain.OwnerPageVO;
import kr.co.domain.OwnerVO;
import kr.co.domain.UserVO;
import kr.co.persistence.OwnerDAO;

@Service
public class OwnerServiceImpl implements OwnerService  {

	@Inject
	OwnerDAO dao;

	@Override
	public OwnerPageVO OwnerPage(int opnum) throws Exception {
		// TODO Auto-generated method stub
		return dao.OwnerPage(opnum);
	}

	@Override
	public List<OrderInfoVO> getId() throws Exception {
		
		return dao.getId();
		
	}

	@Override
	public List<OwnerVO> getGender() throws Exception {
		return dao.getGender();
		
		
	}

	@Override
	public List<OwnerVO> getAge() throws Exception {
		return dao.getAge();
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OwnerVO> getState() throws Exception {
		// TODO Auto-generated method stub
		return dao.getState();
	}

	@Override
	public List<OwnerPageVO> day() {
		// TODO Auto-generated method stub
		return dao.day();
	}

	@Override
	public List<OwnerPageVO> month() {
		// TODO Auto-generated method stub
		return dao.month();
	}

	@Override
	public List<OwnerPageVO> year() {
		// TODO Auto-generated method stub
		return dao.year();
	}

	@Override
	public List<OwnerVO> category() {
		// TODO Auto-generated method stub
		return dao.category();
	}
	
	
	
	
}
