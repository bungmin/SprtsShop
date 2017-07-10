package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.AgeGraphVO;
import kr.co.domain.BoardVO;
import kr.co.domain.StateVO;
import kr.co.domain.UserVO;
import kr.co.domain.VisitVO;
import kr.co.persistence.AdsDAO;
import kr.co.persistence.BoardDAO;
import kr.co.persistence.CartDAO;
import kr.co.persistence.MsgDAO;
import kr.co.persistence.ReviewDAO;
import kr.co.persistence.UserManageDAO;

@Service
public class UserManageServiceImpl implements UserManageService {
	
	@Inject
	UserManageDAO dao;
	
	/*
	@Inject
	ReviewDAO reviewDao;
	
	@Inject
	BoardDAO boardDao;
	
	@Inject
	AdsDAO adsDao;
	
	@Inject
	CartDAO cartDao;
	
	@Inject
	MsgDAO msgDao;
	
	@Inject*/
	
	

	@Transactional
	@Override
	public List<UserVO> userList() throws Exception {
		// TODO Auto-generated method stub
		return dao.getListUser();
	}

	
	@Transactional
	@Override
	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(id);
		
	}

	@Override
	public List<UserVO> Analysis() throws Exception {
		// TODO Auto-generated method stub
		return dao.getGenderCnt();
	}

	@Override
	public List<VisitVO> visitLog_D() throws Exception {
		// TODO Auto-generated method stub
		return dao.getVisitLog_D();
	}

	@Override
	public void visit_log(String id) throws Exception {
		// TODO Auto-generated method stub
		
		dao.visit_log(id);
		
	}

	@Override
	public List<VisitVO> visitLog_M() throws Exception {
		// TODO Auto-generated method stub
		return dao.getVisitLog_M();
	}

	@Override
	public List<BoardVO> analysisBoard() throws Exception {
		// TODO Auto-generated method stub
		return dao.analysisBoard();
	}

	@Override
	public List<AgeGraphVO> analysisAge() throws Exception {
		// TODO Auto-generated method stub
		return dao.analysisAge();
	}

	@Override
	public List<StateVO> analysisState() throws Exception {
		// TODO Auto-generated method stub
		return dao.analysisState();
	}

	@Override
	public List<UserVO> memberToday() throws Exception {
		// TODO Auto-generated method stub
		return dao.memberToday();
	}

	/*@Override
	public List<UserVO> genderAnalysis(UserVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.getlistAnalysis();
	}*/
	

}
