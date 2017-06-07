<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html> 
<html lang="ko">
 <head> 
 <meta charset="utf-8"> 
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
</div>
</body>
</html>
    