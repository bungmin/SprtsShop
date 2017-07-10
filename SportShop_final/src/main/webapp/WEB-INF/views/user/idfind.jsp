<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<jsp:include page="../header.jsp"></jsp:include>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script type="text/javascript">
	
$(document).ready(function() {
	
		$("#idfind").click(function() {
			
			var name = $("#name").val();
			var email = $("#email").val();
			var birthday = $("#birthday").val();			
			
			 $.ajax({
				type : "PUT",
				url : "/user/idfind",
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "DELETE"
				},
				dataType : "text",
				data : JSON.stringify({
					name : name,
					email : email,
					birthday : birthday					
				}),
				success : function(result) {
					alert(result);					
				},error: function() {
					alert("정보가 일치하지 않습니다.");
				}
 	
			});
		});
	
		 
		 
		 $("#birthday").click(function() {
			 
			 
			 $("#birthday").datepicker({
				  changeMonth: true,
				  changeYear: true,
				  yearRange: "c-100:c",
				  dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],	
				  dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
				  monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	 	          monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	 	         
	 	          nextText: "다음 달", // next 아이콘의 툴팁.
	 	  	      prevText: '이전 달', // prev 아이콘의 툴팁.
	 	  	      dateFormat: "yy-mm-dd",
	 	  	      selectOtherMonths: true,
	 	  	   	  showAnim: "fold",
	 	  	      showButtonPanel: true,
	 	  	      currentText: "오늘날짜",
				  closeText: "닫기"				 
			 });		   	
	    });	
		
		
		$("button[type=reset]").click(function() {			
			
				$("#name").val("");						
				$("#email").val("");				
				$("#birthday").val("");		
				
			});
	
		 	$("#mainpage").click(function() {				
				/* 메인 페이지로 이동하기 만들기 */
				
		 		location.href="/";
			});
		 	
});
			
			
		
	

		

	</script>
</head>
<body>
	
	<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<br>
			<h2>
				<span class="label label-default">아이디 찾기</span>
			</h2>
		
		</div>
			<hr>
			
				<table class="table table-condensed table-hover">
				<thead>
				<tr>
					<td>이름</td>
					<!-- <td>썸네일 사진을 올려볼까 함</td> -->
					<td>	
					<td colspan="2">
									
					<input class="form-control" id="name" type="text"
									name="name" placeholder="이름을 쓰세요."> 
				
					</td>	
						
					<!-- <td>내용보기</td> 내용관련 페이지로 넘어가게끔 하기 -->
				</tr>
				<tr>
					<td>이메일</td>
					<!-- <td>썸네일 사진을 올려볼까 함</td> -->
					<td>	
					<td colspan="2">
								
					<input class="form-control" id="email" type="text"
									name="email" placeholder="이메일을 쓰세요."> 
				
					</td>
					
					<!-- <td>내용보기</td> 내용관련 페이지로 넘어가게끔 하기 -->
				</tr>
				<tr>
					<td>생년월일</td>
					<!-- <td>썸네일 사진을 올려볼까 함</td> -->
					<td>	
					<td colspan="2">
					<div class="input-group">						
					<input class="input-group form-control" id="birthday" type="text"
									name="birthday" placeholder="생년월일을 선택하세요."> <span
									class="input-group-addon glyphicon glyphicon-calendar"></span>
								</span>
					</div>
					</td>	
					<!-- <td>내용보기</td> 내용관련 페이지로 넘어가게끔 하기 -->
				</tr>
				<tr>
						<td colspan="3"><button style="margin-left: 400px;" class="btn btn-info" id="idfind">아이디찾기</button>&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-warning" type="reset">초기화</button>&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-default" id="mainpage">메인페이지로</button></td>				
															
				</tr>
				</thead>
			</table>
	</div>
	
	<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>

</body>
</html>