package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.Criteria;
import kr.co.domain.ReplyVO;
import kr.co.persistence.BoardDAO;
import kr.co.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Inject
	private ReplyDAO dao;
	
	@Inject
	private BoardDAO bDao;
	

	@Override
	public List<ReplyVO> list(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.list(bno);
	}

	
	
	@Transactional
	@Override
	public void create(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		dao.create(vo);
		
		//댓글이 등록이 되면  bdao의 증가해야됨. replyCnt 값이 1이 증가해야됨...... 그리고  transaction 작업
		bDao.updateReplyCnt(vo.getBno(), 1);
		
		

	}

	@Override
	public int getRno() throws Exception {
		// TODO Auto-generated method stub
		
		return dao.getRno();
	}

	@Override
	public void update(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		dao.update(vo);

	}

	
	@Transactional
	@Override
	public void delete(Integer rno) throws Exception {
		// TODO Auto-generated method stub

		int bno = dao.getBno(rno);
		
		//int bno = dao.getBno(rno);
		/*일단은 삭제 될 bno값을 가져온다음에*/ 

		dao.delete(rno);
		
		bDao.updateReplyCnt(bno, -1);
		
		
		
	}

	
	
	@Override
	public List<ReplyVO> listPage(Integer bno, Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listPage(bno, cri);
	}

	@Override
	public int count(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		
	/*	Integer count = dao.count(bno);
		if(count == null){
			count = 0;
		}
		*/
		
		return dao.count(bno);
	}

}
