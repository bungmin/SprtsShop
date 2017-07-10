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
  width: 100%;
  height: 500px;
}													
</style>
<script type="text/javascript">
var cate0 = ${ovo[0].count}
var cate0a = '${ovo[0].o_category}'
var cate1 = ${ovo[1].count}
var cate1a = '${ovo[1].o_category}'
var cate2 = ${ovo[2].count}
var cate2a = '${ovo[2].o_category}'


var chart = AmCharts.makeChart("chartdiv", {
    "theme": "light",
    "type": "serial",
    "startDuration": 2,
    "dataProvider": [{
        "country": cate0a,
        "visits": cate0,
        "color": "#FF0F00"
    }, {
        "country": cate1a,
        "visits": cate1,
        "color": "#FF6600"
    }, {
        "country": cate2a,
        "visits": cate2,
        "color": "#FF9E01"
    }],
    "graphs": [{
        "balloonText": "[[category]]: <b>[[value]]</b>",
        "colorField": "color",
        "fillAlphas": 0.85,
        "lineAlpha": 5,
        "type": "column",
        "topRadius":1,
        "valueField": "visits"
    }],
    "depth3D": 40,
	"angle": 30,
    "chartCursor": {
        "categoryBalloonEnabled": false,
        "cursorAlpha": 0,
        "zoomable": false
    },
    "categoryField": "country",
    "categoryAxis": {
        "gridPosition": "start",
        "axisAlpha":0,
        "gridAlpha":0

    },
    "export": {
    	"enabled": true
     }

}, 0);



</script>
</head>
<body>

<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>
<div class="panel panel-default">
  <div class="panel-heading"><h1 style="text-align: center; font-style: italic;">종목별 판매량</h1></div>
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
<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>

</body>
</html>