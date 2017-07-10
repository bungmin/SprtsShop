<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<title>Excerciser</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="../resources/bxslider/jquery.bxslider.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js" type="text/javascript"></script>
<!-- bxSlider CSS file -->
<link href="../resources/bxslider/jquery.bxslider.css" rel="stylesheet" />
<style>

/* Remove the navbar's default rounded borders and increase the bottom margin */
.navbar {
	margin-bottom: 50px;
	border-radius: 0;
}

/* Remove the jumbotron's default bottom margin */
.jumbotron {
	margin-bottom: 0;
}
	.soccerList ul{
		margin: 0;
		padding: 0;		
		
	}
	.soccerList li{
		list-style-type:none;		
		
	}
	
	.soccer ul{
		margin: 0;
		padding: 0;
	}
	.baseball ul{
		margin: 0;
		padding: 0;
	}
	.basketball ul{
		margin: 0;
		padding: 0;
	}
	
	.soccer li{
		list-style-type: none;
	}
	.baseball li{
		list-style-type: none;
	}
	.basketball li{
		list-style-type: none;
	}
	
	.allBoard li{
		list-style-type: none;
	}
	

/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
}



	img {
		width: 500px;
		height: 450px;
		
	}
	
	div #leftBox {

	height: 300px;
	width: 200px;
	
	}
	
	div #rightBox {

	width: 220px;
	
	}
</style>
<script type="text/javascript">
  $(document).ready(function() {
	  
	  //setInterval("getServerTime()", 1000);
	

  
  });
  
  function getServerTime() {
		$.ajax({
			url: "/replies/time",
			type : "GET",
			success: function(result) {
				
				$("#serverTime").html(result);
							
			}
			
			
		});
		
	}
  
  
  </script>

</head>
<body>

	<jsp:include page="/WEB-INF/views/admin_page_header.jsp"></jsp:include>

	<div class="container text-center">
		<div class="row">
			  	<c:choose>
  		<c:when test="${login ne null}">
  	
			<div class="col-sm-3 ">				
				<div class="well">					
					
					<p>
						ID : ${login.id}																
					</p>
					<div class="userInfo">
					
					</div>
										
					<hr>
					<p>					
						<a href="/user/mypage?id=${login.id}">내 정보관리</a> </p>
					<a id="cash">캐시 충전하기</a> &nbsp;&nbsp; <a href="/user/logout">로그아웃</a>					
				</div>
				

				<div class="alert alert-success fade in">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
					<p>
						<strong>Enjoy!</strong>
					</p>
					Exeriser에 오신 것을 환영합니다.
				</div>
				
			</div>
		</c:when>
		<c:otherwise>
			<div class="col-sm-3 ">
			</div>		
		</c:otherwise>
	</c:choose>


			<div class="col-sm-7">
			
				<div style="position: relative; left: 100px;" class="row">

					<div>
						<img class="mySlides" src="/resources/img/soccer.jpg">
						<img class="mySlides" src="/resources/img/baseball.jpg"> 
						<img class="mySlides" src="/resources/img/basketball.jpg">
						
					</div>

				</div>
				
				<br>
				
				
				<div class="row">
					<div class="col-sm-12">
					
				
						
						<div class="text-right">
							<a href="/sboard/listCriteria?category=notice">더보기</a>
						</div>
						<div class="panel-group notice" id="accordion" role="tablist" aria-multiselectable="true">
						</div>
					

					</div>
				</div>
				<div class="row"></div>

				<div class="row">
					<div class="col-sm-3">						
						<img src="/resources/img/soccerball.jpg" style="width: 100%" class="img-responsive" alt="Avatar">
						<strong>축구용품</strong>
					</div>
					<div class="col-sm-9">
						<ul class="soccerList">  							
						</ul>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<img src="/resources/img/baseball1.jpg" style="width: 100%" class="img-responsive" alt="Avatar">					
						<strong>야구용품</strong>			
					</div>
					<div class="col-sm-9">						
						<ul class="BaseBalllList">  							
						</ul>						
					</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<img src="/resources/img/basketball1.jpg" style="width: 100%" class="img-responsive" alt="Avatar">
						<strong>농구용품</strong>
					</div>
					<div class="col-sm-9">
						<ul class="basketBallList">  							
						</ul>			
					</div>
				</div>
				<div class="row">
					<div class="col-sm-3">						
						<img src="/resources/img/board_image.png" style="width: 100%" class="img-responsive" alt="Avatar">						
					</div>
					<div class="col-sm-9">
						<div class="text-right"><a id="all_board">더보기</a></div>					
						<div class="panel-group allBoard">
    						
  						</div>												
					</div>
					
				</div>
			</div>
			<div class="col-sm-2">
				
				 <div class="adslist">
      			</div>

			</div>
		</div>
	</div>
	
	
	<script id="source" type="text/x-handlebars-template">			
			{{#each.}}				
					<li><img src="/displayFile?fileName={{p_img_1}}" class="img-responsive" style="width: 100%">
						<p style="color: red;">{{p_title}}</p>
						<p >{{p_price}} 원</p>
						

					</li>				
			{{/each}}	
			
	</script>
	
	
		<script id="adsource" type="text/x-handlebars-template">
			{{#each.}}
				<div class="well">
        		<p><a class="img_link" data-ano="{{ano}}" href="{{a_img_link}}"><img src="/displayFile?fileName={{a_img_name}}" class="img-responsive" style="width: 100%" alt="{{a_title}}"></a></p>
				<p>{{a_title}}</p>
      			</div>   										
			{{/each}}	
		</script>
		
		
		<script id="notice_title" type="text/x-handlebars-template">
			{{#each.}}			
		<div class="myCollapsible panel panel-default">
			<div class="panel-body" role="tab">				
				<strong> 공지사항 : {{title}}</strong>				
				<p class="form-group row collapse">
				<br><br>
					<strong>{{content}}</strong>				 
				</p>
					
			</div>						
		</div>								
			{{/each}}	
	</script>
		<script id="soccer" type="text/x-handlebars-template">
			{{#each.}}
				
				<li>
					<strong>제목 : </strong><a href="/sboard/bread?&bno={{bno}}&category=soccer">{{title}}</a>
      			</li>   										
			{{/each}}	
	</script>
		<script id="basketball" type="text/x-handlebars-template">
			{{#each.}}
				<li>
					<strong>제목 : </strong><a href="/sboard/bread?&bno={{bno}}&category=basketball">{{title}}</a>
      			</li>   										
			{{/each}}	
	</script>
		<script id="baseball" type="text/x-handlebars-template">
			{{#each.}}
				<li>
					<strong>제목 : </strong><a href="/sboard/bread?&bno={{bno}}&category=baseball">{{title}}</a>
      			</li>   										
			{{/each}}	
	</script>
		<script id="allBoard" type="text/x-handlebars-template">			
			{{#each.}}			
						<div class="myCollapsible panel panel-default">
										<div class="panel-body" role="tab">				
										<strong> {{category}}  :</strong>										
										<a href="sboard/read?bno={{bno}}&category=soccer">{{title}}</a> / <span class="badge">{{viewCnt}}</span>	 										
										</div>					
						</div>										
			{{/each}}			
	</script>
	
	<script id="UserInfosource" type="text/x-handlebars-template">
				<p>
					캐시 - {{cash}} cash		
				</p>
				<p>
					마일리지 - {{mileage}} 마일리지					
				</p>	
	</script>
	
		
		
	<script type="text/javascript">
		$(document).ready(function() {
			var slideIndex = 0;
			
			getAllList();
			getNotice();
			getSoccer();
			getBaseball();
			getbasketball();
			
			
			
			var id = '${login.id}';
			
			getUserInfo(id);
			
			$("#cash").click(function(){
				window.open("/userProductList/cash","충전", "height=500, width=500, top=200, left=200");
			
			
			//	location.href="/userProductList/cash";
			
			
			});
	
			
			
			$(".notice").on("click",".myCollapsible", function(event) {
				event.preventDefault();
				
				
				$(this).find("p").collapse("toggle");		
				
				
			});
			
			$("#all_board").click(function() {
				location.href= "/sboard/listCriteria?category=soccer";
			});
			
			$("#notice_board").click(function(){
				location.href= "/sboard/listCriteria?category=notice";
				
				
			});
			
	$(".adslist").on("click", ".img_link", function(event) {
				
				var ano = $(this).attr("data-ano");	
				
				 $.ajax({
						type : "delete",
						url : "/adsinfo/addreadcnt/" + ano,
						headers : {
							"Content-Type" : "application/json",
							"X-HTTP-Method-Override" : "DELETE"
						},
						dataType : "text",
						success : function(result) {							
							//getAllList();					
						}
					});			
			
			});
			
			var slider = $('.soccerList').bxSlider({
				minSlides: 5,
				maxSlides: 5,
				moveSlides: 5,
				speed : 1000,
				slideWidth: 200,
				slideMargin: 10,
				captions: true,
				auto: true,
				autoDelay : 500,
				pager : false
			 
			});
			
			var baseBallslider = $('.BaseBalllList').bxSlider({
				minSlides: 5,
				maxSlides: 5,
				moveSlides: 5,
				speed : 1000,
				slideWidth: 200,
				slideMargin: 10,
				captions: true,
				auto: true,
				autoDelay : 500,
				pager : false
			 
			});
			
			var basketslider = $('.basketBallList').bxSlider({
				minSlides: 5,
				maxSlides: 5,
				moveSlides: 5,
				speed : 1000,
				slideWidth: 200,
				slideMargin: 10,
				captions: true,
				auto: true,
				autoDelay : 500,
				pager : false
			 
			});
			
			getSoccerList(slider);
			getBasketBallList(basketslider);
			getBaseBalllList(baseBallslider);
			
			
			
			carousel();

			function carousel() {
				var i;
				var x = document.getElementsByClassName("mySlides");
				for (i = 0; i < x.length; i++) {
					x[i].style.display = "none";
				}
				slideIndex++;
				if (slideIndex > x.length) {
					slideIndex = 1
				}
				x[slideIndex - 1].style.display = "block";
				setTimeout(carousel, 2000); // Change image every 2 seconds
			}
			
			
			
			$("#logout").click(function() {
				alert("ㅇㅇ");
				
			});
			
		});
		
		
		
		
		
		
		
		function getSoccerList(slider) {
			  $.getJSON("/mainList/soccerlist", function(data) {
					
					var source = $("#source").html();
					var template =Handlebars.compile(source);
					var gab=data;
					
					
					$('.soccerList').append(template(gab)); 
					slider.reloadSlider();
					
				});
		};
		
		function getBasketBallList(slider) {
			  $.getJSON("/mainList/basketBallList", function(data) {
					
					var source = $("#source").html();
					var template =Handlebars.compile(source);
					var gab=data;
					
					
					$('.basketBallList').append(template(gab)); 
					slider.reloadSlider();
					
				});
		};
		function getBaseBalllList(slider) {
			  $.getJSON("/mainList/baseballlist", function(data) {
					
					var source = $("#source").html();
					var template =Handlebars.compile(source);
					var gab=data;
					
					
					$('.BaseBalllList').append(template(gab)); 
					slider.reloadSlider();
					
				});
		};
		
		
		function getNotice() {
			$.getJSON("/board/notice", function(data) {
				
			 	var source = $("#notice_title").html();
				var template =Handlebars.compile(source);
				
				for(i = 0; i<data.length ; i++){					
					data[i].content = removeHTML(data[i].content);
				}
				
				var gab=data;	
				
				
				
				
				
				$(".notice").html(template(gab));
				 
				
			});

			
		}
		
		function getSoccer() {
			$.getJSON("/board/soccer", function(data) {
				
			 	var source = $("#soccer").html();
				var template =Handlebars.compile(source);
				var gab=data;					
				
				$(".soccer").html(template(gab));
				 
				
			});

			
		}
		function getBaseball() {
			$.getJSON("/board/baseball", function(data) {
				
			 	var source = $("#baseball").html();
				var template =Handlebars.compile(source);
				var gab=data;					
				
				$(".baseball").html(template(gab));
				 
				
			});

			
		}
		
		function getbasketball() {
			$.getJSON("/board/basketball", function(data) {
				
			 	var source = $("#basketball").html();
				var template =Handlebars.compile(source);
				var gab=data;					
				
				$(".basketball").html(template(gab));
				 
				
			});

			
		}
		
		function getbasketball() {
			$.getJSON("/board/allBoard", function(data) {
				
			 	var source = $("#allBoard").html();
				var template =Handlebars.compile(source);
				var gab=data;					
				
				$(".allBoard").html(template(gab));
				 
				
			});

			
		}
		
		
		function getAllList() {
			$.getJSON("/adsinfo/registerdListAds/", function(data) {
				var source = $("#adsource").html();
				var template =Handlebars.compile(source);
				var gab=data;	
				
				
				
				$(".adslist").html(template(gab));
				
				
			});
			
		};
		
		
		
		function removeHTML(text){
			text = text.replace(/<br\/>/ig, "\n"); 
			text = text.replace(/<(\/)?([a-zA-Z]*)(\s[a-zA-Z]*=[^>]*)?(\s)*(\/)?>/ig, "");

			return text;
			
		}
		
		function getUserInfo(id) {
			
			$.getJSON("/user/userinfo/"+id, function(data) {
				
				
				var source = $("#UserInfosource").html();
				var template =Handlebars.compile(source);
				var gab=data;	
				
				$(".userInfo").html(template(gab));
				
				
			});
			
		}
		
		
			</script>
	
	


	<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>

</body>
</html>

