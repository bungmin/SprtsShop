package kr.co.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.AdsVO;

@Repository
public class AdsDAOImpl implements AdsDAO {
	
	@Inject
	private SqlSession session;
	
	private final String NAMESPACE= "kr.co.mapper.AdsMapper";

	/*새로운 bno 만들기*/
	@Override
	public int getAno() throws Exception {
		// TODO Auto-generated method stub		
		Integer maxAno=session.selectOne(NAMESPACE+".getAno");
		
		if(maxAno==null){
			maxAno=0;			
		}
		
		return maxAno+1;
	}

	@Override
	public void insertAds(AdsVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(NAMESPACE+".insertAds", vo);
		
	}

	@Override
	public List<AdsVO> listads() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".listads");
	}

	@Override
	public void delete(int ano) throws Exception {
		// TODO Auto-generated method stub
		
		session.delete(NAMESPACE+".delete", ano);
		
	}

	@Override
	public void registerAds(int ano) throws Exception {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ano", ano);
		map.put("register", "true");
		
		session.update(NAMESPACE+".registerAds", map);
		
	}
	
	@Override
	public void deleteAds(int ano) throws Exception {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ano", ano);
		map.put("register", "false");
		
		session.update(NAMESPACE+".registerAds", map);
		
	}

	@Override
	public List<AdsVO> registerdListAds() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".registedListAds");
	}

	@Override
	public void addReadCnt(int ano) throws Exception {
		// TODO Auto-generated method stub
		
		session.update(NAMESPACE+".addreadcnt", ano);
		
		
	}

	@Override
	public AdsVO readAds(int ano) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("^^^^^^^^^");
		System.out.println(ano);
		
		return session.selectOne(NAMESPACE+".readAds", ano);
	}

	@Override
	public void update(AdsVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		session.update(NAMESPACE+".update", vo);
		
	}

	@Override
	public void deletById(String id) throws Exception {
		// TODO Auto-generated method stub
		
		
		session.delete(NAMESPACE+".deletById", id);
		
	}


}
