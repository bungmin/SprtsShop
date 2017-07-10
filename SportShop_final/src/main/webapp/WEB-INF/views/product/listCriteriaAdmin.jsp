<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<jsp:include page="../header.jsp"></jsp:include>
<title>Insert title here</title>
<script type="text/javascript">

$(document).ready(function () {
	
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
				<span class="label label-info">재고현황</span>
			</h2>
			<hr>
			
			<table border="1" class="table table-bordered table-condensed table-hover">
				<thead>
				<tr class="info">
					<th>상품번호</th>
					<!-- <td>썸네일 사진을 올려볼까 함</td> -->
					<th>종목</th>
					<th>제목</th>
					<th>상품명</th>
					<th>브랜드명</th>
					<th>사이즈</th>
					<th>원가</th>
					<th>판매가</th>
					<th>할인율</th>
					<th>입고량</th>
					<th>재고량</th>
					<th>원산지</th>
					<th>추천수</th>
					<th>등록일</th>
					<th>수정일</th>
					<th>수정</th>
					<th>삭제</th>					
					<!-- <td>내용보기</td> 내용관련 페이지로 넘어가게끔 하기 -->
				</tr>
				</thead>
				
				
				<tbody>
				
				<c:forEach items="${listAllProduct}" var="pList"> <!-- attribute로 저장한 데이터를 불러온다 -->
					<tr>													
						<td>${pList.pno}</td>
						<td>${pList.p_category}</td>
						<td>${pList.p_title}</td>
						<td>${pList.p_name}</td>
						<td>${pList.p_brand_name}</td>
						<td>${pList.p_size}</td>
						<td>${pList.p_ori_price}</td>
						<td>${pList.p_price}</td>
						<td>${pList.p_discount_rate}</td>
						<td>${pList.p_ori_amount}</td>
						<td>${pList.p_amount}</td>
						<td>${pList.p_made}</td>
						<td>${pList.p_goodcnt}</td>
						<td>${pList.regdate}</td>
						<td>${pList.updatedate}</td>
						<td><a href="/product/updateProduct?pno=${pList.pno}" class="btn btn-info">수정</a></td>
						<td><a href="/product/deleteProduct?pno=${pList.pno}" class="btn btn-warning">삭제</a></td>						
						
						<%-- <td>${pList.updatedate}</td> 내용관련.jsp로 이동하게 하자! --%>
					</tr>
					
				</c:forEach>
				</tbody>	
			
			</table>
			
			<div class="row">
				<div class="text-center">
					<ul class="pagination">
						<li>							
							<li>
						<c:if test="${pageMaker.cri.page >1 }">
						<li><a href="listCriteriaAdmin${pageMaker.makeQuery(1)}">
											<span aria-hidden="true">First</span>
									</a></li>
						<li><a
							href="listCriteriaAdmin${pageMaker.makeQuery(pageMaker.cri.page-1)}">&laquo;</a></li>
							
						</c:if>
						
												
						<c:forEach begin="${pageMaker.startPageNum}"
						end="${pageMaker.endPageNum}" var="idx">
						<li							
							<c:out value="${pageMaker.cri.page==idx?'class=active' : ''}" />><a
							href="listCriteriaAdmin?page=${idx}&perPageNum=${pageMaker.cri.perPageNum}">${idx}</a></li>
					</c:forEach>					
					
					<c:if test="${pageMaker.cri.page < pageMaker.totalPage}">
						<li><a
							href="listCriteriaAdmin${pageMaker.makeQuery(pageMaker.cri.page+1)}">&raquo;</a></li>
							
						<li><a
										href="listCriteriaAdmin${pageMaker.makeQuery(pageMaker.totalPage)}">
											<span aria-hidden="true">Last</span>
									</a></li>
					</c:if>					
					</ul>

				</div>
			</div>
		
		
			
			
				
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>



</body>
</html>