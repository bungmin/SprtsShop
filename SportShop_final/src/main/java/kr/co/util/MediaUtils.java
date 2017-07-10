package kr.co.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

public class MediaUtils {
	
	
	//org.springframework.http.MediaType
	private static Map<String, MediaType> mediaMap;
	
	/*메서드나 생성자를 이용해서 초기화하는거 말고 static으로 되어있는거 초기화 하는법 있음*/
	
	
	/*static 초기화 방법  괄호 안에 넣으면 됨.
	static{
		
	}*/
	
	
	static{
		mediaMap = new HashMap<String, MediaType>();
		mediaMap.put("JPG", MediaType.IMAGE_JPEG);
		mediaMap.put("PNG", MediaType.IMAGE_PNG);
		mediaMap.put("GIF", MediaType.IMAGE_GIF);
		
		/*JPG,PNG,GIF 3파일만 화면에 출력하려공*/		
	}
	
	public static MediaType getMediaType(String type){
		/*대문자로 변환해서*/
		
		
		return mediaMap.get(type.toUpperCase());		
	}
	
	
	
	

}
