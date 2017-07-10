package kr.co.service;

import java.util.List;

import kr.co.domain.AgeGraphVO;
import kr.co.domain.BoardVO;
import kr.co.domain.StateVO;
import kr.co.domain.UserVO;
import kr.co.domain.VisitVO;

public interface UserManageService {

	public abstract List<UserVO> userList() throws Exception;

	public abstract void delete(String id) throws Exception;

	public abstract List<UserVO> Analysis() throws Exception;

	public abstract List<VisitVO> visitLog_D() throws Exception;
	
	public abstract void visit_log(String id) throws Exception;

	public abstract List<VisitVO> visitLog_M() throws Exception;
	
	public abstract List<BoardVO> analysisBoard() throws Exception;
	
	public abstract List<AgeGraphVO> analysisAge() throws Exception;
	
	public abstract List<StateVO> analysisState() throws Exception;
	
	public abstract List<UserVO> memberToday() throws Exception;
	
	
	/*public abstract List<UserVO> genderAnalysis(UserVO vo) throws Exception;*/

}
