<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="https://www.amcharts.com/lib/3/pie.js"></script>
<script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
<link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
<script src="https://www.amcharts.com/lib/3/themes/light.js"></script>
<jsp:include page="../header.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#chartdiv {
  width: 100%;
  height: 500px;
}

</style>
<script type="text/javascript">
var a = '${orderCountByGender[0].sex}';
var b = ${orderCountByGender[0].count};
var c = '${orderCountByGender[1].sex}';
var d = ${orderCountByGender[1].count};



$(document).ready(function() {
	
	$("#a").html(b+"명");
	$("#b").html(d+"명");
	
	
	var chart = AmCharts.makeChart( "chartdiv", {
		  "type": "pie",
		  "theme": "light",
		  "dataProvider": [ {
		    "title": a,
		    "value": b
		  }, {
		    "title": c,
		    "value": d
		  } ],
		  "titleField": "title",
		  "valueField": "value",
		  "labelRadius": 5,

		  "radius": "42%",
		  "innerRadius": "60%",
		  "labelText": "[[title]] / [[value]]",
		  "export": {
		    "enabled": true
		  }
		} );

	
	
});

</script>
</head>

<body>

<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>


<!-- HTML -->
<div class="panel panel-default">
  <div class="panel-heading"><h1 style="text-align: center; font-style: italic;">구매자 성 비율</h1></div>
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
				<thead style="background-color: aqua;">
				<tr>
					<td>남성</td>
					<td>여성</td>
					
				</tr>
				</thead>
				
				<tbody>
					<tr>
					<td id="a"></td>
					<td id="b"></td>
				
					</tr>
				</tbody>
			</table>
		
		</div>
</div>

<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>

</body>
</html>