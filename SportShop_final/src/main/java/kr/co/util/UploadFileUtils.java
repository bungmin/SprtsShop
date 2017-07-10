package kr.co.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
		
	
	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);
	
	/*이클래스는 클래스 변수 사용할꺼임 그래서 static*/
	
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception{
		/*2017년 폴더 안에 05월 달 폴더 안에 30 일 폴더 안에 업로드 파일을 넣겠다.*/
		
		
		/*upload 파일에 유니크한 이름 지어주기 savedName*/
		UUID uid = UUID.randomUUID();
		String savedName =uid.toString()+"_"+originalName;
		

		//저장된 폴더의 패스 설정....
		String savedPath =calcPath(uploadPath);
		
		
		File target = new File(uploadPath+savedPath, savedName);
		
		/*fileData를 target에 복사하기 실제로 file을 복사하는거.......*/ 
		FileCopyUtils.copy(fileData, target);		
		
		/*확장자 확인*/
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
		
		
		String uploadedFileName=null;
		
		
		if(MediaUtils.getMediaType(formatName)!= null){
			/*이미지 파일이라는 이야기*/
			
			/*썸네일 파일이 만들어짐 */
			uploadedFileName = makeThumbnail(uploadPath, savedPath, savedName);
		}else{
			/*이름만 넘겨주는거 이미지 파일이 아니라서 파일명만 보여주기....*/
			uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		}
		
		
		return uploadedFileName;		
	}
	
	
	
	//메인 이미지인지, 서브 이미지 인지 알기 위한 메서드
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData, String ImagePosition) throws Exception{
		/*2017년 폴더 안에 05월 달 폴더 안에 30 일 폴더 안에 업로드 파일을 넣겠다.*/
		
		
		/*upload 파일에 유니크한 이름 지어주기 savedName*/
		UUID uid = UUID.randomUUID();
		String savedName =uid.toString()+"_"+originalName;
		
		
		//저장된 폴더의 패스 설정....
		String savedPath =calcPath(uploadPath);
		
		
		File target = new File(uploadPath+savedPath, savedName);
		
		/*fileData를 target에 복사하기 실제로 file을 복사하는거.......*/ 
		FileCopyUtils.copy(fileData, target);		
		
		/*확장자 확인*/
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
		
		
		String uploadedFileName=null;		
		
		if(ImagePosition == "main"){
			
			if(MediaUtils.getMediaType(formatName)!= null){
				/*이미지 파일이라는 이야기*/
				
				/*썸네일 파일이 만들어짐 */
				uploadedFileName = makeMainImage(uploadPath, savedPath, savedName);
			}else{
				/*이름만 넘겨주는거 이미지 파일이 아니라서 파일명만 보여주기....*/
				uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
			}			
		}else if(ImagePosition == "sub"){
			
			if(MediaUtils.getMediaType(formatName)!= null){
				/*이미지 파일이라는 이야기*/
				
				/*썸네일 파일이 만들어짐 */
				uploadedFileName = makeSubImage(uploadPath, savedPath, savedName);
			}else{
				/*이름만 넘겨주는거 이미지 파일이 아니라서 파일명만 보여주기....*/
				uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
			}
			
		}
		
		
		
		
		return uploadedFileName;		
	}
	
	
	
	private static String makeIcon(String uploadPath, String savedPath, String savedName) {
		// TODO Auto-generated method stub
		
		String iconName=uploadPath+savedPath+File.separator+savedName;
		
		String re =iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
		
		
		
		return re;
	}



	/*패스 계산*/
	private static String calcPath(String uploadPath){
		Calendar cal = Calendar.getInstance();
		//cal 만든이유는 해당 폴더를 만들기 위해서. 날짜별로..
		
		String yearPath = File.separator+cal.get(Calendar.YEAR);
		logger.info("연도 : " +yearPath);
		
		/*이렇게만 하면 그냥 5 나옴..그래서 formatting 해줘야됨*/
		//String monthPath = yearPath+File.separator+cal.get(Calendar.MONTH)+1;
		//그래서 formating 변경해서 저장......
		String monthPath = yearPath+File.separator+
				new DecimalFormat("00").
				format(cal.get(Calendar.MONTH)+1);
		logger.info("월 : " +monthPath);									     		
		
		String datePath = monthPath+File.separator+
				new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		logger.info("일 : " + datePath);
		
		makeDir(uploadPath, yearPath, monthPath, datePath);
		
		return datePath;		
	}


	
	/*폴더 만들기*/
	private static void makeDir(String uploadPath, String...paths) {
		// TODO Auto-generated method stub
		
		//
		//private static void makeDir(String uploadPath, String yearPath, String monthPath, String datePath) 
		//똑같은 자료형의 parameter일 때, ...  배열 로 인식함.......  가변형 인자 Varargs
		
		
		
		File f = new File(paths[paths.length-1]);
		
		if(f.exists()){		//존재하면 만들 필요 가 없음...... 폴더를
			return;
		}
		
		
		/*paths를 풀어 헤쳐서 각각에 대해서 폴더를 만들면 됨. yearpath, monthpath, datepath*/
		for(String path:paths){
			File dirPath= new File(uploadPath+path);
			
			if(!dirPath.exists()){		//없으면 만들어라........
				dirPath.mkdir();
			}					
		}
	}
	
	
	
	/*썸네일 만드는거*/
	private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception{
		
		File sF = new File(uploadPath+path, fileName);
						
		/*path안에 있는 파일의 정보를 읽어서 메모리에 저장*/
		BufferedImage sourceImg = ImageIO.read(sF);		
		
		/*이미지의 크기를 줄이기*/
		BufferedImage destImg= Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 150);
		
		//BufferedImage destImg= Scalr.resize(sourceImg, 200, 300);
		
				
		//	BufferedImage destImg= Scalr.resize(sourceImg, 100, 100);
		
		//Scalr.res
		
		/*썸네일 이미지 이름 지정*/
		String thumbnailName = uploadPath + path + File.separator+"s_"+fileName;		
			
		/*이미지 파일이면 썸네일 처리. 아니면 파일명만 보이게*/
		File newFile = new File(thumbnailName);		
				
		/*. 뒤부터 확장자만 가져오기*/
		String formatName=  fileName.substring(fileName.lastIndexOf(".")+1);
		
		
		/*램에 저장되있는 가상의 데이터를 실제 파일데이터로 써주는 코드임*/
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
				
		/*대체하겠다. 파일 구분자를 / 로 바꾸기.  왜? 브라우저에서 \를 인식하지 못해서, 윈도우에서 구분을 못해서....*/
		String re =thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
				
		return re;
		
	}
	
	
	private static String makeSubImage(String uploadPath, String path, String fileName) throws Exception{
		
		File sF = new File(uploadPath+path, fileName);
						
		/*path안에 있는 파일의 정보를 읽어서 메모리에 저장*/
		BufferedImage sourceImg = ImageIO.read(sF);		
		
		/*이미지의 크기를 줄이기*/
		BufferedImage destImg= Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 400);
		
		//BufferedImage destImg= Scalr.resize(sourceImg, 200, 300);
		
				
		//	BufferedImage destImg= Scalr.resize(sourceImg, 100, 100);
		
		//Scalr.res
		
		/*썸네일 이미지 이름 지정*/
		String thumbnailName = uploadPath + path + File.separator+"s_"+fileName;		
			
		/*이미지 파일이면 썸네일 처리. 아니면 파일명만 보이게*/
		File newFile = new File(thumbnailName);		
				
		/*. 뒤부터 확장자만 가져오기*/
		String formatName=  fileName.substring(fileName.lastIndexOf(".")+1);
		
		
		/*램에 저장되있는 가상의 데이터를 실제 파일데이터로 써주는 코드임*/
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
				
		/*대체하겠다. 파일 구분자를 / 로 바꾸기.  왜? 브라우저에서 \를 인식하지 못해서, 윈도우에서 구분을 못해서....*/
		String re =thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
				
		return re;
		
	}
	
	
	private static String makeMainImage(String uploadPath, String path, String fileName) throws Exception{
		
		File sF = new File(uploadPath+path, fileName);
						
		/*path안에 있는 파일의 정보를 읽어서 메모리에 저장*/
		BufferedImage sourceImg = ImageIO.read(sF);		
		
		/*이미지의 크기를 줄이기*/
		BufferedImage destImg= Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
		
		//BufferedImage destImg= Scalr.resize(sourceImg, 200, 300);
		
				
		//	BufferedImage destImg= Scalr.resize(sourceImg, 100, 100);
		
		//Scalr.res
		
		/*썸네일 이미지 이름 지정*/
		String thumbnailName = uploadPath + path + File.separator+"s_"+fileName;		
			
		/*이미지 파일이면 썸네일 처리. 아니면 파일명만 보이게*/
		File newFile = new File(thumbnailName);		
				
		/*. 뒤부터 확장자만 가져오기*/
		String formatName=  fileName.substring(fileName.lastIndexOf(".")+1);
		
		
		/*램에 저장되있는 가상의 데이터를 실제 파일데이터로 써주는 코드임*/
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
				
		/*대체하겠다. 파일 구분자를 / 로 바꾸기.  왜? 브라우저에서 \를 인식하지 못해서, 윈도우에서 구분을 못해서....*/
		String re =thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
				
		return re;
		
	}
}
