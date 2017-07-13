<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
    /* Remove the navbar's default rounded borders and increase the bottom margin */ 
    .navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }
    
    /* Remove the jumbotron's default bottom margin */ 
    .jumbotron {
     margin-top: auto;
     padding-top : inherit;
     margin-bottom: auto;
     padding-bottom: inherit;      
    }
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
  </style>
  
 <div class="jumbotron" style="background-color: white;">
  <div class=" container text-center">
  	<div
  	style="background: url('../resources/img/main_image4.png') no-repeat;        
     background-size: cover;     
     background-position: center;
  	    
     height: auto; overflow: hidden; 
     ">
    <h1>Exerciser</h1>      
    <p>Health, Enjoy&Enterprise</p>
    </div>
  </div>
</div>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">Home</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">상품<span
						class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/userProductList/listSearchCriteria?page=1&perPageNum=12&category=all">모든 상품</a></li>
						<li><a href="/userProductList/listSearchCriteria?page=1&perPageNum=12&category=soccer">축구 상품</a></li>
						<li><a href="/userProductList/listSearchCriteria?page=1&perPageNum=12&category=baseball">야구 상품</a></li>
						<li><a href="/userProductList/listSearchCriteria?page=1&perPageNum=12&category=basketball">농구 상품</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">커뮤니티<span
						class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">					
						<li><a href="/sboard/listCriteria?category=notice">공지사항</a></li>					
						<li><a href="/sboard/listCriteria?category=soccer">SoccerBoard</a></li>
						<li><a href="/sboard/listCriteria?category=baseball">BaseballBoard</a></li>
						<li><a href="/sboard/listCriteria?category=basketball">BasketBallBoard</a></li>				
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">고객센터<span
						class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/msg/listCriteriaUser?id=${login.id}">1:1 문의</a></li>
						<li><a href="/order/myOrder?id=${login.id}">주문조회</a></li>
						<li><a href="/myWrite/list?id=${login.id}">내가 쓴 글 보기</a></li>
					</ul></li>
			</ul>		

			<ul class="nav navbar-nav navbar-right">
					<li><span
					style="color: gray; list-style: none; display: inline; position: relative; top: 15px;"
					class="glyphicon glyphicon-user"> ${login.id}님 환영합니다.</span></li>
				<li><a href="/user/logout"><span
						class="glyphicon glyphicon-user"></span> 로그아웃</a></li>
				<li><a href="/cart/list?id=${login.id}"><span class="glyphicon glyphicon-shopping-cart"></span> 장바구니</a></li>
		
			</ul>
		</div>
	</div>
</nav>