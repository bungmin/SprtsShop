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
		  alert("������ �����ϴ�.");
		  location.href="/";
	  }
	  
	  //$(".uploadedList").on("click",".largeShow", function(event) {
/* 	  $("#selected").on("click", ".del", function(event){
		  
		  location.href = "/usermanage/delete";
		  <a href="/usermanage/delete?id=${c.id}"	class="btn btn-warning">����</a>
		  
	  } 
		  
	  
	  });*/
	  
	  
	  $("#selectedId").click(function(){
		  
		  alert("���� ���� �Ǿ����ϴ�.");		  
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
							<td><a href="/usermanage/delete?id={{id}}" data-id={{id}} class="btn btn-warning del">����</a></td>
							</tr>				
			{{/each}}	
		</script>
		
		
	<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<br>
			<h2>
				<span class="label label-info">ȸ����ȸ</span>
				<div class="pull-right">
				<button id="selectedId" class="btn btn-default">���õ� id ����</button>
				</div>
			</h2>
			<hr>
			<table border="1"
				class="table table-bordered table-condensed table-hover">
				<thead>
					<tr class="info">
						<th>���û���</th>
						<th>ID</th>
						<th>�̸�</th>
						<th>�ּ�</th>
						<th>���ּ�</th>
						<th>���ֵ���</th>
						<th>�̸���</th>
						<th>����</th>
						<th>����</th>
						<th>����</th>
						<th>���Գ�¥</th>
						<th>����</th>
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
							<td><a href="/usermanage/delete?id=${c.id}"	class="btn btn-warning">����</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>
</body>
</html>