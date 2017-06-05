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
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

</br>

<sec:authorize access="isAnonymous()">
<a href="/signin">로그인 하기</a> <br/>
 </sec:authorize>
<sec:authorize access="isAuthenticated()">
이름: <%=name%> 님 반갑습니다.<br/>
<a href="/signout">로그아웃 하기</a>
<a href="/mypage">mypage가기</a>
</sec:authorize>

<ul>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <li>관리자 화면</li>
        </sec:authorize>
        <sec:authorize access="isAnonymous()">
        <li>비회원 게시판</li>
        </sec:authorize>
        <sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
        <li><a href="/board/list.do">권한회원 게시판</a></li>
        </sec:authorize>
        
    </ul>


</body>
</html>
