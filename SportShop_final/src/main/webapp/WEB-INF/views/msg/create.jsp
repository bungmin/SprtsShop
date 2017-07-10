<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../header.jsp"></jsp:include>
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
<script src="/resources/js/upload.js" type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>
<div class="container">
		<div class="row">
			<br>
			<h2>
				<span class="label label-info">1:1 문의 등록</span>
			</h2>
			<hr>
		</div>
		<div class="row">
			<form class="form-horizontal" role="form" id="myForm" method="post">
				<input type="hidden" value="${login.id}" name="id">
							
				<div class="form-group">
					<div class="form-group">
						<label class="col-sm-2 control-label" for="m_category">문의내용</label>
						<div class="col-sm-6">
							<select class="selectpicker show-tick" data-width="auto"
							id="m_category" name="m_category">
							<option disabled data-icon="fa fa-sort"
								data-header="Select a condiment">카테고리선택</option>
							<option value="payment">결제문의</option>
							<option value="delivery">배송문의</option>
							<option value="board">게시글문의</option>							
							<option value="member">회원정보문의</option>							
						</select>
						</div>
						<div class="col-sm-4">
							
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="title">타이틀</label>
						<div class="col-sm-6">
							<input class="form-control" type="text" id="title" name="title"
								placeholder="타이틀">
						</div>
						<div class="col-sm-4">
							<!-- <strong><div id="idcheck"></div></strong> -->
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="content">내용</label>
						<div class="col-sm-6">
							<textarea class="form-control" id="content"
								name="content" placeholder="문의할 내용을 적어주세요"></textarea>						
						</div>
						<div class="col-sm-4">
							<!-- <strong><div id="pw1check"></div></strong> -->
						</div>
					</div>				
					
					<div class="form-group">
						<div class="col-sm-10 col-sm-offset-2">
							<button class="btn btn-info text-center" type="submit">등록하기</button>
							<button class="btn btn-info text-center" type="reset">초기화</button>
							<button class="btn btn-info text-center" type="button"
								id="mainpage">메인페이지로</button>
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
			
				
			
			$("button[type='submit']").click(function(event) {
				event.preventDefault();
				
				alert("관리자에게 문의 내용이 발송 되어졌습니다.");
				var form=$("#myForm");
				var str="";
			
				
				form.append(str);
				
				form.get(0).submit();
			});
			
			$("#mainpage").click(function(){
				location.href = "/";
				
			});
			
		});
		
		
	</script>
</body>
</html>