<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@	include file="/WEB-INF/views/inc/header.jsp" %>		
<link rel="stylesheet" type="text/css" href="/js/guupload/css/guupload.css"/>
<script type="text/javascript" src="/js/guupload/guUploadManager.js"></script>
<script src="/js/sj/jquery.bpopup.min.js" type="text/javascript"></script>

 <script>
        /*  var guManager=null;
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
       	  if ($("#title").val().trim() == "") 
       	  {
       	   alert("제목을 입력해 주세요.");
       	   $("#title").focus();
       	   return ;
       	  }
       	  
       	  if($("#content").val().trim() == "") 
       	  {
       		   alert("내용을 입력해 주세요.");
       		   $("#content").focus();
       		   return ;
       		}
       	  
       	 if($("#selectFile").val().trim() == "") 
      	  {
      		   alert("파일을 선택해주세요 ");
      		   return ;
      	 }
        	 
        guManager.uploadFiles();
        go_popup();
 */      
		}
         
      
         </script>
 <script>    
     $(document).ready(function(){
    	 
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
	
	$("#submit").click(function(){
			
		 if ($("#title").val().trim() == "") 
      	  {
      	   alert("제목을 입력해 주세요.");
      	   $("#title").focus();
      	   return ;
      	  }
		 if($("#content").val().trim() == "") 
      	  {
      		   alert("내용을 입력해 주세요.");
      		   $("#content").focus();
      		   return ;
      		}
      	  
      	if($("#selectFile").val().trim() == "") 
     	  {
     		   alert("파일을 선택해주세요 ");
     		   return ;
     	 } 
     	 
      	guManager.uploadFiles();
      	
      	$("#popup").bPopup();
	   
		});
	
	$("#cancelSubmit").click(function(){
	  
		 $("#wtitle").val($("#title").val());
		 $("#wcontent").val($("#content").val());
         $("#frm2").submit();
	});
});
</script>

	</head>
	<body>
		<div id="pychang">
			<div id="header" class="header">
				<%@	include file="/WEB-INF/views/inc/login_header.jsp" %>
				<div class="top_visual">
				</div>
			</div>

			<div id="wrap">
				<p class="dwon_tit">올림픽 영상 다운로드 </p>
				
				<div class="boardView">
					<table cellpadding="0" cellspacing="0" class="tbL" summary="올림픽 영상 다운로드 게시판">
					<form action="/board/write_ok.do"  method="post" id="form1" name="form1" >
						<caption>올림픽 영상 다운로드 게시판 상세보기</caption>
						<colgroup>
							<col width="16.6%" />
							<col width="33.3%" />
							<col width="16.6%" />
							<col width="33.3%" />
						</colgroup>
						<tbody>
							<tr>
								<th scope="row">작성자 </th>
								<td><%=name%></td>
								<th scope="row">등록일</th>
								<td>${strToday}</td>
							</tr>
							<tr>
								<th scope="row">제목</th>
								<td colspan="3"><input type="text" class="it" name="title"  value="${title}" id="title" placeholder="제목을 입력하세요." ></td>
							</tr>
							<tr>
								<th scope="row">동영상 첨부파일</th>
								<td colspan="3" class="admin_de">
									<!-- <input type="text" class="it " id="searchText" value="" name="searchText" title="">  <a href="#n" class="btn" title="다운로드" onclick="go_popup()">영상등록</a> --> 
										<div id="guupload" class="guupload" style="width: 500px;">
									<ul>
										<li>* 저장된 동영상 파일을 선택해 주세요.</li>
										<li>* 최대 1G byte까지 업로드 하실 수 있습니다.</li>
										<li>* 등록 가능한 동영상 파일: avi, asf, wmv, mp4, mpeg, mpg, mov, flv</li>
									</ul>
								</td>
							</tr>
							<tr>
								<th scope="row">동영상 내용<br/>(소개글)</th>
								<td colspan="3">
									<textarea rows="5"  placeholder="내용을 입력하세요." id="content" name="content">${content}</textarea>
								</td>
							</tr>
						</tbody>
			<input type="hidden" id="filename" name="filename"/>
            <input type="hidden"  name="writer"  value="<%=name%>"/>
            <input type="hidden" id="selectFile"  />
            <input type="hidden" name="pwd"/>
       </form>	 
					</table>
				</div>				
		<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SUPERADMIN')">
				<div class="btn_area mt20">
					<a href="javascript:document.form1.reset();" class="list" title="">다시쓰기</a>
					<a href="#" class="list" title="등록" id="submit">등록</a>
					<a href="/board/list.do" class="list01" title="목록">목록</a>
				</div>
			</sec:authorize>
			</div>
			
			<div id="popup" class="pstyle">
				<!-- <span class="b-close"><img src="/images/igm/pych_bt01.png" alt="닫기" /></span> -->
				<div class="content" style="height: auto; width: auto;">
					<p>올림픽 영상 업로드 </p>
					<img src="/images/igm/pych_down.gif" alt="downloading" />
					<a href="#" id="cancelSubmit" class="list" title="취소" >취소</a>
				<!-- 	<a href="" class="btn"> 닫기</a> -->
				</div>
			</div>

			<!-- div class="footer">
			</div -->
		</div>
	</body>
</html>
<form name="frm2" id="frm2"  actoin="/board/write.do" method="post">
<input type="hidden" name="title" id="wtitle"/>
<input type="hidden" name="content" id="wcontent"/>
</form>
