package kr.co.service;

import java.util.List;

import kr.co.domain.AttachVO;

public interface AttachService {
	
	public abstract List<AttachVO> getAttach(int bno) throws Exception;
	
	
}
