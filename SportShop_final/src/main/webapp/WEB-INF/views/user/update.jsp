<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<jsp:include page="../header.jsp"></jsp:include>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style type="text/css">
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

</head>
<body>
<jsp:include page="/WEB-INF/views/page_header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<br>
			<h2>
				<span class="label label-default">회원정보수정</span>
			</h2>
			<hr>
		</div>
		<div class="row">
			<form id="myForm" class="form-horizontal" role="form" method="post">
				<div class="form-group">
					<div class="form-group">
						<label class="col-sm-2 control-label" for="id">ID</label>
						<div class="col-sm-6">
							<input class="form-control" type="text" id="id" name="id" value="${login.id}" readonly="readonly">
						</div>
						
						<div class="col-sm-2">
							<span id="idcheckmsg"></span>							
						</div>
							
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="pw">PASS1</label>
						<div class="col-sm-6">
							<input class="form-control" type="password" id="pw"
								name="pw" value="${userVO.pw}">
						</div>
						
						<div class="col-sm-4">
							<span id="pwcheckmsg"></span>							
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="pw2">PASS2</label>
						<div class="col-sm-6">
							<input class="form-control" type="password" id="pw2"
								name="pw2" value="${userVO.pw}">
						</div>
						<div class="col-sm-4">
							<span id="pwcheckmsg2"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="name">이름</label>
						<div class="col-sm-6">
							<input class="form-control" type="text" id="name" name="name"
								value="${userVO.name}">
						</div>
						<div class="col-sm-4">
							<span id="namecheck"></span>
						</div>
					</div>
					
					
					<div class="form-group">
						<label class="col-sm-2 control-label" for="postcode">우편번호</label>
						<div class="col-sm-2">
							<input readonly="readonly" class="form-control" type="text" id="postcode" name="postcode"
								>
						</div>
						<div class="col-sm-2">
							<a onclick="sample6_execDaumPostcode()" class="btn btn-warning">우편번호 찾기</a>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label" for="addr1">주소</label>
						<div class="col-sm-6">
							<input readonly="readonly" class="form-control" type="text" id="addr1" name="addr1"
								value="${userVO.addr1}">
						</div>
						<div class="col-sm-4">
							
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label" for="addr2">상세주소</label>
						<div class="col-sm-6">
							<input class="form-control" type="text" id="addr2" name="addr2"
								value="${userVO.addr2}">
						</div>
						<div class="col-sm-4">
							
						</div>
					</div>
					
					
					
					<input class="form-control" value="${userVO.state}" type="hidden" id="state" name="state" placeholder="지역">



					<div class="form-group">
						<label class="col-sm-2 control-label" for="email">이메일</label>
						<div class="col-sm-6">
							<input class="form-control" type="text" id="email"
								name="email" value="${userVO.email}">
						</div>
						<div class="col-sm-4">
							<span id="emailcheck"></span>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label" for="birthday">생년월일</label>
						<div class="col-sm-6">
							<div class="input-group">
								<input class="form-control" id="birthday" type="text"
									name="birthday" value="${userVO.birthday}"> <span
									class="input-group-addon"> <span
									class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
						<div class="col-sm-4"></div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label" for="name">전화번호</label>
						<div class="col-sm-6">
							<input class="form-control" type="text" id="phone" name="phone"
								value="${userVO.phone}">
						</div>
					</div>


					<!-- 
					<div class="form-group">
						<label class="col-sm-2 control-label" for="joincode">이메일
							인증번호</label>
						<div class="col-sm-6">
							<input class="form-control" type="joincode" id="joincode"
								name="joincode" placeholder="인증번호를 입력하세요.">
						</div>
						<div class="col-sm-4">
								<strong><button id="joincodecheck">이메일 인증</button></strong>			
						</div>
					</div>
					 -->

					<div class="form-group">
						<div class="col-sm-10 col-sm-offset-2">
							<button class="btn btn-info text-center" type="submit">수정하기</button>
							<button class="btn btn-warning text-center" type="reset">초기화</button>
							<button class="btn btn-warning text-center" type="button" id="mainpage">메인페이지</button>
						</div>
					</div>

				</div>
			</form>
			<hr>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/page_footer.jsp"></jsp:include>
	
	
	<script type="text/javascript">
	
$(document).ready(function() {	

		
		
		$("#pw").keyup(function() {	
			var pass1 =$("#pw").val();
			if(pass1 == ""){
				$("#pwcheckmsg").html("비밀번호를 입력하세요.");
				$("#pwcheckmsg").css("color", "red");
			} else if (pass1 != ""){
				$("#pwcheckmsg").html("");
			}
						
		});
		
		$("#pw2").keyup(function() {	
			
			var pass1 = $("#pw").val();
			var pass2 = $("#pw2").val();		
			if(pass2 == ""){
				$("#pwcheckmsg2").html("비밀번호를 입력하세요.");
				$("#pwcheckmsg2").css("color", "red");
			} else if (pass2 != ""){
				if(pass1 == pass2){
					$("#pwcheckmsg2").html("패스워드가 동일 합니다.");
					$("#pwcheckmsg2").css("color", "blue");
					
				}else if(pass1 != pass2){
					$("#pwcheckmsg2").html("패스워드를 확인해주세요.");
					$("#pwcheckmsg2").css("color", "red");
				}
				
			}
			
		});
					
		$("#name").keyup(function() {	
			
			var name = $("#name").val();
			
			if(name == ""){
				$("#namecheck").html("이름을 입력하세요.");
				$("#namecheck").css("color", "red");
			} else if(name != ""){
					$("#namecheck").html("");
			}
							
		});
		
		 $("#birthday").click(function() {
			 
			 
			 $("#birthday").datepicker({
				  changeMonth: true,
				  changeYear: true,
				  yearRange: "c-100:c",
				  dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],	
				  dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
				  monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	 	          monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	 	         
	 	          nextText: "다음 달", // next 아이콘의 툴팁.
	 	  	      prevText: '이전 달', // prev 아이콘의 툴팁.
	 	  	      dateFormat: "yy-mm-dd",
	 	  	      selectOtherMonths: true,
	 	  	   	  showAnim: "fold",
	 	  	      showButtonPanel: true,
	 	  	      currentText: "오늘날짜",
				  closeText: "닫기"				 
			 });		   	
	    });	
		
		
 		 $("#email").keyup(function() {
				//이메일 형식 체크
				var email = $("#email").val();
				var isEmail = emailcheck(email);				
				if(isEmail == true){
					$("#emailcheck").html("이메일 형식에 적합합니다.");
					$("#emailcheck").css("color", "blue");
				}else{
					$("#emailcheck").html("이메일 형식에 부적합합니다.");
					$("#emailcheck").css("color", "red");
				} 
			});
 
			//이메일 형식 체크 함수		
			function emailcheck(email) {			
				atPos = email.indexOf('@');			//@의 위치
				dotPos = email.lastIndexOf('.');		//.의 위치
				lastIdx = email.length -1;		//마지막 길이

				if(atPos == -1 || dotPos == -1){
					return false;
				}else if(atPos >= dotPos){
					return false;
				}else if(atPos == 0 || atPos == lastIdx ||
					dotPos == 0 || dotPos == lastIdx){
					return false;
				}			
				return true;	
 			
			}
 
			$("button[type='submit']").click(function(event){
				
				if($("#id").val() ==""){
					alert("아이디를 정확히 입력해주세요.");
					$("#id").select();
					$("#id").focus();		
					return false;
					
				}else if($("#pw").val() ==""){
					alert("비밀번호를 정확히 입력해주세요.");
					$("#pw").select();
					$("#pw").focus();		
					return false;
					
				}else if($("#pw2").val() ==""){
					alert("비밀번호를 정확히 입력해주세요.");
					$("#pw2").select();
					$("#pw2").focus();		
					return false;
					
				}else if($("#name").val() ==""){
					alert("성함을 정확히 입력해주세요.");
					$("#name").select();
					$("#name").focus();		
					return false;
					
				}else if($("#addr1").val() ==""){
					alert("주소를 정확히 입력해주세요.");
					$("#addr1").select();
					$("#addr1").focus();		
					return false;
					
				}else if($("#addr2").val() ==""){
					alert("상세주소를 정확히 입력해주세요.");
					$("#addr2").select();
					$("#addr2").focus();		
					return false;
					
				}else if($("#email").val() ==""){
					alert("이메일을 정확히 입력해주세요.");
					$("#email").select();
					$("#email").focus();		
					return false;
					
				}else if($("#birthday").val() ==""){
					alert("생년월일을 정확히 입력해주세요.");
					$("#birthday").select();
					$("#birthday").focus();		
					return false;
					
				}else if($("#phone").val() ==""){
					alert("연락처를 정확히 입력해주세요.");
					$("#phone").select();
					$("#phone").focus();		
					return false;
					
				}else if($("#gender").val() ==""){
					alert("성별을 정확히 입력해주세요.");
					$("#gender").select();
					$("#gender").focus();		
					return false;
					
				}else{
					alert("회원정보가 수정되었습니다.")
					event.preventDefault();
					var form=$("#myForm");
					$("form").attr("action", "update");
					$("form").attr("method", "post");			
					$("form").submit();
				}
				
			});
			

			
			
			$("button[type=reset]").click(function() {			
				$("#id").val() =="";
				$("#idcheckmsg").html("");	
				$("#pw").val() =="";
				$("#pwcheckmsg").html("");	
				$("#pw2").val() =="";
				$("#pwcheckmsg2").html("");			
				$("#name").val() =="";
				$("#namecheck").html("");		
				$("#addr1").val() =="";			
				$("#addr2").val() =="";
				$("#email").val() =="";	
				$("#emailcheck").html("");
				$("#birthday").val() =="";			
				$("#phone").val() =="";			
				$("#gender").val() =="";
			});
			
			
		 	$("#mainpage").click(function() {				
				/* 메인 페이지로 이동하기 만들기 */
		 		location.href="/";
			});
		 	
});
			
			
		
	

		

	</script>

		<script>
    			function sample6_execDaumPostcode() {
        			new daum.Postcode({oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수
                
                var state = '';
                
               

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                    
                    state += data.sido;
                }
                
                

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('addr1').value = fullAddr;
                document.getElementById('state').value = state;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('addr2').focus();
            }
        }).open();
    }
  

</script>

</body>
</html>