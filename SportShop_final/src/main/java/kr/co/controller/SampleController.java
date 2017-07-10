package kr.co.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.co.domain.AttachVO;
import kr.co.domain.BoardVO;
import kr.co.service.AttachService;
import kr.co.service.BoardService;
import kr.co.util.MediaUtils;
import kr.co.util.UploadFileUtils;


/*@RestController*/

@Controller
/*@RequestMapping("/sample")*/
public class SampleController {
	
	/*servlet-context.xml에 등록한 bean에 uploadPath 등록*/	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	@Inject
	private AttachService service;
	
	
	@Inject
	private BoardService daoService;
	
	/*
	@RequestMapping(value= "/uploadAjax", method=RequestMethod.POST)
	public ResponseEntity<String> uploadAjaxPost(MultipartFile file){
		//
		ResponseEntity<String> entity = null;		
		
		entity = new ResponseEntity<String>("file",HttpStatus.OK);
		
		return entity;
		
		
	}*/
	
	@ResponseBody
	@RequestMapping(value="/listAttach/{bno}", method=RequestMethod.GET)
	public ResponseEntity<List<AttachVO>> listAttch(@PathVariable("bno")int bno){
		
		
		System.out.println("--------------");
		ResponseEntity<List<AttachVO>> entity = null;
		
		List<AttachVO> list = null;
		
		
		try {
			list = service.getAttach(bno);
			System.out.println(list);
			System.out.println("++++++++++");
			entity= new ResponseEntity<List<AttachVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity= new ResponseEntity<List<AttachVO>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}
	
	
	
	
	
	
	/*첨부파일 삭제*/
	@ResponseBody
	@RequestMapping(value="/deleteFile", method=RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName) throws Exception{
		
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		
		MediaType mType= MediaUtils.getMediaType(formatName);
		
		if(mType !=null){	//이미지 파일이면
			String prefix= fileName.substring(0, 12);
			String suffix= fileName.substring(14);
			
			System.out.println(prefix);
			System.out.println(suffix);
			
			System.out.println("================================");
			System.out.println(fileName);
			
			/*원본 파일 지우는거*/
			File f = new File(uploadPath+(prefix+suffix).replace('/', File.separatorChar));
			
			/*이번에는 거꾸로*/			
		//	C:\zzz/upload/2017/05/30/f45c8c72-5398-4fac-aa44-3d025e4c3d32_yoshi.jpg
			f.delete();
		}
		
		
		/*썸네일 지우는거*/
		new File(uploadPath+fileName.replace('/', File.separatorChar)).delete();
		
		
		System.out.println("++++++++");
		System.out.println("fileName : "+fileName);
		
	
		
		return new ResponseEntity<String>("DELETE_SUCCESS", HttpStatus.OK);
		
	}
	
	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception{
		InputStream in =null;
		ResponseEntity<byte[]> entity= null; 
		
		
		try {
			String formatName= fileName.substring(fileName.lastIndexOf(".")+1);
			
			MediaType mType=MediaUtils.getMediaType(formatName);
			
			HttpHeaders headers = new HttpHeaders();
						
			in = new FileInputStream(uploadPath+fileName);			
			
			if(mType !=null){	//이미지 파일이라는 이야기				
				/*헤더에 설정*/
				headers.setContentType(mType);
			}else{		//일반 파일이면 내려받기.
				fileName = fileName.substring(fileName.indexOf("_")+1);
				
				System.out.println("+++++++");
				System.out.println(fileName);
				/*원래파일 이름 추출*/
				
				/*a.dat
				
				zzzzzzzz_a.dat 이 이름에서 	a.dat 추출ㄴ				
				*/
				//MediaType.APPLICATION_OCTET_STREAM : 파일을 다운로드 받을 수있는 스트림..
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			
				/*한글이 깨치지 않게 UTF-8
				 * ISO-8859-1을 UTF-8로 바꿔라.
				 * */
				headers.add("Content-Disposition", "attachment; filename=\""+new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
			}
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();			
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally {
			if(in !=null)	in.close();
		}
		
		
		return entity;
		
	}
	
	
	
	
	@ResponseBody
	@RequestMapping(value= "/uploadAjax", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception{
		
		
		System.out.println("**********************");
		/*ResponseEntity<String> entity = null;
		
		entity = new ResponseEntity<String>(file.getOriginalFilename(), HttpStatus.OK);
		*/
		System.out.println("ori : " + file.getOriginalFilename());
		System.out.println("size : " + file.getSize());
		System.out.println("con : " + file.getContentType());		
		System.out.println("**********************");
				
		String uploadedFileName=UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
				
		return new ResponseEntity<String>(
				uploadedFileName,
				HttpStatus.CREATED);		
		
	}
	
	@RequestMapping(value= "/uploadAjax", method=RequestMethod.GET)
	public void uploadAjax(){
		
		
	}
	
	@RequestMapping(value="/uploadForm", method=RequestMethod.GET)
	public void uploadForm(){
		
	}
	
	
	@RequestMapping(value="/uploadForm", method=RequestMethod.POST)
	public String uploadFormPost(MultipartFile file, Model model) throws Exception{
		System.out.println("????????????");
		System.out.println("ori : " + file.getOriginalFilename());		//원래 파일의 이름..... 근데 문제가 파일이름이 같은게 있을때 문제가 생김
		System.out.println("size : " + file.getSize());
		System.out.println("con : "+ file.getContentType());
				
		/*일단은 파일명이 겹치지 않도록 유니크한 이름 부여*/
		UUID uid = UUID.randomUUID();
		String savedName =uid.toString()+"_"+file.getOriginalFilename();
		
		
		
		File target = new File(uploadPath, savedName);
		
		/*실제 데이터를 바이트 배열로 만들어서 (target)누군가한테 전달해줌
		 * 받아온 file 객체를 만들어진 폴더에 복사를 한다. 
		 * file 객체를 바이트 형태로 만들어진것을, target에......
		 * */
		FileCopyUtils.copy(file.getBytes(), target);
		
		/*
		 * 복사한다음에. savedName을 가져오기.
		 * */
		
		model.addAttribute("savedName", savedName);		
		
		System.out.println("????????????");
		
		return "uploadResult";
		
	}
	
	
	
	
	 @RequestMapping(value = "/community/imageUpload", method = RequestMethod.POST)
	    public void communityImageUpload(HttpServletRequest request, HttpServletResponse response, @RequestParam MultipartFile upload) throws Exception, Exception {
	 
		   OutputStream out = null;
	        PrintWriter printWriter = null;
	        response.setCharacterEncoding("utf-8");
	        response.setContentType("text/html;charset=utf-8");
	 
	        try{
	 
	            String fileName = upload.getOriginalFilename();
	            byte[] bytes = upload.getBytes();
	            //uploadPath += fileName;//저장경로
	            
	            
	            String uploadedFileName=UploadFileUtils.uploadFile(uploadPath, fileName, bytes);
	 
	            /*out = new FileOutputStream(new File(uploadPath));
	            out.write(bytes);*/
	            
	            
	            String callback = request.getParameter("CKEditorFuncNum");
	 
	            printWriter = response.getWriter();
	            String fileUrl = "/displayFile?fileName=" + uploadedFileName;//url경로            
	           
	 
	            printWriter.println("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction("
	                    + callback
	                    + ",'"
	                    + fileUrl
	                    + "','이미지를 업로드 하였습니다.'"
	                    + ")</script>");
	            printWriter.flush();
	 
	        }catch(IOException e){
	            e.printStackTrace();
	        } finally {
	            try {
	                if (out != null) {
	                    out.close();
	                }
	                if (printWriter != null) {
	                    printWriter.close();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	 
	        return;
	    }

}
