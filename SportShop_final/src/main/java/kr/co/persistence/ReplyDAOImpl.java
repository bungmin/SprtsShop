package kr.co.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.Criteria;
import kr.co.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	private SqlSession session;

	private final String NAMESPACE = "kr.co.mapper.ReplyMapper";

	@Override
	public List<ReplyVO> list(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE + ".list", bno);
	}

	@Override
	public void create(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub

		vo.setRno(getRno());

		session.insert(NAMESPACE + ".create", vo);

	}

	@Override
	public int getRno() throws Exception {
		// TODO Auto-generated method stub
		Integer rno =session.selectOne(NAMESPACE + ".getRno");
		if(rno == null){
			rno = 0;
		}
		
		return ++rno; 
	}

	@Override
	public void update(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub

		session.update(NAMESPACE + ".update", vo);

	}

	@Override
	public void delete(Integer rno) throws Exception {
		// TODO Auto-generated method stub

		session.delete(NAMESPACE + ".delete", rno);

	}

	@Override
	public List<ReplyVO> listPage(Integer bno, Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("bno", bno);
		map.put("startrow", cri.getStartRow());		
		map.put("endrow", cri.getEndRow());		
		
		//map.put("cri", cri);
		//map.put("cri", cri); 이렇게 하면 xml 파일에 cri.startRow cri.endRow 해야됨......
		
		return session.selectList(NAMESPACE+".listPage", map);
	}

	@Override
	public int count(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		Integer count = session.selectOne(NAMESPACE+".count", bno);
		
		if(count == null){
			return 0;
		}

		return count;
	}

	
	@Override
	public int getBno(Integer rno) throws Exception {
		// TODO Auto-generated method stub
		
		/*Integer count =session.selectOne(NAMESPACE+".getBno", rno);
		
		if(count == null){
			return 0;
		}		*/
		
		return session.selectOne(NAMESPACE+".getBno", rno);
	}

	@Override
	public void deleteAllByBno(int bno) throws Exception {
		// TODO Auto-generated method stub
		
		session.delete(NAMESPACE+".deleteByBno",bno);
		
	}

	
}
