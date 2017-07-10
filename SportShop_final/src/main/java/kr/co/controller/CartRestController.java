package kr.co.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.domain.AdsVO;
import kr.co.domain.CartDetailVO;
import kr.co.domain.CartTestVO;
import kr.co.domain.CartVO;
import kr.co.domain.ProductVO;
import kr.co.domain.ReplyVO;
import kr.co.service.AdsService;
import kr.co.service.CartService;
import kr.co.service.ProductService;
import kr.co.util.MediaUtils;

@RestController
@RequestMapping("/cartinfo")
public class CartRestController {
	
	@Inject	
	CartService service;
	
	@Inject
	ProductService productService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	@ResponseBody
	@RequestMapping(value="/listcart/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<CartTestVO>> list(@PathVariable("id") String id){
		
		ResponseEntity<List<CartTestVO>> entity = null;	
		
		try {
			List<CartTestVO> list=service.CartView(id);	
			
			entity= new ResponseEntity<List<CartTestVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity= new ResponseEntity<List<CartTestVO>>(HttpStatus.BAD_REQUEST);
		}
		
		System.out.println("+++++++++");
		System.out.println(entity);
		
		return entity;
		
	}	
	
	
	@RequestMapping(value="/deletecart/{cno}", method=RequestMethod.DELETE, produces = "application/text; charset=utf8")
	public ResponseEntity<String> deleteAds(@PathVariable("cno") Integer cno){
		ResponseEntity<String> entity = null;
		
		try {
			
			service.delete(cno);
			//service.deleteAds(ano);
			
			//service.registerAds(ano);
			//service.delete(ano);
			entity = new ResponseEntity<String>("장바구니에서 삭제했습니다", HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}
	
		
}
