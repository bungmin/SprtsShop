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
<!-- <script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBcHku8BnZHqQuX4MTmsZgc1AXjRKX-t5s"></script> -->
<!-- <script type="text/javascript" src="http://google-maps-utility-library-v3.googlecode.com/svn/trunk/markerclusterer/src/markerclusterer.js"></script> -->
</head>
<body>
<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>
<style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    
</style>			<div id="map"></div>
    <script type="text/javascript">
    var locations = [
        {lat: -31.563910, lng: 147.154312}   
      ] 
    
    
    var lat3=11;   
    $(document).ready(function(){    	
    	$.getJSON("/memberLog/state", function(data) {		
    		for(var j in data){
    			geocoder = new google.maps.Geocoder();
    	         geocoder.geocode({'address' : data[j]}, function(results, status) {
    	                 if (status == google.maps.GeocoderStatus.OK) {
    	              	   var lat = results[0]['geometry']['location']['lat']();
    	                     var lng = results[0]['geometry']['location']['lng']();                  
    	             
    	                     lat3= results[0].geometry.location;
    	                     
    	                     lat_lng = new Object();
    	                     
    	                     lat_lng.lat= lat;
    	                     lat_lng.lng= lng;    	                      
    	                   
    	                     locations.push(lat_lng);
    	                     alert(locations);
    	                     
    	                   
    	                     
    	                 }    	                       
    	         });                 
    			
    		}	
    		
    		 /*  // Create an array of alphabetical characters used to label the markers.
            var labels = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';

            // Add some markers to the map.
            // Note: The code uses the JavaScript Array.prototype.map() method to
            // create an array of markers based on a given "locations" array.
            // The map() method here has nothing to do with the Google Maps API.
            var markers = locations.map(function(location, i) {
              return new google.maps.Marker({
                position: location,
                label: labels[i % labels.length]
              });
            });

            // Add a marker clusterer to manage the markers.
            var markerCluster = new MarkerClusterer(map, markers,
                {imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m'});
          */
            
    	
    		
		});
    	
    	
    	
    });
    
    
    function codeAddress(address) {
    	
		  geocoder = new google.maps.Geocoder();
         geocoder.geocode({'address' : address}, function(results, status) {
                 if (status == google.maps.GeocoderStatus.OK) {
              	   var lat = results[0]['geometry']['location']['lat']();
                     var lng = results[0]['geometry']['location']['lng']();                  
             
                     lat3= results[0].geometry.location;            	                       
                     alert(lat3);
                 }    	                       
         });
      
        }
	 
    
   
    
    


      function initMap() {

        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 3,
          center: {lat: -28.024, lng: 140.887}
        });
      }

      
      
      
      
    </script>
    <script src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js">
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBLv-_ILIbQvAd6g7TtrfNASnEd9rOOD6M&callback=initMap">
    </script>
	
	
<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>
</body>
</html>