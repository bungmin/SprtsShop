package kr.co.service;

import java.util.List;

import kr.co.domain.Criteria;
import kr.co.domain.ReplyVO;
import kr.co.domain.ReviewCriteria;
import kr.co.domain.ReviewVO;

public interface ReviewService {
	/*원래 글에 있는 댓글을 다 나오게 하는거임*/

	public abstract int getRevno() throws Exception;
	public abstract void reviewInsert(ReviewVO vo) throws Exception;
	public List<ReviewVO> listPage(Integer pno, ReviewCriteria cri) throws Exception;
	public abstract int count(Integer pno) throws Exception;
	
	public abstract void update(ReviewVO vo) throws Exception;
	public abstract void delete(Integer revno) throws Exception;
	
	public abstract List<ReviewVO> myReview(String id) throws Exception;

}
