package kr.co.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.domain.CartVO;
import kr.co.domain.ReplyVO;
import kr.co.domain.UserVO;
import kr.co.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Inject
	private CartService service;
	
/*	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insertCart(CartVO vo) throws Exception{	
		
		int cno = service.getCno();
		vo.setCno(cno);
		
		service.insertCart(vo);
		
		return "redirect:/product/listAllProduct";
		
		
	}*/
	
	@RequestMapping(value="/insert", method=RequestMethod.PUT, produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> cartInsert(@RequestBody CartVO vo){
		ResponseEntity<String> entity = null;			
		try {
			int cno = service.getCno();
			vo.setCno(cno);
			service.insertCart(vo);		
			entity = new ResponseEntity<String>("장바구니에 담겨졌습니다. ", HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity = new ResponseEntity<String>("장바구니 담기에 실패했습니다", HttpStatus.BAD_REQUEST);
		}			
		return entity;	
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void ListAllCart(String id, Model model) throws Exception{
		
		//List<CartVO> listAllCart = service.listAllCart(id);
		
		//model.addAttribute("list", listAllCart);
		
		
	}
	
	/*@RequestMapping(value="/listAll/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<CartVO>> list(@PathVariable("id") String id){
		//@PathVariable("bno")
		System.out.println("+++++++++++");
		
		ResponseEntity<List<CartVO>> entity = null;
		
		List<CartVO> list;
		try {
			list = service.listAllCart(id);
			System.out.println(list);
			entity= new ResponseEntity<List<CartVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity= new ResponseEntity<List<CartVO>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}*/
	

	
	@RequestMapping(value="/delete", method=RequestMethod.PUT, produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> cartDelete(@RequestBody CartVO vo){
		ResponseEntity<String> entity = null;
		System.out.println(vo.getCno());
		try {

			service.delete(vo.getCno());		
			entity = new ResponseEntity<String>("장바구니에서 삭제했습니다.. ", HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity = new ResponseEntity<String>("장바구니 삭제에 실패했습니다", HttpStatus.BAD_REQUEST);
		}			
		return entity;	
	}
	

	
	
}
