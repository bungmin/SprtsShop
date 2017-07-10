package kr.co.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.ReplyVO;
import kr.co.domain.ReviewCriteria;
import kr.co.domain.ReviewVO;

@Repository
public class ReviewDAOImpl implements ReviewDAO {
	
	@Inject
	private SqlSession session;

	private final String NAMESPACE = "kr.co.mapper.ReviewMapper";


	@Override
	public int getRevno() throws Exception {
		// TODO Auto-generated method stub
		Integer maxRevno = session.selectOne(NAMESPACE+".getRevno");
		
		if(maxRevno  == null){
			maxRevno  = 0;
		}
		return maxRevno +1;
	}

	@Override
	public void reviewInsert(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub

		//vo.setRno(getRno());
		
		/*vo.setPno();*/

		session.insert(NAMESPACE + ".create", vo);
	}

	@Override
	public List<ReviewVO> listPage(Integer pno, ReviewCriteria cri) throws Exception {
		// TODO Auto-generated method stub
	Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pno", pno);
		map.put("startRow", cri.getStartRow());		
		map.put("endRow", cri.getEndRow());		
		
		//
		
		return session.selectList(NAMESPACE+".listPage", map);
	}

	@Override
	public int count(Integer pno) throws Exception {
		// TODO Auto-generated method stub
		Integer count = session.selectOne(NAMESPACE+".count", pno);
		
		if(count == null){
			return 0;
		}

		return count;
	}

	@Override
	public void update(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		
		session.update(NAMESPACE + ".update", vo);
		
	}

	@Override
	public void delete(Integer revno) throws Exception {
		// TODO Auto-generated method stub
		session.delete(NAMESPACE + ".delete", revno);
	}
	
	@Override
	public List<ReviewVO> myReview(String id) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".myReview", id);
	}

	@Override
	public void deleteByPno(Integer pno) throws Exception {
		// TODO Auto-generated method stub
		
		session.delete(NAMESPACE+".deleteByPno", pno);
		
	}

	@Override
	public void deletById(String id) throws Exception {
		// TODO Auto-generated method stub
		
		session.delete(NAMESPACE+".deletById", id);
	}

}
