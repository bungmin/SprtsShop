<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<jsp:include page="../header.jsp"></jsp:include>
<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="https://www.amcharts.com/lib/3/pie.js"></script>
<script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
<link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
<script src="https://www.amcharts.com/lib/3/themes/none.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Styles -->
<style>
#chartdiv {
  width: 100%;
  height: 500px;
}												
</style>
<script type="text/javascript">

var under10 = ${age[0].count};
var ageUnder10 = '${age[0].age}';
var ten = ${age[1].count};
var age10 = '${age[1].age}';
var twenty = ${age[2].count};
var age20 = '${age[2].age}';
var thirty = ${age[3].count};
var age30 = '${age[3].age}';
var fourty = ${age[4].count};
var age40 = '${age[4].age}';
var fifty = ${age[5].count};
var age50 = '${age[5].age}';
var sixty = ${age[6].count};
var age60 = '${age[6].age}';
var ageOver70 = ${age[7].count};
var over70 = '${age[7].age}';

$(document).ready(function () {
	
	$("#under10").html(under10+"명");
	$("#ten").html(ten+"명");
	$("#twenty").html(twenty+"명");
	$("#thirty").html(thirty+"명");
	$("#fourty").html(fourty+"명");
	$("#fifty").html(fifty+"명");
	$("#sixty").html(sixty+"명");
	$("#over70").html(ageOver70+"명");
	
	
	
	
	
	
	
})


var chart = AmCharts.makeChart( "chartdiv", {
  "type": "pie",
  "theme": "none",
  "titles": [ {
    "text": "구매자 연령층",
    "size": 16
  } ],
  "dataProvider": [ {
    "country":  ageUnder10,
    "visits": under10
  }, {
    "country": age10,
    "visits": ten
  }, {
    "country": age20,
    "visits": twenty
  }, {
    "country": age30,
    "visits": thirty
  }, {
    "country": age40,
    "visits": fourty
  }, {
    "country": age50,
    "visits":  fifty 
  }, {
    "country": age60,
    "visits": sixty
  }, {
    "country": over70,
    "visits": ageOver70
  } ],
  "valueField": "visits",
  "titleField": "country",
  "startEffect": "elastic",
  "startDuration": 2,
  "labelRadius": 15,
  "innerRadius": "50%",
  "depth3D": 10,
  "balloonText": "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>",
  "angle": 15,
  "export": {
    "enabled": true
  }
} );

</script>


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
				<tr style="background: aqua;">
					<td>10대 이하</td>
					<td>10대</td>
					<td>20대</td>
					<td>30대</td>
					<td>40대</td>
					<td>50대</td>
					<td>60대</td>
					<td>70대 이상</td>
				</tr>
				</thead>
				
				<tbody>
					<tr>
					<td id="under10"></td>
					<td id="ten"></td>
					<td id="twenty"></td>
					<td id="thirty"></td>
					<td id="fourty"></td>
					<td id="fifty"></td>
					<td id="sixty"></td>
					<td id="over70"></td>
					
					</tr>
				</tbody>
			</table>
		
		</div>
	
	</div>

<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>

</body>
</html>