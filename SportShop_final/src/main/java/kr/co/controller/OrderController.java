package kr.co.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.domain.DateVO;
import kr.co.domain.OrderInfoVO;
import kr.co.service.OrderInfoService;

@Controller
@RequestMapping("/order/*")
public class OrderController {
	
	@Inject
	private OrderInfoService service;
	
	
	@RequestMapping(value="myOrder", method=RequestMethod.GET)
	public void myOrder(String id, Model model) throws Exception{
				
		List<OrderInfoVO> list =service.myOrder(id);
		
		model.addAttribute("list", list);
		
	}
	
	@RequestMapping(value="orderAdmin", method=RequestMethod.GET)
	public void orderAdmin(Model model) throws Exception{
		
		List<OrderInfoVO> list =service.orderAdmin();
		
		model.addAttribute("list", list);
		
	}
	
	@ResponseBody
	@RequestMapping(value="dateOrder", method=RequestMethod.PUT, produces = "application/json; charset=utf8")
	public List<OrderInfoVO> dateOrder(@RequestBody DateVO vo) throws Exception{ 
		
		
		System.out.println("%%%%");
		System.out.println(vo);
		System.out.println("%%%%");
		Date date = new Date();
		
		System.out.println("++++");
		System.out.println(date);
		System.out.println("++++");
		
		SimpleDateFormat new_format = new SimpleDateFormat("yyyy-MM-dd");
		
		String today = new_format.format(date);
		
		System.out.println("######");
		System.out.println(today);
		System.out.println("######");
		
		//String formattedDate = dateFormat.format(date);
		if(vo.getDate1() == ""){			
			vo.setDate1("2010-01-01");			
		}
		
		if(vo.getDate2() == ""){
			vo.setDate2(today);
		}
		
		System.out.println("&&&&");
		System.out.println(vo);
		System.out.println("&&&&");
		
		
		
		
		List<OrderInfoVO> list = service.dateOrder(vo);		
		
		return list;		
	}
	
	
}
