<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<!-- <script type="text/javascript" src="https://rawgit.com/googlemaps/js-marker-clusterer/gh-pages/src/markerclusterer.js"></script> -->

<script type="text/javascript" src="http://maps.google.com/maps/api/js?key=AIzaSyBLv-_ILIbQvAd6g7TtrfNASnEd9rOOD6M"></script>
<!-- <script
	src="http://maps.google.com/maps/api/js?key=AIzaSyBLv-_ILIbQvAd6g7TtrfNASnEd9rOOD6M&v=3&sensor=false"></script> -->
<jsp:include page="../header.jsp"></jsp:include>
<title>Insert title here</title>
<style>
#map {
	height: 100%;
}
/* Optional: Makes the sample page fill the window. */
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}
</style>
<script type="text/javascript">
	var map;
	$(document).ready(function() {
		map = new GMaps({
			el : '#map',
			zoom : 6,
			lat: 37.566535,
			lng: 126.97796,
			markerClusterer: function(map) {
		          return new MarkerClusterer(map);
		        }
			
		});
		
		/* var styles = [
            {
              stylers: [
                { hue: "#00ffe6" },
                { saturation: -20 }
              ]
            }, {
                featureType: "road",
                elementType: "geometry",
                stylers: [
                    { lightness: 100 },
                    { visibility: "simplified" }
              ]
            }, {
                featureType: "road",
                elementType: "labels",
                stylers: [
                    { visibility: "off" }
              ]
            }
        ];
        
        map.addStyle({
            styledMapName:"Styled Map",
            styles: styles,
            mapTypeId: "map_style"  
        });
        
        map.setStyle("map_style"); */
        
		
		$("#search").click(function (){		
			//$.getJSON("/memberLog/state", function(data) {
			//	for(var j in data)
			//	{			
					GMaps.geocode({
					//	address : data[j],
						address : $('#address').val(),
						callback : function(results, status) {
							if (status == 'OK') {
								
								var latlng = results[0].geometry.location;								
								map.setCenter(latlng.lat(), latlng.lng());
								map.addMarker({
									lat : latlng.lat(),
									lng : latlng.lng(),
								
								});							
							}/* else if (status == 'OVER_QUERY_LIMIT') {    
								setTimeout(function() {
									var latlng = results[0].geometry.location;								
									map.setCenter(latlng.lat(), latlng.lng());
									map.addMarker({
										lat : latlng.lat(),
										lng : latlng.lng(),
									});									
								}, 200);
							}  */
						}
					});
					
				//}
				
				
			//});
			
			/* GMaps.geocode({
				address : $('#address').val().trim(),
				callback : function(results, status) {
					if (status == 'OK') {
						var latlng = results[0].geometry.location;
						map.setCenter(latlng.lat(), latlng.lng());
						map.addMarker({
							lat : latlng.lat(),
							lng : latlng.lng()							
						});
					
					}
				}
			});
	 */		
		});
	
	});
</script>

</head>
<body>
	<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>

	<h1>GMaps.js &mdash; Geocoding</h1>

		<div class="span11">
			
				<label for="address">Address:</label>
				<div class="input">
					<input type="text" id="address" name="address" /> 
					<input id ="search"  type="submit" class="btn" value="Search" />
				</div>
			
			
		</div> 
		
		<div id="map"></div>
	


	<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>
</body>
</html>