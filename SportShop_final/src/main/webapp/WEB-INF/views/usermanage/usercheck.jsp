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
	  
	  //$(".uploadedList").on("click",".largeShow", function(event) {
/* 	  $("#selected").on("click", ".del", function(event){
		  
		  location.href = "/usermanage/delete";
		  <a href="/usermanage/delete?id=${c.id}"	class="btn btn-warning">삭제</a>
		  
	  } 
		  
	  
	  });*/
	  
	  
	  $("#selectedId").click(function(){
		  
		  alert("선택 삭제 되었습니다.");		  
		  $(".checked:checked").each(function(){			 
			  var ea = $(this).val();			  
			$.ajax({
				type : "delete",
				url : "/memberLog/deleteId/" + ea,
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "DELETE"
				},
				dataType : "text",
				success : function(result) {
					
					$.getJSON("/memberLog/usercheck/", function(data) {
						var source = $("#source").html();
						var template =Handlebars.compile(source);
						var gab=data;
						
						$(".selectedList").html(template(gab));
						
					});
					
				}

			});
		
			  
		  });
		  
		  
	  });
	  
	  
	  
	  
	  

	
});

</script>
</head>
<body>

<script id="source" type="text/x-handlebars-template">
			{{#each.}}
							<tr>
							<td><input type="checkbox" class="checked" value={{id}}"></td>
							<td>{{id}}</td>
							<td>{{name}}</td>
							<td>{{addr1}}</td>
							<td>{{addr2}}</td>
							<td>{{state}}</td>
							<td>{{email}}</td>
							<td>{{birthday}}</td>
							<td>{{gender}}</td>
							<td>{{phone}}</td>
							<td>{{regdate}}</td>
							<td><a href="/usermanage/delete?id={{id}}" data-id={{id}} class="btn btn-warning del">삭제</a></td>
							</tr>				
			{{/each}}	
		</script>
		
		
	<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<br>
			<h2>
				<span class="label label-info">회원조회</span>
				<div class="pull-right">
				<button id="selectedId" class="btn btn-default">선택된 id 삭제</button>
				</div>
			</h2>
			<hr>
			<table border="1"
				class="table table-bordered table-condensed table-hover">
				<thead>
					<tr class="info">
						<th>선택삭제</th>
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
				<tbody class="selectedList">
					<c:forEach items="${listUser}" var="c">
						<tr>
							<td><input type="checkbox" class="checked" value="${c.id}"></td>
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