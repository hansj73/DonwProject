<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="com.prj.Culture.security.dto.UserDTO" %>
<%
Authentication auth = SecurityContextHolder.getContext().getAuthentication();
Object principal = auth.getPrincipal();
String name = "";
if(principal != null && principal instanceof UserDTO){
    name = ((UserDTO)principal).getUsername();
}
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" />
        <title>글쓰기</title>
    </head>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
         <link rel="stylesheet" type="text/css" href="/js/guupload/css/guupload.css"/>
		 <script type="text/javascript" src="/js/guupload/guUploadManager.js"></script>
         <script>
         
         var guManager=null;
         window.onload = function() {
         	var option = {
         			//listtype: "list",
         			fileid: "guupload",
         			//uploadURL: "upload",
         			uploadURL: "/board/fileUpload.do",
         			form: document.form1
         	}
         	guManager = new guUploadManager(option);
         }	
         
         function formSubmit() {
      	//document.frm.submmit();
      	//alert('afasdf');
        guManager.uploadFiles();
      	View();
		}
         </script>
         <style>
         .layer{position:absolute;top:0;left:0;width:100%;height:100%;text-align:center}
		.layer .content{display:inline-block;background:#fffff;vertical-align:middle}
		.layer .blank{display:inline-block;width:0;height:100%;vertical-align:middle}
		.layer {display:none;}
         </style>
    	<body>
   <div class="container">
    <section>
   <div>
        <table class="table table table-bordered">
        <tbody>
        <form action="/board/write_ok.do"  method="post" id="form1" name="form1" >
        <!-- <form action="/board/write_ok.do" method="post" id="form1" name="form1" > -->
        <!-- <form method="post" id="form1" name="form1" enctype="multipart/form-data"  > -->
       
            <tr>
                <th>제목 </th>
                <td><input type="text" placeholder="제목을 입력하세요" name="title"  class="form-control"/></td>
            </tr>
            <tr>
                <th>내용 </th>
                <td><textarea rows="5"  placeholder="내용을 입력하세요." name="content"  class="form-control"></textarea></td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><input type="text" placeholder="비밀번호를 입력하세요" name="pwd"  class="form-control"></td>
            </tr>
            <tr>
                <th>작성자 </th>
                <td><input type="text" placeholder="작성자를 입력하세요"  name="writer"  value="<%=name%>"class="form-control"></td>
            </tr>
            <tr>
                <th>파일업로드 </th>
               <!--  <td><input type="file" name="upload"   id="guupload" ></td> -->
                
                <td>
				
				<div id="guupload" class="guupload" style="width: 500px;"></div>
				</br>
				</br>
				</br>
			</td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="button" value="등록하기"  class="pull-right" onclick="formSubmit()"/>
                    <input type="button" value="reset" class="pull-left" onclick="document.frm.reset()"/>
                    <input type="button" value="리스트가기" class="pull-right" onclick="javascript:location.href='/board/list.do'"/>
                </td>
            </tr>
            <input type="hidden" id="filename" name="filename"/>
            <input type="hidden" id="selectFile" />
        </form>
        </tbody>
</table>
</div>
</section>

</div>
<script type="text/javascript" language="JavaScript">
function View(){
	
	document.all.loadingBar.style.display="block"; 

/* document.all.divBody.style.display=";"; */
}
</script>
 <!-- <div id="loadingBar" style="position:absolute; top:200px; left:500px; display:none;">
   <img src="/images/loading.gif">
   </div> -->
<div class="layer" id="loadingBar">
  <span class="content"><img src="/images/loading.gif"></span>
  <span class="blank"></span>
</div>
  <!-- Bootstrap core JavaScript -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    </body>
</html>
