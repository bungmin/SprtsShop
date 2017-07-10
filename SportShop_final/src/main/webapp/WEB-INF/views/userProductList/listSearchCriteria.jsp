<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
   
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	.proudctList li{
		list-style-type:none;		
		margin-bottom: 50px;
	}
	
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../header.jsp"></jsp:include>
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#sel").change(function(){	
			
			var ea = $(this).val();		

			self.location="listSearchCriteria?page=${pageMaker.cri.page}&category=${pageMaker.cri.category}&orderType=${pageMaker.cri.orderType}&perPageNum="+ea;
			
		});
		
		$("#categorysel").change(function() {
			
			var ea = $(this).val();
			
			
			self.location="listSearchCriteria?page=1&perPageNum=12&orderType=${pageMaker.cri.orderType}&category="+ea;
			
		});
		
		
		$("#ordersel").change(function() {
			
			var ea = $(this).val();
			
			self.location="listSearchCriteria?page=${pageMaker.cri.page}&perPageNum=${pageMaker.cri.perPageNum}&category=${pageMaker.cri.category}&orderType="+ea;
			
		});
		
		
		
		$("#searchBtn").click(function () {
		
			var uri = "listSearchCriteria${pageMaker.makeQuery(1)}&category=${pageMaker.cri.category}&orderType=${pageMaker.cri.orderType}"+"&searchType="+$("select#ssel option:selected").val()+"&keyword="+$("#keyword").val();
				
	
				uri=encodeURI(uri);
				self.location= uri;
				
				
			}); 
	
		
	});

</script>
</head>
<body>

	<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>
	
	<!-- 낮은 가격순, 높은 가격순, 추천많은 순, 추천 적은순. 할인율많은순, 할인율 적은순-->
	<div class="container">
		<div class="row">
			<br>
			<h2>
				<span class="label label-info">
				<c:if test="${pageMaker.cri.category =='all'}">모든 상품</c:if>
				<c:if test="${pageMaker.cri.category =='soccer'}">축구 상품</c:if>
				<c:if test="${pageMaker.cri.category =='basketball'}">농구 상품</c:if>
				<c:if test="${pageMaker.cri.category =='baseball'}">야구 상품</c:if>				
				</span>
			</h2>
			<hr>
			
			<div class="pull-right">
			<select class="selectpicker show-tick" data-width="auto"
				id="ordersel" name="orderType">
				<option class="text-center" disabled
					data-icon="glyphicon glyphicon-list-alt"
					data-header="Select a condiment">정렬하기</option>
				<option class="text-center"
					 ${pageMaker.cri.orderType =='lowprice'?'selected':'' } value="lowprice">낮은 가격순</option>
				<option class="text-center"
					 ${pageMaker.cri.orderType =='highprice'?'selected':'' } value="highprice">높은 가격순
					</option>
				<option class="text-center"
					 ${pageMaker.cri.orderType =='lowgoocnt'?'selected':'' } value="lowgoocnt">낮은 추천순</option>
				<option class="text-center"
					 ${pageMaker.cri.orderType =='highgoocnt'?'selected':'' } value="highgoocnt">높은 추천순
					</option>
				<option class="text-center"
					 ${pageMaker.cri.orderType =='lowdiscount'?'selected':'' } value="lowdiscount">낮은 할인순</option>
				<option class="text-center"
					 ${pageMaker.cri.orderType =='highdiscount'?'selected':'' } value="highdiscount">높은 할인순
					</option>
				<%-- <option class="text-center"
					${pageMaker.cri.category=='baseball'?'selected':'' } value="baseball">추천 많은순</option>				
				<option class="text-center"
					${pageMaker.cri.category=='baseball'?'selected':'' } value="baseball">추천 적은순</option> --%>				
			</select>
			<select class="selectpicker show-tick" data-width="auto"
				id="categorysel" name="category">
				<option class="text-center" disabled
					data-icon="glyphicon glyphicon-list-alt"
					data-header="Select a condiment">카테고리</option>
				<option class="text-center"
					${pageMaker.cri.category=='all'?'selected':'' } value="all">모든상품</option>
				<option class="text-center"
					${pageMaker.cri.category=='soccer'?'selected':'' } value="soccer">축구</option>
				<option class="text-center"
					${pageMaker.cri.category=='basketball'?'selected':'' } value="basketball">농구
					</option>
				<option class="text-center"
					${pageMaker.cri.category=='baseball'?'selected':'' } value="baseball">야구</option>				
			</select>
			<select class="selectpicker show-tick" data-width="auto"
				id="sel" name="perPageNum">
				<option class="text-center" disabled
					data-icon="glyphicon glyphicon-list-alt"
					data-header="Select a condiment">상품 개수 선택</option>
				<option class="text-center"
					${pageMaker.cri.perPageNum==12?'selected':'' } value="12">12개씩
					보기</option>
				<option class="text-center"
					${pageMaker.cri.perPageNum==24?'selected':'' } value="24">24개씩
					보기</option>
				<option class="text-center"
					${pageMaker.cri.perPageNum==48?'selected':'' } value="48">48개씩
					보기</option>
				<option class="text-center"
					${pageMaker.cri.perPageNum==72?'selected':'' } value="72">72개씩
					보기</option>
			</select>
			</div>
			<br><br><br>
			
			
			<ul id="proudctList" class="clearfix proudctList">
				<c:forEach items="${listAllProduct}" var="pList">
				<li class="col-xs-3">
				<span>
					<a href="/userProductList/productDetail?pno=${pList.pno}&page=1&perPageNum=12&searchType=${pageMaker.cri.searchType}&keyword=${pageMaker.cri.keyword}&category=${pageMaker.cri.category}&orderType=${pageMaker.cri.orderType}"><img alt="메인이미지" src="/displayFile?fileName=${pList.p_img_1}"></a>
				</span>
					<div>
						<a href="#">상품분류 : ${pList.p_category}</a>
					</div>
					<div>
						<a href="#">상품번호 : ${pList.pno}</a>
					</div>
					<div>
						<a href="#">상품명 : ${pList.p_title}</a>
					</div>
					<div>		
						<a href="#">상품가격 : ${pList.p_price}</a>						
					</div>
				</li>
				
				</c:forEach>
			</ul>
	</div>
	
		<div class="row">
				<div class="text-center">
					<ul class="pagination">
						<li>							
							<li>
						<c:if test="${pageMaker.cri.page >1 }">
						<li><a href="listSearchCriteria${pageMaker.makeSearch(1)}&category=${pageMaker.cri.category}&orderType=${pageMaker.cri.orderType}">
											<span aria-hidden="true">First</span>
									</a></li>
						<li><a
							href="listSearchCriteria${pageMaker.makeSearch(pageMaker.cri.page-1)}&category=${pageMaker.cri.category}&orderType=${pageMaker.cri.orderType}">&laquo;</a></li>
							
						</c:if>
						
												
						<c:forEach begin="${pageMaker.startPageNum}"
						end="${pageMaker.endPageNum}" var="idx">
						<li							
							<c:out value="${pageMaker.cri.page==idx?'class=active' : ''}" />><a
							href="listSearchCriteria?page=${idx}&perPageNum=${pageMaker.cri.perPageNum}&searchType=${pageMaker.cri.searchType}&keyword=${pageMaker.cri.keyword}&category=${pageMaker.cri.category}&orderType=${pageMaker.cri.orderType}">${idx}</a></li>
					</c:forEach>					
					
					<c:if test="${pageMaker.cri.page < pageMaker.totalPage}">
						<li><a
							href="listSearchCriteria${pageMaker.makeSearch(pageMaker.cri.page+1)}&category=${pageMaker.cri.category}&orderType=${pageMaker.cri.orderType}">&raquo;</a></li>
							
						<li><a
										href="listSearchCriteria${pageMaker.makeSearch(pageMaker.totalPage)}&category=${pageMaker.cri.category}&orderType=${pageMaker.cri.orderType}">
											<span aria-hidden="true">Last</span>
									</a></li>
					</c:if>					
					</ul>

				</div>
			</div>
			
			
			<div class="row">
			
				<div class="col-xs-2 col-sm-2 col-lg-2"> 

				<!-- <i class="fa fa-pencil-square" aria-hidden="true"></i> -->
				
				</div>				
					<div class="input-group col-xs-8 col-sm-8 col-lg-8">
					<span class="input-group-addon" style="background-color: white"> 
					<select id="ssel" name="searchType">
							<option disabled>검색기준</option>
							<!-- 컨트롤러에서 cri라는 이름으로 model attribute 했었음 -->
							<option value="p_title">상품타이틀</option>							
							<option value="p_content">내용</option>
					</select>
					</span> <input class="form-control" name="keyword" id="keyword"
						>
					<!-- form-control하면 비워있는거 다 차지 -->					
					
					<span class="input-group-btn">
						<button class="btn btn-success" id="searchBtn"><i class="fa fa-search-plus" aria-hidden="true"></i>검색</button> <!-- button은 btn임 -->
						<!-- 버튼을 하나더 만들꺼임. 왜 검색 목록을 볼수있는 -->						
					</span>
					
				</div>
				

			</div>

			
	</div>
	
	<br><br>
	
	
	
	<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>



</body>
</html>