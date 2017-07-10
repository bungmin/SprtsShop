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
				<span class="label label-info">1:1 문의 조회</span>
			</h2>
			<hr>
		</div>
		<div class="row">
			<div class="table-responsive">
				<table class="table table-bordered table-hover" border="1">
					<!-- table-condensed: table 크기가 줄어들음 -->
					<thead>
						<tr class="info">
							<th>글번호</th>
							<th>ID</th>							
							<th>분류</th>							
							<th>제목</th>
							<th>내용</th>
							<th>답변여부</th>
							<th>작성일자</th>							
						</tr>
					</thead>
					<tbody>
					 	<c:forEach items="${list}" var="MsgVO">
							<tr>
								<td>${MsgVO.mno}</td>
								<td>${MsgVO.id}</td>
								<td>${MsgVO.m_category}</td>
								<td><a href="/msg/reply?mno=${MsgVO.mno}">${MsgVO.title}</a></td>								
								<td>${MsgVO.content}</td>
								<td>${MsgVO.replycheck}</td>
								<td>${MsgVO.regdate}</td>								
							</tr>
						</c:forEach> 
					</tbody>
				</table>

			</div>			
			
		</div>
		
		
			
			</div>
		<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>
		
		<script type="text/javascript">
		
		$(document).ready(function() {
			
			  var position ='${login.position}';
			  
			  if(position == 'user'){
				  alert("권한이 없습니다.");
				  location.href="/";
			  }
			
			$("#msgRegister").click(function() {
				
				location.href="/msg/create";
				
			});
			
			
		});
					
		</script>


</body>
</html>