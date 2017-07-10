package kr.co.interceptor;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.util.MediaUtils;

public class FileDeleteInterceptor extends HandlerInterceptorAdapter {

	@Resource(name="uploadPath") 
	private String uploadPath = "C:\\zzz\\upload";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

		/*
		 * 1. fileInfo값을 호출. JSP 서블릿에서 했음. 2. "~~AA.jpg#~~bb.txt#~cc.png#"
		 * ------------> 끊어 내야함. -> 끊어낸 하나하나가 fullName.
		 * 
		 * 3. 파일 삭제 코드를 적용함.
		 */

		// request.getParameter("")

		String delInfo = request.getParameter("delInfo");

		System.out.println("++++++++");
		System.out.println(delInfo);
		System.out.println("========");
		
		//이거 처리 안해주면 update일때 get방식 없어짐......
		if (delInfo == null) {
			return;
		}

		/*구분자를 이용해서 잘라내서 배열에 넣기........*/
		String[] arr = delInfo.split("#");

		for (String fileName: arr) {
			// fullName[i];
			// 여기서 실제 파일을 지워야함........
			String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
			
			MediaType mType= MediaUtils.getMediaType(formatName);
			
			if(mType !=null){	//이미지 파일이면
				String prefix= fileName.substring(0, 12);
				String suffix= fileName.substring(14);
				
				System.out.println(prefix);
				System.out.println(suffix);
				
				System.out.println("================================");
				System.out.println(fileName);
			
				File f = new File(uploadPath+(prefix+suffix).replace('/', File.separatorChar));
						
			//	C:\zzz/upload/2017/05/30/f45c8c72-5398-4fac-aa44-3d025e4c3d32_yoshi.jpg
				f.delete();
			}
			
			new File(uploadPath+fileName.replace('/', File.separatorChar)).delete();

		}

	}

}
