<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>글보기</title>
    </head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<script>
	
function sendData(){
	
	if($('#seq').val()==''){
		alert('번호를 입력하세요');
		return false;
	}
	
	document.delForm.submit();
	
}	

	
</script>
     <body>

<div class="container">
        <table class="table">
        <tbody>
            <tr>
                <th>번호 </th>
                <td>${boardView.seq}</td>
            </tr>
            <tr>
                <th>제목</th>
                <td>${boardView.title}</td>
            </tr>
            <tr>
                <th>내용</th>
                <td>${boardView.content}</td>
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
	              <c:if test="${!empty boardView.filename}">
	        		첨부파일 : <a href="/board/file.do?filename=${boardView.filename}">${boardView.filename}</a>
	        	</c:if>        
			</td>
            </tr>
            <tr>
                <td colspan="2">
                    <a href="/board/write.do"><input type="button" value="새글등록하기"  class="pull-right"/></a>&nbsp;&nbsp;&nbsp;
                    <a href="/board/edit/${boardView.seq}"><input type="button" value="수정하기"  class="pull-right"/></a>&nbsp;&nbsp;&nbsp;
                    <input type="button" value="삭제하기"   onClick="sendData()" class="pull-right"/>&nbsp;&nbsp;&nbsp;
                    <input type="button" value="리스트" onclick="javascript:location.href='/board/list.do'"  class="pull-right"/>
                </td>
            </tr>
            </tbody>
</table>
</div>

    
    </body>
</html>
<form name="delForm" action="/board/delete.do" method="post">
<input type="hidden" name="seq" value="${boardView.seq}"  id="seq"/>
<input type="hidden" name="fileName" value="${boardView.filename}" id="filename"/>
</form>