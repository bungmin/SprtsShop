<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/resources/bs/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet"
	href="/resources/bs/css/bootstrap.min.css">
<script type="text/javascript" src="../resources/jquery.js"></script>
<script src="/resources/bs/js/bootstrap.min.js" type="text/javascript"></script>
<script src="https://use.fontawesome.com/87057865c2.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js" type="text/javascript"></script>
</head>
<body>

		<section id="section1">
		
		</section>

		<script id="source" type="text/x-handlebars-template">
	
		<div>{{name}}</div>
		<div>{{addr}}</div>
		<div>{{addsi addr}}</div>

		{{#test name}}
			<div>조건에 따라 출력 여부가 결정됨</div>
		{{/test}}
				
		</script>
		<!-- addsi 함수명
		addr 함수의 데이터 -->
		
		<script type="text/javascript">
		
			var source = $("#source").html();
			var template =Handlebars.compile(source);
			var data={name:"박", addr:"서울"};
			
			
			
			/* addsi 함수명 
			addr 함수의 데이터
			*/
			Handlebars.registerHelper("addsi", function(addr) {
				return addr+"시";
			});
			
			
			
			 Handlebars.registerHelper("test", function(name, option) {
				var str="";
				
				// option.fn() 의미 :  <div>조건에 따라 출력 여부가 결정됨</div>
				
				
				
				if(name=='김'){
					str+= option.fn();	
				}				
				
				
				return str;
				
			});
			
			
			
			
			
			var html=template(data);
			
			$("#section1").append(html);
			/* append는 추가
			html은 덮어쒸우는거 */
		
		</script>
		
		

</body>
</html>