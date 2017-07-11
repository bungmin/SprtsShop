<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
   
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
#myCollapsible {
	margin-top: 30px;
}

	.proudctList li{
		list-style-type:none;		
		margin-bottom: 50px;
	}
	body{
	font-weight: bold;
	}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../header.jsp"></jsp:include>
<title>Insert title here</title>
<script type="text/javascript">

</script>


</head>
<body>

	<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>
	<div class="container">
		<div class="row">			
			<br>
			<h2>
				<span class="label label-info">상품 상세 페이지</span> 추천수 : <span id="goodcntview">${vo.p_goodcnt}</span>
			</h2>
			<hr>			
			<table class="table">
				<tbody>
					<tr>
						<td rowspan="6"><img align="center" alt="상품이미지" src="/displayFile?fileName=${vo.p_img_2}"></td>
						<td colspan="2">제목 : ${vo.p_category}</td>
					</tr>
					<tr>
						<td width="300">카테고리 : ${vo.p_category}</td>
						<td width="300">상품명 : ${vo.p_name}</td>
					</tr>
					<tr>
						<td>브랜드 : ${vo.p_brand_name}</td>
						<td>원산지 : ${vo.p_made}</td>
					</tr>
					<tr>
						<td colspan="2" style="color: red;">판매가 : ${vo.p_price} &nbsp; <strong> 할인률 : ${vo.p_discount_rate} </strong> <div id="finalPrice"></div></td>
						<!-- <td style="color: red;"></td> -->
					</tr>
					<tr>
						<td colspan="2">SIZE : ${vo.p_size}	
						</td>						
					</tr>
					
					<tr>
						<td>재고량 : ${vo.p_amount}</td>
						<td>
							구매량 : <input type="number" id="count" name="count">
						</td>						
					</tr>
					<tr>
					<td colspan="3" class="text-right">
							<button id="reviewInsertForm" class="btn btn-default text-center">상품 후기</button>							
							<a id="cartInsert" class="btn btn-default text-center" type="button">장바구니담기</a>
							<button id="pucharseProduct" class="btn btn-default text-center" type="button">구매하기</a>
							<button id="goodcnt" class="btn btn-default text-center" type="button">추천하기</button>
							<a href="/userProductList/listSearchCriteria?page=${cri.page}&perPageNum=${cri.perPageNum}&category=${cri.category}&orderType=${cri.orderType}" class="btn btn-default text-center" type="button">목록</a>					
					</td>					
					</tr>
				</tbody>			
			</table>
			<div id="content" align="center">
				${vo.p_content}
			</div>
			
			
			<hr>
			
			
			<div id="myCollapsible" class="row collapse">			
			<button class="btn btn-success text-center">상품 후기 등록 </button>
			
			<div class="form-group">
				<label for="reviewid">작성자</label> <input id="reviewid"
					value ="${login.id}" class="form-control" readonly="readonly">
			</div>

			<div class="form-group">
				<label for="reviewcontent">내용</label> <input id="reviewcontent"
					class="form-control">
			</div>			

			<div class="form-group">
				<button id="reviewInsert" class="btn btn-default">댓글등록</button>
				<button id="reviewReset" class="btn btn-default">초기화</button>
			</div>
		</div>
		
		<hr>		
		<div class="row">
		<div id="reviews" class="row jump">		
		</div>	
		</div>
		
		<div class="row">
			<ul class="pagination pagination-sm">
			
			</ul>		
		</div>
			
		</div>
	</div>	
	
	<!-- 모달 -->
		<div class="row">
			<div data-backdrop="static" id="myModal" class="modal fade">
				<div class="modal-dialog" >
					<div class="modal-content" style="background-color: #D4F4FA; opacity: 0.8;">
						<div class="modal-header">
							<button data-dismiss="modal" class="close">&times;</button>							
							<div>
							 	<strong style="float: left;">상품 후기 번호 : </strong>
								<p id="modal_revno"></p>							
							</div>
						</div>
						<div class="modal-body">
							<input id="modal_content" class="form-control">
						</div>					
						
						<div class="modal-footer">					
							<button data-dismiss="modal" class="btn" id="modal_update">수정</button>
							<button data-dismiss="modal" class="btn" id="modal_delete">삭제</button>					
							<button data-dismiss="modal" class="btn" id="modal_close">닫기</button>
						</div>
					</div>
					
				</div>	
			</div>		
		</div>	
	
	
			
		
	
	
		
	
	
	
	<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>
	
	
		<script id="source" type="text/x-handlebars-template">
					{{#each.}}		
	<div class="panel panel-info">
				<div class="panel-heading">
					<span><i class="fa fa-sticky-note" aria-hidden="true"></i> 글번호 : {{revno}}, <i class="fa fa-user" aria-hidden="true"></i> : {{id}}</span>
					<span class="pull-right"><i class="fa fa-calendar-o" aria-hidden="true"></i> : {{regdate}}</span>					
				</div>
				<div class="panel-body replyLi">
					<p data-revno="{{revno}}" data-rnum="{{rnum}}">{{content}}</p>

					{{#eqReplyer id}}
						<button class="btn btn-default callModal">수정/삭제</button>
					{{/eqReplyer}}				
				</div>		
	</div>
	{{/each}}	
		</script>



</body>
<script type="text/javascript">
	$(document).ready(function() {		
		var p_price =${vo.p_price};
		var p_discount_rate =${vo.p_discount_rate};
		var reviewPage=1;
		
		
		var final_price = p_price * (1-p_discount_rate/100);
		$("#finalPrice").html("할인적용된 가격 :"+final_price);	
		
		var pno = ${vo.pno};	
		
		getAllList(pno, reviewPage);	
		
		$("#goodcnt").click(function(){
			
			
			var pno=${vo.pno};
			
			var login = '${login}';
			if(login == ""){
				alert("로그인을 하셔야합니다.");
				location.href= "/user/login";				
			}else{
				$.ajax({
					type : "get",
					url : "/userProductList/goodcnt/" + pno,
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "DELETE"
					},
					dataType : "text",
					success : function(result) {
						
						
						$.getJSON("/userProductList/productDetailajax/"+pno, function(data) {
							
							$("#goodcntview").html(data.p_goodcnt);
							
						});
						
						 alert("추천되어졌습니다."); 
						
					}

				});

				
				
			}
			
			 			
			//location.href="/userProductList/goodcnt?pno=${vo.pno}";
			
		});
		
		
		$("#pucharseProduct").click(function() {
			var count = $("#count").val();
			var amount=${vo.p_amount};
			
			var login = '${login}';
			if(login == ""){
				alert("로그인을 하셔야합니다.");
				location.href= "/user/login";				
			}else{				
				if(count > amount){
					alert("구입 수량을 다시 입력해주세요. 등록한 상품수보다 많습니다.");
				}else if(count == ""){
					alert("구입 수량을 써주세요. 구입수량은 재고량보다 많이 적으실 수 없습니다.");					
				}else{
					location.href="/product/purchaseProductPage?pno=${vo.pno}&count="+count;				
				}
				
			}
			
			
						
		});
		
		/* 클래스가 callModal $(this)  
		바로 앞에 있는 p태그	*/		
		$("#reviews").on("click", ".callModal", function() {		
			var revno=$(this).prev("p").attr("data-revno");				
			var content =$(this).prev("p").text();				
		
					
					//$("#modal_rno").attr("data-rno", rno);
					
					$("#modal_revno").text(revno);
					
					$("#modal_revno").attr("data-revno", revno);
						
					$("#modal_content").val(content);			
									
					$("#myModal").modal("show");
				
				
					
		});
		
		$("#modal_close").click(function() {
			
			$("#myModal").modal("hide");
			
		});
		
		
		$("#modal_delete").click(function(){
			var revno = $("#modal_revno").attr("data-revno");			

			 $.ajax({
				type : "delete",
				url : "/review/" + revno,
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "DELETE"
				},
				dataType : "text",
				success : function(result) {
					if (result == 'DELETE_SUCCESS') {
					//	$("#modDiv").hide("slow");
						alert("삭제 되었습니다.");
						getAllList(pno, reviewPage);
					}
				}

			});
 		
		});
		
		
		$("#modal_update").click(function() {
			
			//var rno=$("#modal_rno").text();
			var revno = $("#modal_revno").attr("data-revno");
			var content =$("#modal_content").val();			

			 $.ajax({
				type : "PUT",
				url : "/review/" + revno,
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "DELETE"
				},
				dataType : "text",
				data : JSON.stringify({
					content : content
				}),
				success : function(result) {
					if (result == 'UPDATE_SUCCESS') {
						
						alert("수정되었습니다");
						getAllList(pno, reviewPage);
					}
				}

			}); 
			
		});
		
		
		$("#cartInsert").click(function() {
		
			var pno = ${vo.pno};
			var id = '${login.id}';			
			var count = $("#count").val();
			var amount=${vo.p_amount};
			
			var login = '${login}';
			if(login == ""){
				alert("로그인을 하셔야합니다.");
				location.href= "/user/login";				
			}else{
				
				
				if(count > amount){
					alert("구입 수량을 다시 입력해주세요. 등록한 상품수보다 많습니다.");
				} else if (count < 0){
					alert("0보다 큰 값을 입력하세요");
				}else if(count == ""){
					alert("구매량을 입력해야합니다.");
				}else {
					//location.href="/product/purchaseProductPage?pno=${vo.pno}&count="+count;
					$.ajax({
						type : "PUT",
						url : "/cart/insert",
						headers : {
							"Content-Type" : "application/json",
							"X-HTTP-Method-Override" : "DELETE"
						},
						dataType : "text",
						data : JSON.stringify({
							id : id,
							pno : pno,
							count : count
						}),
						success : function(result) {
							 alert(result);	 				
						},error: function(result) {
							 alert(result); 
						}	 	
					});
				}
				
				
			}
			
			
			
					
		
		});
		
		$(".pagination").on("click", "li a", function(event) {
			event.preventDefault(); 
			replyPage=$(this).attr("href");
			getAllList(pno,replyPage);
			
		});
		
		$("#reviewInsertForm").click(function() {
			
			var login = '${login}';
			if(login == ""){
				alert("로그인을 하셔야합니다.");
				location.href= "/user/login";				
			}
			
			
			$("#myCollapsible").collapse("toggle");
			
		});
		
		
		$("#reviewReset").click(function() {
			$("#reviewcontent").val("");
			
		});
		
		$("#reviewInsert").click(function() {
			var id=$("#reviewid").val();
			var content=$("#reviewcontent").val();
			var pno = ${vo.pno};
			
			
			
			
			$.ajax({
				type: "post",
				url: "/review",
				headers: {
					"Content-Type":"application/json",
					"X-HTTP-Method-Override":"POST"
				},
				dataType: "text",
				data: JSON.stringify({
				/* stringify : 객체를 JSON 문자열로 바꿔주는 메소드 */
					pno:pno,
					id:id,
					content:content
				}),
				
				success: function(result) {					
					if(result=="INSERT_SUCCESS"){
						alert("댓글입력성공");
						getAllList(pno, reviewPage); 
						$("#myCollapsible").collapse("toggle");
						$("#reviewcontent").val("");
						
					/* 	$("#reviewid").val("");
						 */
					}
				}
			});			
		});		
	});
	
	
	
	function getAllList(pno, page) {
		$.getJSON("/review/"+pno+"/"+page, function(data) {
			
	
			 var source = $("#source").html();
			var template =Handlebars.compile(source);
			var gab=data.list;
			
			
			Handlebars.registerHelper("eqReplyer", function(id, option) {
				var str="";
				if(id=='${login.id}'){
					str+=option.fn();
					
				}
				return str;					
			});
			
			
			$("#reviews").html(template(gab));
			
			
			printPaging(data.pageMaker);
	 		
			
		});
		
	};
	
	function printPaging(pageMaker) {
		var str="";
		if(pageMaker.cri.page>1){
			str+="<li><a href='"+(pageMaker.cri.page-1)+"'>&laquo;</a></li>";					
		}		
		
		for(var i=pageMaker.startPageNum; i<=pageMaker.endPageNum; i++){
			var strClass = pageMaker.cri.page == i ? 'class=active' : '';
			
			str+= "<li "+strClass+"><a href='"+i+"'>"+i+"</a></li>";
		}
		
		if(pageMaker.cri.page < pageMaker.totalPage){
			str+="<li><a href='"+(pageMaker.cri.page+1)+"'>&raquo;</a></li>";					
		}	
		
		$(".pagination").html(str);
		
		
	};
	

</script>
</html>