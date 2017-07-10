package kr.co.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.OrderInfoVO;
import kr.co.domain.OwnerPageVO;
import kr.co.domain.OwnerVO;
import kr.co.domain.UserVO;

@Repository
public class OwnerDAOImpl implements OwnerDAO{
	
	@Inject
	private SqlSession session;
	private final String NAMESPACE = "kr.co.mapper.ownerMapper";
	@Override
	public OwnerPageVO OwnerPage(int opnum) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(NAMESPACE + ".ownerPage", opnum);
	}
	@Override
	public List<OrderInfoVO> getId() throws Exception {
		
		
		return session.selectList(NAMESPACE + ".getId");
	}
	@Override
	public List<OwnerVO> getGender() {
		// TODO Auto-generated method stub
		
		return session.selectList(NAMESPACE+".getGender");
	}
	@Override
	public List<OwnerVO> getAge() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".getAge");
	}
	@Override
	public List<OwnerVO> getState() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".getState");
	}
	@Override
	public List<OwnerPageVO> day() {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE + ".day");
	}
	@Override
	public List<OwnerPageVO> month() {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE + ".month");
	}
	@Override
	public List<OwnerPageVO> year() {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE + ".year");
	}
	@Override
	public List<OwnerVO> category() {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE + ".category");
	}
	
	
	
}
