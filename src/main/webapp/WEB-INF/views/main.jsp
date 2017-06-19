<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@	include file="/WEB-INF/views/inc/header.jsp" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAuthenticated()">
<script>
location.href="/board/list.do";
</script>
</sec:authorize>
	<body>
		<div id="pychang">
			<!-- div id="header">
			</div -->

			<div id="main_wrap">
				<div class="ul_box">
					<p class="blind">“평창동계올림픽 HOT 영상” 올림픽 관련 생생한 영상 정보를 만나보세요!</p>
					<ul class="listCam">
						<li>평창올림픽 동영상 게시물을 다운로드 또는 동영상 등록 및  수정, 삭제등 영상 콘텐츠 관리를 하시고자 할 경우 로그인을 해 주세요. </li>
						<li>본 시스템을 무단으로 사용하거나 시스템에 대해 악의적인 행동을 할 경우 관련 법규에 의해 처벌됩니다. </li>
					</ul>
				</div>

				<a href="/login.do" title="로그인" ><div class="btn01">로그인</div></a>
			</div>

			<!-- <div class="footer"></div>-->
		</div>
	</body>
</html>
