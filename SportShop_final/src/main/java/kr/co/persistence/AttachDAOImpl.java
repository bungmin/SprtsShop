package kr.co.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.AttachVO;
import kr.co.domain.BoardVO;
import kr.co.domain.ProductCriteria;
import kr.co.domain.ProductSearchCriteria;

@Repository
public class AttachDAOImpl implements AttchDAO {
	
	@Inject
	private SqlSession session;
	
	private final String NAMESPACE= "kr.co.mapper.AttachMapper";


	@Override
	public List<AttachVO> getAttach(int bno) throws Exception {
		// TODO Auto-generated method stub
		
		return session.selectList(NAMESPACE+".getAttach", bno);
	}
}
