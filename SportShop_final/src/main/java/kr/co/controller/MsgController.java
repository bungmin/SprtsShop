package kr.co.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.domain.BoardVO;
import kr.co.domain.Criteria;
import kr.co.domain.LoginDTO;
import kr.co.domain.MsgVO;
import kr.co.domain.PageMaker;
import kr.co.domain.UserVO;
import kr.co.service.BoardService;
import kr.co.service.MsgService;
import kr.co.service.UserService;
import kr.co.util.MediaUtils;

@Controller
@RequestMapping("/msg")
public class MsgController {
	
	
	@Inject
	private MsgService service;
	
	@Inject
	private UserService userService;

	@Inject
	private JavaMailSenderImpl javaMailSenderImpl;


	
	// 입력폼으로 넘어간느거..
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public void createGet() throws Exception {

		/*System.out.println("입력 화면으로 넘어감.");
		System.out.println("path : board/create.jsp");*/

	}
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createPost(MsgVO vo) throws Exception {
				
	
		
		//for (int i = 0; i < 100; i++) {
		int mno=service.getMno();		
		vo.setMno(mno);
		vo.setReplycheck("false");
		// vo.setTitle("title"+i);
		 //vo.setContent("content"+i);
		service.create(vo);		
		//Thread.sleep(50);
		//}
		
		
		UserVO userVo=userService.idck(vo.getId());
		MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();
		mimeMessage.setFrom(new InternetAddress(userVo.getEmail()));
		mimeMessage.addRecipient(RecipientType.TO, new InternetAddress("babobungmin@naver.com"));
		mimeMessage.setSubject(vo.getId() + " 님으로부터 " + vo.getM_category() +"의 문의 내용입니다.");
		mimeMessage.setText("<p>"+ vo.getContent()+ "</p>", "UTF-8", "html");
		
		javaMailSenderImpl.send(mimeMessage);
		
		return "redirect:/msg/listAll?id="+vo.getId();
		
	}
	
	@RequestMapping(value = "listAll", method = RequestMethod.GET)
	public void listAll(String id, Model model) throws Exception {
		
		List<MsgVO> list = service.listAll(id);

		model.addAttribute("list", list);
		

	}
	
	
	@RequestMapping(value = "listAllAdmin", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		
		List<MsgVO> list = service.listAllAdmin();
		
		model.addAttribute("list", list);
		
		
	}
	
	
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public String reply(int mno, Model model) throws Exception {
		
		
		service.replyCheckUpdate(mno);
		
	//	List<MsgVO> list = service.listAllAdmin();
		
		//model.addAttribute("list", list);
		
		return "redirect:/msg/listCriteria";
		
		
	}
	
	@RequestMapping(value = "listCriteria", method = RequestMethod.GET)
	public void listCriteria(@ModelAttribute("cri") Criteria cri, Model model
			) throws Exception {
		
		
		
		System.out.println("++++++++++++++++++++");
		System.out.println(cri);
		List<MsgVO> list = service.listCriteria(cri);

		model.addAttribute("list", list);
		
		int totalCount = service.totalCount();
		PageMaker pageMaker = new PageMaker();
	
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);

		model.addAttribute("pageMaker", pageMaker);	

	}
	
	@RequestMapping(value = "listCriteriaUser", method = RequestMethod.GET)
	public void listCriteria(@ModelAttribute("cri") Criteria cri, String id, Model model
			) throws Exception {
		
		
		
		System.out.println("++++++++++++++++++++");
		System.out.println(cri);
		List<MsgVO> list = service.listCriteriaUser(cri,id);

		model.addAttribute("list", list);
		
		int totalCount = service.totalCount(id);
		PageMaker pageMaker = new PageMaker();
	
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);

		model.addAttribute("pageMaker", pageMaker);	

	}
	
	
	
	
}
