package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.AttachVO;
import kr.co.persistence.AttchDAO;

@Service
public class AttachServiceImpl implements AttachService {
	
	@Inject
	AttchDAO dao;

	
	@Override
	public List<AttachVO> getAttach(int bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.getAttach(bno);
	}
	
}
