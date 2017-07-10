package kr.co.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.AgeGraphVO;
import kr.co.domain.BoardVO;
import kr.co.domain.StateVO;
import kr.co.domain.UserVO;
import kr.co.domain.VisitVO;

@Repository
public class UserManageDAOImpl implements UserManageDAO{
	
	@Inject
	private SqlSession session;
	private final String NAMESPACE= "kr.co.mapper.UserManageMapper";
	
	@Override
	public List<UserVO> getListUser() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".usercheck");
	}

	@Override
	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		
		session.delete(NAMESPACE+".delete", id);
		
	}

	@Override
	public List<UserVO> getGenderCnt() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".mAnalysis");
	}

	@Override
	public List<VisitVO> getVisitLog_D() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".visitLog_D");
	}

	@Override
	public void visit_log(String id) throws Exception {
		// TODO Auto-generated method stub
		
		session.insert(NAMESPACE+".visit_log", id);
		
	}

	@Override
	public List<VisitVO> getVisitLog_M() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".visitLog_M");
	}

	@Override
	public List<BoardVO> analysisBoard() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".analysisBoard");
	}

	@Override
	public List<AgeGraphVO> analysisAge() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".analysisAge");
	}

	@Override
	public List<StateVO> analysisState() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".analysisState");
	}

	@Override
	public List<UserVO> memberToday() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".memberToday");
	}

	/*@Override
	public List<UserVO> getlistAnalysis() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".manalysis");
	}*/

}
