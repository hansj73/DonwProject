<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
Authentication auth = SecurityContextHolder.getContext().getAuthentication();
Object principal = auth.getPrincipal();
String name = "";
if(principal != null && principal instanceof UserDTO){
    name = ((UserDTO)principal).getUsername();
}
%>
<div class="top">
					<div class="topMeun">
						<div class="user">		
							<div class="userL">
								<a href="#"><%=name%> &nbsp;님 로그인하셨습니다.</a>
								<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SUPERADMIN')">
								<a href="/member/mypage">&nbsp;관리자페이지가기</a>
									</sec:authorize>
								<a href="/logout"> 로그아웃</a>
							</div>				
						</div>
					</div>
				</div>