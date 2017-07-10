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
<style type="text/css">
	.fileDrop{
		width: 80%;
		height: 100px; 
		border: 1px dotted gray;
		background-color: lightslategray;
		margin: auto;
	}
		
	.uploadedList li{
		list-style-type:none;		
	}
</style>
</head>
<body>

<div class="container">
		<div class="row">
			<br>
			<h2>
				<span class="label label-info">캐시 충전</span>
			</h2>
			<hr>
		</div>
		<div class="row">
		
				<input type="hidden" value="${login.id}" name="id">			
				<div class="form-group">					
						<label class="col-sm-pull-2 control-label" for="cash">캐시 금액</label>
						<div>
							<select class="selectpicker show-tick" data-width="auto"
							id="cash" name="cash">
							<option disabled data-icon="fa fa-sort"
								data-header="Select a condiment">캐시금액</option>
							<option value="5000">5000원</option>
							<option value="10000">10000원</option>
							<option value="15000">15000원</option>							
							<option value="20000">20000원</option>							
						</select>
						</div>
						
						
				</div>
										
					<div class="form-group">
						<div class="col-sm-10 col-sm-offset-2">
							<button class="btn btn-info text-center" type="submit">충전하기</button>							
							<button class="btn btn-info text-center" type="button"
								id="mainpage">닫기</button>
						</div>
					</div>

				</div>
			
			<hr>
		</div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function() {
			
			
			$("button[type='submit']").click(function(event) {
				
				id = '${login.id}';
				cash = $("#cash").val();
					
				
				 $.ajax({
					type : "POST",
					url : "/userProductList/cashcharge",
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "DELETE"
					},
					dataType : "text",
					data : JSON.stringify({
						id : id,
						cash : cash
					}),
					success : function(result) {
						if (result == 'UPDATE_SUCCESS') {							
							alert("충전되어졌습니다.");
							window.open("https://www.inicis.com/Support_new/stdpay/INIStdPaySample/INIStdPayRequest.php","결제", "height=600, width=600, top=200, left=200");
							self.close();							
							opener.document.location.href= "/";
							
						
							
						}
					}

				});
		
 
		
			
				
				
			});
			
			$("#mainpage").click(function(){
				window.close();
				
			});
			
		});
		
		
	</script>
</body>
</html>