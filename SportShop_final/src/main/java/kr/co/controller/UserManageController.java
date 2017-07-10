package kr.co.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.domain.UserVO;
import kr.co.service.UserManageService;

@Controller
@RequestMapping("/usermanage")
public class UserManageController {
	
	@Inject
	private UserManageService service;
	
	@RequestMapping(value="/usercheck", method=RequestMethod.GET)
	public void usercheck(Model model) throws Exception{
		List<UserVO> listUser = service.userList();
		
		System.out.println("----------------------------------------");
		System.out.println(listUser);
		System.out.println("----------------------------------------");
		
		model.addAttribute("listUser", listUser);
		
	}
	
	
	@RequestMapping(value="/todayUser", method=RequestMethod.GET)
	public void todayUser(Model model) throws Exception{
		//List<UserVO> listUser = service.userList();
		
		List<UserVO> listUser = service.memberToday();
		
		System.out.println("----------------------------------------");
		System.out.println(listUser);
		System.out.println("----------------------------------------");
		
		model.addAttribute("listUser", listUser);
		
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String userDelete(String id) throws Exception{
		
		service.delete(id);
		
		return "redirect:/usermanage/usercheck";
	}
	
	@RequestMapping(value="/manalysis", method=RequestMethod.GET)
	public void mAnalysis(Model model) throws Exception{
		
		List<UserVO> mAnalysis = service.Analysis();
		
		model.addAttribute("mAnalysis", mAnalysis);
		
		/*model.addAttribute("genderAnalysis", listAnalysis);*/
	}
	
	@RequestMapping(value="/visitlog_D", method=RequestMethod.GET)
	public void visitlog_D() throws Exception{
	/*	List<VisitVO> visitlog_M = service.visitLog_M();
		
		model.addAttribute("visitlog_M", visitlog_M);*/
	}
	@RequestMapping(value="/visitlog_M", method=RequestMethod.GET)
	public void visitlog_M() throws Exception{
	
	}
	@RequestMapping(value="/visitlog_Age", method=RequestMethod.GET)
	public void visitlog_Age(Model model) throws Exception{
		/*List<VisitVO> visitlog = service.visitLog();
		
		model.addAttribute("visitlog", visitlog);*/
	}
	
	@RequestMapping(value="/analysisBoard" , method=RequestMethod.GET)
	public void analysisBoard() throws Exception{
		/*List<VisitVO> visitlog = service.visitLog();
		
		model.addAttribute("visitlog", visitlog);*/
	}
}
