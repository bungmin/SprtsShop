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

.amcharts-export-menu-top-right {
  top: 10px;
  right: 0;
}

</style>

<!-- Resources -->
<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="https://www.amcharts.com/lib/3/pie.js"></script>
<script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
<link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
<script src="https://www.amcharts.com/lib/3/themes/light.js"></script>


<!-- HTML -->



	<div class="container">
		<div class="row">
			
			<h3>
			<span class="label label-info">회원 통계</span>
		</h3>
		<button id="gender" class="label label-success">회원성비분석</button>
		<button id="age" class="label label-success">회원나이분석</button>		
		<button id="state" class="label label-success">회원지역분석</button>		
		
		<div id="chartdiv"></div>
		
		
			<div class="table-responsive">
				<table class="table table_bordered table-hover data" border="1">
					<thead>
						<tr class="info">
							<td>남자</td>
							<td>여자</td>
						</tr>
					</thead>
					<tbody >
						<c:forEach items="${mAnalysis}" var="a">
						<tr>
							<td class="manCount" data-mcount="${a.mCount}">${a.mCount}</td>
							<td class="womanCount" data-wcount="${a.wCount}">${a.wCount}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div id="chart"></div>
		</div>
	</div>
	
		<script id="source" type="text/x-handlebars-template">
					<thead>
						<tr class="info">
							<td>나이대</td>
							<td>회원수</td>
						</tr>
					</thead>
			{{#each.}}
					<tr>
						<td>{{age}}</td>
						<td>{{count}}</td>						
					</tr>				
			{{/each}}	
		</script>
		
		
		<script id="genderSource" type="text/x-handlebars-template">
					<thead>
						<tr class="info">
							<td>남자</td>
							<td>여자</td>
						</tr>
					</thead>
			{{#each.}}
					<tr>
						<td>{{mCount}}</td>
						<td>{{wCount}}</td>						
					</tr>				
			{{/each}}	
		</script>
		
		<script id="stateSource" type="text/x-handlebars-template">
					<thead>
						<tr class="info">
							<td>지역</td>
							<td>회원수</td>
						</tr>
					</thead>
			{{#each.}}
					<tr>
						<td>{{state}}</td>
						<td>{{count}}</td>						
					</tr>				
			{{/each}}	
		</script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			var strArray;
			
			
			  var position ='${login.position}';
			  
			  if(position == 'user'){
				  alert("권한이 없습니다.");
				  location.href="/";
			  }
		
		
			var mCount =$(".manCount").attr("data-mcount");
			var wCount =$(".womanCount").attr("data-wcount");
			
			
			$("#state").click(function(){
				
				$.getJSON("/memberLog/analysisState", function(data) {					
					
					var source = $("#stateSource").html();
					var template =Handlebars.compile(source);
					var gab=data;
					
					
					$(".data").html(template(gab));
					
					var chart = AmCharts.makeChart("chartdiv", {
						  "type": "serial",
						  "theme": "light",
						  "marginRight": 70,
						  "dataLoader" : {
								"url" : "/memberLog/analysisState",
								"format" : "json",
								"useColumnNames": true,
								"postProcess" : function(data, config, chart) {
								
									return data;
								}
								
							},					  
						  "valueAxes": [{
						    "axisAlpha": 0,
						    "position": "left",
						    "title": "회원 수"
						  }],
						  "startDuration": 1,
						  "graphs": [{
						    "balloonText": "<b>[[state]] : [[count]]</b>",
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
						  "categoryField": "state",
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
			
			
			$("#gender").click(function() {
				
				$.getJSON("/memberLog/analysisGender", function(data) {					
					
					var source = $("#genderSource").html();
					var template =Handlebars.compile(source);
					var gab=data;
					
					
					$(".data").html(template(gab));	
					
					var chart = AmCharts
					.makeChart(
							"chartdiv",
							{
								"type" : "pie",
								"theme" : "light",
								"dataProvider" : [ {
									"성별" : "남성",
									"value" : data[0].mCount,
									 "color": "#5CD1E5"
								}, {
									"성별" : "여성",
									"value" : data[0].wCount,
									 "color": "#FFFF5A"
								} ],
								"valueField" : "value",
								"titleField" : "성별",
								 "colorField": "color",
								"outlineAlpha" : 0.4,
								"depth3D" : 50,
								"balloonText" : "[[title]]<br><span style='font-size:15px'><b>[[value]]</b> ([[percents]]%)</span>", 
								"angle" : 30,
								"export" : {
									"enabled" : true
								}
							});
					
					
					
				});
				
				
				
			})
			
			
			$("#age").click(function(){
				$.getJSON("/memberLog/analysisAge", function(data) {					
					
					var source = $("#source").html();
					var template =Handlebars.compile(source);
					var gab=data;
					
					
					$(".data").html(template(gab));	
					
				});
				
				var chart = AmCharts.makeChart("chartdiv", {
					  "type": "serial",
					  "theme": "light",
					  "marginRight": 70,
					  "dataLoader" : {
							"url" : "/memberLog/analysisAge",
							"format" : "json",
							"useColumnNames": true,
							"postProcess" : function(data, config, chart) {
							
								return data;
							}
							
						},					  
					  "valueAxes": [{
					    "axisAlpha": 0,
					    "position": "left",
					    "title": "회원 수"
					  }],
					  "startDuration": 1,
					  "graphs": [{
					    "balloonText": "<b>[[age]] 대: [[count]]</b>",
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
					  "categoryField": "age",
					  "categoryAxis": {
					    "gridPosition": "start",
					    "labelRotation": 45
					  },
					  "export": {
					    "enabled": true
					  }
				});
				
				
			});
			
			
			
		
			
			var chart = AmCharts
			.makeChart(
					"chartdiv",
					{
						"type" : "pie",
						"theme" : "light",
						"dataProvider" : [ {
							"성별" : "남성",
							"value" : mCount,
							 "color": "#5CD1E5"
						}, {
							"성별" : "여성",
							"value" : wCount,
							 "color": "#FFFF5A"
						} ],
						"valueField" : "value",
						"titleField" : "성별",
						 "colorField": "color",
						"outlineAlpha" : 0.4,
						"depth3D" : 50,
						"balloonText" : "[[title]]<br><span style='font-size:15px'><b>[[value]]</b> ([[percents]]%)</span>", 
						"angle" : 30,
						"export" : {
							"enabled" : true
						}
					});
		});
	</script>
	
<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>
</body>
</html>