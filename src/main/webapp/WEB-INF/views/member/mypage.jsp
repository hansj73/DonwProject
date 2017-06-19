<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@	include file="/WEB-INF/views/inc/header.jsp" %>
  <link rel="stylesheet" type="text/css" href="/css/iGraph.css"/>
<script> 

function signinOk() 
{ 
	document.frm.submit();
}

   </script> 
 
  

<%--   <form action="/member/passwd_ok.do" method="post" name="frm"> 
   
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
</c:if> --%>

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
						<caption>올림픽 영상 다운로드 게시판 </caption>
						<colgroup>
							<col width="16.6%" />
							<!-- <col width="33.3%" />
							<col width="16.6%" />
							<col width="33.3%" /> -->
						</colgroup>
						<tbody>
							<tr>
								<th scope="row">파일용량보기</th>
								<td colspan="3"><p>사용중: ${usedSpace}GB / 총용량: ${totalSpace}GB 
								<span class="iGraph">
									<span class="gBar"><span class="gAction" style="width:${usedPer}"></span></span>
									<span class="gPercent"><strong>${usedPer}</strong></span>
								</span> 
							</p></td>
							</tr>
							<%-- <tr>
								<th scope="row">작성자 </th>
								<td>${boardView.writer}</td>
								<th scope="row">등록일</th>
								<td><fmt:formatDate value="${boardView.regdate}" pattern="yyyy-MM-dd"/></td>
							</tr>
							<tr>
								<th scope="row">동영상 내용<br/>(소개글)</th>
								<td colspan="3" class="detail">
									${boardView.content}
								</td>
							</tr>
							<tr>
								<th scope="row">동영상 파일</th>
								<td colspan="3">
								  <c:if test="${!empty boardView.filename}">
	        					<img src="/images/igm/pych_bar05.png" alt="동영상 파일" />${boardView.realname} <a href="/board/file.do?filename=${boardView.filename}&realname=${boardView.realname}" class="btn" title="다운로드">다운로드</a>
	        					</c:if>   
								
								</td>
							</tr> --%>
						</tbody>
					</table>
				</div>				
				
				<div class="btn_area mt20">
					<a href="/board/list.do" class="list" title="목록">목록</a>
				</div>
			</div>

			<!-- div class="footer">
			</div -->
		</div>
	</body>
</html>
    