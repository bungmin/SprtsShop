package kr.co.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.domain.AgeGraphVO;
import kr.co.domain.BoardVO;
import kr.co.domain.ReplyVO;
import kr.co.domain.StateVO;
import kr.co.domain.UserInfoVO;
import kr.co.domain.UserVO;
import kr.co.domain.VisitVO;
import kr.co.service.UserManageService;
import kr.co.service.UserService;

@RestController
@RequestMapping("/memberLog")
public class UserManageRestController {
	
	@Inject
	UserManageService service;
	
	@Inject
	private UserService service2;
	
	
	
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
	
	
	@ResponseBody
	@RequestMapping(value="/state", method=RequestMethod.GET)
	public List<String> state() throws Exception{
		
		List<String> list =service.state();
		System.out.println(list);
		//List<StateVO> list=service.analysisState();
		
		return list;
	}
	
	
	@RequestMapping(value="/deleteId/{id}", method=RequestMethod.DELETE, produces = "application/text; charset=utf8")
	public ResponseEntity<String> deleteAds(@PathVariable("id") String id){
		ResponseEntity<String> entity = null;
		
		try {
			
			service.delete(id);
			//service.deleteAds(ano);
			
			//service.registerAds(ano);
			//service.delete(ano);
			entity = new ResponseEntity<String>("DELETE_SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/usercheck", method=RequestMethod.GET)
	public List<UserVO> usercheck() throws Exception{
		List<UserVO> listUser = service.userList();
		
		System.out.println("----------------------------------------");
		System.out.println(listUser);
		System.out.println("----------------------------------------");
		return listUser;		
		//model.addAttribute("listUser", listUser);
		
	}
	
	
	/*@RequestMapping(value="/{rno}", method={RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> update(@PathVariable("rno") Integer rno, @RequestBody ReplyVO vo){*/ 
	
	@ResponseBody
	@RequestMapping(value="/userinfo/{id}")
	public ResponseEntity<UserInfoVO> getUserInfo(@PathVariable("id") String id){
		
		
		System.out.println("++++++**********+++++++++");
		System.out.println(id);
		ResponseEntity<UserInfoVO> entity = null;	
		System.out.println("(((((((((((((");
		try {
			//List<CartTestVO> list=service.CartView(id);
			
			UserInfoVO vo=service2.userInfo(id);
			
			entity= new ResponseEntity<UserInfoVO>(vo, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity= new ResponseEntity<UserInfoVO>(HttpStatus.BAD_REQUEST);
		}
		
		System.out.println("+++++++++");
		System.out.println(entity);
		
		return entity;
		
	}	
	
/*	@ResponseBody
	@RequestMapping(value="/state", method=RequestMethod.GET)
	public List<String> state() throws Exception{
		
		List<String> list =service.state();
		System.out.println(list);
		//List<StateVO> list=service.analysisState();
		
		return list;
	}
	*/
	
	
}
