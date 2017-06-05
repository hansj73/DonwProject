<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>글보기</title>
    </head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/js/guupload/css/guupload.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>

<script>
/* 	
function sendData(){
	
	if($('#title').val()==''){
		alert('제목을  입력하세요');
		return false;
	}
	if($('#content').val()==''){
		alert('내용을 입력하세요');
		return false;
	}
	
	document.frm.submit();
	
}	
 */
	
</script>

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
		}
         </script>
     <body>

<div class="container">
        <table class="table">
        <form action="/board/edit_ok.do"  method="post" id="form1" name="form1" >
        <input type="hidden" value="${boardView.seq}" name="seq"/>
        <tbody>
            <tr>
                <th>번호 </th>
                <td>${boardView.seq}</td>
            </tr>
            <tr>
                <th>제목</th>
                <td><input type="text" value="${boardView.title}" name="title"  class="form-control"/></td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea rows="5"   name="content"  class="form-control">${boardView.content}</textarea></td>
            </tr>
            <tr>
                <th>등록일</th>
                <td>${boardView.regdate}</td>
            </tr>
            <tr>
                <th>조회수</th>
                <td>${boardView.hit}</td>
            </tr>
            <tr>
                <th>첨부파일</th>
                <td>
                <div id="guupload" class="guupload" style="width: 500px;"></div>
	              <c:if test="${!empty boardView.filename}">
	        		첨부파일 : <input type="text" name="oldFileName" value="${boardView.filename}" readOnly/></a>
	        		
	        	</c:if>        
			</td>
            </tr>
            <tr>
                <td colspan="2">
                    <a href="/board/write.do"><input type="button" value="등록하기"  class="pull-right"/></a>&nbsp;&nbsp;&nbsp;
                    <input type="button" value="수정하기"  onClick="formSubmit()" class="pull-right"/></a>&nbsp;&nbsp;&nbsp;
                    <!-- input type="button" value="삭제하기"   onClick="sendData()" class="pull-right"/-->&nbsp;&nbsp;&nbsp;
                    <input type="button" value="리스트" onclick="javascript:location.href='/board/list.do'"  class="pull-right"/>
                </td>
            </tr>
            </tbody>
              <input type="hidden" id="filename" name="filename"/>
            <input type="hidden" id="selectFile" />
            </form>
</table>
</div>
    </body>
</html>
