package kr.co.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.Criteria;
import kr.co.domain.OwnerPageVO;
import kr.co.domain.ProductCriteria;
import kr.co.domain.ProductSearchCriteria;
import kr.co.domain.ProductVO;

@Repository
public class ProductDAOImpl implements ProductDAO{

	@Inject
	private SqlSession session;
	
	private final String NAMESPACE= "kr.co.mapper.ProductMapper";
	
	@Override
	public void insertProduct(ProductVO vo) throws Exception {
		
		session.insert(NAMESPACE+".insertProduct", vo);
	}

	@Override
	public int getPno() throws Exception {
		// TODO Auto-generated method stub
		 Integer maxPno = session.selectOne(NAMESPACE+".getPno");
		
		 if (maxPno == null) {
			maxPno = 0;
		}
		 
		 return maxPno+1;
	}

	@Override
	public List<ProductVO> ListAllProduct() throws Exception {
		
		
		return session.selectList(NAMESPACE+".listAllProduct");
	}
	
	@Override
	public void updateProduct(ProductVO vo) throws Exception {
		
		session.update(NAMESPACE+".updateProduct", vo);
	}

	@Override
	public ProductVO readProduct(int pno) {
		// TODO Auto-generated method stub
		return session.selectOne(NAMESPACE+".readProduct", pno);
	
	}

	@Override
	public void deleteProduct(int pno) {
		
		session.delete(NAMESPACE+".deleteProduct", pno);
		
	}

	@Override
	public List<ProductVO> listCriteria(ProductCriteria cri) {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".listCriteria", cri);
	}

	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		Integer i =session.selectOne(NAMESPACE+".totalCount");
		
		if(i==null){
			return 0;
		}
		
		return i;
	}

	@Override
	public int listSearchCount(ProductSearchCriteria cri, String category) throws Exception {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<String, Object>();
			
		
		if(category == null){
			category = "";
		}else{
			if(category.equalsIgnoreCase("all")){
				category = "";
			}else if(category.equalsIgnoreCase("soccer")){
				category = "where p_category='soccer'";			
			}else if(category.equalsIgnoreCase("baseball")){
				category = "where p_category='baseball'";			
			}else if(category.equalsIgnoreCase("basketball")){
				category = "where p_category='basketball'";			
			}	
		}
		
		
		System.out.println("***********");
		System.out.println(category);		
		
		map.put("cri", cri);
		map.put("category", category);	
		
	
		Integer cnt = session.selectOne(NAMESPACE+".listSearchCount", map);
		
		System.out.println(cnt);
		System.out.println("))))))))))))))))))))))");
		
		if(cnt == null){
			return 0;
		}
		
		
		return cnt;
	}

	@Override
	public List<ProductVO> listSearch(ProductSearchCriteria cri,String category, String orderType) throws Exception {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
		
		String order = null;
		
		if(orderType == null){
			order = "order by p_price asc";
		}else{
			if(orderType.equals("lowprice")){
				order = "order by p_price asc";				
			}else if(orderType.equals("highprice")){
				order = "order by p_price desc";
			}else if(orderType.equals("lowgoocnt")){
				order = "order by p_goodcnt desc";
			}else if(orderType.equals("highgoocnt")){
				order = "order by p_goodcnt desc";
			}else if(orderType.equals("lowdiscount")){
				order = "order by p_discount_rate desc";
			}else if(orderType.equals("highdiscount")){
				order = "order by p_discount_rate desc";
			}
			
		}
		
		/*="text-center"
				 ${pageMaker.cri.orderType =='lowgoocnt'?'selected':'' } value="lowprice">낮은 추천순</option>
			<option class="text-center"
				 ${pageMaker.cri.orderType =='highgoocnt'?'selected':'' } value="highprice">높은 추천순
				</option>
			<option class="text-center"
				 ${pageMaker.cri.orderType =='lowdiscount'?'selected':'' } value="lowprice">낮은 할인순</option>
			<option class="text-center"
				 ${pageMaker.cri.orderType =='highdiscount
		*/
		
		if(category == null){
			category = "";
		}else{
			if(category.equalsIgnoreCase("all")){
				category = "";
			}else if(category.equalsIgnoreCase("soccer")){
				category = "where p_category = 'soccer'";			
			}else if(category.equalsIgnoreCase("baseball")){
				category = "where p_category = 'baseball'";			
			}else if(category.equalsIgnoreCase("basketball")){
				category = "where p_category = 'basketball'";			
			}	
		}
		
		
		System.out.println("((((((((((((((((((");
		System.out.println(category);		
		
		map.put("cri", cri);
		map.put("category", category);
		map.put("order", order);
		
		System.out.println("(((((((((((((((((((");
		System.out.println(cri);
		System.out.println(category);

		return session.selectList(NAMESPACE+".listSearch",  map);
	}

	@Override
	public List<ProductVO> SoccerProList() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".SoccerProList");
	}

	@Override
	public List<ProductVO> baseBallList() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".baseBallList");
	}

	@Override
	public List<ProductVO> basketBallList() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".baseketBallList");
	}

	@Override
	public void addViewCnt(int pno) throws Exception {
		// TODO Auto-generated method stub
		session.update(NAMESPACE+".addviewcnt", pno);
		
	}

	@Override
	public void addGoodCnt(int pno) throws Exception {
		// TODO Auto-generated method stub
		
		session.update(NAMESPACE+".addgoodcnt", pno);
	}

	@Override
	public List<ProductVO> listCriteriaAdmin(Criteria cri) {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".listCriteriaAdmin", cri);
	}

	@Override
	public void amountBalance(ProductVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		session.update(NAMESPACE+".amountBalance", vo);
		
	}

	@Override
	public void deletById(String id) throws Exception {
		// TODO Auto-generated method stub
		
		session.delete(NAMESPACE+".deletById", id);
	}
	
	@Override
	public void insertOwnerPage(OwnerPageVO opvo) {
		session.insert(NAMESPACE + ".insertOwnerPage", opvo);
		
	}

	@Override
	public int getOpnum() throws Exception {
		Integer maxOpnum = session.selectOne(NAMESPACE+".getOpnum");
		
		if (maxOpnum == null) {
			maxOpnum = 0;
		}
		
		return maxOpnum+1;
	}

	@Override
	public void insertOwnerPage2(OwnerPageVO opvo) throws Exception {
		
		session.update(NAMESPACE+ ".insertOwnerPage2", opvo);
	}

	@Override
	public OwnerPageVO getBeforeInfo(int opnum) throws Exception {
		return session.selectOne(NAMESPACE + ".getBeforeInfo", opnum);
	
	}
	
	
}
