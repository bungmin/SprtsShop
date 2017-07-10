<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<jsp:include page="../header.jsp"></jsp:include>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style type="text/css">
    /* Remove the navbar's default rounded borders and increase the bottom margin */ 
    .navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }
    
    /* Remove the jumbotron's default bottom margin */ 
     .jumbotron {
      margin-bottom: 0;
    }
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }

</style>

</head>
<body>
<jsp:include page="/WEB-INF/views/page_header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<br>
			<h2>
				<span class="label label-default">회원정보</span>
			</h2>
			<hr>
		</div>
		<div class="row">
			<form id="myForm" class="form-horizontal" role="form" method="post">
				<div class="form-group">
					<div class="form-group">
					<input type="hidden" value="${userVO.state}" name="state">					
						<label class="col-sm-2 control-label" for="id">ID</label>
						<div class="col-sm-6">
							<input class="form-control" type="text" id="id" name="id" value="${userVO.id}" readonly="readonly">
						</div>
							
					</div>
				
					<div class="form-group">
						<label class="col-sm-2 control-label" for="name">이름</label>
						<div class="col-sm-6">
							<input class="form-control" type="text" id="name" name="name" value="${userVO.name}" readonly="readonly">
						</div>
					</div>
					
					
					<div class="form-group">
						<label class="col-sm-2 control-label" for="addr1">주소</label>
						<div class="col-sm-6">
							<input readonly="readonly" class="form-control" type="text" id="addr1" name="addr1" value="${userVO.addr1}" readonly="readonly">
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label" for="addr2">상세주소</label>
						<div class="col-sm-6">
							<input class="form-control" type="text" id="addr2" name="addr2" value="${userVO.addr2}" readonly="readonly">
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label" for="email">이메일</label>
						<div class="col-sm-6">
							<input class="form-control" type="text" id="email" name="email" value="${userVO.email}" readonly="readonly">
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label" for="birthday">생년월일</label>
						<div class="col-sm-6">
							<div class="input-group">
								<input class="form-control" id="birthday" type="text"
									name="birthday" value="${userVO.birthday}" readonly="readonly">
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label" for="phone">전화번호</label>
						<div class="col-sm-6">
							<input class="form-control" type="text" id="phone" name="phone" value="${userVO.phone}" readonly="readonly">
						</div>
					</div>
<!-- 
					<div class="form-group">
						<label class="col-sm-2 control-label" for="gender">성별</label>
						<div class="col-sm-6">
							<div class="radio">
								<label class="col-sm-2"> <input type="radio"
									name="gender" value="man" checked="checked"> 남자
								</label> <label class="col-sm-2"> <input type="radio"
									name="gender" value="woman"> 여자
								</label>
							</div>
						</div>
					</div>
 -->
					<!-- 
					<div class="form-group">
						<label class="col-sm-2 control-label" for="joincode">이메일
							인증번호</label>
						<div class="col-sm-6">
							<input class="form-control" type="joincode" id="joincode"
								name="joincode" placeholder="인증번호를 입력하세요.">
						</div>
						<div class="col-sm-4">
								<strong><button id="joincodecheck">이메일 인증</button></strong>			
						</div>
					</div>
					 -->

					<div class="form-group">
						<div class="col-sm-10 col-sm-offset-2">
							<button class="btn btn-info text-center" type="submit">수정하기</button>
							<button id="deleteUser" class="btn btn-warning text-center" type="button">회원탈퇴</button>
							<button id="mainpage" class="btn btn-warning text-center" type="button" >메인페이지</button>
						</div>
					</div>

				</div>
			</form>
			<hr>
		</div>
	</div>
	
	
	<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>
	
	
	<script type="text/javascript">
	
$(document).ready(function() {	
		
			var $form = $("form[role='form']");
			
			$("button[type='submit']").click(function(event){
		 		$form.attr("method", "GET");
		 		$form.attr("action", "/user/update");
		 		$form.submit();  
		 		/* location.href="/user/updateForm?id=${login.id}"; */
			});
			
		 	$("#mainpage").click(function() {				
				/* 메인 페이지로 이동하기 만들기 */
		 		location.href="/";
			});
		 	
		 	
		 	$("#deleteUser").click(function() {
				alert("정상적으로 탈퇴 되었습니다.")		
		 		$form.attr("method", "GET")
		 		$form.attr("action", "/user/delete");
		 		$form.submit(); 
		 		
		 		/* location.href="/user/delete"; */
			});
		 	
});


			
			
		
	

		

	</script>



</body>
</html>