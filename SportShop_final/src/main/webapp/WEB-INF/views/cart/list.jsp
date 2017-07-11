<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../header.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<br>
			<h2>
				<span class="label label-info">장바구니</span>
			</h2>
			<hr>
			<table border="1"
				class="table table-bordered table-condensed table-hover">
				<thead>
					<tr class="info">				
						<th>cno</th>
						<th>pno</th>
						<th>제목</th>
						<th>이미지</th>
						<th>상품명</th>						
						<th>브랜드명</th>						
						<th>원산지</th>					
						<th>구매가격</th>				
						<th>사이즈</th>	
						<th>구매량</th>				
						<th>장바구니삭제</th>					
						<!-- <td>내용보기</td> 내용관련 페이지로 넘어가게끔 하기 -->
					</tr>
				</thead>
				<tbody class="cartlist">
	
				</tbody>
			</table>
		</div>
		
		<div class="form-group" align="right">
			<button class="btn btn-primary" id="goPurchase">결재페이지로</button>
			<button class="btn btn-info" id="goList">계속쇼핑하기</button>
		</div>
		
	</div>
	
	
			
	<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>
</body>

<script id="source" type="text/x-handlebars-template">
			{{#each.}}
					<tr>
						<td>{{cno}}</td>
						<td>{{pno}}</td>
						<td>{{p_title}}</td>
						<td><img src="/displayFile?fileName={{p_img_1}}"></td>
						<td>{{p_name}}</td>						
						<td>{{p_brand_name}}</td>				
						<td>{{p_made}}</td>		
						<td>{{p_price}}</td>			
						<td>{{p_size}}</td>
						<td>{{count}}</td>

							
						<td>
							<button data-cno="{{cno}}" class="btn btn-info delBtn">장바구니 삭제 </button><br>
							<a href="/userProductList/productDetail?pno={{pno}}" class="btn btn-default detailView ">상세보기 </a>
						</td>
					</tr>				
			{{/each}}	
		</script>

<script type="text/javascript">
	$(document).ready(function() {
	//	var id = '${login.id}';
		
		//getAllCart(id);
		var id = '${login.id}';
		
		getAllList(id);
		
		$("#goPurchase").click(function(){			
			var data_cno = $(".cartlist").find("button").attr("data-cno");
			
			
			
			if(data_cno == null){
				alert("결제할 상품이 없습니다.");
				
			}else{
				location.href="/product/purchaseProductPage?id="+id+"&pno=0&count=0";				
			}
			
			
		});
		
		$("#goList").click(function (){
			location.href ="/userProductList/listSearchCriteria?category=all";
			
		});
		
		
		$(".cartlist").on("click", ".delBtn", function(event) {
			var cno = $(this).attr("data-cno");		

			 $.ajax({
				type : "delete",
				url : "/cartinfo/deletecart/" + cno,
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "DELETE"
				},
				dataType : "text",
				success : function(result) {	
					alert(result);
					getAllList(id);					
				}
			});			
			
			
		});
		
		
		
	});
	
	function getAllList(id) {		
		
		$.getJSON("/cartinfo/listcart/"+id, function(data) {			
		
			var source = $("#source").html();
			var template =Handlebars.compile(source);
			var gab=data;
			
			//alert(data[1].cartVo.cno);
	
			
			$(".cartlist").html(template(gab)); 
			
			
		});
	};
		
		
		
		
	



</script>
</html>