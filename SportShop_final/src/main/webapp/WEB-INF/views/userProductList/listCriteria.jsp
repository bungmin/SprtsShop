<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
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
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<jsp:include page="../header.jsp"></jsp:include>
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#sel").change(function(){	
			
			var ea = $(this).val();		

			self.location="listCriteria?page=${pageMaker.cri.page}&perPageNum="+ea;
			
		});
		
		$("#searchBtn").click(function () {
		
				var uri = "/listCriteria${pageMaker.makeQuery(1)}"+"&searchType="+$("select#ssel option:selected").val()+"&keyword="+$("#keyword").val();			//상대좌표
				
	
				uri=encodeURI(uri);
				self.location= uri;
				
				
			}); 
	
		
	});

</script>
</head>
<body>

	<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>
	
	<div class="container">
		<div class="row">
			<br>
			<h2>
				<span class="label label-info">상품목록</span>
			</h2>
			<hr>
			
			<div class="pull-right">
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
					<img alt="메인이미지" src="/displayFile?fileName=${pList.p_img_1}">
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
						<li><a href="listCriteria${pageMaker.makeQuery(1)}">
											<span aria-hidden="true">First</span>
									</a></li>
						<li><a
							href="listCriteria${pageMaker.makeQuery(pageMaker.cri.page-1)}">&laquo;</a></li>
							
						</c:if>
						
												
						<c:forEach begin="${pageMaker.startPageNum}"
						end="${pageMaker.endPageNum}" var="idx">
						<li							
							<c:out value="${pageMaker.cri.page==idx?'class=active' : ''}" />>							
							
							<a
							href="listCriteria?page=${idx}&perPageNum=${pageMaker.cri.perPageNum}">${idx}</a></li>
					</c:forEach>					
					
					<c:if test="${pageMaker.cri.page < pageMaker.totalPage}">
						<li><a
							href="listCriteria${pageMaker.makeQuery(pageMaker.cri.page+1)}&orderType=${pageMaker.cri.orderType}">&raquo;</a></li>
							
						<li><a
										href="listCriteria${pageMaker.makeQuery(pageMaker.totalPage)}&orderType=${pageMaker.cri.orderType}">
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
							<option value="title">상품타이틀</option>							
							<option value="content">내용</option>
					</select>
					</span> <input class="form-control" name="keyword" id="keyword"
						>
					<!-- form-control하면 비워있는거 다 차지 -->					
					
					<span class="input-group-btn">
						<button class="btn btn-success" id="searchBtn"><i class="fa fa-search-plus" aria-hidden="true"></i>검색</button> <!-- button은 btn임 -->
						<!-- 버튼을 하나더 만들꺼임. 왜 검색 목록을 볼수있는 -->
						<a href="listCriteria" class="btn btn-warning"><span class="fa fa-list" aria-hidden="true"></span>&nbsp; 총 상품 목록</a>
					</span>
					
				</div>
				

			</div>

			
	</div>
	
	<br><br>
	
	
	
	<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>



</body>
</html>