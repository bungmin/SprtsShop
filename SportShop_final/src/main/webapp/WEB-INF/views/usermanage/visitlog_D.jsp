<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="../header.jsp"></jsp:include>
<!-- Resources -->
<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="https://www.amcharts.com/lib/3/serial.js"></script>
<!-- <script src="lang/ko.js"> -->
<script
	src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
<link rel="stylesheet"
	href="https://www.amcharts.com/lib/3/plugins/export/export.css"
	type="text/css" media="all" />
<script src="https://www.amcharts.com/lib/3/themes/light.js"></script>
<script src="//www.amcharts.com/lib/3/plugins/dataloader/dataloader.min.js"></script>
<style>
#chartdiv {
	width: 100%;
	height: 500px;
}
</style>
</head>
<body>
<jsp:include page="../admin_page_header.jsp"></jsp:include>

<div class="container">
	<div class="row">
		<br>
		<h3>
			<span class="label label-info">방문자 수 조회</span>
		</h3>
		<button id="day" class="label label-success">일별</button>
		<button id="month" class="label label-success">월별</button>
	
		<hr>
		<h3 class="label label-warning" class="check"></h3>
		
		
		<div id="chartdiv"></div>
		<table class="table table-bordered table-condensed table-hover" border="1">
			<thead>
				<tr class="info">
					<th class="check"></th>
					<th>방문자 수</th>
				</tr>
			</thead>
			<tbody class="List">
			
			</tbody>
		</table>
	</div>
</div>
<br><br>

	<script id="source" type="text/x-handlebars-template">
			{{#each.}}
					<tr>
						<td>{{visit_date}}</td>
						<td>{{count}}</td>						
					</tr>				
			{{/each}}	
		</script>


<!-- 내가 원하는 거는

날짜랑  날짜에 해당하는 count값의 리스트 들 -->


<jsp:include page="../page_footer.jsp"></jsp:include>

<script type="text/javascript">
	$(document).ready(function() {
		
		
		  var position ='${login.position}';
		  
		  if(position == 'user'){
			  alert("권한이 없습니다.");
			  location.href="/";
		  }
	
		
		$.getJSON("/memberLog/day", function(data) {
			
			var source = $("#source").html();
			var template =Handlebars.compile(source);
			var gab=data;
			$(".check").html("일");
			
			$(".List").html(template(gab));	
			
			 var chart = AmCharts
				.makeChart(
						"chartdiv",
						{
							"type" : "serial",
							"theme" : "light",
							"language": "ko",
							"marginRight" : 40,
							"marginLeft" : 40,
							"autoMarginOffset" : 20,
							"mouseWheelZoomEnabled" : true,
																
							"dataDateFormat" : "YYYY-MM-DD",
							 "dataLoader" : {
								"url" : "/memberLog/day",
								"format" : "json",
								"useColumnNames": true,
								"postProcess" : function(data, config, chart) {
									
									return data;
								}
								
							}, 
							
							"valueAxes" : [ {
								"id" : "v1",
								"axisAlpha" : 0,
								"position" : "left",
								"ignoreAxisWidth" : true
							} ],
							"balloon" : {
								"borderThickness" : 1,
								"shadowAlpha" : 0
							},
							"graphs" : [ {
								"id" : "g1",
								"balloon" : {
									"drop" : true,
									"adjustBorderColor" : false,
									"color" : "#ffffff"
								},
								"bullet" : "round",
								"bulletBorderAlpha" : 1,
								"bulletColor" : "#FFFFFF",
								"bulletSize" : 5,
								"hideBulletsCount" : 50,
								"lineThickness" : 2,
								"title" : "red line",
								"useLineColorForBulletBorder" : true,
								"valueField" : "count",
								"balloonText" : "방문자수:<span style='font-size:18px;'>[[count]]</span>"
							} ],
							"chartScrollbar" : {
								"graph" : "g1",
								"oppositeAxis" : false,
								"offset" : 30,
								"scrollbarHeight" : 80,
								"backgroundAlpha" : 0,
								"selectedBackgroundAlpha" : 0.1,
								"selectedBackgroundColor" : "#888888",
								"graphFillAlpha" : 0,
								"graphLineAlpha" : 0.5,
								"selectedGraphFillAlpha" : 0,
								"selectedGraphLineAlpha" : 1,
								"autoGridCount" : true,
								"color" : "#AAAAAA"
							},
							"chartCursor" : {
								"pan" : true,
								"valueLineEnabled" : true,
								"valueLineBalloonEnabled" : true,
								"cursorAlpha" : 1,
								"cursorColor" : "#258cbb",
								"categoryBalloonDateFormat" : "YYYY.MM.DD",
								"limitToGraph" : "g1",
								"valueLineAlpha" : 0.2,
								"valueZoomable" : true
							},
							"valueScrollbar" : {
								"oppositeAxis" : false,
								"offset" : 50,
								"scrollbarHeight" : 10
							},
						 	"categoryField" : "visit_date", 
							"categoryAxis" :{
								"parseDates" : true, 
								"dashLength" : 1,
								"minorGridEnabled" : true,
							    "dateFormats" : [{period:'DD', format: "D일"},{period:'MM',format:'M월'},{period:'YYYY',format:'YYYY년'}],
							   
							},											
							"export" : {
								"enabled" : true
							},

						});

		chart.addListener("rendered", zoomChart);

		zoomChart();

		function zoomChart() {
			chart.zoomToIndexes(chart.dataProvider.length - 40,
					chart.dataProvider.length - 1);
		} 

	
		
		});
					
			$("#day").click(function() {
				$.getJSON("/memberLog/day", function(data) {
					
					var source = $("#source").html();
					var template =Handlebars.compile(source);
					var gab=data;
					
					//alert(data.count);
					$(".check").html("일");
					
					$(".List").html(template(gab));	
					
					 var chart = AmCharts
							.makeChart(
									"chartdiv",
									{
										"type" : "serial",
										"theme" : "light",
										"language": "ko",
										"marginRight" : 40,
										"marginLeft" : 40,
										"autoMarginOffset" : 20,
										"mouseWheelZoomEnabled" : true,
																			
										"dataDateFormat" : "YYYY-MM-DD",
										 "dataLoader" : {
											"url" : "/memberLog/day",
											"format" : "json",
											"useColumnNames": true,
											"postProcess" : function(data, config, chart) {
												
												return data;
											}
											
										}, 
										
										"valueAxes" : [ {
											"id" : "v1",
											"axisAlpha" : 0,
											"position" : "left",
											"ignoreAxisWidth" : true
										} ],
										"balloon" : {
											"borderThickness" : 1,
											"shadowAlpha" : 0
										},
										"graphs" : [ {
											"id" : "g1",
											"balloon" : {
												"drop" : true,
												"adjustBorderColor" : false,
												"color" : "#ffffff"
											},
											"bullet" : "round",
											"bulletBorderAlpha" : 1,
											"bulletColor" : "#FFFFFF",
											"bulletSize" : 5,
											"hideBulletsCount" : 50,
											"lineThickness" : 2,
											"title" : "red line",
											"useLineColorForBulletBorder" : true,
											"valueField" : "count",
											"balloonText" : "방문자수:<span style='font-size:18px;'>[[count]]</span>"
										} ],
										"chartScrollbar" : {
											"graph" : "g1",
											"oppositeAxis" : false,
											"offset" : 30,
											"scrollbarHeight" : 80,
											"backgroundAlpha" : 0,
											"selectedBackgroundAlpha" : 0.1,
											"selectedBackgroundColor" : "#888888",
											"graphFillAlpha" : 0,
											"graphLineAlpha" : 0.5,
											"selectedGraphFillAlpha" : 0,
											"selectedGraphLineAlpha" : 1,
											"autoGridCount" : true,
											"color" : "#AAAAAA"
										},
										"chartCursor" : {
											"pan" : true,
											"valueLineEnabled" : true,
											"valueLineBalloonEnabled" : true,
											"cursorAlpha" : 1,
											"cursorColor" : "#258cbb",
											"categoryBalloonDateFormat" : "YYYY.MM.DD",
											"limitToGraph" : "g1",
											"valueLineAlpha" : 0.2,
											"valueZoomable" : true
										},
										"valueScrollbar" : {
											"oppositeAxis" : false,
											"offset" : 50,
											"scrollbarHeight" : 10
										},
									 	"categoryField" : "visit_date", 
										"categoryAxis" :{
											"parseDates" : true, 
											"dashLength" : 1,
											"minorGridEnabled" : true,
										    "dateFormats" : [{period:'DD', format: "D일"},{period:'MM',format:'M월'},{period:'YYYY',format:'YYYY년'}],
										   
										},											
										"export" : {
											"enabled" : true
										},

									});

					chart.addListener("rendered", zoomChart);

					zoomChart();

					function zoomChart() {
						chart.zoomToIndexes(chart.dataProvider.length - 40,
								chart.dataProvider.length - 1);
					} 

				});
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				
			});
			
			
			$("#month").click(function() {				
				
				$.getJSON("/memberLog/month", function(data) {
					
					var source = $("#source").html();
					var template =Handlebars.compile(source);
					var gab=data;
					$(".check").html("월");
					
					$(".List").html(template(gab));		
					
					 var chart = AmCharts
						.makeChart(
								"chartdiv",
								{
									"type" : "serial",
									"theme" : "light",
									"language": "ko",
									"marginRight" : 40,
									"marginLeft" : 40,
									"autoMarginOffset" : 20,
									"mouseWheelZoomEnabled" : true,
																		
									"dataDateFormat" : "YYYY-MM-DD",
									 "dataLoader" : {
										"url" : "/memberLog/month",
										"format" : "json",
										"useColumnNames": true,
										"postProcess" : function(data, config, chart) {
											
										
										
											return data;
										}
										
									}, 
									
									"valueAxes" : [ {
										"id" : "v1",
										"axisAlpha" : 0,
										"position" : "left",
										"ignoreAxisWidth" : true
									} ],
									"balloon" : {
										"borderThickness" : 1,
										"shadowAlpha" : 0
									},
									"graphs" : [ {
										"id" : "g1",
										"balloon" : {
											"drop" : true,
											"adjustBorderColor" : false,
											"color" : "#ffffff"
										},
										"bullet" : "round",
										"bulletBorderAlpha" : 1,
										"bulletColor" : "#FFFFFF",
										"bulletSize" : 5,
										"hideBulletsCount" : 50,
										"lineThickness" : 2,
										"title" : "red line",
										"useLineColorForBulletBorder" : true,
										"valueField" : "count",
										"balloonText" : "방문자수:<span style='font-size:18px;'>[[count]]</span>"
									} ],
									"chartScrollbar" : {
										"graph" : "g1",
										"oppositeAxis" : false,
										"offset" : 30,
										"scrollbarHeight" : 80,
										"backgroundAlpha" : 0,
										"selectedBackgroundAlpha" : 0.1,
										"selectedBackgroundColor" : "#888888",
										"graphFillAlpha" : 0,
										"graphLineAlpha" : 0.5,
										"selectedGraphFillAlpha" : 0,
										"selectedGraphLineAlpha" : 1,
										"autoGridCount" : true,
										"color" : "#AAAAAA"
									},
									"chartCursor" : {
										"pan" : true,
										"valueLineEnabled" : true,
										"valueLineBalloonEnabled" : true,
										"cursorAlpha" : 1,
										"cursorColor" : "#258cbb",
										"categoryBalloonDateFormat" : "YYYY.MM.DD",
										"limitToGraph" : "g1",
										"valueLineAlpha" : 0.2,
										"valueZoomable" : true
									},
									"valueScrollbar" : {
										"oppositeAxis" : false,
										"offset" : 50,
										"scrollbarHeight" : 10
									},
								 	"categoryField" : "visit_date", 
									"categoryAxis" :{
										"parseDates" : true, 
										"dashLength" : 1,
										"minorGridEnabled" : true,
									    "dateFormats" : [{period:'DD', format: "D일"},{period:'MM',format:'M월'},{period:'YYYY',format:'YYYY년'}],								   
									},											
									"export" : {
										"enabled" : true
									},

								});

							chart.addListener("rendered", zoomChart);

							zoomChart();
	
							function zoomChart() {
								chart.zoomToIndexes(chart.dataProvider.length - 40,
								chart.dataProvider.length - 1);
						} 
				});
				
			});
			
			
		});
		

</script>
</body>
</html></html>