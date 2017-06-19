<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html> 
<html lang="ko">
 <head> 
 <meta charset="utf-8"> 
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>비밀번호생성</title>
</head> 
<body> 
<script> 

function signinOk() 
{ 
	document.frm.submit();
}

   </script> 
  <div>
  <div id="message" style="width:300px;position:absolute; top:-60px;border: 1px;border-color: #000;"></div> 
  </div> 
  <div style="margin-top:100px;"> 
  <form action="/member/passwd_ok.do" method="post" name="frm"> 
  <!-- 아이디 : <input type="text" id="user_id" name="user_id"> --> 
  비밀번호 : <input type="password" id="password" name="password"> 
<button type="button" onClick="signinOk();">비밀번호생성</button> 
</form>
<p>비밀번호 권한</p> 
<ol>
  <li>ROLE_USER: 보기권한</li>
  <li>ROLE_ADMIN:파일업로드 권한</li>
  <li>ROLE_SUPERADMIN:비밀번호생성</li>
</ol>
<c:if test ="${!empty passwd}">
생성된 비밀번호:${passwd}
</c:if>
<ol>
<li>디스크 용량보기
</ol>
</div>
${usedPer}
<div class="container">
  <h2>Colored Progress Bars</h2>
  <p>The contextual classes colors the progress bars:</p> 
  <div class="progress">
    <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="${usedPer}" aria-valuemin="0" aria-valuemax="100" style="width:${usedPer}%">
      ${usedSpace}GB / ${totalSpace}GB 사용중
    </div>
  </div>
</div>


<div class="container">
  <h2>Colored Progress Bars</h2>
  <p>The contextual classes colors the progress bars:</p> 
  <div class="progress">
    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:40%">
      40% Complete (success)
    </div>
  </div>
  <div class="progress">
    <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width:50%">
      50% Complete (info)
    </div>
  </div>
  <div class="progress">
    <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width:60%">
      60% Complete (warning)
    </div>
  </div>
  <div class="progress">
    <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width:70%">
      70% Complete (danger)
    </div>
  </div>
</div>


</body>
</html>
    