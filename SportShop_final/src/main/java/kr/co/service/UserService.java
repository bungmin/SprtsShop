package kr.co.service;


import kr.co.domain.LoginDTO;
import kr.co.domain.UserInfoVO;
import kr.co.domain.UserVO;

public interface UserService {

	public abstract UserVO login(LoginDTO dto) throws Exception;
	public abstract void join(UserVO vo) throws Exception;
	public abstract UserVO idck(String id) throws Exception;
	public abstract UserVO mypage(String id) throws Exception;
	public abstract void delete(String id) throws Exception;
	public abstract void update(UserVO userVO) throws Exception;
	public abstract UserVO idfind(UserVO dto) throws Exception;
	public abstract UserVO pwfind(UserVO dto) throws Exception;
	
	
	public abstract void firstUserInfo(String id) throws Exception;
	public abstract void cashcharge(UserInfoVO vo) throws Exception;
	public abstract UserInfoVO userInfo(String id) throws Exception;
	
	
	public abstract void addMileage(UserInfoVO vo) throws Exception;
	public abstract void minusCash(UserInfoVO vo) throws Exception;
	public abstract void minusMileage(UserInfoVO vo) throws Exception;
	
}
