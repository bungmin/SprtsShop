package kr.co.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.domain.AgeGraphVO;
import kr.co.domain.BoardVO;
import kr.co.domain.StateVO;
import kr.co.domain.UserVO;
import kr.co.domain.VisitVO;
import kr.co.service.UserManageService;

@RestController
@RequestMapping("/memberLog")
public class UserManageRestController {
	
	@Inject
	UserManageService service;
	
	@ResponseBody
	@RequestMapping(value="/day", method=RequestMethod.GET)
	public List<VisitVO> list_d() throws Exception{
		
			List<VisitVO> list=service.visitLog_D();
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/month", method=RequestMethod.GET)
	public List<VisitVO> list_m() throws Exception{
		
	
		System.out.println("AAAAAAAAAAA");
		List<VisitVO> list = service.visitLog_M();
		System.out.println("AAAAAAAAAAA");
				
		
		//List<VisitVO> list = null;
		
		return list;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/boardAnalysis", method=RequestMethod.GET)
	public List<BoardVO> list_board() throws Exception{
		
		List<BoardVO> list = service.analysisBoard();
		System.out.println("CCCCCCCCCCCCCC");
		System.out.println(list);
		System.out.println("CCCCCCCCCCCCCC");
		
		
		//List<VisitVO> list = null;
		
		return list;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/analysisAge", method=RequestMethod.GET)
	public List<AgeGraphVO> listAge() throws Exception{
		
		List<AgeGraphVO> list = service.analysisAge();
		System.out.println("CCCCCCCCCCCCCC");
		System.out.println(list);
		System.out.println("CCCCCCCCCCCCCC");
		
		
		//List<VisitVO> list = null;
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/analysisGender", method=RequestMethod.GET)
	public List<UserVO> genderAnalysis() throws Exception{
		
		List<UserVO> list = service.Analysis();
		
		//model.addAttribute("mAnalysis", mAnalysis);
		
		/*model.addAttribute("genderAnalysis", listAnalysis);*/
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/analysisState", method=RequestMethod.GET)
	public List<StateVO> stateAnalysis() throws Exception{
		
		List<StateVO> list=service.analysisState();
		
		return list;
	}
}
