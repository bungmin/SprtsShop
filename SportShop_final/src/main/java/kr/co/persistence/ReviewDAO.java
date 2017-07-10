package kr.co.persistence;

import java.util.List;

import kr.co.domain.ReplyVO;
import kr.co.domain.ReviewCriteria;
import kr.co.domain.ReviewVO;

public interface ReviewDAO {
	
	public abstract int getRevno() throws Exception;
	public abstract void reviewInsert(ReviewVO vo) throws Exception;
	public List<ReviewVO> listPage(Integer pno, ReviewCriteria cri) throws Exception;
	
	/*page 처리할때 꼭 필요한거 전체 목록 수*/
	public abstract int count(Integer pno) throws Exception;
	public abstract void update(ReviewVO vo) throws Exception;
	public abstract void delete(Integer revno) throws Exception;
	
	public abstract List<ReviewVO> myReview(String id) throws Exception;
	
	
	
	public abstract void deleteByPno(Integer pno) throws Exception;
	
	public abstract void deletById(String id) throws Exception;

}
