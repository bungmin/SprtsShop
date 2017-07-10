<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../header.jsp"></jsp:include>
<!-- Latest compiled and minified CSS -->
<title>Insert title here</title>
</head>
<body> 
	
	
		<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>
	
	<!-- 낮은 가격순, 높은 가격순, 추천많은 순, 추천 적은순. 할인율많은순, 할인율 적은순-->
	
		
			
	<div class="container">
		
			<br>
			<h2>
				<span class="label label-info">
				<c:if test="${pageMaker.cri.category =='notice'}">공지사항</c:if>
				<c:if test="${pageMaker.cri.category =='soccer'}">축구 게시판</c:if>
				<c:if test="${pageMaker.cri.category =='basketball'}">농구 게시판</c:if>
				<c:if test="${pageMaker.cri.category =='baseball'}">야구게시판</c:if>				
				</span>
			</h2>
			<hr>
		
 		
 		<div class="row">
			
				<div class="pull-right">
				<select class="selectpicker show-tick" data-width="auto"
				id="categorysel" name="category">
				<option class="text-center" disabled
					data-icon="glyphicon glyphicon-list-alt"
					data-header="Select a condiment">카테고리</option>
				<option class="text-center"
					${pageMaker.cri.category=='notice'?'selected':'' } value="notice">공지사항게시판</option>
				<option class="text-center"
					${pageMaker.cri.category=='soccer'?'selected':'' } value="soccer">축구게시판</option>
				<option class="text-center"
					${pageMaker.cri.category=='basketball'?'selected':'' } value="basketball">농구게시판
					</option>
				<option class="text-center"
					${pageMaker.cri.category=='baseball'?'selected':'' } value="baseball">야구게시판</option>				
			</select>
			
			<select class="selectpicker show-tick" data-width="auto"
				id="order_sel" name="orderType">
				<option disabled
					data-icon="fa fa-sort"
					data-header="Select a condiment">정렬하기</option>
				<option 
				${pageMaker.cri.orderType=="old"?'selected':'' } value="old">오래된순
					보기</option>
				<option 
			    ${pageMaker.cri.orderType=="recently"?'selected':'' } value="recently">최신순
					보기</option>			
				<option 
			    ${pageMaker.cri.orderType=="countasc"?'selected':'' } value="countasc">조회수적은순
					보기</option>			
				<option 
			    ${pageMaker.cri.orderType=="countdesc"?'selected':'' } value="countdesc">조회수많은순
					보기</option>			
			</select>
			
			
			<select class="selectpicker show-tick" data-width="auto"
				id="sel" name="perPageNum">
				<option class="text-center" disabled
					data-icon="glyphicon glyphicon-list-alt"
					data-header="Select a condiment">게시글 수</option>
				<option class="text-center"
					${pageMaker.cri.perPageNum==5?'selected':'' } value="5">5개씩
					보기</option>
				<option class="text-center"
					${pageMaker.cri.perPageNum==10?'selected':'' } value="10">10개씩
					보기</option>
				<option class="text-center"
					${pageMaker.cri.perPageNum==20?'selected':'' } value="20">20개씩
					보기</option>
			</select>
			</div>
		</div>		
		
		
		
		<div class="clearfix"></div>
		<br>
		
		<div class="row">
			<!-- <div class="table-responsive"> -->
				<table class="table table-bordered table-hover" border="1">
					<!-- table-condensed: table 크기가 줄어들음 -->
					<thead>
						<tr class="info">
							<th>분류</th>
							<th>#</th>
							<th>제목</th>
							<th>작가</th>
							<th>작성일자</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="boardVO">
							<tr>
								<td>${boardVO.category}</td>
								<td>${boardVO.bno}</td>
								<td><a class="titleClick"
									href="/sboard/bread${pageMaker.makeSearch(pageMaker.cri.page)}&bno=${boardVO.bno}&orderType=${pageMaker.cri.orderType}&category=${pageMaker.cri.category}">${boardVO.title}<strong>[${boardVO.replyCnt}]</strong></a></td>
								<td>${boardVO.id}</td>
								<td>${boardVO.regDate}</td>
								<td><span class="badge">${boardVO.viewCnt}</span></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

		
			<!-- </div> -->



			<div class="row">
				<div class="text-center">
					<ul class="pagination">
						
						<li>
						<c:if test="${pageMaker.cri.page >1 }">
						<li><a href="listCriteria${pageMaker.makeSearch(1)}&category=${pageMaker.cri.category}&orderType=${pageMaker.cri.orderType}">
											<span aria-hidden="true">First</span>
									</a></li>
						<li><a
							href="listCriteria${pageMaker.makeSearch(pageMaker.cri.page-1)}&category=${pageMaker.cri.category}&orderType=${pageMaker.cri.orderType}">&laquo;</a></li>
							
						</c:if>
						
												
						<c:forEach begin="${pageMaker.startPageNum}"
						end="${pageMaker.endPageNum}" var="idx">
						<li
							<%-- <c:out value="${pageMaker.cri.page==idx?'class=active' : ''}" />><a
							href="blistCriteria?page=${idx}&perPageNum=${pageMaker.cri.perPageNum}">${idx}</a></li> --%>
							<c:out value="${pageMaker.cri.page==idx?'class=active' : ''}" />><a
							href="listCriteria?page=${idx}&perPageNum=${pageMaker.cri.perPageNum}&searchType=${pageMaker.cri.searchType}&keyword=${pageMaker.cri.keyword}&category=${pageMaker.cri.category}&orderType=${pageMaker.cri.orderType}">${idx}</a></li>
					</c:forEach>					
					
					<c:if test="${pageMaker.cri.page < pageMaker.totalPage}">
						<li><a
							href="listCriteria${pageMaker.makeSearch(pageMaker.cri.page+1)}&category=${pageMaker.cri.category}&orderType=${pageMaker.cri.orderType}">&raquo;</a></li>
							
						<li><a
										href="listCriteria${pageMaker.makeSearch(pageMaker.totalPage)}&category=${pageMaker.cri.category}&orderType=${pageMaker.cri.orderType}">
											<span aria-hidden="true">Last</span>
									</a></li>
					</c:if> 

					</ul>
					
					<div class="row">
				
				 <div class="col-xs-2 col-sm-2 col-lg-2"> 
					
						<c:choose>
								<c:when test="${pageMaker.cri.category =='notice' && (login.position eq null || login.position == 'user') }">
								</c:when>
								<c:otherwise>
								<a class="btn btn-info pull-right"
								href="/board/create${pageMaker.makeSearch(pageMaker.cri.page)}"><span> 글쓰기</span></a>								
								</c:otherwise>
						</c:choose>						
						
				</div>

				<div class="input-group col-xs-8 col-sm-8 col-lg-8">
					<span class="input-group-addon" style="background-color: white"> 
					<select id="ssel" name="searchType">
							<option disabled>검색기준</option>
							<!-- 컨트롤러에서 cri라는 이름으로 model attribute 했었음 -->
							<option ${cri.searchType=='id'?'selected':'' } value="id">아이디</option>
							<option ${cri.searchType=='title'?'selected':'' } value="title">제목</option>
							<option ${cri.searchType=='content'?'selected':'' }
								value="content">내용</option>
					</select>
					</span> <input class="form-control" name="keyword" id="keyword"
						value="${cri.keyword}">
					<!-- form-control하면 비워있는거 다 차지 -->					
					
					<span class="input-group-btn">
						<button class="btn btn-success" id="searchBtn"><i class="fa fa-search-plus" aria-hidden="true"></i>검색</button> <!-- button은 btn임 -->											
					</span>
					
				</div>
				
					
					<%-- <ul class="pagination pagination-lg">
					
						<li>
						<c:out value="${pageMaker.cri.page<=1?'class=disabled' : '' }" /><a href="">&laquo;</a>
					<a href="blistCriteria?page=${pageMaker.cri.page-1}&perPageNum=${pageMaker.cri.perPageNum}">&laquo;</a></li>
					<c:forEach begin="${pageMaker.startPageNum}"
						end="${pageMaker.endPageNum}" var="idx">
						<li
							<c:out value="${pageMaker.cri.page==idx?'class=active' : ''}" />><a
							href="blistCriteria?page=${idx}&perPageNum=${pageMaker.cri.perPageNum}">${idx}</a></li>
					</c:forEach>
					<c:if test="${pageMaker.cri.page < pageMaker.totalCount}">
						<li><a
							href="blistCriteria?page=${pageMaker.cri.page+1}&perPageNum=${pageMaker.cri.perPageNum}">&raquo;</a></li>
					</c:if>  --%><%-- <c:if test="${pageMaker.cri.page >1}">
								<li><a
									href="blistCriteria${pageMaker.makeQuery(1)}"> <span aria-hidden="true">First</span></a></li>
								<li><a
									href="blistCriteria${pageMaker.makeQuery(pageMaker.cri.page-1)}">&laquo;</a></li>
							</c:if> 
					</ul>

				</div>
			</div>

			



				<%-- <input name="keyword" id="keyword" value="${cri.keyword}"> --%>
				
				
				<!-- 이거하고  밑에 주소창에 넣어보기.
				http://localhost:8089/sboard/listCriteria?page=3&perPageNum=10&searchType=title&keyword=content -->
				
				
					
				

			</div>
			




			<!-- <button class="btn btn-info">글쓰기</button> -->

			<!-- 물어볼꺼.. href 경로 
			
			-->





		</div>

		<script type="text/javascript">
			
			//setInterval("getServerTime()", 1000);	
		
			var result1 = '${msg}';
			/* 이 msg는 dispather 방식으로 주소창으로 하면 인식이 되는데, redirect로 해서 인식이 안됨.. */
			
			var result2= '${param.msg}';
			
			var bno = '${param.bno}';
			
			if(result1 == 'INSERT_SUCCESS' || result2 == 'INSERT_SUCCESS'){
				alert("입력성공하였습니다.");
			}else if(result1 == 'DELETE_SUCCESS' || result2 == 'DELETE_SUCCESS'){
				alert("삭제하였습니다.");
			}else if(result1 == 'UPDATE_SUCCESS' || result2 == 'UPDATE_SUCCESS'){
				alert(bno+"번 글을 수정하였습니다.");
			}
			
			
			$(document).ready(function() {
				
				 $("#order_sel").click(function() {
					 
						var ea=$("select option:selected").val();
						
						//alert();
								
						self.location="listCriteria${pageMaker.makeSearch(pageMaker.cri.page)}&category=${pageMaker.cri.category}&orderType="+ea;
						
					}); 
				 
				 
				 $("#sel").change(function(){
						//var ea= $(this).val();
						
						//var ea=$("select option:selected").val();
						
						var ea = $(this).val();
						
						
						
						
						/* 선택되어져 있는 거에 val을 가져옴  5냐 10이냐 20이냐*/
						
						/* self.location="/board/listCriteria${pageMaker.makeQuery(pageMaker.cri.page)}";
						현재 이거 안되는이유 getPerPage가 고정되어있기때문에 */
						
						/* if() */
					
					//	self.location="/board/listCriteria?page=${pageMaker.cri.page}&perPageNum="+ea+"&change=${true}&revPerPageNum2=${pageMaker.cri.perPageNum}";
						self.location=encodeURI("listCriteria?page=${pageMaker.cri.page}&perPageNum="+ea+"&searchType=${pageMaker.cri.searchType}&keyword=${pageMaker.cri.keyword}&category=${pageMaker.cri.category}&orderType=${pageMaker.cri.orderType}");
						
					});
						
						
					//});
					 
					 
				 	 $("#order_sel").change(function() {		 	
						 
						//var ea=$("select option:selected").val();
						var ea = $(this).val();
						
						//날짜 오름차순,
						//날짜 내림차순,
						//조회수 오름차순,
						//조회수 내림차순,
								
						self.location="listCriteria${pageMaker.makeSearch(pageMaker.cri.page)}&category=${pageMaker.cri.category}&orderType="+ea;
						
					}); 
				 
				 
				 $("#searchBtn").click(function () {
				//	 alert("aa");
					//var ea=$("select option:selected").val();
					/* 선택되어져 있는 거에 val을 가져옴  5냐 10이냐 20이냐*/
					
					/* self.location="/board/listCriteria${pageMaker.makeQuery(pageMaker.cri.page)}";
					현재 이거 안되는이유 getPerPage가 고정되어있기때문에 */
					
					/* if() */
					
				//	self.location="/board/listCriteria?page=${pageMaker.cri.page}&perPageNum="+ea+"&change=${true}&revPerPageNum2=${pageMaker.cri.perPageNum}";
				
				
					//var uri = "/sboard/listCriteria";		절대좌표
					
					/* 검색하면 1페이지로 가야됨 */
					
					var uri = "listCriteria${pageMaker.makeQuery(1)}&orderType=${pageMaker.cri.orderType}&category=${pageMaker.cri.category}"+"&searchType="+$("select#ssel option:selected").val()+"&keyword="+$("#keyword").val();			//상대좌표
					
					/* 한글처리 익스플로랑 이클립스 브라우저 */
					uri=encodeURI(uri);
					self.location= uri;
					
					/* 검색해서 주소창에 나오면 되는거임*/
					
				}); 
				 
				 $(".titleClick").click(function(event) {
					 					 
					 /* 이것도 제목을 클릭했을때  이것도 익스플로러에서 안됨.
					 
					 event를 파라미터로 주면 받아올수 있음.
					 
					 */
					 event.preventDefault();		 //event를 파라미터로 주면 받아올수 있음. a태그 클릭했을때 링크로 넘어가지않게 잠시 막는거임.. 이게.... 마니 사용함..
					 var uri=$(this).attr("href");
					 uri=encodeURI(uri);
					 self.location= uri;
				 	
				 })
				
				
			});
			
			function getServerTime() {
				$.ajax({
					url: "/replies/time",
					type : "GET",
					success: function(result) {
						
						$("#serverTime").html("<span style=font-size:40px;> 검색결과  - 시간 : " + result + ".</span>");
									
					}
					
					
				});
				
			}
			
			$("#categorysel").change(function() {
				
				var ea = $(this).val();
				
				
				self.location="listCriteria?page=${pageMaker.cri.page}&perPageNum=${pageMaker.cri.perPageNum}&orderType=${pageMaker.cri.orderType}&category="+ea;
				
			});
			
			
			
			/* $(".btn-info").click(function() {
				location.href = "/board/create${pageMaker.makeQuery(pageMaker.cri.page)}";
				
			}); */
			
		/* 	$("a").click(function(event) {
				event.preventDefault();
				var uri=$("a").attr("href");
				
				location.href = uri;
				
				
			}) */
			
		/* 	$("a").click(function() {
				location.href = "/board/create";
				
			}) */
			
			
			
			/* $("a").click(function() {
				
			});
			 */
			 
			
		
		</script>
</body>
</html>