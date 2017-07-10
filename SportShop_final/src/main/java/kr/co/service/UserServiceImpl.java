package kr.co.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.IdFindDTO;
import kr.co.domain.LoginDTO;
import kr.co.domain.UserInfoVO;
import kr.co.domain.UserVO;
import kr.co.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDAO dao;

	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return dao.login(dto);
	}

	@Transactional
	@Override
	public void join(UserVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.join(vo);
		
		dao.firstUserInfo(vo.getId());
		
	}

	@Override
	public UserVO idck(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.idck(id);
	}

	@Override
	public UserVO mypage(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.mypage(id);
	}

	@Override
	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public void update(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		dao.update(userVO);
	}

	@Override
	public UserVO idfind(UserVO dto) throws Exception {
		// TODO Auto-generated method stub
		return dao.idfind(dto);
	}

	@Override
	public UserVO pwfind(UserVO dto) throws Exception {
		// TODO Auto-generated method stub
		return dao.pwfind(dto);
	}

	@Override
	public void firstUserInfo(String id) throws Exception {
		// TODO Auto-generated method stub
		
		dao.firstUserInfo(id);
		
	}

	@Override
	public void cashcharge(UserInfoVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		dao.cashcharge(vo);
		
	}

	@Override
	public UserInfoVO userInfo(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.userInfo(id);
	}

	@Override
	public void addMileage(UserInfoVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		
		dao.addMileage(vo);
		
	}

	@Override
	public void minusCash(UserInfoVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		dao.minusCash(vo);
	}

	@Override
	public void minusMileage(UserInfoVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		
		dao.minusMileage(vo);
		
	}

}
