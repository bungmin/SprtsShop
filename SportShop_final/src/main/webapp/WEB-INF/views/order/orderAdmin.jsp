<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<jsp:include page="../header.jsp"></jsp:include>
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function (){
	  var position ='${login.position}';
	  
	  if(position == 'user'){
		  alert("권한이 없습니다.");
		  location.href="/";
	  }
	
});

</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<br>
			<h2>
				<span class="label label-info">회원들의 주문 내역</span>
			</h2>
			<hr>
			<table border="1"
				class="table table-bordered table-condensed table-hover">
				<thead>
					<tr class="info">
						<th>#</th>
						<th>ID</th>
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
				<tbody>
				 	<c:forEach items="${list}" var="c">
						<tr>
							<td>${c.ono}</td>
							<td>${c.id}	</td>
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