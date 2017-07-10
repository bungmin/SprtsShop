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
	<div class="container">
		<div class="row">
			<div class="table-responsive">
				<table class="table table-bordered table-hover" border="1">
					<!-- table-condensed: table 크기가 줄어들음 -->
					<thead>
						<tr class="info">
							<th>글번호</th>
							<th>제목</th>							
							<th>작성자</th>
							<th>작성일자</th>
							<th>조회수</th>							
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="boardVO">
							<tr>
								<td>${boardVO.bno}</td>
								<td><a href="/board/read?bno=${boardVO.bno}">${boardVO.title}</a></td>
								<td>${boardVO.id}</td>
								<td>${boardVO.regDate}</td>
								<td>
								<span class="badge">${boardVO.viewCnt}</span>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
			
			<div class="row">
				<button class="btn btn-info">글쓰기</button>
			
			</div>
		</div>
		
		<script type="text/javascript">
			var result = '${msg}';
			if(result == 'SUCCESS'){
				alert("작업이 정상 완료되었습니다.");
			}else if(result == 'DELETE_SUCCESS'){
				alert("삭제하였습니다.");
			}
			
			$(".btn-info").click(function() {
				location.href = "/board/create";
				
			});
			
/* 			$("a").click(function() {
				location.href = "/board/create";
				
			}) */
			
			
			
			/* $("a").click(function() {
				
			});
			 */
			 
			
		
		</script>


</body>
</html>