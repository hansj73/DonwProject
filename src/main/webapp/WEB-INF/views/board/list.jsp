<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@	include file="/WEB-INF/views/inc/header.jsp" %>
<script>
$(document).ready(function(){
	
$(".btn_search").click(function(){
    	
	 if($("#searchText").val().trim() == "") 
	 {
		   alert("검색어를 입력해 주세요.");
		   $("#searchText").focus();
		   return ;
	 }
	 document.boardSearch.submit();
   
    });
	
	
    $("#all").click(function(){
    	if($('#all').is(":checked")){
    	$('input:checkbox[name="delChk"]').each(function() {
            this.checked = true; //checked 처리
 			}); 
    	}else{
    		$('input:checkbox[name="delChk"]').each(function() {
                this.checked = false; //checked 처리
     			});
    	}
   
    });
    
    $("#del").click(function(){
    	
    	if($('input:checkbox[name="delChk"]:checked').length==0){
    		alert("체크박스를 선택하시기 바랍니다. ");
    	    return;	
    	}
    	
    	/* $('input:checkbox[name="delChk"]').each(function() {
    	      if(this.checked){//checked 처리된 항목의 값
    	            alert(this.value); 
    	      }
    	 }); */
    	 
    	 var param = "";
         $(".boardArea :checked").each(function() {
        	 
        	if($(this).parent().children("#delChk").val()!=undefined && $(this).parent().children("#delFname").val()!=undefined){ 
            if(param=="" ){
             param = "seq="+$(this).parent().children("#delChk").val();
            }else{ param = param + "&seq="+$(this).parent().children("#delChk").val();} 
           
            param = param + "&delFileName="+$(this).parent().children("#delFname").val();
        	}
         });
    	 
    	 if(confirm("정말 삭제하시겠습니까??") == true){  
    	 
    		 $.ajax({
                 url : '/board/multiDel.do',
                 type : 'post',
                 data : param,
                 dataType : 'text',
                 success : function(data) {
                   /* console.log('return string : ' + data); */
                   //alert('return string : ' + data);
                   location.href="/board/list.do";
                 },
                 error : function(request,status,error) { 
                	 alert("code:"+request.status+"\n"+"error:"+error);
                	 }
               });
    		 
    		 
    	 }else{
    		 return;
    	 } 
   
    });
    
    viewGo=function(seq,keyword,keyfield){
    	
    	 $("#seq").val(seq); 
    	 $("#keyWord").val(keyword); 
    	 $("#keyField").val(keyfield); 
    	 $("#viewPage").submit();
    }
    
    Paging=function(pageUrl,keyField,keyWord,pageNum){
    	
   	 $("#pageNum").val(pageNum); 
   	 $("#PkeyWord").val(keyWord); 
   	 $("#PkeyField").val(keyField); 
   	 $("#paging").submit(); 
   }
});
</script>
	<body>
		<div id="pychang">
			<div id="header" class="header">
				<%@	include file="/WEB-INF/views/inc/login_header.jsp" %>
				<div class="top_visual">
				</div>
			</div>

			<div id="wrap">
				<p class="dwon_tit">올림픽 영상 다운로드 </p>
				<p class="search_result">총  ${count} 건</p>
				<form name="boardSearch" id="boardActionFrm" method="post" action="/board/list.do">
					<fieldset class="search">
						<select name="keyField" >
							<option value="all">제목+내용</option>
							<option value="title">제목</option>
							<option value="content">내용</option>
						</select>
						<input type="text" class="it " id="searchText"  name="keyWord"  placeholder="검색어를 입력하세요"> 
						<a href="#" class="btn_search" >검색</a>
					</fieldset> 
				</form>
			
				<div class="boardArea">
					<table cellpadding="0" cellspacing="0" class="tbC" summary="올림픽 영상 다운로드 관리">
						<caption>올림픽 영상 다운로드 관리</caption>
						<colgroup>
							<col width="5%">
							<col width="18%">
							<col width="*%">
							<col width="18%">
							<col width="18%">
						</colgroup>
						<thead>
							<tr>
								<th scope="col"><input type="checkbox" name="all" id="all"></th>
								<th scope="col">번호</th>
								<th scope="col">제목</th>
								<th scope="col">작성자</th>
								<th scope="col">등록일</th>
							</tr>
						</thead>
						<tbody>
						 <c:forEach var="article" items="${boardlist}" >
						 <div>
							<tr>
								<td><input type="checkbox" id="delChk" name="delChk" value="${article.seq}"/><input type="hidden"  name="fname" value="${article.filename}" id="delFname"/></td>
								<td>${number}<c:set var="number" value="${number-1}"/></td>
								<td class="txt1"><a href="#" onclick="viewGo('${article.seq}','${keyWord}','${keyField}')" >${article.title}</a></td>
								<td>${article.writer}</td>
								<td><fmt:formatDate value="${article.regdate}" pattern="yyyy-MM-dd"/></td>
							</tr>
							</div>
							 </c:forEach>
							   <c:if test="${count==0}">
							     <tr>
							     <td colspan="5">등록된 게시물이 없습니다.</td>
							     </tr>
      						</c:if>
						</tbody>
						
					
					</table>
				</div>

				<div class="paging">
				<!-- 	<span>
						
						<img src="/images/igm/btn_first.png" alt="처음" class="prev"></a>
						
						<img src="/images/igm/btn_prev.png" alt="이전 10페이지 이동"></a>
					</span> -->
					<span class="num">
						  ${pagingHtml}
					</span>
					<!-- <span>
						<img src="/images/igm/btn_next.png" alt="다음 10페이지 이동"></a>
						<img src="/images/igm/btn_last.png" alt="끝" class="next"></a>
					</span> -->
				</div>
				
			<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SUPERADMIN')">
				<div class="btn_area">
					<a href="#" class="del" title="삭제" id="del">삭제</a>
					<a href="/board/write.do" class="write" title="등록">등록</a>
					<a href="/board/list.do" class="llist" title="목록">목록</a>
				</div>
			</sec:authorize>
			</div>
			

			<!-- div class="footer">
			</div -->
		</div>
	</body>
</html>

<form name="viewPage" action="/board/view.do" method="post" id="viewPage">
<input type="hidden" name="seq"  id="seq"/>
<input type="hidden" name="keyWord"  id="keyWord"/>
<input type="hidden" name="keyField" id="keyField"/>
</form>

<form name="paging" action="/board/list.do" method="post" id="paging">
<input type="hidden" name="pageNum"  id="pageNum"/>
<input type="hidden" name="keyWord"  id="PkeyWord"/>
<input type="hidden" name="keyField" id="PkeyField"/>
</form>
