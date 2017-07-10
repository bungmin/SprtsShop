package kr.co.controller;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.BoardVO;
import kr.co.domain.ReviewVO;
import kr.co.service.BoardService;
import kr.co.service.ReviewService;

@Controller
@RequestMapping("/myWrite")
public class MyWriteController {

/*	@Inject
	private ReplyService service;*/
	
	/*@Inject
	private ReviewService service;*/
	
	@Inject
	private BoardService service;

	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void myReview(String id,Model model) throws Exception{
		
		//List<ReviewVO> list =service.myReview(id);
		List<BoardVO> list =service.myList(id);
		
		model.addAttribute("list", list);
		
	}
	
	
	
	
	
}
