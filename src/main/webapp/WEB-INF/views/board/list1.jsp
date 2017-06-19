<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="com.prj.Culture.security.dto.UserDTO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>리스트</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- Custom styles for this template -->


    <!-- Temporary navbar container fix -->
    <style>
    .navbar-toggler {
        z-index: 1;
    }

    @media (max-width: 576px) {
        nav > .container {
            width: 100%;
        }
    }

  

nav ul {
    padding: 0;
}

nav ul li {
    display: inline;
    margin: 5px;
}

div.navLoc{
	margin-right:700px;
}

.center {
    text-align: right;
    color: navy;
 }

.navPage{
 text-align: center;
}

.navLoc{
  border: 1px solid red;
 }

 div.relative {
    position: relative;
    width: 100%;
    height: 50px;
   border: 0px solid #73AD21;
}

div.absolute {
    position: absolute;
    top: 0px;
    right: 0px;
    border: 0px solid red;
}

    </style>

</head>

<body>

<div>
    <!-- Navigation -->
    <nav>
        <div class="container">
                <ul class="center">
                    <li>
                        <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li>
                        <a class="nav-link" href="#">About</a>
                    </li>
                    <li>
                        <a class="nav-link" href="#">Services</a>
                    </li>
                    <li>
                        <a class="nav-link" href="#">Contact</a>
                    </li>
                </ul>
        </div>
    </nav>

    <!-- Page Content -->
    <div class="container">
    <div>
    <span>Total ${count}건</span> / ${number} 페이지
    </div>
        <table class="table table-borderd table-hover">
        <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>등록자</th>
        <th>등록일</th>
        <th>조회수</th>
      </tr>
      </thead>
      <tbody>
        <c:forEach var="article" items="${boardlist}" >
	      <tr>
	        <td>${number}<c:set var="number" value="${number-1}"/></td>
	        <td>
	        <!-- a href="/board/view.do?seq=${article.seq}">${article.title}</a-->
	        <a href="/board/view/${article.seq}">${article.title}</a>
	        </td>
	        <td>${article.writer}</td>
	        <td><fmt:formatDate value="${article.regdate}" pattern="yyyy년 MM월 dd일"/></td>
	        <td>${article.hit}</td>
	        </tr>
	     </c:forEach>
	     <c:if test="${count==0}">
		     <tr>
		     <td colspan="5">등록된 게시물이 없습니다.</td>
		     </tr>
      	</c:if>
	    </tbody>
       </table>
    </div>
            <!-- [start]검색 -->
	    <div class="container">
            <div align="center">
                 <!-- 게시판 검색 시작 { -->
					<form action="/board/list.do" name="search" method="get" onsubmit="return seachCheck()">
					    <table class="search">
					        <tr>
					            <td>
					                <select name="keyField">
					                    <option value="title">제목</option>
					                    <option value="writer">이름</option>
					                    <option value="content">내용</option>
					                    <option value="all">전체</option>
					                </select>
					            </td>
					            <td>
					                <input type="text" size="16" name="keyWord">
					            </td>
					            <td>
					                <input type="submit" value="찾기" class="inputb">
					            </td>
					        </tr>
					    </table>
					</form>
	      	</div>
    	</div>
    	<!-- [end] 검색 -->
	    <!-- Pagination -->
	    <div class="container">
                
        	  <div align="center">
	            ${pagingHtml}
	            </div>
	             <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SUPERADMIN')">
	              	<input type="button" value="글쓰기"  onclick="javascript:location.href='/board/write.do'"  class="pull-right"/>
	            </sec:authorize>
	              	
	  </div>
    	<!-- [end] pagging -->
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-inverse">
        <div class="container">
            <p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
        </div>
        <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</div>
</body>

</html>
