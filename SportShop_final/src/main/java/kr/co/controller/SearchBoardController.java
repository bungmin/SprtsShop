package kr.co.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.domain.BoardVO;
import kr.co.domain.PageMaker;
import kr.co.domain.SearchCriteria;
import kr.co.service.BoardService;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/listCriteria", method= RequestMethod.GET)
	public void listCriteria(@ModelAttribute("cri") SearchCriteria cri, String category, String orderType, Model model)throws Exception{
		/*이거를 임시로 일단 쓸꺼임.*/
		//List<BoardVO> list=service.listCriteria(cri);
		List<BoardVO> list=service.listSearch(cri,category, orderType);
		model.addAttribute("list", list);
		
		//pageMaker
		
		System.out.println("&&&&&&");
		System.out.println(cri);
		System.out.println(list);
		System.out.println("&&&&&&");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		//int cnt = service.totalCount();
		int cnt = service.listSearchCount(cri,category);
		pageMaker.setTotalCount(cnt);
		
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("orderType", pageMaker.getCri().getOrderType());		
		model.addAttribute("page", pageMaker.getCri().getPage());
		model.addAttribute("perPageNum", pageMaker.getCri().getPerPageNum());		
		model.addAttribute("searchType", cri.getSearchType());
		model.addAttribute("keyword", cri.getKeyword());	
		model.addAttribute("category", pageMaker.getCri().getCategory());
		
		/*이거 경로	검색한 경로..
		/sboard/listCriteria.jsp*/
	
	}
	
	@RequestMapping(value = "/blistCriteria", method = RequestMethod.GET)
	public String blistCriteria(@ModelAttribute("cri")SearchCriteria cri, RedirectAttributes rttr) throws Exception {
		
		int totalCount = service.listSearchCount(cri);
		
		
		PageMaker pageMaker = new PageMaker();

		/*cri.setPage(page);
		cri.set*/
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);

		rttr.addAttribute("page", pageMaker.getCri().getPage());
		rttr.addAttribute("perPageNum", pageMaker.getCri().getPerPageNum());		
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("orderType", pageMaker.getCri().getOrderType());
		rttr.addAttribute("category", pageMaker.getCri().getCategory());

		return "redirect:/sboard/listCriteria";
	}
	

	
	//조회수 방지작업 쿠키이용.
	@RequestMapping(value="/bread")
	public String newRead(HttpServletRequest request, 
			HttpServletResponse response, int bno, SearchCriteria cri, RedirectAttributes rttr)throws Exception{
		
		Cookie[] cookies= request.getCookies();
		Cookie cookie = null;
		
		/*특정 이름이 있는지 확인*/		
		if(cookies != null && cookies.length>0){
			for(int i=0; i<cookies.length;i++){
				if(cookies[i].getName().equals("ck")){
					cookie = cookies[i];
					
				}
			}
			
		}		
		
		/*오긴 왔어도 자세히 보기를 한적이 없는경우임*/
		if(cookie==null){
			cookie= new Cookie("ck", "|"+bno+"|");
			//없으니까 새로 만들어줌. cookie를
			
			response.addCookie(cookie);
			/*클라이언트에게 쿠키 주기*/
			service.addViewCnt(bno);
		}else{
			/*읽은적이 있는 상황
			 * 1번글은 읽었지만, 2,3,4 번등의 값을 읽지 않은상황
			 * */
			
			String value = cookie.getValue();
			if(value.indexOf("|"+bno+"|")<0){
				/*0보다 작다는것은 없다는 거임*/				
				value=value+"|"+bno+"|";
				
				/*쿠키의 값을 바꾸고나서 set 해줘야됨*/
				cookie.setValue(value);
				
				
				/*마찬가지로 클라이언트에게 쿠키보내주기*/
				response.addCookie(cookie);
				
				/*조회수 올려주기*/
				service.addViewCnt(bno);
				
			}
		}
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("orderType", cri.getOrderType());
		rttr.addAttribute("category", cri.getCategory());
		
		rttr.addAttribute("bno", bno);		
				
		return "redirect:/sboard/read";
		
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, @ModelAttribute("cri") SearchCriteria cri,
			Model model
			)throws Exception{
		
		BoardVO vo=service.read(bno);
		model.addAttribute("vo", vo);
		
		//model.addAttribute(attributeName, c);
		
		
		System.out.println("sboard/read.jsp");
		
	}
	
	
	@RequestMapping(value ="/delete", method=RequestMethod.POST)
	public String delete(@RequestParam("bno")int bno, 
			SearchCriteria cri, 
			RedirectAttributes rttr)throws Exception{
		
		
		service.delete(bno);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("orderType", cri.getOrderType());
		rttr.addAttribute("category", cri.getCategory());
		
		rttr.addAttribute("msg", "DELETE_SUCCESS");
		
		return "redirect:/sboard/listCriteria";
		
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public void update(int bno, 
			@ModelAttribute("cri") SearchCriteria cri,
			Model model)throws Exception{
		
		BoardVO vo =service.read(bno);		
		model.addAttribute("vo", vo);	
		
	}
	
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updatePost(BoardVO vo, 
			 SearchCriteria cri,
			RedirectAttributes rttr)throws Exception{
		
		
		service.update(vo);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "UPDATE_SUCCESS");
		rttr.addAttribute("orderType", cri.getOrderType());
		rttr.addAttribute("category", cri.getCategory());
		
		rttr.addAttribute("bno", vo.getBno());
		
		return "redirect:/sboard/listCriteria";		
	}
	
	
	//modelattribute는 뷰만이 아니라 여기까지....
	@RequestMapping(value="/ts", method=RequestMethod.GET)
	public void tsGet(@ModelAttribute("num") int num){
		
	}
	@RequestMapping(value="/ts", method=RequestMethod.POST)
	public void tsPost(@ModelAttribute("num") int num){
		
		System.out.println(num);
	}

}
