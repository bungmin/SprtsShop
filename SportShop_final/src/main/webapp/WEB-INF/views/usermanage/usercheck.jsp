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
$(document).ready(function(){
	
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
				<span class="label label-info">회원조회</span>
			</h2>
			<hr>
			<table border="1"
				class="table table-bordered table-condensed table-hover">
				<thead>
					<tr class="info">
						<th>ID</th>
						<th>이름</th>
						<th>주소</th>
						<th>상세주소</th>
						<th>거주도시</th>
						<th>이메일</th>
						<th>생일</th>
						<th>성별</th>
						<th>전번</th>
						<th>가입날짜</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listUser}" var="c">
						<tr>
							<td>${c.id}</td>
							<td>${c.name}</td>
							<td>${c.addr1}</td>
							<td>${c.addr2}</td>
							<td>${c.state}</td>
							<td>${c.email}</td>
							<td>${c.birthday}</td>
							<td>${c.gender}</td>
							<td>${c.phone}</td>
							<td>${c.regdate}</td>
							<td><a href="/usermanage/delete?id=${c.id}"	class="btn btn-warning">삭제</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>
</body>
</html>