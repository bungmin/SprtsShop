package kr.co.persistence;

import java.util.List;

import kr.co.domain.Criteria;
import kr.co.domain.ReplyVO;

public interface ReplyDAO {
	
	/*원래 글에 있는 댓글을 다 나오게 하는거임*/
	public abstract List<ReplyVO> list(Integer bno) throws Exception;
	public abstract void create(ReplyVO vo) throws Exception;
	public abstract int getRno() throws Exception;
	public abstract void update(ReplyVO vo) throws Exception;
	public abstract void delete(Integer rno) throws Exception;
	
	
	public abstract List<ReplyVO> listPage(Integer bno, Criteria cri) throws Exception;
	
	/*page 처리할때 꼭 필요한거 전체 목록 수*/
	public abstract int count(Integer bno) throws Exception;	
	
	/*댓글이 삭제 될떄 삭제가 되기 전에 bno값을 가져오기 위해서.*/	
	public abstract int getBno(Integer rno) throws Exception;
	public abstract void deleteAllByBno(int bno) throws Exception;
	
	
	
	

}
