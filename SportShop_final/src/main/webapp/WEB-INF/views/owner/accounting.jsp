<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Resources -->

<jsp:include page="../header.jsp"></jsp:include>
<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="https://www.amcharts.com/lib/3/serial.js"></script>
<script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
<link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
<script src="https://www.amcharts.com/lib/3/themes/black.js"></script>
<!-- Styles -->
<style>
body { background-color: #000; color: #fff; }
#chartdiv {
  width: 100%;
  height: 500px;
}										
</style>
</head>
<body>

<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>

<div class="panel panel-default">
  <div class="panel-heading"><h1 style="text-align: center; font-style: italic;">매출 정보</h1></div>
  <div class="panel-body">

<ol class="breadcrumb">
  <li><a href="/owner/accounting">매출 전표</a>
  <li><a href="/owner/day">일</a></li>
  <li><a href="/owner/month">월</a></li>
  <li><a href="/owner/year">연</a></li>
  </li>
<li><a href="/owner/accounting">매출 전표</a></li>
  <li><a href="/owner/gender">Gender</a></li>
  <!-- <li><a href="/owner/age">AGE</a></li> -->
  <li><a href="/owner/state">State</a></li>
  <li><a href="/owner/category">Category</a></li>
</ol>
    
  </div>
</div>
	<div id="chartdiv"></div>
	
	<div class="container">
			
		<div class="row">
			<table class="table table-bordered table-condensed table-hover">
				<thead>
				<tr>
					<td>누적 결제액</td>
					<td>누적 할인 금액</td>
					<td>누적 사용적립금</td>
					<td>사용하지 않은 적립금</td>
					<td>총 비용</td>
					<td>순이익</td>
				</tr>
				</thead>
				
				<tbody>
					<tr>
					<td id="a"></td>
					<td id="b"></td>
					<td id="c"></td>
					<td id="g"></td>
					<td id="e"></td>
					<td id="f"></td>
					</tr>
				</tbody>
			</table>
		
		</div>
	
	</div>
	





<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>









<!-- Chart code -->



<!-- HTML -->


</body>

<script type="text/javascript">
$(document).ready(function () {		
		
		var a = ${opvo.stack_revenue};
		var b = ${opvo.stack_discount};
		var c = ${opvo.stack_usedmileage};
		var d = ${opvo.stack_unusedmileage};	
		var e = ${opvo.cost};	
		var f = ${opvo.profit};	
		var g = d - c;
		
		
		$("#a").html(a+"원");
		$("#b").html(b+"원");
		$("#c").html(c+"원");
		$("#g").html(g+"원");
		$("#f").html(f+"원");
		$("#e").html(e+"원");
		

		  var chart = AmCharts.makeChart("chartdiv", {
		    "theme": "black",
		    "type": "serial",
		    "dataProvider": [{
		        "year": "누적결제액",
		        "income": a
		    }, {
		        "year": "누적 할인금액",
		        "income": b
		    }, {
		        "year": "누적 사용적립금",
		        "income": c
		    }, {
		        "year": "누적 총 적립금",
		        "income": d
		    }, {
		        "year": "사용하지 않은 적립금",
		        "income": g
		    }, {
		        "year": "총 비용",
		        "income": e
		    }, {
		        "year": "순이익",
		        "income": f
		    }],
		    "valueAxes": [{
		        "title": "Income in millions, USD"
		    }],
		    "graphs": [{
		        "balloonText": "Income in [[category]]:[[value]]",
		        "fillAlphas": 1,
		        "lineAlpha": 0.2,
		        "title": "Income",
		        "type": "column",
		        "valueField": "income"
		    }],
		    "depth3D": 20,
		    "angle": 30,
		    "rotate": true,
		    "categoryField": "year",
		    "categoryAxis": {
		        "gridPosition": "start",
		        "fillAlpha": 0.05,
		        "position": "left"
		    },
		    "export": {
		    	"enabled": true
		     }
		});  
		  
		  
		  
		
	});

</script>
</html>