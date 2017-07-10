package kr.co.controller;

import java.util.Random;

import javax.inject.Inject;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.domain.LoginDTO;
import kr.co.domain.UserInfoVO;
import kr.co.domain.UserVO;
import kr.co.service.UserManageService;
import kr.co.service.UserService;

@Controller
@RequestMapping("/user") 
public class UserController {

	@Inject
	private UserService service;
	
	@Inject
	private UserManageService manageService;
	
	@Inject
	private JavaMailSenderImpl javaMailSenderImpl;
	
	

	
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public void myPage(String id, Model model) throws Exception{
		
		UserVO userVO = service.mypage(id);
		model.addAttribute("userVO", userVO);
		
	}

	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete (String id, HttpSession session, Model model) throws Exception{
		
		session.getAttribute("userVO");
		service.delete(id);
		
		if(session!=null){			
			session.invalidate();			
		}
		
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void loginGet(@ModelAttribute("dto") LoginDTO dto) throws Exception{
		
	}
	
	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public void loginPost(LoginDTO dto, HttpSession session, Model model, RedirectAttributes rttr) throws Exception{
		
		UserVO userVO = service.login(dto);
		if(userVO == null){
			return;
		}
		
		manageService.visit_log(dto.getId());
		
		model.addAttribute("userVO", userVO);
		session.setAttribute("userVO", userVO);
	}
	
	
	@RequestMapping(value="/logout")
	public String logOut(LoginDTO dto, HttpSession session) throws Exception{
		
		if(session!=null){
			
			session.invalidate();			
		}
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public void joinGet(UserVO vo, HttpSession session) throws Exception{
		
	}
	
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinPost(UserVO vo, HttpSession session) throws Exception{
		
		vo.setPosition("user");
		service.join(vo);
		
	
		
		
		MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();
		mimeMessage.setFrom(new InternetAddress("babobungmin@naver.com"));
		mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(vo.getEmail()));
		mimeMessage.setSubject("Exerciser 가입을 축하드립니다.");
		mimeMessage.setText("<p>Excerciser 회원 가입을 축하드립니다. </p><p>id : "+ vo.getId() + "</p><p>password : "+vo.getPw() +" </p>", "UTF-8", "html");
		
		javaMailSenderImpl.send(mimeMessage);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public void updateGet(UserVO userVO,HttpSession session) throws Exception{
		
		//model.addAttribute("userVO", userVO);
		
	}
	
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updatePost(UserVO userVO, HttpSession session, Model model) throws Exception{

		userVO.setPosition("user");
		service.update(userVO);
		model.addAttribute("userVO", userVO);

		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/idck/{id}", method =RequestMethod.GET)
	public ResponseEntity<String> update(@PathVariable("id") String id) {
		// value에 중괄호가 있으면 @PathVariable 사용
		ResponseEntity<String> entity = null;
		UserVO vo = null;
		
		try {
			vo =service.idck(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(vo != null){			//중복 되있는거니까 사용불가능이니까 false 
			entity= new ResponseEntity<String>("false", HttpStatus.OK);
		}else{					//중복 안되있어서 사용가능해서 true
			entity= new ResponseEntity<String>("true", HttpStatus.OK);
		}				
		return entity;
	}
	
	
	@RequestMapping(value="/idfind", method=RequestMethod.GET)
	public void idfind() throws Exception{
		
		//model.addAttribute("userVO", userVO);
		
		
		
	}
	
		
	@RequestMapping(value="/idfind", method=RequestMethod.PUT, produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> idfind(@RequestBody UserVO vo){
		ResponseEntity<String> entity = null;
		
		System.out.println("++++++++++++");		
		System.out.println(vo);
		
		
	
		try {
			UserVO vo2=service.idfind(vo);
			entity = new ResponseEntity<String>("아이디 : "+vo2.getId(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}	
		
		return entity;
		
	}
	
	@RequestMapping(value="/pwfind", method=RequestMethod.GET)
	public void pwfind() throws Exception{
		
	
		
	}
	
	@RequestMapping(value="/pwfind", method=RequestMethod.PUT, produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> pwfind(@RequestBody UserVO vo){
		ResponseEntity<String> entity = null;
		
	
		try {
			UserVO vo2=service.pwfind(vo);
			entity = new ResponseEntity<String>("비밀번호 : "+vo2.getPw(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}	
		
		
		return entity;
		
	}
	
	
	@RequestMapping(value="/emailConfirm", method=RequestMethod.PUT, produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> emailConfirm(HttpServletRequest request, @RequestBody UserVO vo){
		ResponseEntity<String> entity = null;
		
		
		HttpSession session =request.getSession();
		
		int ran = new Random().nextInt(100000) + 10000; // 10000 ~ 99999
	    String joinCode = String.valueOf(ran);
		
		
		
		System.out.println(vo.getEmail());
		System.out.println(joinCode);
		try {
			session.setAttribute("joincode", joinCode);	
			MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();
			mimeMessage.setFrom(new InternetAddress("babobungmin@naver.com"));
			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(vo.getEmail()));
			mimeMessage.setSubject("Exerciser 회원 가입 인증 코드 발급 안내입니다.");
			mimeMessage.setText("<p>Excerciser 귀하의 인증코드는. </p><p> 인증코드 : "+ joinCode + "</p>", "UTF-8", "html");
			entity = new ResponseEntity<String>("이메일을 확인하세요. 인증코드가 발송되었습니다 ", HttpStatus.OK);
			javaMailSenderImpl.send(mimeMessage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}	
			
		return entity;
		
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/userinfo/{id}", method=RequestMethod.GET)
	public ResponseEntity<UserInfoVO> getUserInfo(@PathVariable("id") String id){
		
		
		System.out.println("++++++**********+++++++++");
		System.out.println(id);
		ResponseEntity<UserInfoVO> entity = null;	
		
		try {
			//List<CartTestVO> list=service.CartView(id);
			
			UserInfoVO vo=service.userInfo(id);
			
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
	
	
	

	
	
	
	
}
