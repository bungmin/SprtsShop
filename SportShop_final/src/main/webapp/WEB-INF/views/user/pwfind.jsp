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
	
		$("#pwfind").click(function() {
			
			var id = $("#id").val();
			var email = $("#email").val();						
			
			 $.ajax({
				type : "PUT",
				url : "/user/pwfind",
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "DELETE"
				},
				dataType : "text",
				data : JSON.stringify({
					id : id,
					email : email										
				}),
				success : function(result) {
					alert(result);					
				},error: function() {
					alert("잘못 입력하였습니다");
				}
 	
			});
		});
	
		 
		 
		 
		
		$("button[type=reset]").click(function() {			
			
				$("#id").val("");						
				$("#email").val("");			
						
				
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
				<span class="label label-default">비밀번호 찾기</span>
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
									
					<input class="form-control" id="id" type="text"
									name="id" placeholder="아이디를 입력하세요."> 
				
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
						<td colspan="3"><button style="margin-left: 400px;" class="btn btn-info" id="pwfind">비밀번호찾기</button>&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-warning" type="reset">초기화</button>&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-default" id="mainpage">메인페이지로</button></td>				
															
				</tr>
				</thead>
			</table>
	</div>
	
	<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>

</body>
</html>