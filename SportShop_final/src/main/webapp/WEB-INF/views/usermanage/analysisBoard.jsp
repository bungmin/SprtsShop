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
<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="https://www.amcharts.com/lib/3/serial.js"></script>
<script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
<link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
<script src="https://www.amcharts.com/lib/3/themes/light.js"></script>
<script src="//www.amcharts.com/lib/3/plugins/dataloader/dataloader.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>


<style>
#chartdiv {
  width: 100%;
  height: 500px;
}
</style>

	<div class="container">
		<div class="row">
		
		<h3>
			<span class="label label-info">게시글 작성 순위(10위)</span>
		</h3>
		
			<div id="chartdiv"></div>	
			
			
			<div class="table-responsive">
				<table class="table table_bordered table-hover" border="1">
					<thead>
						<tr>
							<td>아이디</td>	
							<td>게시글 수</td>						
						</tr>
					</thead>	
					<tbody class="list">
											
					</tbody>				
				</table>
			</div>
			
		</div>
	</div>
	
	
	<script id="source" type="text/x-handlebars-template">
			{{#each.}}
					<tr>
						<td>{{id}}</td>
						<td>{{count}}</td>						
					</tr>				
			{{/each}}	
	</script>
	
	
	<script type="text/javascript">
		$(document).ready(function() {
			
			
				
				  var position ='${login.position}';
				  
				  if(position == 'user'){
					  alert("권한이 없습니다.");
					  location.href="/";
				  }
			
			
			
			$.getJSON("/memberLog/boardAnalysis", function(data) {
			
				 var source = $("#source").html();
				var template =Handlebars.compile(source);
				var gab=data;				
				
				$(".list").html(template(gab)); 
				
				var chart = AmCharts.makeChart("chartdiv", {
					  "type": "serial",
					  "theme": "light",
					  "marginRight": 70,
					  "dataLoader" : {
							"url" : "/memberLog/boardAnalysis",
							"format" : "json",
							"useColumnNames": true,
							"postProcess" : function(data, config, chart) {								
							
								return data;
							}
							
						},
					  "startDuration": 1,
					  "graphs": [{
					    "balloonText": "<b>[[id]] 대: [[count]]</b>",
					    "fillColorsField": "color",
					    "fillAlphas": 0.9,
					    "lineAlpha": 0.2,
					    "type": "column",
					    "valueField": "count"
					  }],
					  "chartCursor": {
					    "categoryBalloonEnabled": false,
					    "cursorAlpha": 0,
					    "zoomable": false
					  },
					  "categoryField": "id",
					  "categoryAxis": {
					    "gridPosition": "start",
					    "labelRotation": 45
					  },
					  "export": {
					    "enabled": true
					  }
				});
				
				
			});
			
			
		});
	</script>
	
<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>
</body>
</html>