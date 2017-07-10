package kr.co.service;

import java.util.List;

import kr.co.domain.OrderInfoVO;
import kr.co.domain.OwnerPageVO;
import kr.co.domain.OwnerVO;
import kr.co.domain.UserVO;

public interface OwnerService {

	public abstract OwnerPageVO OwnerPage(int opnum) throws Exception;

	public abstract List<OrderInfoVO> getId() throws Exception;

	public abstract List<OwnerVO> getGender() throws Exception;

	public abstract List<OwnerVO> getAge() throws Exception;

	public abstract List<OwnerVO> getState() throws Exception;

	public abstract List<OwnerPageVO> day();

	public abstract List<OwnerPageVO> month();

	public abstract List<OwnerPageVO> year();

	public abstract List<OwnerVO> category();
	
}
