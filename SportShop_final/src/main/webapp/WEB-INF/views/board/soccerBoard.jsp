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
	<!-- <h1 class="text-center">목록</h1>
	<br><br> -->
	
	<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>
	<div class="container">

			<h2>
				<span class="label label-info">
				축구 게시판				
				</span>
			</h2>
			<hr>
		<div class="row">
		
			<div class="col-xs-2">
				<select class="selectpicker show-tick" data-width="auto"
					id="order_sel" name="orderType">
					<option disabled data-icon="fa fa-sort"
						data-header="Select a condiment">정렬하기</option>
					<option ${pageMaker.cri.orderType=="old"?'selected':'' }
						value="old">오래된순 보기</option>
					<option ${pageMaker.cri.orderType=="recently"?'selected':'' }
						value="recently">최신순 보기</option>
					<option ${pageMaker.cri.orderType=="countasc"?'selected':'' }
						value="countasc">조회수적은순 보기</option>
					<option ${pageMaker.cri.orderType=="countdesc"?'selected':'' }
						value="countdesc">조회수많은순 보기</option>
				</select>
			</div>
			
			<div class="col-xs-2">
				<select class="selectpicker show-tick" data-width="auto" id="sel"
					name="perPageNum">
					<option class="text-center" disabled
						data-icon="glyphicon glyphicon-list-alt"
						data-header="Select a condiment">게시글 수</option>
					<option class="text-center" ${pageMaker.cri.perPageNum==5?'selected':'' } value="5">5개씩보기</option>
					<option class="text-center" ${pageMaker.cri.perPageNum==10?'selected':'' } value="10">10개씩보기</option>
					<option class="text-center" ${pageMaker.cri.perPageNum==20?'selected':'' } value="20">20개씩보기</option>
				</select>
			</div>
			
			<div class="col-xs-offset-4">
				
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
						<th>#</th>
						<th>제목</th>
						<th>카테고리</th>
						<th>작성자</th>
						<th>작성일자</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="boardVO">
						<tr>
							<td>${boardVO.bno}</td>
							<td><a href="/board/bread${pageMaker.makeQuery(pageMaker.cri.page)}&bno=${boardVO.bno}&orderType=${pageMaker.cri.orderType}">${boardVO.title}<strong>[${boardVO.replyCnt}]</strong></a></td>
							<td>${boardVO.category}</td>
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
					<ul class="pagination pagination-lg">
						<li>
						<li><c:if test="${pageMaker.cri.page >1 }">
								<li><a
									href="blistCriteria${pageMaker.makeQuery(1)}&orderType=${pageMaker.cri.orderType}">
										<span aria-hidden="true">First</span>
								</a></li>
								<li><a
									href="blistCriteria${pageMaker.makeQuery(pageMaker.cri.page-1)}&orderType=${pageMaker.cri.orderType}">&laquo;</a></li>

							</c:if> <c:forEach begin="${pageMaker.startPageNum}"
								end="${pageMaker.endPageNum}" var="idx">
								<li
							<c:out value="${pageMaker.cri.page==idx?'class=active' : ''}" />>

									<a href="blistCriteria?page=${idx}&perPageNum=${pageMaker.cri.perPageNum}&orderType=${pageMaker.cri.orderType}">${idx}</a>
								</li>
							</c:forEach> <c:if test="${pageMaker.cri.page < pageMaker.totalPage}">
								<li><a
									href="blistCriteria${pageMaker.makeQuery(pageMaker.cri.page+1)}&orderType=${pageMaker.cri.orderType}">&raquo;</a></li>

								<li><a
									href="blistCriteria${pageMaker.makeQuery(pageMaker.totalPage)}&orderType=${pageMaker.cri.orderType}">
										<span aria-hidden="true">Last</span>
								</a></li>
							</c:if>
					</ul>

				</div>
			</div>

			<div class="row">

				<div class="col-xs-2 col-sm-2 col-lg-2">

					<!-- <i class="fa fa-pencil-square" aria-hidden="true"></i> -->
					<a class="btn btn-info pull-right"
						href="/board/create${pageMaker.makeQuery(pageMaker.cri.page)}&orderType=${pageMaker.cri.orderType}">글쓰기
						<span class="fa fa-pencil-square-o fa-2x"></span>
					</a>
				</div>



				<div class="input-group col-xs-8 col-sm-8 col-lg-8">
					<span class="input-group-addon" style="background-color: white">
						<select id="ssel" name="searchType">
							<option disabled>검색기준</option>
							<!-- 컨트롤러에서 cri라는 이름으로 model attribute 했었음 -->
							<option value="id">작성자</option>
							<option value="title">제목</option>
							<option value="content">내용</option>
					</select>
					</span> <input class="form-control" name="keyword" id="keyword">
					<!-- form-control하면 비워있는거 다 차지 -->

					<span class="input-group-btn">
						<button class="btn btn-success" id="searchBtn">
							<i class="fa fa-search-plus" aria-hidden="true"></i>검색
						</button> <!-- button은 btn임 --> <!-- 버튼을 하나더 만들꺼임. 왜 검색 목록을 볼수있는 --> <a
						href="listCriteria" class="btn btn-warning"><span
							class="fa fa-list" aria-hidden="true"></span>&nbsp; 총 목록</a>
					</span>

				</div>


			</div>

			<!-- <button class="btn btn-info">글쓰기</button> -->

			<!-- 물어볼꺼.. href 경로 
			
			-->

		</div>
	</div>
	<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>
	
	
	<script type="text/javascript">
		
		var result1 = '${msg}';
		/* 이 msg는 dispather 방식으로 주소창으로 하면 인식이 되는데, redirect로 해서 인식이 안됨.. */
		var result2 = '${param.msg}';
		var bno = "${param.bno}";

		if (result1 == 'INSERT_SUCCESS' || result2 == 'INSERT_SUCCESS') {
			alert("입력성공하였습니다.");
		} else if (result1 == 'DELETE_SUCCESS' || result2 == 'DELETE_SUCCESS') {
			alert("삭제하였습니다.");
		} else if (result1 == 'UPDATE_SUCCESS' || result2 == 'UPDATE_SUCCESS') {
			alert(bno + "번 글을 수정하였습니다.");
		}

		$(document).ready(function() { 
			$("#sel").change(function() {
				//var ea= $(this).val();

				//var ea=$("select option:selected").val();

				var ea = $(this).val();

				/* 선택되어져 있는 거에 val을 가져옴  5냐 10이냐 20이냐*/

				/* self.location="/board/listCriteria${pageMaker.makeQuery(pageMaker.cri.page)}";
				현재 이거 안되는이유 getPerPage가 고정되어있기때문에 */

				/* if() */

				//	self.location="/board/listCriteria?page=${pageMaker.cri.page}&perPageNum="+ea+"&change=${true}&revPerPageNum2=${pageMaker.cri.perPageNum}";
				self.location = "/board/blistCriteria?page=${pageMaker.cri.page}&orderType=${pageMaker.cri.orderType}&perPageNum="+ ea;
				});

				$("#order_sel").change(function() {

				//var ea=$("select option:selected").val();
				var ea = $(this).val();

				//날짜 오름차순,
				//날짜 내림차순,
				//조회수 오름차순,
				//조회수 내림차순,
				self.location = "/board/blistCriteria${pageMaker.makeQuery(pageMaker.cri.page)}&orderType="+ ea;

				});

				$("#searchBtn").click(function() {
				//	 alert("aa");
				//var ea=$("select option:selected").val();
				/* 선택되어져 있는 거에 val을 가져옴  5냐 10이냐 20이냐*/
				/* self.location="/board/listCriteria${pageMaker.makeQuery(pageMaker.cri.page)}";
				현재 이거 안되는이유 getPerPage가 고정되어있기때문에 */
				/* if() */
				//	self.location="/board/listCriteria?page=${pageMaker.cri.page}&perPageNum="+ea+"&change=${true}&revPerPageNum2=${pageMaker.cri.perPageNum}";
				//var uri = "/sboard/listCriteria";		절대좌표
				/* 검색하면 1페이지로 가야됨 */
				var uri = "/sboard/blistCriteria${pageMaker.makeQuery(1)}"
				+ "&searchType="
				+ $("select#ssel option:selected").val()
				+ "&keyword="+ $("#keyword").val(); //상대좌표
				/* 한글처리 익스플로랑 이클립스 브라우저 */
				uri = encodeURI(uri);
				self.location = uri;
				
				/* 검색해서 주소창에 나오면 되는거임*/
				});
				});

	/* 	function getServerTime() {
			$.ajax({
				url : "/replies/time",
				type : "GET",
				success : function(result) {

					$("#serverTime").html(
							"<span style=font-size:40px;> 전체목록  - 시간 : "
									+ result + ".</span>");

				}

			});

		} */

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