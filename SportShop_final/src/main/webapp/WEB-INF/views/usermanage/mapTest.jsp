<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<jsp:include page="../header.jsp"></jsp:include>
<script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBcHku8BnZHqQuX4MTmsZgc1AXjRKX-t5s&v=3.exp&libraries=visualization"></script>
<script src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js"></script>
<title>Insert title here</title>
 

<script>
$(document).ready(function(){
	geocode();
	
});
 var heatmap;
 var heatMapData = [];
var map;


function initialize() {
  var mapProp = {
    center:new google.maps.LatLng(37.250943, 127.028344),
    zoom:5,
    mapTypeId:google.maps.MapTypeId.ROADMAP
  };
  map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
}
google.maps.event.addDomListener(window, 'load', initialize);

var geocoder;

var markerCluster;
var markers = new Array();



		function geocode(addressList) {
			
			$.getJSON("/memberLog/state", function(data) {		
				addressList = data;
				
				for(var j in data){
				
					codeAddress(addressList[j]);
			   }
			}); 
			
			
	      /* var addressList = new Array('서울','서울','서울','서울','서울','서울',
	'서울','서울','대구','광주','부산','포항','강릉','전주','광양','거제','김해',
	'대전','울산','마산','수원','인천','서울','대구','광주','부산','포항','강릉',
	'전주','서울','서울','서울','광양','거제','김해','대전','울산','마산',
	'서울','서울','수원','인천','군산','파주','서울','서울');
	            for ( var j in addressList) {
	                    codeAddress(addressList[j]);
	            } */
	       /*      heatmap = new google.maps.visualization.HeatmapLayer({
	                  data : heatMapData,
	                   radius : 40,
	                   dissipating : true
	           });
	           heatmap.setMap(map);
	           
 	          var clusterOptions = {
	        		                 gridSize: 30,
	        		                   minimumClusterSize: 2
	        		           };
	        		           markerCluster = new MarkerClusterer(map, markers, 
	        		 clusterOptions);  */
	      
	   }
	  

 
 	//function geocode() {
	 
	 /* var addressList;
		 $.getJSON("/memberLog/state", function(data) {		
			addressList = data;
			
			for(var j in data){
			
	            codeAddress(data[j]);
		   }
		}); */
		
		 
		
		/* for(var j in addressList){
			alert(addressList[j]);
            codeAddress(addressList[j]);
	   } */
	/*    var addressList = new Array( '서울', '대구','광주','부산','포항','강릉','전주','광양','거제','김해','대전','울산','마산','수원','인천','군산','파주');
	   for(var j in addressList){
		    
            codeAddress(addressList[j]);
	   }   */
//}
 
 
 function codeAddress(address) {
	   geocoder = new google.maps.Geocoder();	   
	   /* alert(address); */	   
	   geocoder.geocode( { 'address': address}, function(results,status) {
		   	if (status == google.maps.GeocoderStatus.OK) {
	                 var lat = results[0]['geometry']['location']['lat']();
	                 var lng = results[0]['geometry']['location']['lng']();
	                 //alert(address+"의 위도는 " + lat + " 이며, 경도는" + lng + " 입니다.");
	                 //map.setCenter(results[0].geometry.location);
	      
	                 var marker = new google.maps.Marker({   
	                	 	map: map,                 
	                         position: results[0].geometry.location,
	                         draggable:false,
	                         animation:google.maps.Animation.DROP,
	                         title:address
	                 });
	                 
	                 var labels = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
	                 var markers = results.map(function() {
	                     return new google.maps.Marker({
	                       position: results[0].geometry.location,
	                       label: "count"
	                     });
	                   });

	                   // Add a marker clusterer to manage the markers.
	                   var markerCluster = new MarkerClusterer(map, markers,
	                       {imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m'});
	                 markers.push(marker);
	                 
	                 /* var weightedLoc = {
	                		         location : new google.maps.LatLng(lat, lng),
	                		  		 weight : 2 * 100
	                		};
	              	heatMapData.push(weightedLoc); */
	                
	         }else if(status ==  google.maps.GeocoderStatus.OVER_QUERY_LIMIT){
			   		 setTimeout(function(){			   			 
			   			codeAddress(address);
			   		},200); 
			   		
			   	} else {
	           alert('Geocode was not successful for the following reason: ' + status);
	         }
	   });
	 }
 

 
 /*  function codeAddress() {
 geocoder = new google.maps.Geocoder();
 var address = document.getElementById('address').value;
 geocoder.geocode( { 'address': address}, function(results,status) {
       if (status == google.maps.GeocoderStatus.OK) {
               var lat = results[0]['geometry']['location']['lat']();
               var lng = results[0]['geometry']['location']['lng']();
               alert(address+"의 위도는 " + lat + " 이며, 경도는" + lng + " 입니다.");
               map.setCenter(results[0].geometry.location);    
               var marker = new google.maps.Marker({   
              	 	map: map,                 
                       position: results[0].geometry.location,
                       draggable:false,
                       animation:google.maps.Animation.DROP,
                       title:address
               });
       } else {
         alert('Geocode was not successful for the following reason: ' + status);
       }
 });
}  */









 
/*  var heatmap;
  var heatMapData = [];
          
  function geocode(addressList) {
    var addressList = new Array('서울','서울','서울','서울','서울','서울',
 '서울','서울','대구','광주','부산','포항','강릉','전주','광양','거제','김해',
 '대전','울산','마산','수원','인천','서울','대구','광주','부산','포항','강릉',
 '전주','서울','서울','서울','광양','거제','김해','대전','울산','마산',
 '서울','서울','수원','인천','군산','파주','서울','서울');
         for ( var j in addressList) {
                  codeAddress(addressList[j]);
          }
          heatmap = new google.maps.visualization.HeatmapLayer({
                  data : heatMapData,
                  radius : 40,
                  dissipating : true
          });
          heatmap.setMap(map);
  }
 
 function codeAddress(address) {
	           geocoder = new google.maps.Geocoder();
	          geocoder.geocode({'address' : address}, function(results, status) {
	                   if (status == google.maps.GeocoderStatus.OK) {
	                           var lat = results[0]['geometry']['location']['lat']();
	                           var lng = results[0]['geometry']['location']['lng']();
	                           map.setCenter(results[0].geometry.location);
	                           var marker = new google.maps.Marker({
	                                   map : map,
	                                   position : results[0].geometry.location,
	                                   draggable : false,
	                                   animation : google.maps.Animation.DROP,
	                                   title : address
	                           });
	                           var weightedLoc = {
	                                   location : new google.maps.LatLng(lat, lng),
	                                   weight : 2 * 3
	                           };
	                           heatMapData.push(weightedLoc);
	                   } else {
	                           alert('Geocode was not successful for the following reason: '+ status);
	                   }
	           });
	   } */
 
  
 

</script>
</head>

<body>
	<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>

	<div id="googleMap" style="width: 500px; height: 380px;"></div>

	<div id="panel">
		<input id="address" type="textbox" value="Seoul"> 
		<!-- <input type="button" value="GO" onclick="codeAddress()"> -->

		<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>
</body>

</html>
