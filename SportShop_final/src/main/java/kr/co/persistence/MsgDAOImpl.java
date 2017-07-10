package kr.co.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.Criteria;
import kr.co.domain.MsgVO;

@Repository
public class MsgDAOImpl implements MsgDAO {

	@Inject
	private SqlSession session;

	private final String NAMESPACE = "kr.co.mapper.MsgMapper";

	@Override
	public void create(MsgVO vo) throws Exception {
		// TODO Auto-generated method stub

		session.insert(NAMESPACE + ".create", vo);

	}

	@Override
	public int getMno() throws Exception {
		// TODO Auto-generated method stub
		Integer maxMno = session.selectOne(NAMESPACE + ".getMno");

		if (maxMno == null) {
			maxMno = 0;
		}

		return maxMno + 1;
	}

	@Override
	public List<MsgVO> listAll(String id) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".listAll", id);
	}

	@Override
	public List<MsgVO> listAllAdmin() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".listAllAdmin");
	}

	@Override
	public void replyCheckUpdate(int mno) throws Exception {
		// TODO Auto-generated method stub
		session.update(NAMESPACE+".replyUpdate", mno);
	}

	@Override
	public List<MsgVO> listCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
	/*	Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("cri", cri);
		map.put("id", id);*/
		
		return session.selectList(NAMESPACE+".listCriteria", cri);
	}

	@Override
	public int totalCount() throws Exception {
		// TODO Auto-generated method stub
	
		Integer i =session.selectOne(NAMESPACE+".totalCount");
		
		if(i==null){
			return 0;
		}
		
		return i;
	}

	@Override
	public List<MsgVO> listCriteriaUser(Criteria cri, String id) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("cri", cri);
		map.put("id", id);
		
		return session.selectList(NAMESPACE+".listCriteriaUser", map);
	}

	@Override
	public int totalCountUser(String id) throws Exception {
		// TODO Auto-generated method stub
	Integer i =session.selectOne(NAMESPACE+".totalCountUser", id);
		
		if(i==null){
			return 0;
		}
		
		return i;
	}

	@Override
	public void deletById(String id) throws Exception {
		// TODO Auto-generated method stub
		
		session.delete(NAMESPACE+".deletById", id);
	}

}
