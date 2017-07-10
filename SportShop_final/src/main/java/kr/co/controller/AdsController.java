package kr.co.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.domain.AdsVO;
import kr.co.domain.BoardVO;
import kr.co.domain.ProductCriteria;
import kr.co.domain.ReplyVO;
import kr.co.service.AdsService;

@Controller
@RequestMapping("/ads/*")
public class AdsController {

	/*@Inject
	private BoardService service;
	
	@Resource(name="uploadPath")
	private String uploadPath;
*/
	/*@Inject
	private AdsService service;*/
	
	@Inject
	private AdsService service;
	
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public void createGet() throws Exception {

		System.out.println("입력 화면으로 넘어감.");
		System.out.println("path : ads/create.jsp");

		/*
		 * model.addAttribute("page", cri.getPage());
		 * model.addAttribute("perPageNum", cri.getPerPageNum());
		 */

	}
	
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String createPost(AdsVO vo) throws Exception {		
	
		System.out.println("+++++++++++++++++++");

		System.out.println("000000000000");
		int ano = service.getAno();
		
		
		
		vo.setAno(ano);
		
		System.out.println("_________________");
		
		vo.setRegister("false");
		
		System.out.println(vo);

		service.insertAds(vo);

		return "redirect:/ads/list";

	}
	
	
	@RequestMapping(value="list", method =  RequestMethod.GET)
	public void list() throws Exception{		
		
		
		
	}
	
	@RequestMapping(value = "updateads", method = RequestMethod.GET)
	public void updateGet(@RequestParam("ano") String ano, Model model)
			throws Exception {
		System.out.println(ano);
		System.out.println("*********");
		System.out.println(ano);
		
		int iAno=Integer.valueOf(ano);
		System.out.println(iAno);
		AdsVO vo = service.readAds(iAno);
		model.addAttribute("vo", vo);
	}
	
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updatePost(AdsVO vo) throws Exception {
		/* 작업이 끝나고 난다음에, listAll로 갈것임. */

		service.update(vo);
		
		//service.deleteAttach();
		System.out.println("++++++++++++++++++");
		System.out.println(vo);
		
		return "redirect:/ads/list";

	}
	

	
	
	
	

}
