package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.Criteria;
import kr.co.domain.MsgVO;
import kr.co.persistence.MsgDAO;

@Service
public class MsgServiceImpl implements MsgService {
	
	@Inject
	MsgDAO dao;
	
	

	@Override
	public void create(MsgVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		dao.create(vo);
		
	}

	@Override
	public int getMno() throws Exception {
		// TODO Auto-generated method stub
		return dao.getMno();
	}

	@Override
	public List<MsgVO> listAll(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.listAll(id);
	}

	@Override
	public List<MsgVO> listAllAdmin() throws Exception {
		// TODO Auto-generated method stub
		return dao.listAllAdmin();
	}

	@Override
	public void replyCheckUpdate(int mno) throws Exception {
		// TODO Auto-generated method stub
		
		dao.replyCheckUpdate(mno);
		
	}

	

	@Override
	public int totalCount() throws Exception {
		// TODO Auto-generated method stub
		return dao.totalCount();
	}

	@Override
	public List<MsgVO> listCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCriteria(cri);
	}

	@Override
	public List<MsgVO> listCriteriaUser(Criteria cri, String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCriteriaUser(cri,id);
	}

	@Override
	public int totalCount(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.totalCountUser(id);
	}

	


}
