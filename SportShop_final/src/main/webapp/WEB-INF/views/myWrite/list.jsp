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
</head>
<body>
	<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<br>
			<h2>
				<span class="label label-info">내가 쓴 글 보기</span>
			</h2>
			<hr>
			<table border="1"
				class="table table-bordered table-condensed table-hover">
				<thead>
					<tr class="info">
							<th>글번호</th>
							<th>카테고리</th>
							<th>제목</th>							
							<th>작성일자</th>
							<th>조회수</th>							
						</tr>
				</thead>
				<tbody>    
				 	<c:forEach items="${list}" var="boardVO">
							<tr>
								<td>${boardVO.bno}</td>
								<td>${boardVO.category}</td>
								<td><a href="/sboard/read?bno=${boardVO.bno}">${boardVO.title}</a></td>								
								<td>${boardVO.regDate}</td>
								<td><span class="badge">${boardVO.viewCnt}</span></td>
							</tr>
						</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>
</body>
</html>