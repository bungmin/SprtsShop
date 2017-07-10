package kr.co.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.CartTestVO;
import kr.co.domain.CartVO;

@Repository
public class CartDAOImpl implements CartDAO {
	
	@Inject
	private SqlSession session;
	private final String NAMESPACE="kr.co.mapper.CartMapper";
	
	
	@Override
	public void insertCart(CartVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		session.insert(NAMESPACE+".insertCart", vo);
		
	}


	@Override
	public int getCno() throws Exception {
		Integer maxCno = session.selectOne(NAMESPACE+".getCno");
		
		if(maxCno == null){
			maxCno = 0;
		}
		return maxCno+1;
		
	}





	@Override
	public List<CartVO> ListAllCart(String id) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".listAllCart", id);
	}


	@Override
	public void updateCart(CartVO vo) {
		session.update(NAMESPACE+".updateCart", vo);
		
	}


	@Override
	public void delete(int cno) throws Exception {
		// TODO Auto-generated method stub
		session.delete(NAMESPACE+".delete", cno);
		
	}


	@Override
	public List<CartTestVO> CartView(String id) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".CartView", id);
	}
	
	@Override
	public void deleteAfterPurchase(String id) throws Exception {
		
		session.delete(NAMESPACE+".deleteAfterPurchase", id);
	}


	@Override
	public void deletById(String id) throws Exception {
		// TODO Auto-generated method stub
		
		
		session.delete(NAMESPACE+".deletById", id);
	}

}
