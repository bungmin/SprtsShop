package kr.co.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.domain.OrderInfoVO;
import kr.co.domain.OwnerPageVO;
import kr.co.domain.OwnerVO;
import kr.co.domain.UserVO;
import kr.co.service.OwnerService;
import kr.co.service.ProductService;

@Controller
@RequestMapping("/owner")
public class OwnerController {

	@Inject
	OwnerService service;
	
	@Inject
	ProductService p_service;
	
	@RequestMapping(value="/accounting", method=RequestMethod.GET)
	public void accountingPage(Model model) throws Exception{
	
		OwnerPageVO opvo = new OwnerPageVO();
		int opnum = p_service.getOpnum();
		
		opvo = service.OwnerPage(opnum - 1);
		model.addAttribute("opvo", opvo);
	}

	@RequestMapping(value="/gender", method=RequestMethod.GET)
	public void Gender(Model model) throws Exception{
		
		
		List<OwnerVO> orderCountByGender = service.getGender();	
			
		model.addAttribute("orderCountByGender", orderCountByGender);
		
	}
		
	@RequestMapping(value="/age", method=RequestMethod.GET)
	public void getAge(Model model) throws Exception{
	
		List<OwnerVO> getAge = service.getAge();	
		model.addAttribute("age", getAge);
		
		
	}

	
	
	@RequestMapping(value="/state", method=RequestMethod.GET)
	public void getState(Model model) throws Exception{

		List<OwnerVO> ovo = service.getState();
		
		model.addAttribute("ovo", ovo);
		
		
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/stateGraph", method=RequestMethod.GET)
	public List<OwnerVO> stateGraph() throws Exception{
			List<OwnerVO> list = service.getState();
			
			
			return list;			
		}
	
	
	
	@RequestMapping(value="/day", method=RequestMethod.GET)
	public void DAY(Model model) throws Exception{

		List<OwnerPageVO> dayList = service.day();
		model.addAttribute("dayList", dayList);
		
	}
	@ResponseBody
	@RequestMapping(value="/dayGraph", method=RequestMethod.GET)
	public List<OwnerPageVO> dayGraph(Model model) throws Exception{
			List<OwnerPageVO> list = service.day();
			
			return list;
		
		
	}
	@RequestMapping(value="/month", method=RequestMethod.GET)
	public void MONTH(Model model) throws Exception{
		
		List<OwnerPageVO> monthList = service.month();
		model.addAttribute("monthList", monthList);
		
		
	}
	@ResponseBody
	@RequestMapping(value="/monthGraph", method=RequestMethod.GET)
	public List<OwnerPageVO> monthGraph(Model model) throws Exception{
			List<OwnerPageVO> list = service.month();
			
			return list;
		
		
	}
	@RequestMapping(value="/year", method=RequestMethod.GET)
	public void YEAR(Model model) throws Exception{
		
		List<OwnerPageVO> yearList = service.year();
		
		
		model.addAttribute("yearList", yearList);
		
		
	}
	@ResponseBody
	@RequestMapping(value="/yearGraph", method=RequestMethod.GET)
	public List<OwnerPageVO> yearGraph(Model model) throws Exception{
			List<OwnerPageVO> list = service.year();
		
			return list;
		
		
	}
	
	@RequestMapping(value="/category", method=RequestMethod.GET)
	public void category(Model model) throws Exception{

		List<OwnerVO> ovo = service.category();
		
		System.out.println(ovo+"*************************************************");
		
		model.addAttribute("ovo", ovo);
		
		
		
	}
	
	
	
}
