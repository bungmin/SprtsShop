<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<jsp:include page="../header.jsp"></jsp:include>
<script type="text/javascript">

	$(document).ready(function() {		
		$("form").submit(function() {
			var id = document.getElementById("idcheck").textContent;
			var password = document.getElementById("password").textContent;		
						
			if(id == ""){
				alert("아이디를 제대로 입력하세요");
				$("#id").select();
				$("#id").focus();				
				return false;
			}else if(password ==""){
				alert("비밀번호를 제대로 입력하세요.");
				$("#password").focus();	
				return false;
			}
			return true;			
		});		
		
		
		$("button[type=reset]").click(function() {
			location.href = "/";
		})
		
	});
</script>
</head>
<body>
	
	<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<form class="form-horizontal" action="/user/loginPost" method="post">
				<div class="form-group">
					<label class="text-right col-xs-2 control-label" for="id">아이디</label>
					<div class="col-xs-10">  
					<input name="id" class="form-control" id="id" placeholder="아이디를 입력하세요">
					</div>
				</div>				
				<div class="form-group">
					<label class="text-right col-xs-2 control-label" for="pw">Password</label> 
					<div class="col-xs-10">
					<input type="password" name="pw" class="form-control" id="pw" placeholder="비밀번호를 입력하세요">
					</div>
				</div>				
				<div class="form-group">					
					<div class="col-xs-offset-2 col-xs-10">
						<button class="btn btn-primary form-control" type="submit">로그인</button>
					</div>
				</div>
								
				<div class="form-group">					
					<div class="col-xs-offset-2 col-xs-10 text-center">
						<select class="selectpicker show-tick" data-width="auto"
							id="position" name="position">
							<option disabled data-icon="fa fa-sort"
								data-header="Select a condiment">권한 여부</option>
							<option value="user">일반유저</option>
							<option value="admin">관리자</option>
							<option value="ceo">경영자</option>							
						</select>
						<a href="/user/idfind" class="btn btn-info">아이디 찾기</a> &nbsp;&nbsp; &nbsp;&nbsp;
						<a href="/user/pwfind" class="btn btn-info">비밀번호 찾기</a>  &nbsp;&nbsp; &nbsp;&nbsp;							  
					</div>
				</div>				
			</form>
					
		</div>	
	</div>
	
	<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>

</body>
</html>