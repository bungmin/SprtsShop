<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="https://www.amcharts.com/lib/3/serial.js"></script>
<script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
<link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
<script src="https://www.amcharts.com/lib/3/themes/light.js"></script>

<jsp:include page="../header.jsp"></jsp:include>
<script src="https://www.amcharts.com/lib/3/plugins/dataloader/dataloader.min.js"></script>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
#chartdiv {
	width	: 100%;
	height	: 500px;
}			

</style>

<script type="text/javascript">

var chart = AmCharts.makeChart("chartdiv", {
    "type": "serial",
    "theme": "light",
    "marginTop":0,
    "marginRight": 80,
    "dataLoader" : {			
		"url" : "/owner/dayGraph",
		"format" : "json",
		"useColumnNames" : true,
		"postProcess" : function (data, config, chart) {
		return data;
		}
	},	
    "graphs": [{
        "id":"g1",
        "balloonText": "[[regdate]]<br><b><span style='font-size:14px;'>[[stack_revenue]]</span></b>",
        "bullet": "round",
        "bulletSize": 8,
        "lineColor": "#d1655d",
        "lineThickness": 2,
        "negativeLineColor": "#637bb6",
        "type": "smoothedLine",
        "valueField": "stack_revenue"
    }],
    "chartScrollbar": {
        "graph":"g1",
        "gridAlpha":0,
        "color":"#888888",
        "scrollbarHeight":55,
        "backgroundAlpha":0,
        "selectedBackgroundAlpha":0.1,
        "selectedBackgroundColor":"#888888",
        "graphFillAlpha":0,
        "autoGridCount":true,
        "selectedGraphFillAlpha":0,
        "graphLineAlpha":0.2,
        "graphLineColor":"#c2c2c2",
        "selectedGraphLineColor":"#888888",
        "selectedGraphLineAlpha":1

    },
    "chartCursor": {
        "categoryBalloonDateFormat": "YYYY-MM-DD",
        "cursorAlpha": 0,
        "valueLineEnabled":true,
        "valueLineBalloonEnabled":true,
        "valueLineAlpha":0.5,
        "fullWidth":true
    },
    "dataDateFormat": "YYYY-MM-DD",
    "categoryField": "regdate",
    "categoryAxis": {
        "minPeriod": "YYYY-MM-DD",

        "minorGridAlpha": 0.1,
        "minorGridEnabled": true
    },
    "export": {
        "enabled": true
    }
});

chart.addListener("rendered", zoomChart);
if(chart.zoomChart){
	chart.zoomChart();
}

function zoomChart(){
    chart.zoomToIndexes(Math.round(chart.dataProvider.length * 0.4), Math.round(chart.dataProvider.length * 0.55));
}

</script>

															


</head>
<body>
<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>
<div class="panel panel-default">
  <div class="panel-heading"><h1 style="text-align: center; font-style: italic;">일별 판매 추이</h1></div>
  <div class="panel-body">

<ol class="breadcrumb">
<li><a href="/owner/accounting">매출 전표</a></li>
  <li><a href="/owner/day">일</a></li>
  <li><a href="/owner/month">월</a></li>
  <li><a href="/owner/year">연</a></li>
</ol>
        
    <div id="chartdiv"></div>
    
    
  </div>
</div>
<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>
</body>
</html>