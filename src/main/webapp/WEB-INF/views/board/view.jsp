<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@	include file="/WEB-INF/views/inc/header.jsp" %>
<script>    
     $(document).ready(function(){
    
	$("#wDel").click(function(){
			
		if(confirm("정말 삭제하시겠습니까??") == true){   
			$("delForm").submit();
			}else{
				return
			}
		});
	
	$("#preGo").click(function(){
	 	
         $("#prePage").submit();
	});
	
	$("#nextGo").click(function(){
	 	
        $("#nextPage").submit();
	});
	
	$("#listGo").click(function(){
	 	
        $("#listPage").submit();
	});
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
				
				<div class="boardView">
					<table cellpadding="0" cellspacing="0" class="tbL" summary="올림픽 영상 다운로드 게시판">
						<caption>올림픽 영상 다운로드 게시판 </caption>
						<colgroup>
							<col width="16.6%" />
							<col width="33.3%" />
							<col width="16.6%" />
							<col width="33.3%" />
						</colgroup>
						<tbody>
							<tr>
								<th scope="row">제목</th>
								<td colspan="3">${boardView.title}</td>
							</tr>
							<tr>
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
							</tr>
						</tbody>
					</table>
				</div>				
				
				<div class="boardView_lst">
					<table cellpadding="0" cellspacing="0" class="tbL" summary="목록리스트">
						<caption>목록리스트 상세보기</caption>
						<colgroup>
							<col width="16.6%" />
							<col width="*" />
						</colgroup>
						<tbody>
							<tr>
								<th scope="row">이전글</th>
								<td>
								<c:choose>
									<c:when test="${!empty boardView.pre_title}">
									<a href="#" id="preGo">${boardView.pre_title}</a>
									</c:when>
									<c:otherwise>
										이전 게시글이 없습니다.
									</c:otherwise>
								</c:choose>
							</tr>
							<tr>
								<th scope="row">다음글</th>
								<td>
								<c:choose>
									<c:when test="${!empty boardView.next_title}">
									<a href="#" id="nextGo">${boardView.next_title}</a>
									</c:when>
									<c:otherwise>
										다음 게시글이 없습니다.
									</c:otherwise>
								</c:choose>
								</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div class="btn_area mt20">
				<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SUPERADMIN')">
					<a href="/board/edit/${boardView.seq}" class="list" title="수정">수정</a>
					<a href="#"  class="list" title="삭제" id="wDel">삭제</a>
				</sec:authorize>	
					<a href="#" class="list" title="목록" id="listGo">목록</a>
				</div>
			</div>

			<!-- div class="footer">
			</div -->
		</div>
	</body>
</html>
<form name="delForm" action="/board/delete.do" method="post" id="delForm">
<input type="hidden" name="seq" value="${boardView.seq}"  id="seq"/>
<input type="hidden" name="delFileName" value="${boardView.filename}" id="filename"/>
<input type="hidden" name="mode" value="one"/>
</form>

<form name="prePage" action="/board/view.do" method="post" id="prePage">
<input type="hidden" name="seq" value="${boardView.pre_seq}"  />
<input type="hidden" name="keyWord" value="${keyWord}" />
<input type="hidden" name="keyField" value="${keyField}"/>
</form>

<form name="nextPage" action="/board/view.do" method="post" id="nextPage">
<input type="hidden" name="seq" value="${boardView.next_seq}"  />
<input type="hidden" name="keyWord" value="${keyWord}" />
<input type="hidden" name="keyField" value="${keyField}"/>
</form>

<form name="listPage" action="/board/list.do" method="post" id="listPage">
<input type="hidden" name="keyWord" value="${keyWord}" />
<input type="hidden" name="keyField" value="${keyField}"/>
</form>
