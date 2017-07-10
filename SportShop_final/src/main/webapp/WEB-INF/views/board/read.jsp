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
	#myCollapsible{
		margin-top: 30px;
	}
	
	.jump{
		margin-top: 50px;
	}
	.uploadedList{
		list-style: none;
		margin-bottom: 50px;
	}
	.popup{
		position: absolute;
	}
	.back{
		background-color: gray;
		opacity: 0.5;
		width: 50%;
		height: 100%;
		overflow: hidden;
		z-index: 1101;
	}
	.front{
		border: 1px;
		margin: auto;
		opacity: 1;
		z-index: 1110;
	}
	.show{
		position: relative;
		max-width: 1200px;
		max-height: 800px;
		overflow: auto;
	}
	
</style>

<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/page_header.jsp"></jsp:include>
	<form role="form" method="post"> <!-- action값이 없으면 사용한 페이지 그대로 돌아감 -->
		<input value="${vo.bno}" id="bno" name="bno" type="hidden"> <!-- bno를 가져감 -->
		<input value="${cri.page}" name="page" type="hidden">
		<input value="${cri.perPageNum}" name="perPageNum" type="hidden">
	</form>
	
	<div class="container">
		<div class="row">
		
			<div style="display: none;" class="popup back"></div>
			<div style="display: none;" id="popup_front" class="popup front">
				<img id="popup_img">
			</div>
			
			
			<div class="form-group">
				<label for="title">제목</label>
				<input readonly="readonly" value="${vo.title}" name="title" class="form-control">
			</div>
			
			<div class="form-group">
				<label for="id">작성자</label>
				<input readonly="readonly" value="${vo.id}" name="id" class="form-control">
			</div>
			
			<div class="form-group">
				<label for="content">내용</label>
				<!-- <input readonly="readonly" value="${vo.content}" name="content" class="form-control"> -->
				${vo.content} 
			</div>
			
			<div class="form-group">
				<label for="uploadedList">첨부파일</label>
				<ul id="uploadedList" class="clearfix uploadedList">
				</ul>
			</div>
			
			<div class="form-group">
				<button class="btn btn-info" type="submit">목록</button>
				
				<c:if test="${not empty login}">
					<button id="reply_form" class="btn btn-primary" type="submit">댓글</button>
				</c:if>
				
				<c:if test="${vo.id==login.id}">
					<button class="btn btn-warning" type="submit">수정</button>
					<button class="btn btn-danger" type="submit">삭제</button>
				</c:if>
			</div>  
			
		</div>
	</div>
		
	<div class="container">
		<div class="row">
		
		<div id="myCollapsible"  class="row collapse">
			<div class="form-group">
				<label class="id">작성자</label>
				<input readonly="readonly" value="${login.id}" id="id" class="form-control">
			</div>
			
			<div class="form-group">
				<label class="replyText">내용</label>
				<input id="replyText" class="form-control">
			</div>
			
			<div class="form-group">
				<button id="replyInsertBtn" class="btn btn-default" >댓글등록</button>
				<button id="replyResetBtn" class="btn btn-default" >초기화</button>
			</div>	
			</div>
		</div>
			
		<div id="replies" class="row jump">
		
		</div>
		
		<div class="row">
			<ul class="pagination"></ul>
		</div>
		
		<div class="row">
			<div data-backdrop="static" id="myModal" class="modal fade"> <!-- data-backdrop="static" 다른 화면을 눌러도 꺼지지않음 -->
				<div class="modal-dialog">
				
					<div class="modal-header">
						<button data-dismiss="modal" class="close">&times;</button>
						<p id="modal_rno"></p>
					</div>
					
					<div class="modal-body">
						<input id="modal_replyText" class="form-control">
					</div>
					
					<div class="modal-footer">
						<button data-dismiss="modal" class="btn" id="modal_update">수정</button>
						<button data-dismiss="modal" class="btn" id="modal_delete">삭제</button>
						<button data-dismiss="modal" class="btn" id="modal_close">닫기</button>
					</div>
					
				</div>
			</div>
		</div>
		
		<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>
		
		
		<script id="sourceAttach" type="text/x-handlebars-template">
		
		<li class="col-xs-3" data-src="{{fullName}}"> <!-- "col-xs-3" 한줄에 4개씩 -->
			<span>
				<img alt="" src="{{imgsrc}}">
			</span>
			<div>
				<a href="{{getLink}}" class="largeShow">{{fileName}}</a>
			</div>
		</li>
		</script>
		
		
		<!-- data-rno 직접 만든 속성 -->
		<!-- 댓글작성 -->
		<script id="source" type="text/x-handlebars-template">
		{{#each.}}
		<div class="panel panel-info">
			<div class="panel-heading">
				<span>rno: {{rno}}, 작성자: {{id}}</span>
				<span class="pull-right">{{regdate}}</span>
			</div>
			<div class="panel-body">
				<p data-rno="{{rno}}">{{replyText}}</p>

				{{#eqReplyer id}}
					<button class="btn callModal">수정/삭제</button>
				{{/eqReplyer}}
			</div>
		</div>
		{{/each}}
		</script>
		
		
	</div>
		
	<script type="text/javascript">
		var bno = ${vo.bno};	
		var replyPage=1;
		
		$(document).ready(function(){
			getAllAttach(bno);//이미지 클릭시 생기는 이벤트
			getAllList(bno, replyPage);
			
			$(".uploadedList").on("click",".largeShow", function(event) {
				var fileLink=$(this).attr("href");
				if(checkImageType(fileLink)){
					event.preventDefault();
					var imgTag = $("#popup_img");
					imgTag.attr("src", fileLink);
					$(".popup").show("slow");
					imgTag.addClass("show");
				}
				$("#popup_img").on("click", function() {
					$(".popup").hide("slow");	
				});
				
			});
			
			$("#replies").on("click", ".callModal", function() {
				var	rno=$(this).prev("p").attr("data-rno"); //바로 앞 p태그에 속성값을 가져와 rno에 넣음
				var replyText=$(this).prev("p").text();  //prev("p")바로앞에 있는 p태그, this는 클래스가 callModal인 버튼
				$("#modal_rno").text(rno);
				$("#modal_replyText").val(replyText);
				
				$("#myModal").modal("show");
			}); 
			
			
			$("#reply_form").click(function() {
				$("#myCollapsible").collapse("toggle");
			});
			
			
			$("#replyResetBtn").click(function() {
				$("#replyText").val("");
			});
			
			
			$("#replyInsertBtn").click(function() {
				var id = $("#id").val();
				var replyText = $("#replyText").val(); //입력한거를 가져옴
				
				$.ajax({
					type:'post',
					url:'/replies',
					headers:{
						"Content-Type":"application/json",
						"X-HTTP-Method-Override":"POST"
					},
					dataType:"text",
					data:JSON.stringify({
						bno:bno, 
						id:id, 
						replyText:replyText
					}),
					
					success:function(result){
						if(result=="INSERT_SUCCESS"){
							alert("댓글을 등록했습니다.");
							getAllList(bno, replyPage);
							//비어있게 해줌
							$("#replyText").val(""); 
						}
						
					}
				});
				
			});
			
			
			var $form = $("form[role='form']"); 
			
			$(".btn-warning").click(function(){ //클래스가 btn-warning를 클릭시 나타나는 이벤트
				$form.attr("action", "/board/update");
				$form.attr("method", "get");
				$form.submit();
			});
			
			$(".btn-danger").click(function(){
				$form.attr("method", "POST")
				$form.attr("action", "/board/delete");
				$form.submit();
			});
			
			$(".btn-info").click(function(){
				$form.attr("method","get");
				$form.attr("action","/board/listCriteria");
				$form.submit();
			});
			
			$(".pagination").on("click", "li a", function () {
				event.preventDefault();
				replyPage=$(this).attr("href");
				getAllList(bno, replyPage);
			});
			
			

		});
		
		function getAllList(bno, page) {
			$.getJSON("/replies/"+bno+"/"+page, function(data) {
				var source = $("#source").html();
				var template = Handlebars.compile(source);
				var gab=data.list;
				
				Handlebars.registerHelper("eqReplyer", function(id, option) {
					var str="";
					if(id=='${login.id}'){
						str+=option.fn();
					}
					return str;
				});
				
				$("#replies").html(template(gab));
				printPaging(data.pageMaker);
			});
		}
		
		function printPaging(pageMaker) {
			var str="";
			if(pageMaker.cri.page>1){
				str+="<li><a href='"+(pageMaker.cri.page-1)+"'>&laquo;</a></li>";
			}
			
			for(var i=pageMaker.startPageNum; i<=pageMaker.endPageNum; i++){
				var strClass=pageMaker.cri.page==i?'class=active':'';
				str+="<li "+strClass+"><a href='"+i+"'>"+i+"</a></li>";
			}
			
			if(pageMaker.cri.page<pageMaker.totalPage){
				str+="<li><a href='"+(pageMaker.cri.page+1)+"'>&raquo;</a></li>";
			}
			$(".pagination").html(str);
		}
		
		

		$("#modal_update").click(function (){
			var rno = $("#modal_rno").text();
			var replyText = $("#modal_replyText").val();
			
			$.ajax({
				type: "PUT",
				url: "/replies/"+rno,
				headers: {
					"Content-Type":"application/json", 
					"X-HTTP-Method-Override":"PUT"
				},
				dataType: "text",
				data: JSON.stringify({
					replyText:replyText
				}),
				success:function(result){
					if(result=="UPDATE_SUCCESS"){
						alert("댓글이 수정되었습니다.");
						getAllList(bno, replyPage);
					}
				}
			});
			
		});
		

		$("#modal_delete").click(function (){
			var rno = $("#modal_rno").text();
			
			$.ajax({
				type: "delete",
				url:"/replies/"+rno,
				headers:{
					"Content-Type":"application/json",
					"X-HTTP-Method-Override":"DELETE"
				},
				dataType: "text",
				success:function(result){
					if(result=="DELETE_SUCCESS"){
						alert("댓글이 삭제되었습니다.");
						getAllList(bno, replyPage);
					}
				}
			});
			
		});
		


		function getAllAttach(bno){
			$.getJSON("/board/getAttach/"+bno, function(result) {
				var source =  $("#sourceAttach").html();
				var template = Handlebars.compile(source);
				$(result).each(function() {
					var fileInfo = getFileInfo(this);
					var ht = template(fileInfo);
					$(".uploadedList").append(ht);
				});
			});
		}
	</script>
</body>
</html>