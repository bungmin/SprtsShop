/**
 * 
 */


function checkImageType(fileName) {
				/* 파일이름에 jpg, png, 등등 인지 확인하는 함수 */
				
				/* //정규화 표현식 
				//i 대소문자 구분하지 않겠다
				//g 한줄식 체크
				//m 여러줄 체크 */
				
				//fileName = "aaa.jpg";   true
				//fileName = "aaa.txt";   false
				//fileName = "fjpg.txt";   true				
				
				var pattern = /jpg|gif|png|jpeg/i;				
				/* match라는 함수가 패턴에 있으면 true, false */
								
				return fileName.match(pattern); 
				
}

function getFileInfo(fullName) {
	var fileName, imgsrc, getLink;
	var fileLink;		/*UUID+ 원래 파일이름을 적용한 이름..*/
	
	if(checkImageType(fullName)){		/*이미지파일이다*/
		imgsrc= "/displayFile?fileName="+fullName;		//아이콘의 표시될 그림.  fullanme /2017/05/31/safasfsa  작은 그림을 표시하겠다..
		fileLink = fullName.substr(14);					//인덱스  s_ 뺴고 UUID부터 그이후까지.   원본파일을 링크하겠다.....
		
		var prefix=fullName.substr(0,12);			//앞에 부분...
		var suffix=fullName.substr(14);				
		
		getLink = "/displayFile?fileName="+prefix+suffix;
	}else{		/*이미지가 아니였을때*/
		imgsrc = "/resources/img/back.png";			/*그림판으로 만든담에 resources 폴더에 넣을꺼임.*/ 
		fileLink = fullName.substr(12);				//일반파일은 s_ 가 안들어가기때문에.......
		getLink = "/displayFile?fileName="+fullName;		
	}
	
	fileName = fileLink.substr(fileLink.indexOf("_")+1);       //원래 오리지날 파일 네임 예) 학교.txt
	
	/*핸들바스에서는 반드시 대문자*/
	
	
	
	
	return {fileName: fileName, imgsrc: imgsrc, getLink:getLink, fullName:fullName};	
	
}