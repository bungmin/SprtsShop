package kr.co.persistence;

import java.util.List;

import kr.co.domain.AgeGraphVO;
import kr.co.domain.BoardVO;
import kr.co.domain.StateVO;
import kr.co.domain.UserVO;
import kr.co.domain.VisitVO;

public interface UserManageDAO {

	public abstract List<UserVO> getListUser() throws Exception;

	public abstract void delete(String id) throws Exception;

	public abstract List<UserVO> getGenderCnt() throws Exception;

	public abstract List<VisitVO> getVisitLog_D() throws Exception;
	
	public abstract void visit_log(String id) throws Exception;

	public abstract List<VisitVO> getVisitLog_M() throws Exception;
	
	
	public abstract List<BoardVO> analysisBoard() throws Exception;
	
	
	public abstract List<AgeGraphVO> analysisAge() throws Exception;
	
	
	public abstract List<StateVO> analysisState() throws Exception;
		
	public abstract List<UserVO> memberToday() throws Exception;
	
	
	/*public abstract List<UserVO> getlistAnalysis() throws Exception;*/

}
