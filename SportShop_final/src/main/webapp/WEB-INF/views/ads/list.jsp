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
.fileDrop {
	width: 80%;
	height: 100px;
	border: 1px dotted gray;
	background-color: lightslategray;
	margin: auto;
}

.uploadedList li {
	list-style-type: none;
}
</style>

</head>
<body>
	<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>
	<!-- <div class="container">
		<div class="row">
			<br>
			<h3>
				<span class="label label-info">DB에 등록된 광고 목록</span>
			</h3>
			<hr>
		</div>

		<div class="row">
			<div class="table-responsive">
			<table class="table table-bordered table-hover" border="1">
				table-condensed: table 크기가 줄어들음
				<thead>
					<tr class="info">
						<th>#</th>
						<th>등록 ID</th>
						<th>광고타이틀</th>
						<th>광고 링크</th>
						<th>광고 이미지 미리보기</th>
						<th>광고 클릭수</th>
						<th>등록 광고여부</th>
						<th>광고 게시</th>
						<th>광고 미게시</th>
						<th>DB 등록 삭제</th>
					</tr>
				</thead>			
			 	<tbody class="adslist">

				</tbody> 
			</table>
		</div>
	</div>
 -->
 
 
 
 <div class="container">		
		<div class="row">		
			<table class="table table-bordered table-condensed table-hover" border="1">
				
				<thead>
					<tr class="info">
						<th>#</th>
						<th>등록 ID</th>
						<th>광고타이틀</th>
						<th>광고 링크</th>
						<th>광고 이미지 미리보기</th>
						<th>광고 클릭수</th>
						<th>등록 광고여부</th>
						<th>광고 게시</th>
						<th>광고 미게시</th>
						<th>DB 등록 삭제</th>
						<th>DB 수정</th>
					</tr>
					 <tbody class="adslist">

					 </tbody> 
				</thead>			
			 	
			</table>
		</div>
			
				
	</div>


 
		<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>




		<script id="source" type="text/x-handlebars-template">
			{{#each.}}
					<tr>
						<td>{{ano}}</td>
						<td>{{id}}</td>
						<td>{{a_title}}</td>
						<td>{{a_img_link}}</td>
						<td><img class="img-responsive" style="width: 100%" src="/displayFile?fileName={{a_img_name}}"></td>
						<th>{{readcnt}}</th>
						<td>{{register}}</td>
						<td><button data-ano="{{ano}}" class="btn btn-warning registerBtn">DB 홈페이지에 게시</button></td>
						<td><button data-ano="{{ano}}" class="btn btn-default deleteBtn">DB 홈페이지에 게시 안하기</button></td>
						<td><button data-ano="{{ano}}" class="btn btn-info delBtn">DB 등록 삭제 </button></td>
						<td><button data-ano="{{ano}}" class="btn btn-success updateBtn">DB 수정</button></td>
					</tr>				
			{{/each}}	
		</script>

		<script type="text/javascript">

	$(document).ready(function(){
		
		  var position ='${login.position}';
		  
		  if(position == 'user'){
			  alert("권한이 없습니다.");
			  location.href="/";
		  }
		
		getAllList();
		
		$(".adslist").on("click", ".updateBtn", function(event) {
			var ano = $(this).attr("data-ano");			
			
			location.href="/ads/updateads?ano="+ ano;			
			
		});
		
		$(".adslist").on("click", ".registerBtn", function(event) {
			var ano = $(this).attr("data-ano");		

		
			 $.ajax({
				type : "delete",
				url : "/adsinfo/registerAds/" + ano,
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "DELETE"
				},
				dataType : "text",
				success : function(result) {							
					getAllList();					
				}
			});			
		});
		
		$(".adslist").on("click", ".deleteBtn", function(event) {
			var ano = $(this).attr("data-ano");		
			 $.ajax({
				type : "delete",
				url : "/adsinfo/deleteAds/" + ano,
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "DELETE"
				},
				dataType : "text",
				success : function(result) {
				//alert(result);
					getAllList();					
				}
			});			
		});
		
		
		
		
		$(".adslist").on("click", ".delBtn", function(event) {
			var ano = $(this).attr("data-ano");
			
			$.ajax({
				type : "delete",
				url : "/adsinfo/delete/" + ano,
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "DELETE"
				},
				dataType : "text",
				success : function(result) {
					if (result == 'DELETE_SUCCESS') {
					
						alert("삭제 되었습니다.");
						getAllList();
					}
				}

			});
			
			
			
		});
		

	/* 	var rno = $("#modal_rno").attr("data-rno");

		$.ajax({
			type : "delete",
			url : "/replies/" + rno,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "DELETE"
			},
			dataType : "text",
			success : function(result) {
				if (result == 'DELETE_SUCCESS') {
				//	$("#modDiv").hide("slow");
					alert("삭제 되었습니다.");
					getAllList(bno, replyPage);
				}
			}

		}); */
	
	
		
	});
	
	function getAllList() {		
		
		$.getJSON("/adsinfo/listads/", function(data) {
			var source = $("#source").html();
			var template =Handlebars.compile(source);
			var gab=data;	
			
			/* 
			//1방법	each돌리는거
			$(data).each(function() {
			//	alert(this.fullname);
				
				var imgData = getFileInfo(this.a_img_name);
				var ht=template(imgData);								
			})			 */
			
			
			$(".adslist").html(template(gab));
			
			
		});
		
	};


</script>
</body>
</html>