package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.ReplyVO;
import kr.co.domain.ReviewCriteria;
import kr.co.domain.ReviewVO;
import kr.co.persistence.ReviewDAO;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Inject
	ReviewDAO dao;
	

	@Override
	public int getRevno() throws Exception {
		// TODO Auto-generated method stub
		return dao.getRevno();
	}

	@Override
	public void reviewInsert(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		dao.reviewInsert(vo);
		
	}
	
	
	@Override
	public List<ReviewVO> listPage(Integer pno, ReviewCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listPage(pno, cri);
	}

	@Override
	public int count(Integer pno) throws Exception {
		// TODO Auto-generated method stub
		return dao.count(pno);
	}

	@Override
	public void update(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		dao.update(vo);		
	}

	@Override
	public void delete(Integer revno) throws Exception {
		// TODO Auto-generated method stub
		
		dao.delete(revno);
		
	}

	@Override
	public List<ReviewVO> myReview(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.myReview(id);
	}

}
