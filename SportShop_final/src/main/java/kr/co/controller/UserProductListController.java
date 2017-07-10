package kr.co.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.domain.BoardVO;
import kr.co.domain.CartTestVO;
import kr.co.domain.PageMaker;
import kr.co.domain.ProductCriteria;
import kr.co.domain.ProductPageMaker;
import kr.co.domain.ProductSearchCriteria;
import kr.co.domain.ProductVO;
import kr.co.domain.SearchCriteria;
import kr.co.domain.UserInfoVO;
import kr.co.service.ProductService;
import kr.co.service.UserService;

@Controller
@RequestMapping("/userProductList")
public class UserProductListController {
	
	@Inject
	private ProductService service;
	
	
	@Inject
	private UserService userService;
	
	
	@RequestMapping(value="list", method =  RequestMethod.GET)
	public void list(Model model) throws Exception{
		
		List<ProductVO> listAllProduct = service.ListAllProduct();
		
		model.addAttribute("listAllProduct", listAllProduct);  
		
	}
	
	@RequestMapping(value="/listSearchCriteria", method= RequestMethod.GET)
	public void listCriteria(@ModelAttribute("cri") ProductSearchCriteria cri, String category, String orderType, Model model)throws Exception{
		
		System.out.println("+++++++++++++++++");	
		System.out.println(orderType);
		System.out.println("++++++++++++++");
	
		List<ProductVO> list=service.listSearch(cri,category,orderType);
		model.addAttribute("listAllProduct", list);
		
		ProductPageMaker pageMaker = new ProductPageMaker();
		pageMaker.setCri(cri);
	
		int cnt = service.listSearchCount(cri, category);
		pageMaker.setTotalCount(cnt);
		
		
		model.addAttribute("pageMaker", pageMaker);

	
	}
	
	
	
	@RequestMapping(value="/productDetail", method= RequestMethod.GET)
	public void productDetail(int pno, @ModelAttribute("cri") ProductSearchCriteria cri, Model model)throws Exception{		
		
		
		service.addViewCnt(pno);
		ProductVO vo=service.readProduct(pno);
		
		model.addAttribute("vo", vo);
		model.addAttribute("cri", cri);
		
		
		
	
	
	}
	
	
	@ResponseBody
	@RequestMapping(value="/goodcnt/{pno}", method= RequestMethod.GET)
	public String goodcnt(@PathVariable("pno") int pno)throws Exception{		
		
		service.addGoodCnt(pno);
		
		return "redirect:/userProductList/productDetail?pno="+pno;
	
	
	}
	
	@ResponseBody
	@RequestMapping(value="/productDetailajax/{pno}", method= RequestMethod.GET)
	public ProductVO productDetailajax(@PathVariable("pno") int pno)throws Exception{		
		
		
		service.addViewCnt(pno);
		ProductVO vo=service.readProduct(pno);			
		
		
		return vo;	
	}
	
	
	
	@RequestMapping(value="/cash", method= RequestMethod.GET)
	public void cash()throws Exception{		
		
	}
	
	
	
	
	@ResponseBody
	@RequestMapping(value="/cashcharge", method=RequestMethod.POST)
	public ResponseEntity<String> list(@RequestBody UserInfoVO vo){
		
		ResponseEntity<String> entity = null;	
		System.out.println(vo);
		
		try {
			//List<CartTestVO> list=service.CartView(id);
			
			userService.cashcharge(vo);			
			
			System.out.println("!!!!!!!!!!!!!");
			entity= new ResponseEntity<String>("UPDATE_SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity= new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		System.out.println("+++++++++");
		System.out.println(entity);
		
		return entity;
		
	}	

	
	
}
