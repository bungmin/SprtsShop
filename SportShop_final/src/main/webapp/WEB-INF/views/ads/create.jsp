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
<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>
<div class="container">
		<div class="row">
			<br>
			<h2>
				<span class="label label-info">광고 등록</span>
			</h2>
			<hr>
		</div>
		<div class="row">
			<form class="form-horizontal" role="form" id="myForm" method="post">
				<input type="hidden" value="${login.id}" name="id">
				<input type="hidden" value="${login.position}" name="position">
				<div class="form-group">
					<div class="form-group">
						<label class="col-sm-2 control-label" for="a_title">광고 타이틀</label>
						<div class="col-sm-6">
							<input class="form-control" type="text" id="a_title" name="a_title"
								placeholder="광고 명을 입력하세요">
						</div>
						<div class="col-sm-4">
							<!-- <strong><div id="idcheck"></div></strong> -->
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="a_img_link">광로 연결 링크</label>
						<div class="col-sm-6">
							<input class="form-control" type="url" id="a_img_link"
								name="a_img_link" placeholder="연결할 광고 링크(URL)를 써주세요">
						</div>
						<div class="col-sm-4">
							<!-- <strong><div id="pw1check"></div></strong> -->
						</div>
					</div>				
				
					<div class="form-group">
						<label class="col-sm-2 control-label" for="a_img_name">광고 이미지 이름</label>
						<div class="col-sm-6">
							<input class="form-control" type="file" placeholder="광고 이미지 파일 올려주는데">
						</div>
						<div class="col-sm-4">
							<!-- <strong><div id="pw1check"></div></strong> -->
						</div>
					</div>			
					
					<ul class="clearfix uploadedList">
							
					</ul>
					<!-- <div class="form-group">
						<label class="col-sm-2 control-label" for="a_img_name">광고 이미지 파일 미리보기</label>
						<div class="col-sm-6">
							
						</div>
						<div class="col-sm-4">
							<strong><div id="pw1check"></div></strong>
						</div>
					</div>			
				 -->
					
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
	
	<script id="source" type="text/x-handlebars-template">
			
				<li class="col-xs-3">
					<span>
						<img src="{{imgsrc}}">
					</span>
					<div>
						<a href="{{getLink}}">{{fileName}}</a>				
						<a href="{{fullName}}" class="btn btn-default btn-xs pull-right delbtn"><span class="glyphicon glyphicon-remove-circle"/></a>					
					</div>
				</li>			
			</script>
	
	<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>
	
	<script type="text/javascript">
		$(document).ready(function() {
			
			var source=$("#source").html();
			var template= Handlebars.compile(source);
			
			  var position ='${login.position}';
			  
			  if(position == 'user'){
				  alert("권한이 없습니다.");
				  location.href="/";
			  }
			
			
			
			$("input[type=file]").change(function(event){
				
				//event.originalEvent.data
			
			
				event.preventDefault();
				var files = event.originalEvent.target.files;
				var file = files[0];
				
				var formData = new FormData();
				formData.append("file", file);
				
				$.ajax({
					type: "post",
					url: "/uploadAjax",
					data: formData,
					dataType: 'text',
					processData: false,
					contentType: false,
					success: function(result) {
						var data = getFileInfo(result);
						var ht=template(data);
						
						
						$(".uploadedList").html(ht);						
					}					
				});
	 

			});
			
			
			$(".uploadedList").on("click", "li div .delbtn", function(event) {
				
			
				 event.preventDefault();
				var delBtn = $(this);	
				var delLi = $(this).parent("div").parent("li");
				
				$.ajax({
					type: "post",
					url: "/deleteFile?fileName="+delBtn.attr("href"),
					/* data: {
						fileName: 
					}, */
					dataType: "text",
					success: function(result) {						
						if(result=="DELETE_SUCCESS"){
							delLi.remove();
							alert("삭제가 되었습니다.");
						}
						
					}
					
				});
 
			});
			
			
			
			$("button[type='submit']").click(function(event) {
				

				event.preventDefault();
				//var subBtn=$(this);
				var form=$("#myForm");
				var str="";
			
				
			
				
				
			
				$(".delbtn").each(function(index) {
					
					str += "<input value='"+$(this).attr("href")+"' name=a_img_name type='hidden'>";
					
				})			
		 
				
				//alert(str);
				form.append(str);
				
				form.get(0).submit();
				
			});
			
		});
		
		
	</script>
</body>
</html>