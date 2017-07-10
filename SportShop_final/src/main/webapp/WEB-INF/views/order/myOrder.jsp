<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<jsp:include page="../header.jsp"></jsp:include>
<script type="text/javascript">
$(document).ready(function() {	
	$("#search").click(function(){
		
		var date1 = $("#date1").val();
		var date2 = $("#date2").val();
		var id = '${login.id}';
		
		$.ajax({
			type: "PUT",
			url: "/order/dateOrder/",
			headers: {
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"PUT"
			},
			dataType: "json",							
			data: JSON.stringify({
				date1 : date1,
				date2 : date2,
				id : id
						
			}),							
			success : function(data) {				
				
			 	var source = $("#source").html();
				var template =Handlebars.compile(source);
				var gab=data;					
				
				
				$(".myOrder").html(template(gab)); 																
			}
		});
	});	
});
</script>
<title>Insert title here</title>
</head>
<body>

<script id="source" type="text/x-handlebars-template">
			{{#each.}}
					<tr>
							<td>{{ono}}</td>
							<td>{{o_category}}</td>
							<td>{{o_title}}</td>
							<td>{{o_size}}</td>
							<td>{{o_name}}</td>
							<td>{{o_brand_name}}</td>
							<td><img src="/displayFile?fileName={{o_img_1}}"></td>
							<td>{{o_amount}}</td>
							<td>{{o_mileage_usage}}</td>
							<td>{{o_mileage_gain}}</td>
							<td>{{u_addr1}} {{u_addr2}}</td>
							<td>{{u_phone}}</td>
							<td>배송상태추가해야됨</td>
					</tr>		
			{{/each}}	
		</script>
		
	<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<br>
			<h2>
				<span class="label label-info">나의 주문 내역</span>
			</h2>
			<hr>
			<div class="form-group">
						
						<div class="col-sm-4">
							<input class="form-control" type="date" id="date1" name="date1"/>								
						</div>
						<div class="col-sm-1 text-center"><strong>~</strong></div>
						<div class="col-sm-4">
							<input class="form-control" type="date" id="date2" name="date2"/>								
						</div>							
						<div class="col-sm-3">
							<button id="search" class="btn btn-info">검색</button>								
						</div>							
			</div>
			<br>
			<hr>
			<table border="1"
				class="table table-bordered table-condensed table-hover">
				<thead>
					<tr class="info">
						<th>#</th>
						<th>상품카테고리</th>						
						<th>상품타이틀</th>
						<th>상품사이즈</th>
						<th>상품이름</th>
						<th>상품브랜드</th>
						<th>상품이미지</th>
						<th>주문 수량</th>
						<th>사용 마일리지</th>
						<th>획득 마일리지</th>
						<th>배송지주소</th>
						<th>배송지전화번호</th>
						<th>배송상태</th>						
					</tr>
				</thead>
				<tbody class="myOrder">
				 	<c:forEach items="${list}" var="c">
						<tr>
							<td>${c.ono}</td>
							<td>${c.o_category}</td>
							<td>${c.o_title}</td>
							<td>${c.o_size}</td>
							<td>${c.o_name}</td>
							<td>${c.o_brand_name}</td>
							<td><img src="/displayFile?fileName=${c.o_img_1}"></td>
							<td>${c.o_amount}</td>
							<td>${c.o_mileage_usage}</td>
							<td>${c.o_mileage_gain}</td>
							<td>${c.u_addr1} ${c.u_addr2}</td>
							<td>${c.u_phone}</td>
							<td>배송상태추가해야됨</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>
</body>
</html>