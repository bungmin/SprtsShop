package kr.co.persistence;



import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.LoginDTO;
import kr.co.domain.UserInfoVO;
import kr.co.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject
	private SqlSession session;
	private final String NAMESPACE="kr.co.mapper.UserMapper";
	
	

	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(NAMESPACE+".login", dto);
		
	}



	@Override
	public void join(UserVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(NAMESPACE+".join", vo);
	}



	@Override
	public UserVO idck(String id) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(NAMESPACE+".idck", id);
	}



	@Override
	public UserVO mypage(String id) throws Exception {
		// TODO Auto-generated method stub
	
		return session.selectOne(NAMESPACE+".mypage", id);
	}


/*
	@Override
	public UserVO delete(String id) throws Exception {
		// TODO Auto-generated method stub
	
		return session.delete(NAMESPACE+".delete", id);
	}
*/


	@Override
	public void update(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		
		session.update(NAMESPACE+".update", userVO);
	}



	
	@Override
	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		session.delete(NAMESPACE+".delete", id);
	}



	@Override
	public UserVO idfind(UserVO dto) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(NAMESPACE+".idfind", dto);
	}



	@Override
	public UserVO pwfind(UserVO dto) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(NAMESPACE+".pwfind", dto);
	}



	@Override
	public void firstUserInfo(String id) throws Exception {
		// TODO Auto-generated method stub
		
		session.insert(NAMESPACE+".firstUserInfo", id);
		
	}



	@Override
	public void cashcharge(UserInfoVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		
		session.update(NAMESPACE+".cashcharge", vo);
		
	}



	@Override
	public UserInfoVO userInfo(String id) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(NAMESPACE+".userinfo", id);
	}



	@Override
	public void addMileage(UserInfoVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		
		session.update(NAMESPACE+".addMileage", vo);
		
	}



	@Override
	public void minusCash(UserInfoVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		
		session.update(NAMESPACE+".minusCash", vo);
	}



	@Override
	public void minusMileage(UserInfoVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		
		session.update(NAMESPACE+".minusMileage", vo);
		
	}



	




	


}
