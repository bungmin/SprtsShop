package kr.co.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.domain.BoardVO;
import kr.co.domain.Criteria;
import kr.co.domain.PageMaker;
import kr.co.domain.ProductPageMaker;
import kr.co.domain.ProductSearchCriteria;
import kr.co.domain.ProductVO;
import kr.co.domain.SearchCriteria;
import kr.co.service.BoardService;
import kr.co.util.MediaUtils;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Inject
	private BoardService service;
	
	@Resource(name="uploadPath")
	private String uploadPath;

	/*
	 * 글 등록 폼: board/create, get 방식 글 등록 db: board/create, post 글 목록:
	 * board/listAll 특정글 보기 : board/read?bno=xxx 글 수정 폼: board/update?bno=xxx,
	 * get 방식 글 수정 db: board/update, post 방식 글 삭제 : board/delete, post 이거는 특정글
	 * 보기에서 글삭제를 할것임........
	 */
	
	
	@ResponseBody
	@RequestMapping("/getAttach/{bno}")
	public List<String> getAttach(@PathVariable("bno") int bno) throws Exception{
		List<String> attchList= service.getAttach(bno);
	
		//@ResponseBody  :  json 형태로 반환한다는 의미임......		
		return service.getAttach(bno);
	}
	
	
	

	// 입력폼으로 넘어간느거..
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public void createGet(@ModelAttribute("cri") Criteria cri) throws Exception {

		/*
		 * model.addAttribute("page", cri.getPage());
		 * model.addAttribute("perPageNum", cri.getPerPageNum());
		 */

	}

	// 실제 db작업
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String createPost(BoardVO vo, Criteria cri, RedirectAttributes rttr, String category) throws Exception {

		
	//	String title="title"; String content="content";
	
		System.out.println("#########");
		System.out.println(category);
		long start=System.currentTimeMillis();

	//	for (int i = 0; i < 1000; i++) {
		int bno = service.getBno();
		vo.setBno(bno);
	//	 vo.setTitle(title+i);
	//	 vo.setContent(content+i);
		// board 객체에 set해주기.............. bno값...... 에러 안나기 위해서......
	
		service.create(vo);

	//	Thread.sleep(50);

	//	}

		rttr.addFlashAttribute("msg", "INSERT_SUCCESS");
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("orderType", cri.getOrderType());

		/* redirect를 할꺼임. */
		/*
		 * redirect 하면서 성공했다는 msg를 줄거임......... 근데 실행하면 에러가 날꺼임. 이유는 create에서
		 * bno를 하지 않고 컨트롤러에서 bno를 하기로 했기 때문에,,
		 * 
		 * bno 넣어주기 작업...... int bno=service.getBno(); vo.setBno(bno);
		 */
		/* 작업이 완료되면 스크립트 나오게. */

		/*
		 * "redirect:/board/read?bno="+bno"; 이렇게 해도 되긴함.......
		 * 
		 */

		rttr.addAttribute("bno", bno);
		
		
		long end=System.currentTimeMillis();

		return "redirect:/board/read";
	}

	@RequestMapping(value = "listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		List<BoardVO> list = service.listAll();

		model.addAttribute("list", list);


	}

	@RequestMapping(value = "read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		BoardVO vo = service.read(bno);
		/*List<String> =service.getAttach(bno);*/
		//service.addViewCnt(bno);
		model.addAttribute("vo", vo);

	}

	/* update의 내용을 뿌려주는거 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void updateGet(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		BoardVO vo = service.read(bno);
		model.addAttribute("vo", vo);
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updatePost(BoardVO vo, Criteria cri, RedirectAttributes rttr) throws Exception {
		/* 작업이 끝나고 난다음에, listAll로 갈것임. */
		
		
		service.update(vo);
		//service.deleteAttach();
		rttr.addAttribute("msg", "UPDATE_SUCCESS");
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("bno", vo.getBno());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("orderType", cri.getOrderType());

		return "redirect:/board/listCriteria";

	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(@RequestParam("bno") int bno, Criteria cri, RedirectAttributes rttr) throws Exception {

		
		List<String> list = service.getAttach(bno);

		service.delete(bno);
		
		if(list != null){
			for(String fileName: list){
				String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
				
				MediaType mType= MediaUtils.getMediaType(formatName);
				
				if(mType !=null){	//이미지 파일이면
					String prefix= fileName.substring(0, 12);
					String suffix= fileName.substring(14);
					
					
					/*원본 파일 지우는거*/
					File f = new File(uploadPath+(prefix+suffix).replace('/', File.separatorChar));
					
					/*이번에는 거꾸로*/			
				//	C:\zzz/upload/2017/05/30/f45c8c72-5398-4fac-aa44-3d025e4c3d32_yoshi.jpg
					f.delete();
				}
				
				
				/*썸네일 지우는거*/
				new File(uploadPath+fileName.replace('/', File.separatorChar)).delete();
			}
		}

		rttr.addAttribute("msg", "DELETE_SUCCESS");
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("orderType", cri.getOrderType());

		return "redirect:/board/listCriteria";
	}
	
	@RequestMapping(value = "/listCriteria", method = RequestMethod.GET)
	public void listCriteria(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {

		List<BoardVO> list = service.listCriteria(cri, cri.getOrderType());
		model.addAttribute("list", list);
	
		int totalCount = service.totalCount();
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);

		model.addAttribute("pageMaker", pageMaker);

	}
	
	@RequestMapping(value = "blistCriteria", method = RequestMethod.GET)
	public String blistCriteria(Criteria cri, RedirectAttributes rttr) throws Exception {
		

		int totalCount = service.totalCount();
		PageMaker pageMaker = new PageMaker();

		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);

		rttr.addAttribute("page", pageMaker.getCri().getPage());
		rttr.addAttribute("perPageNum", pageMaker.getCri().getPerPageNum());
		rttr.addAttribute("orderType", cri.getOrderType());

		return "redirect:/board/listCriteria";
	}
	
	@RequestMapping(value = "/basketballBoard", method = RequestMethod.GET)
	public void basketballBoard(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {

		List<BoardVO> list = service.basketballBoard(cri, cri.getOrderType());
		model.addAttribute("list", list);
	
		int totalCount = service.totalCount();
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);

		model.addAttribute("pageMaker", pageMaker);

	}
	
	@RequestMapping(value = "/baseballBoard", method = RequestMethod.GET)
	public void baseballBoard(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		List<BoardVO> list = service.baseballBoard(cri, cri.getOrderType());
		model.addAttribute("list", list);
	
		int totalCount = service.totalCount();
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);

		model.addAttribute("pageMaker", pageMaker);

	}
	
	@RequestMapping(value = "/soccerBoard", method = RequestMethod.GET)
	public void soccerBoard(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {

		List<BoardVO> list = service.soccerBoard(cri, cri.getOrderType());
		model.addAttribute("list", list);
	
		int totalCount = service.totalCount();
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);

		model.addAttribute("pageMaker", pageMaker);

	}
	
	/*befroe read : read 들어가기전에 실행하겠다 의미*/
	@RequestMapping("bread")
	public String newRead(HttpServletRequest request, HttpServletResponse response, int bno, Criteria cri, RedirectAttributes rttr
			) throws Exception {
		//, int bno parameter 추가
		/* 지금은 쿠키를 배운다고 생각해라 */
		// 조금있다가 조회수 조작은 여기서 하기는 하지만

		/* 클라이언트에 있는 쿠키를 서버로 가져와야됨 request
		 * 
		 * 쿠키 200개정도 저장된다고 함....
		 */
		
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;		//하나짜리 쿠키

		/* 쿠키가 들어있을때만 */
		if (cookies != null && cookies.length > 0) {
			System.out.println("배열쿠키가 있음.");

			/* 쿠키배열있는거하고 내가 컨트롤하는거를 확인해야됨. */
			for (int i = 0; i < cookies.length; i++) {
				/* 이름이 키임 쿠키의이름이 ck */
				if (cookies[i].getName().equals("ck")) {
					cookie = cookies[i];
				}
			}
		}
		
		/*cookies 배열안에 ck가 없다는말임
		 * 그럼 처음으로 만들어줘야된다는 말임.
		 * */
		if(cookie == null){
			// new Cookie("키", "|hello|"); 값은 구분자를 넣어서 들어감... 구분자는 #이던 상관없음.. %이던..
			/*cookie = new Cookie("ck", "|hello|");*/
			cookie = new Cookie("ck", "|"+bno+"|");
			
			/*서버에서 클라이언트에게 넘겨줘야되니까 response를 써줌*/
			response.addCookie(cookie);
			
			
			/*지금 이상황은 한번도 조회를 안한 상태이기 때문에 해당 조회수를 올려줘야됨.*/
			service.addViewCnt(bno);
			
			
		}else{
			/*ck라는 이름이 이미 존재할수 도 있는경우*/
			String value=cookie.getValue();
			if(value.indexOf("|"+bno+"|")<0){
				/*쿠키가 있는 상태인데, 다른 번호의 쿠키가 없는거임. 그런상황
				 * |1||2||3|
				 * 
				 *  if문 안쪽은
				 *  
				 *  여기서 addViewCnt 쿠키가 존재하긴 한데, 다른 번호 이기 때문에
				 * */			
				
				service.addViewCnt(bno);
				
				
				/*없다는 애기임 예를들어 320번인거를 쿠키에 저장해준적이 없다는 말이 
				 * 그래서 저장해준다..
				 * */				
				value=value+"|"+bno+"|";
				
				cookie.setValue(value);
				//바뀐 값을 넣어준다........예전에는 장바구니 이런거 쿠키에다가 했었는데, 지금은 db씀.......
				response.addCookie(cookie);
			}				
		}
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("orderType", cri.getOrderType());
		rttr.addAttribute("bno", bno);


		return "redirect:/board/read";

	}	
	
	
	@ResponseBody
	@RequestMapping(value="/deleteFile", method=RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName, int bno) throws Exception{
		
		service.deleteAttach(fileName, bno);
		
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		
		MediaType mType= MediaUtils.getMediaType(formatName);
		
		if(mType !=null){	//이미지 파일이면
			String prefix= fileName.substring(0, 12);
			String suffix= fileName.substring(14);
			
			System.out.println(prefix);
			System.out.println(suffix);
			
			System.out.println("================================");
			System.out.println(fileName);
			
		
			File f = new File(uploadPath+(prefix+suffix).replace('/', File.separatorChar));
			
			f.delete();
		}
		new File(uploadPath+fileName.replace('/', File.separatorChar)).delete();
		
		return new ResponseEntity<String>("DELETE_SUCCESS", HttpStatus.OK);
		
	}
	
	
	
	@RequestMapping(value="/listSearchCriteria", method= RequestMethod.GET)
	public void listCriteria(@ModelAttribute("cri") SearchCriteria cri, String category, String orderType, Model model)throws Exception{
		
		System.out.println("+++++++++++++++++");	
		System.out.println(orderType);
		System.out.println("++++++++++++++");
	
		List<BoardVO> list=service.listSearch(cri,category,orderType);
		model.addAttribute("listAllProduct", list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
	
		int cnt = service.listSearchCount(cri, category);
		pageMaker.setTotalCount(cnt);
		
		
		model.addAttribute("pageMaker", pageMaker);

	
	}
	
	
	@ResponseBody
	@RequestMapping(value ="/notice", method=RequestMethod.GET)
	public ResponseEntity<List<BoardVO>> notice() throws Exception{
		
		ResponseEntity<List<BoardVO>> entity = null;
		
		List<BoardVO> list;
		
		try {
			
			list = service.notice();
			entity= new ResponseEntity<List<BoardVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity= new ResponseEntity<List<BoardVO>>(HttpStatus.BAD_REQUEST);
		}
		
		
		return entity;
		
		
	}
	@ResponseBody
	@RequestMapping(value ="/soccer", method=RequestMethod.GET)
	public ResponseEntity<List<BoardVO>> soccer() throws Exception{
		
		ResponseEntity<List<BoardVO>> entity = null;
		
		List<BoardVO> list;
		
		try {
			
			//list = service.notice();
			list = service.soccer();
			entity= new ResponseEntity<List<BoardVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity= new ResponseEntity<List<BoardVO>>(HttpStatus.BAD_REQUEST);
		}
		
		
		return entity;
		
		
	}
	@ResponseBody
	@RequestMapping(value ="/baseball", method=RequestMethod.GET)
	public ResponseEntity<List<BoardVO>> baseball() throws Exception{
		
		ResponseEntity<List<BoardVO>> entity = null;
		
		List<BoardVO> list;
		
		try {
			
			//list = service.notice();
			list = service.baseball();
			entity= new ResponseEntity<List<BoardVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity= new ResponseEntity<List<BoardVO>>(HttpStatus.BAD_REQUEST);
		}
		
		
		return entity;
		
		
	}
	@ResponseBody
	@RequestMapping(value ="/basketball", method=RequestMethod.GET)
	public ResponseEntity<List<BoardVO>> basketball() throws Exception{
		
		ResponseEntity<List<BoardVO>> entity = null;
		
		List<BoardVO> list;
		
		try {
			
			//list = service.notice();
			list = service.basketball();
			entity= new ResponseEntity<List<BoardVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity= new ResponseEntity<List<BoardVO>>(HttpStatus.BAD_REQUEST);
		}
		
		
		return entity;
		
		
	}
	
	
	@ResponseBody
	@RequestMapping(value ="/allBoard", method=RequestMethod.GET)
	public ResponseEntity<List<BoardVO>> allBoard() throws Exception{
		
		ResponseEntity<List<BoardVO>> entity = null;
		
		List<BoardVO> list;
		
		try {
			
			list = service.allBoard();
			//list = service.notice();
			//list = service.basketball();
			entity= new ResponseEntity<List<BoardVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity= new ResponseEntity<List<BoardVO>>(HttpStatus.BAD_REQUEST);
		}
		
		
		return entity;
		
		
	}
	

}
