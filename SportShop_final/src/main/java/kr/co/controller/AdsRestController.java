package kr.co.controller;

import java.io.File;
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
import kr.co.domain.ReplyVO;
import kr.co.service.AdsService;
import kr.co.util.MediaUtils;

@RestController
@RequestMapping("/adsinfo")
public class AdsRestController {
	
	@Inject	
	AdsService service;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	@ResponseBody
	@RequestMapping(value="/listads", method=RequestMethod.GET)
	public ResponseEntity<List<AdsVO>> list(){
		
		ResponseEntity<List<AdsVO>> entity = null;
		
		List<AdsVO> list;
		try {
			list = service.listads();
			System.out.println(list);
			entity= new ResponseEntity<List<AdsVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity= new ResponseEntity<List<AdsVO>>(HttpStatus.BAD_REQUEST);
		}
		
		System.out.println("+++++++++");
		System.out.println(entity);
		
		return entity;
		
	}	
	
	@ResponseBody
	@RequestMapping(value="/registerdListAds", method=RequestMethod.GET)
	public ResponseEntity<List<AdsVO>> registerAdslist(){
		
		ResponseEntity<List<AdsVO>> entity = null;
		
		List<AdsVO> list;
		try {
			list = service.registerdListAds();
			System.out.println(list);
			entity= new ResponseEntity<List<AdsVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity= new ResponseEntity<List<AdsVO>>(HttpStatus.BAD_REQUEST);
		}
		
		System.out.println("+++++++++");
		System.out.println(entity);
		
		return entity;
		
	}	
	
	
	@RequestMapping(value="/delete/{ano}", method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("ano") Integer ano){
		ResponseEntity<String> entity = null;
		
		try {
			AdsVO vo=service.readAds(ano);
			service.delete(ano);			
			String formatName = vo.getA_img_name().substring(vo.getA_img_name().lastIndexOf(".")+1);
			
			MediaType mType= MediaUtils.getMediaType(formatName);
			
			if(mType !=null){	//이미지 파일이면
				String prefix= vo.getA_img_name().substring(0, 12);
				String suffix= vo.getA_img_name().substring(14);
				
				
				File f = new File(uploadPath+(prefix+suffix).replace('/', File.separatorChar));
				
				f.delete();
			}
			new File(uploadPath+vo.getA_img_name().replace('/', File.separatorChar)).delete();
			
			entity = new ResponseEntity<String>("DELETE_SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}
	
	@RequestMapping(value="/registerAds/{ano}", method=RequestMethod.DELETE)
	public ResponseEntity<String> Register(@PathVariable("ano") Integer ano){
		ResponseEntity<String> entity = null;
		
		try {
			
			service.registerAds(ano);
			//service.delete(ano);
			entity = new ResponseEntity<String>("DELETE_SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}
	
	
	@RequestMapping(value="/deleteAds/{ano}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAds(@PathVariable("ano") Integer ano){
		ResponseEntity<String> entity = null;
		
		try {
			
			service.deleteAds(ano);
			
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
	
	
	@RequestMapping(value="/addreadcnt/{ano}", method= RequestMethod.DELETE)
	public ResponseEntity<String> addReadCnt(@PathVariable("ano") Integer ano) throws Exception{
		ResponseEntity<String> entity = null;		
		try {			
			service.addReadCnt(ano);
			System.out.println("+++++++++++++");
			
			System.out.println("@@@@@@@@@@@");

			entity = new ResponseEntity<String>("DELETE_SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}
	
}
