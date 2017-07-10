package kr.co.persistence;

import java.util.List;

import kr.co.domain.Criteria;
import kr.co.domain.MsgVO;

public interface MsgDAO {

	public abstract void create(MsgVO vo) throws Exception;

	public abstract int getMno() throws Exception;
	
	public abstract List<MsgVO> listAll(String id) throws Exception;
	
	
	public abstract List<MsgVO> listAllAdmin() throws Exception;
	
	
	public abstract void replyCheckUpdate(int mno) throws Exception;
	
	
	
	public abstract List<MsgVO> listCriteria(Criteria cri) throws Exception;	
	public abstract int totalCount() throws Exception;
	public abstract List<MsgVO> listCriteriaUser(Criteria cri, String id) throws Exception;	
	public abstract int totalCountUser(String id) throws Exception;
	
		
	public abstract void deletById(String id) throws Exception;

}
