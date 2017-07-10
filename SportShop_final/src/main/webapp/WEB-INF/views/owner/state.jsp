<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../header.jsp"></jsp:include>
<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="https://www.amcharts.com/lib/3/serial.js"></script>
<script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
<link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
<script src="https://www.amcharts.com/lib/3/themes/light.js"></script>
<script src="https://www.amcharts.com/lib/3/plugins/dataloader/dataloader.min.js"></script>


<!-- Styles -->
<style>
#chartdiv {
  width: 100%;
  height: 500px;
}	
</style>

<script type="text/javascript">
	var chart = AmCharts.makeChart("chartdiv", {
	    "theme": "light",
	    "type": "serial",
		"startDuration": 2,
		"dataLoader" : {			
			"url" : "/owner/stateGraph",
			"format" : "json",
			"useColumnNames" : true,
			"postProcess" : function (data, config, chart) {
			return data;
			}
		},	
	    
		"valueAxes": [ {
			"color": "#FF0F00",
		    "gridAlpha": 0.2,
		    "dashLength": 0
		  } ],
		  "gridAboveGraphs": true,
		  "startDuration": 1,
		
		
		"graphs": [{
	        "balloonText": "[[state]]: <b>[[count]]</b>",
	        "fillColorsField": "#FF0F00",
	        "fillAlphas": 1,
	        "lineAlpha": 0.1,
	        "type": "column",
	        "valueField": "count"
	        
	    }],
	    "depth3D": 20,
		"angle": 30,
	    "chartCursor": {
	        "categoryBalloonEnabled": false,
	        "cursorAlpha": 0,
	        "zoomable": false
	    },
	    "categoryField": "state",
	    "categoryAxis": {
	        "gridPosition": "start",
	        "labelRotation": 90
	    },
	    "export": {
	    	"enabled": true
	     }

	});
</script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>


<div class="panel panel-default">
  <div class="panel-heading"><h1 style="text-align: center; font-style: italic;">연령별 구매 현황</h1></div>
  <div class="panel-body">

<ol class="breadcrumb">
<li><a href="/owner/accounting">매출 전표</a></li>
  <li><a href="/owner/gender">Gender</a></li>
  <!-- <li><a href="/owner/age">AGE</a></li> -->
  <li><a href="/owner/state">State</a></li>
  <li><a href="/owner/category">Category</a></li>
</ol>
    <div id="chartdiv"></div>
  </div>
</div>



<div class="container">
			
		<div class="row">
			<table class="table table-bordered table-condensed table-hover">
				<thead>
					<tr style="background-color: aqua;">	
					<td>${ovo[0].state}</td>
					<td>${ovo[1].state}</td>
					<td>${ovo[2].state}</td>
					<td>${ovo[3].state}</td>
					<td>${ovo[4].state}</td>
					<td>${ovo[5].state}</td>
					<td>${ovo[6].state}</td>
					<td>${ovo[7].state}</td>
					<td>${ovo[8].state}</td>
					<td>${ovo[9].state}</td>
					<td>${ovo[10].state}</td>
					<td>${ovo[11].state}</td>
					<td>${ovo[12].state}</td>
					<td>${ovo[13].state}</td>
					<td>${ovo[14].state}</td>
					<td>${ovo[15].state}</td>
					
					</tr>
					
				
					
				
				</thead>
				
				<tbody>
					<tr>
					<td>${ovo[0].count}명</td>
					<td>${ovo[1].count}명</td>
					<td>${ovo[2].count}명</td>
					<td>${ovo[3].count}명</td>
					<td>${ovo[4].count}명</td>
					<td>${ovo[5].count}명</td>
					<td>${ovo[6].count}명</td>
					<td>${ovo[7].count}명</td>
					<td>${ovo[8].count}명</td>
					<td>${ovo[9].count}명</td>
					<td>${ovo[10].count}명</td>
					<td>${ovo[11].count}명</td>
					<td>${ovo[12].count}명</td>
					<td>${ovo[13].count}명</td>
					<td>${ovo[14].count}명</td>
					<td>${ovo[15].count}명</td>
					
					</tr>
				</tbody>
			</table>
		
		</div>
	
	</div>

<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>

</body>
</html>