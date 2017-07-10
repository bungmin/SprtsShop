package kr.co.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.BoardVO;
import kr.co.domain.Criteria;
import kr.co.domain.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession session;
	
	private final String NAMESPACE= "kr.co.mapper.BoardMapper";

	@Override
	public void create(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		
		/*위에 메서드를 하나 더 만들어서 bno 올려주는것을 해줄꺼임.*/
		/*근데 vo를 넣어줘야하는데 bno를 넣어주는게 없음 일단 나중에*/		
		session.insert(NAMESPACE+".create", vo);

	}

	@Override
	public BoardVO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(NAMESPACE+".read", bno);
	}
	
	@Override
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".listAll");
	}

	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub
		
		session.delete(NAMESPACE+".delete", bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		session.update(NAMESPACE+".update", vo);

	}

	/*새로운 bno 만들기*/
	@Override
	public int getBno() throws Exception {
		// TODO Auto-generated method stub		
		Integer maxBno=session.selectOne(NAMESPACE+".getBno");
		
		if(maxBno==null){
			maxBno=0;			
		}
		
		return maxBno+1;
	}

	@Override
	public void addViewCnt(int bno) throws Exception {
		// TODO Auto-generated method stub		
		session.update(NAMESPACE+".addviewcnt", bno);		
	}

	@Override
	public List<BoardVO> listPage(int page/*, int displayPerPageCount*/) throws Exception {
		// TODO Auto-generated method stub
			
		int displayPerPageCount = 10;	

		int startRow = (page-1)* displayPerPageCount + 1;
		int endRow = startRow+(displayPerPageCount-1);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startrow", startRow);
		map.put("endrow", endRow);
		
		return session.selectList(NAMESPACE+".listPage", map);
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri,String orderType) throws Exception {
		// TODO Auto-generated method stub
		/*int startRow=cri.getStartRow();
		int endRow = cri.getEndRow();*/
		
		//		Map<"", V>
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("cri", cri);
		
		if(orderType == null){
			orderType = "order by bno desc";
		}else{
			if(orderType.equalsIgnoreCase("old")){
				orderType = "order by bno asc";			
			}else if(orderType.equalsIgnoreCase("recently")){
				orderType = "order by bno desc";
			}else if(orderType.equalsIgnoreCase("countasc")){
				orderType = "order by viewcnt asc";
			}else if(orderType.equalsIgnoreCase("countdesc")){
				orderType = "order by viewcnt desc";
			}			
		}
			
		map.put("orderType", orderType);
		
		
		return session.selectList(NAMESPACE+".listCriteria", map);

		
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
	public int listSearchCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		Integer cnt = session.selectOne(NAMESPACE+".listSearchCount", cri);
		
		if(cnt == null){
			return 0;
		}
		
		
		return cnt;
	}

	@Override
	public List<BoardVO> listSearch(SearchCriteria cri,String orderType) throws Exception {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("cri", cri);
		
		if(orderType == null){
			orderType = "order by bno desc";
		}else{
			if(orderType.equalsIgnoreCase("old")){
				orderType = "order by bno asc";			
			}else if(orderType.equalsIgnoreCase("recently")){
				orderType = "order by bno desc";
			}else if(orderType.equalsIgnoreCase("countasc")){
				orderType = "order by viewcnt asc";
			}else if(orderType.equalsIgnoreCase("countdesc")){
				orderType = "order by viewcnt desc";
			}			
		}
			
		map.put("orderType", orderType);
	

		return session.selectList(NAMESPACE+".listSearch",  map);
	}

	@Override
	public void updateReplyCnt(int bno, int amount) throws Exception {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		
		/*amount는 replyCnt값에 더해주어야할 값임*/
		
		map.put("amount", amount);
		
		session.update(NAMESPACE+".updateReplyCnt", map);
		
	}

	@Override
	public void addAttach(String fullName, int bno) throws Exception {
		// TODO Auto-generated method stub
		
		//int id= getId();
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("fullName", fullName);
		map.put("bno", bno);		
		
		
		session.insert(NAMESPACE+".addAttach", map);
		
	}
	
	public int getId() throws Exception{		
		Integer id =session.selectOne(NAMESPACE+".getId");
		
		if(id == null){
			id =0;
		}
		
		return ++id;
	}

	@Override
	public List<String> getAttach(int bno) throws Exception {
		// TODO Auto-generated method stub		
		
		return session.selectList(NAMESPACE+".getAttach", bno);
	}

	@Override
	public void deleteAllAttach(int bno) throws Exception {
		// TODO Auto-generated method stub
		
		session.delete(NAMESPACE+".deleteAllAttach", bno);
		
	}

	@Override
	public void deleteAttach(String fullName, int bno) throws Exception {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fullName", fullName);
		map.put("bno", bno);
		
		session.delete(NAMESPACE+".deleteAttach", map);
		
		
	}



	@Override
	public List<BoardVO> basketballBoard(Criteria cri, String orderType) throws Exception {
		// TODO Auto-generated method stub	
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("cri", cri);
		
		if(orderType == null){
			orderType = "order by bno desc";
		}else{
			if(orderType.equalsIgnoreCase("old")){
				orderType = "order by bno asc";			
			}else if(orderType.equalsIgnoreCase("recently")){
				orderType = "order by bno desc";
			}else if(orderType.equalsIgnoreCase("countasc")){
				orderType = "order by viewcnt asc";
			}else if(orderType.equalsIgnoreCase("countdesc")){
				orderType = "order by viewcnt desc";
			}			
		}
			
		map.put("orderType", orderType);
		
		
		return session.selectList(NAMESPACE+".basketballBoard", map);
	}

	@Override
	public List<BoardVO> baseballBoard(Criteria cri, String orderType) throws Exception {
		// TODO Auto-generated method stub	
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("cri", cri);
		
		if(orderType == null){
			orderType = "order by bno desc";
		}else{
			if(orderType.equalsIgnoreCase("old")){
				orderType = "order by bno asc";			
			}else if(orderType.equalsIgnoreCase("recently")){
				orderType = "order by bno desc";
			}else if(orderType.equalsIgnoreCase("countasc")){
				orderType = "order by viewcnt asc";
			}else if(orderType.equalsIgnoreCase("countdesc")){
				orderType = "order by viewcnt desc";
			}			
		}
			
		map.put("orderType", orderType);
		
		
		return session.selectList(NAMESPACE+".baseballBoard", map);
	}

	@Override
	public List<BoardVO> soccerBoard(Criteria cri, String orderType) throws Exception {
		// TODO Auto-generated method stub	
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("cri", cri);
		
		if(orderType == null){
			orderType = "order by bno desc";
		}else{
			if(orderType.equalsIgnoreCase("old")){
				orderType = "order by bno asc";			
			}else if(orderType.equalsIgnoreCase("recently")){
				orderType = "order by bno desc";
			}else if(orderType.equalsIgnoreCase("countasc")){
				orderType = "order by viewcnt asc";
			}else if(orderType.equalsIgnoreCase("countdesc")){
				orderType = "order by viewcnt desc";
			}			
		}
			
		map.put("orderType", orderType);
		
		
		return session.selectList(NAMESPACE+".soccerBoard", map);
	}

	@Override
	public List<BoardVO> listSearch(SearchCriteria cri, String category, String orderType) throws Exception {
		// TODO Auto-generated method stub
Map<String, Object> map = new HashMap<String, Object>();
		
		String order = null;
		
		if(orderType == null){
			order = "order by bno desc";
		}else{
			if(orderType.equals("old")){
				order = "order by bno asc";				
			}else if(orderType.equals("recently")){
				order = "order by bno desc";
			}else if(orderType.equals("countasc")){
				order = "order by viewcnt asc";
			}else if(orderType.equals("countdesc")){
				order = "order by viewcnt desc";
			}
			
		}			
		
		if(category == null){
			category = "";
		}else{
			if(category.equalsIgnoreCase("notice")){
				category = "where category = 'notice'";
			}else if(category.equalsIgnoreCase("soccer")){
				category = "where category = 'soccer'";			
			}else if(category.equalsIgnoreCase("baseball")){
				category = "where category = 'baseball'";			
			}else if(category.equalsIgnoreCase("basketball")){
				category = "where category = 'basketball'";			
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
	public int listSearchCount(SearchCriteria cri, String category) throws Exception {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
			
		
		if(category == null){
			category = "";
		}else{
			if(category.equalsIgnoreCase("notice")){
				category = "where category='notice'";
			}else if(category.equalsIgnoreCase("soccer")){
				category = "where category='soccer'";			
			}else if(category.equalsIgnoreCase("baseball")){
				category = "where category='baseball'";			
			}else if(category.equalsIgnoreCase("basketball")){
				category = "where category='basketball'";			
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
	public List<BoardVO> myList(String id) {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".myList", id);
	}

	@Override
	public List<BoardVO> notice() {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".notice");
	}

	@Override
	public List<BoardVO> soccer() {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".soccer");
	}

	@Override
	public List<BoardVO> baseball() {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".baseball");
	}

	@Override
	public List<BoardVO> basketball() {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".basketball");
	}

	@Override
	public List<BoardVO> allBoard() {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".allBoard");
	}

	@Override
	public void deletById(String id) throws Exception {
		// TODO Auto-generated method stub
		
		session.delete(NAMESPACE+".deletById", id);
	}


	

}
