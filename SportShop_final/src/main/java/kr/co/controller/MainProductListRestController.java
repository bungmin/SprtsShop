package kr.co.controller;



import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.domain.CartTestVO;
import kr.co.domain.ProductVO;
import kr.co.service.ProductService;

@RestController
@RequestMapping("/mainList")
public class MainProductListRestController {

	
	@Inject
	private ProductService service;
	
	
	//@RequestMapping("/soccer")
	
	@ResponseBody
	@RequestMapping(value="/soccerlist", method=RequestMethod.GET)
	public ResponseEntity<List<ProductVO>> Soccerlist(){
		
		ResponseEntity<List<ProductVO>> entity = null;	
		
		try {
			List<ProductVO> list=service.SoccerProList();
			//List<CartTestVO> list=service.CartView(id);	
			
			entity= new ResponseEntity<List<ProductVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity= new ResponseEntity<List<ProductVO>>(HttpStatus.BAD_REQUEST);
		}	
		
		return entity;
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/baseballlist", method=RequestMethod.GET)
	public ResponseEntity<List<ProductVO>> baseballList(){
		
		ResponseEntity<List<ProductVO>> entity = null;	
		
		try {
			List<ProductVO> list=service.baseBallList();
			//List<CartTestVO> list=service.CartView(id);	
			
			entity= new ResponseEntity<List<ProductVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity= new ResponseEntity<List<ProductVO>>(HttpStatus.BAD_REQUEST);
		}	
		
		return entity;
		
	}	
	@ResponseBody
	@RequestMapping(value="/basketBallList", method=RequestMethod.GET)
	public ResponseEntity<List<ProductVO>> basketBallList(){
		
		ResponseEntity<List<ProductVO>> entity = null;	
		
		try {
			List<ProductVO> list=service.basketBallList();
			//List<CartTestVO> list=service.CartView(id);	
			
			entity= new ResponseEntity<List<ProductVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity= new ResponseEntity<List<ProductVO>>(HttpStatus.BAD_REQUEST);
		}	
		
		return entity;
		
	}	
	
	

		
	
}
