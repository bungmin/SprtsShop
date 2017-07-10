package kr.co.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.domain.Criteria;
import kr.co.domain.PageMaker;
import kr.co.domain.ReplyVO;
import kr.co.domain.ReviewCriteria;
import kr.co.domain.ReviewPageMaker;
import kr.co.domain.ReviewVO;
import kr.co.service.ReplyService;
import kr.co.service.ReviewService;

@RestController
@RequestMapping("/review")
public class ReviewRestController {

/*	@Inject
	private ReplyService service;*/
	
	@Inject
	private ReviewService service;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody ReviewVO vo) {
		// @RequestBody json으로 되어있는것을 문자열로

		ResponseEntity<String> entity = null;	

		try {
		
			int revNo= service.getRevno();
			
			vo.setRevno(revNo);
			
			service.reviewInsert(vo);
			
			entity = new ResponseEntity<String>("INSERT_SUCCESS", HttpStatus.OK);
			
			System.out.println(entity);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 실패횄을경우
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;

	}
	
	
	@RequestMapping(value="/{pno}/{page}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPage(@PathVariable("pno") Integer pno, 
			@PathVariable("page") Integer page
			){			
		ResponseEntity<Map<String, Object>> entity = null;
		
		System.out.println("^^^^^^^^^^");
		
		ReviewCriteria cri = new ReviewCriteria();
		
		cri.setPage(page);
		ReviewPageMaker pageMaker = new ReviewPageMaker();
		pageMaker.setCri(cri);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			List<ReviewVO> list =service.listPage(pno, cri);
			map.put("list", list);
		
			int reviewCount =service.count(pno);
			pageMaker.setTotalCount(reviewCount);
			map.put("pageMaker", pageMaker);
			System.out.println(reviewCount);
			System.out.println(pageMaker);
			entity = new ResponseEntity<Map<String, Object>>(
					map,HttpStatus.OK);			
		} catch (Exception e) {		
			e.printStackTrace();						
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		
		}	
		

		return entity;
		
	}
	
	
	@RequestMapping(value="/{revno}", method={RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> update(@PathVariable("revno") Integer revno, @RequestBody ReviewVO vo){
		ResponseEntity<String> entity = null;		
		
		vo.setRevno(revno);
		//vo.setRno(rno);
		try {
		//	service.update(vo);
			service.update(vo);
			entity = new ResponseEntity<String>("UPDATE_SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}		
		
		return entity;
		
	}
	

	@RequestMapping(value="/{revno}", method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("revno") Integer revno){
		ResponseEntity<String> entity = null;
		
		
		try {
			service.delete(revno);
			entity = new ResponseEntity<String>("DELETE_SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}
	
	
	@RequestMapping(value="/myReview", method=RequestMethod.GET)
	public void myReview(String id) throws Exception{
		
		
		
		
	}
	
	
	
	
	
}
