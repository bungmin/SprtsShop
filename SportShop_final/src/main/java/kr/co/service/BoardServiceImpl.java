package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.BoardVO;
import kr.co.domain.Criteria;
import kr.co.domain.SearchCriteria;
import kr.co.persistence.BoardDAO;
import kr.co.persistence.ReplyDAO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	BoardDAO dao;
	
	@Inject
	ReplyDAO rDao;

	
	@Transactional
	@Override
	public void create(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		//서비스는 dao랑 접촉을 해야함.
		dao.create(vo);
		
		String[] files= vo.getFiles();
		if(files==null){
			return;
		}
		
		for(String fullName:files){
			dao.addAttach(fullName, vo.getBno());
		}
		
	}

	
	@Override
	public BoardVO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		
		return dao.read(bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	
	@Transactional
	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub
		
		dao.deleteAllAttach(bno);
		
		
		rDao.deleteAllByBno(bno);
		
		
		//삭제가 되기전에.......
		//attach 테이블과 관련된거 다 지우고
		//reply 테이블과 관련된거 다 지우고
		
		
		dao.delete(bno);

		
		
		
	}

	
	@Transactional
	@Override
	public void update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		dao.update(vo);		
		
		
		dao.deleteAllAttach(vo.getBno());
		//다 삭제한다음에 다시 추가할것임..
		
		String[] files= vo.getFiles();
		if(files==null){
			return;
		}
		
		for(String fullName:files){
			dao.addAttach(fullName, vo.getBno());
		}
	}

	@Override
	public int getBno() throws Exception {
		// TODO Auto-generated method stub
		return dao.getBno();
	}

	@Override
	public void addViewCnt(int bno) throws Exception {
		// TODO Auto-generated method stub
		
		dao.addViewCnt(bno);
		
	}



	@Override
	public int totalCount() throws Exception {
		// TODO Auto-generated method stub
		Integer i = dao.totalCount();
		
		if(i == null){
			return 0;
		}
		return i;
	}

	@Override
	public List<BoardVO> listSearch(SearchCriteria cri,String orderType) throws Exception {
		// TODO Auto-generated method stub
		
		//this.getReplyCnt();
		
		return dao.listSearch(cri,orderType);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSearchCount(cri);
	}


	@Override
	public List<String> getAttach(int bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.getAttach(bno);
	}


	@Override
	public void deleteAttach(String fullName, int bno) throws Exception {
		// TODO Auto-generated method stub
		
		dao.deleteAttach(fullName, bno);
		
	}




	@Override
	public List<BoardVO> listCriteria(Criteria cri, String orderType) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCriteria(cri,orderType);
	}


	@Override
	public List<BoardVO> basketballBoard(Criteria cri, String orderType) throws Exception {
		// TODO Auto-generated method stub
		return dao.basketballBoard(cri,orderType);
	}


	@Override
	public List<BoardVO> baseballBoard(Criteria cri, String orderType) throws Exception {
		// TODO Auto-generated method stub
		return dao.baseballBoard(cri,orderType);
	}


	@Override
	public List<BoardVO> soccerBoard(Criteria cri, String orderType) throws Exception {
		// TODO Auto-generated method stub
		return dao.soccerBoard(cri,orderType);
	}


	@Override
	public List<BoardVO> listSearch(SearchCriteria cri, String category, String orderType) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSearch(cri, category,orderType);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	@Override
	public int listSearchCount(SearchCriteria cri, String category) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSearchCount(cri, category);
	}


	@Override
	public List<BoardVO> myList(String id) {
		// TODO Auto-generated method stub
		return dao.myList(id);
	}


	@Override
	public List<BoardVO> notice() {
		// TODO Auto-generated method stub
		return dao.notice();
	}


	@Override
	public List<BoardVO> soccer() {
		// TODO Auto-generated method stub
		return dao.soccer();
	}


	@Override
	public List<BoardVO> baseball() {
		// TODO Auto-generated method stub
		return dao.baseball();
	}


	@Override
	public List<BoardVO> basketball() {
		// TODO Auto-generated method stub
		return dao.basketball();
	}


	@Override
	public List<BoardVO> allBoard() {
		// TODO Auto-generated method stub
		return dao.allBoard();
	}
	







/*	@Override
	public void getReplyCnt() throws Exception {
		// TODO Auto-generated method stub
		
		dao.getReplyCnt();
		
	}*/

}
