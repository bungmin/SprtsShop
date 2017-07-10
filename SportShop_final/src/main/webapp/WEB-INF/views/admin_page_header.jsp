<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
  </style>
  
 <div class="jumbotron" style="background-image: url('../resources/img/yoshi.jpg'); background-size: inherit;">
  <div class="container text-center">
    <h1>Exerciser</h1>      
    <p>Health, Enjoy&Enterprise</p>
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
				
				<c:choose>
						<c:when test="${login eq null || login.position == 'user'}">
							<li class="active"><a href="/">Home</a></li>
						</c:when>
						<c:when test="${login.position == 'admin'}">
							<li class="active"><a href="/admin">Home</a></li>
						</c:when>
						<c:when test="${login.position == 'ceo'}">
							<li class="active"><a href="/ceo">Home</a></li>
						</c:when>								
				</c:choose>
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
					
					
					<c:choose>				
						<c:when test="${login.position == 'user'}">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">고객센터<span
						class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/msg/listCriteriaUser?id=${login.id}">1:1 문의</a></li>
						<li><a href="/order/myOrder?id=${login.id}">주문조회</a></li>
						<li><a href="/myWrite/list?id=${login.id}">내가 쓴 글 보기</a></li>
					</ul></li>
					</c:when>
					</c:choose>
					
					
					 
				
					<c:choose>				
						<c:when test="${login.position == 'admin'}">		
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">상품관리<span
						class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/product/insertProduct">상품 등록</a></li>
						<li><a href="/product/listCriteriaAdmin">상품 조회/수정/삭제</a></li>					
						<li><a href="/order/orderAdmin">회원들의 주문 조회</a></li>					
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">게시물
						관리<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/msg/listCriteria">1대1 문의 조회</a></li>					
						<li><a href="/sboard/listCriteria?category=notice">공지사항 게시판</a></li>
					</ul></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">회원
						관리<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/usermanage/todayUser">오늘 가입한 회원 조회</a></li>
						<li><a href="/usermanage/usercheck">회원 조회/삭제</a></li>
						<li><a href="/usermanage/manalysis">회원 목록 통계</a></li>
						<li><a href="/usermanage/visitlog_D">방문자수 통계</a></li>
						<li><a href="/usermanage/analysisBoard">게시글 통계</a></li>
					</ul></li>
			
					
					
					<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">광고관리
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/ads/create">광고 등록</a></li>
						<li><a href="/ads/list">광고 조회/수정/삭제</a></li>						
					</ul></li>
				</c:when>
				</c:choose>
				
					<c:choose>				
						<c:when test="${login.position == 'ceo'}">		
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">상품관리<span
						class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/product/insertProduct">상품 등록</a></li>
						<li><a href="/product/listCriteriaAdmin">상품 조회/수정/삭제</a></li>					
						<li><a href="/order/orderAdmin">회원들의 주문 조회</a></li>					
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">게시물
						관리<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/msg/listCriteria">1대1 문의 조회</a></li>					
						<li><a href="/sboard/listCriteria?category=notice">공지사항 게시판</a></li>
					</ul></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">회원
						관리<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/usermanage/todayUser">오늘 가입한 회원 조회</a></li>
						<li><a href="/usermanage/usercheck">회원 조회/삭제</a></li>
						<li><a href="/usermanage/manalysis">회원 목록 통계</a></li>
						<li><a href="/usermanage/visitlog_D">방문자수 통계</a></li>
						<li><a href="/usermanage/analysisBoard">게시글 통계</a></li>
					</ul></li>
			
					
					
					<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">광고관리
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/ads/create">광고 등록</a></li>
						<li><a href="/ads/list">광고 조회/수정/삭제</a></li>						
					</ul></li>
					
					<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">매출 관리
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/owner/age">매출 통계</a></li>												
					</ul></li>
					
					
				</c:when>
				</c:choose>
			</ul>		

			<ul class="nav navbar-nav navbar-right">
			
			
				




				<%-- <c:choose>
					<c:when test="${login.id eq null}">
						<li><a href="/user/login"><span
								class="glyphicon glyphicon-user"></span> 로그인</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/user/logout"><span
								class="glyphicon glyphicon-user"></span> 로그아웃</a></li>
					</c:otherwise>
				</c:choose> --%>

				<%-- <c:choose>
					<c:when test="${login.id eq null}">
						<li><a href="/user/login"><span
								class="glyphicon glyphicon-user"></span> 로그인</a></li>
					</c:when>
					<c:otherwise>
						<li><span
							style="color: gray; list-style: none; display: inline; position: relative; top: 15px;"
							class="glyphicon glyphicon-user">관리자 ${login.id}님 환영합니다.</span></li>
						<li><a href="/user/logout"><span
								class="glyphicon glyphicon-user"></span> 로그아웃</a></li>
					</c:otherwise>
				</c:choose>
				
				
 --%>
 				
 					
				<c:choose>				
				<c:when test="${login.id eq null}">				
				<li><a href="/user/login"><span
						class="glyphicon glyphicon-user"></span> 로그인</a></li>
				<li><a href="/user/join"><span class="glyphicon glyphicon-shopping-cart"></span> 회원가입</a></li>
				</c:when>
				<c:otherwise>
				<li><span
					style="color: gray; list-style: none; display: inline; position: relative; top: 15px;"
					class="glyphicon glyphicon-user"><c:if test="${login.position == 'admin' }">관리자</c:if>
					<c:if test="${login.position == 'ceo' }">경영자</c:if>
					 ${login.id}님 환영합니다.</span></li>
				<li><a href="/user/logout"><span
						class="glyphicon glyphicon-user"></span> 로그아웃</a></li>
				
				<c:choose>
					<c:when test="${login.position == 'admin' }">
					</c:when>
					<c:otherwise>
					<li><a href="/cart/list?id=${login.id}"><span class="glyphicon glyphicon-shopping-cart"></span> 장바구니</a></li>
					</c:otherwise>				
				</c:choose>								
				</c:otherwise>							
				</c:choose>
 
 
 
 					
 				
 						
		
			</ul>
		</div>
	</div>
</nav>