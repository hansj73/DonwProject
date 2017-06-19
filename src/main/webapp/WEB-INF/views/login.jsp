<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@	include file="/WEB-INF/views/inc/header.jsp" %>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script> 
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script> 
<script> 
function get_msg(message) 
{ 
    /* var move = '70px'; 
    jQuery('#message').text(message); 
    jQuery('#message').animate({ 
      top : '+=' + move 
      }, 'slow', function() { jQuery('#message').delay(1000).animate({ top : '-=' + move }, 'slow'); 
      }); */
      alert("로그인 실패하였습니다.아이디 나 비번을 확인하세요 ");
 }

<c:if test="${error == 'true'}"> 
  jQuery(function() { 
    get_msg("로그인 실패하였습니다."); 
    }); 
</c:if>

function signinOk() 
{ 
	
	  if ($("#uid").val().trim() == "") 
	  {
	   alert("이름을 입력해 주세요.");
	   $("#uid").focus();
	   return ;
	  }
	  
	  if($("#upw").val().trim() == "") 
	  {
		   alert("비밀번호를  입력해 주세요.");
		   $("#upw").focus();
		   return ;
		}
	  
	document.frm.submit();
}

   </script> 

	<body>
	<div id="message" style="width:300px;position:absolute; top:-60px;border: 1px;border-color: #000;"></div>
		<div id="pychang">
			<div id="header">
			</div>
  
			<div id="wrap">
				<div class="login">
					<div class="tit">로그인</div>
					<div class="sub_tit">평창올림픽 다운로드 사이트에 오신것을 환영합니다.</div>
				<form action="/j_spring_security_check" method="post" name="frm"> 	
					<div class="box01">
						<div> 아이디 <input id="uid" name="user_id" type="text" title="아이디" placeholder="아이디 "> </div>
						<div> 비밀번호 <input id="upw" name="password" type="password" title="비밀번호" placeholder="비밀번호 " onkeydown="javascript:if(event.keyCode==13){signinOk(); return false;}"> </div>
						<a href="javascript:signinOk();" title="로그인"  ><div class="btn01">로그인</div></a>
						<div class="ck_agree">
							<!-- <input type="checkbox" id="" name="" title="필수" class=""> -->
							<label for="">ID 저장       접속권한이 부여된 회원 외에는 접속이 제한됩니다.</label>
						</div>
					</div>
		</form>
					
					
				</div>
			</div>

			<!-- div class="footer">
			</div -->
		</div>
	</body>
</html>
